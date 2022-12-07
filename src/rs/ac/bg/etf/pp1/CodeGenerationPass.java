package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerationPass extends VisitorAdaptor {

    private Obj prog;

    private Map<String, Integer> labelAddressMap = new HashMap<>();
    private Map<String, List<Integer>> patchMap = new HashMap<>();

    public CodeGenerationPass(Program program) {
        prog = Tab.find(program.getProgramBegin().getProgName());
        for (Obj localSymbol : prog.getLocalSymbols()) {
            if (localSymbol.getKind() == Obj.Var) {
                Code.dataSize++;
            }
        }
    }

    @Override
    public void visit(FactorNumConst factorNumConst) {
        Code.loadConst(factorNumConst.getConstValue());
    }

    @Override
    public void visit(FactorCharConst factorCharConst) {
        Code.loadConst(factorCharConst.getConstValue());
    }

    @Override
    public void visit(FactorBoolConst factorBoolConst) {
        Code.loadConst(factorBoolConst.getConstValue() ? 1 : 0);
    }

    @Override
    public void visit(FactorNew factorNew) {
        Code.put(Code.newarray);
        int type = 1;
        if (factorNew.struct== Tab.find("char").getType()) {
            type = 0;
        }
        Code.put(type);
    }

    @Override
    public void visit(FactorDesignator factorDesignator) {
        Code.load(factorDesignator.getDesignator().obj);
    }

    @Override
    public void visit(TermList termList) {
        Mulop mulop = termList.getMulop();
        if (mulop instanceof MulopMul) {
            Code.put(Code.mul);
        } else if (mulop instanceof MulopDiv) {
            Code.put(Code.div);
        } else {
            Code.put(Code.rem);
        }
    }

    @Override
    public void visit(ExpressionAddop expressionAddop) {
        Addop addop = expressionAddop.getAddop();
        if (addop instanceof AddopPlus) {
            Code.put(Code.add);
        } else {
            Code.put(Code.sub);
        }
    }

    @Override
    public void visit(ExpressionMinus expressionMinus) {
        Code.put(Code.neg);
    }

    @Override
    public void visit(MethodName methodName) {
        if (methodName.getMethodName().equals("main")) {
            Code.mainPc = Code.pc;
        }
        Obj method = methodName.obj;
        Code.put(Code.enter);
        Code.put(method.getLevel());
        Code.put(method.getLocalSymbols().size());
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    @Override
    public void visit(DesignatorIdentifier designatorIdentifier) {
        if (designatorIdentifier.getParent() instanceof DesignatorArray) {
            Code.load(designatorIdentifier.obj);
        }
    }

    @Override
    public void visit(DesignatorAssignment designatorAssignment) {
        Code.store(designatorAssignment.getDesignator().obj);
    }

    @Override
    public void visit(DesignatorIncrement designatorIncrement) {
        if (designatorIncrement.getDesignator() instanceof DesignatorArray) {
            Code.put(Code.dup2);
        }
        Code.load(designatorIncrement.getDesignator().obj);
        Code.loadConst(1);
        Code.put(Code.add);
        Code.store(designatorIncrement.getDesignator().obj);
    }

    @Override
    public void visit(DesignatorDecrement designatorDecrement) {
        if (designatorDecrement.getDesignator() instanceof DesignatorArray) {
            Code.put(Code.dup2);
        }
        Code.load(designatorDecrement.getDesignator().obj);
        Code.loadConst(1);
        Code.put(Code.sub);
        Code.store(designatorDecrement.getDesignator().obj);
    }

    @Override
    public void visit(SingleStatementRead singleStatementRead) {
        Code.put(Code.read);
        Code.store(singleStatementRead.getDesignator().obj);
    }

    @Override
    public void visit(SingleStatementPrint singleStatementPrint) {
        int width = 4;
        if (singleStatementPrint.getPrintConst() instanceof PrintConstPresent) {
            width = ((PrintConstPresent) singleStatementPrint.getPrintConst()).getWidth();
        }
        Code.loadConst(width);
        Code.put(Code.print);
    }

    @Override
    public void visit(LabelName labelName) {
        String name = labelName.getLabelName();
        int labelAddress = Code.pc;
        labelAddressMap.put(name, labelAddress);
        List<Integer> addressList = patchMap.get(name);
        if (addressList != null) {
            for (Integer address : addressList) {
                Code.fixup(address);
            }
        }
    }

    @Override
    public void visit(SingleStatementGoto singleStatementGoto) {
        String labelName = singleStatementGoto.getLabelName();
        if (labelAddressMap.containsKey(labelName)) {
            int labelAddress = labelAddressMap.get(labelName);
            Code.putJump(labelAddress);
        } else {
            Code.put(Code.jmp);
            List<Integer> patchAddresses;
            if (patchMap.containsKey(labelName)) {
                patchAddresses = patchMap.get(labelName);
            } else {
                patchAddresses = new ArrayList<>();
                patchMap.put(labelName, patchAddresses);
            }

            patchAddresses.add(Code.pc);
            Code.put2(0);
        }
    }
}
