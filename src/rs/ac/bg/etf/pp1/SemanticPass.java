package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.HashMap;
import java.util.Map;

public class SemanticPass extends VisitorAdaptor {

    private boolean hadError = false;

    private Obj currMethod = null;
    private Map<String, Boolean> labels = new HashMap<>();

    public SemanticPass() {
    }

    private void error(String message) {
        hadError = true;
        System.out.println(message);
    }

    private void error_with_sym(String message, SyntaxNode syntaxNode) {
        hadError = true;
        if (syntaxNode != null) {
            message = message + " (linija " + syntaxNode.getLine() + ")";
        }
        System.out.println(message);
    }

    public boolean hadError() {
        return hadError;
    }

    @Override
    public void visit(ProgramBegin programBegin) {
        Tab.init();
        Tab.insert(Obj.Type, "bool", new Struct(Struct.Bool));
        Tab.insert(Obj.Prog, programBegin.getProgName(), Tab.noType);
        Tab.openScope();
    }

    public void visit(Program program) {
        Obj main = Tab.find("main");
        if (main == Tab.noObj || main.getKind() != Obj.Meth || main.getLevel() != 0 || main.getType().getKind() != Struct.None) {
            error("Ne postoji main metoda ili nema odgovarajuci potpis.");
        }
        for (Map.Entry<String, Boolean> entry : labels.entrySet()) {
            if (!entry.getValue()) {
                error("Labela " + entry.getKey() + " nije nigde definisana.");
            }
        }
        Tab.chainLocalSymbols(Tab.find(program.getProgramBegin().getProgName()));
        Tab.closeScope();
    }

    private Struct resolveType(String typeName) {
        Obj obj = Tab.find(typeName);
        if (obj == Tab.noObj) {
            error("Nije pronadjen tip: " + typeName);
            return Tab.noType;
        } else if (obj.getKind() != Obj.Type) {
            error("Pronadjeno ime " + typeName + " ne opisuje tip.");
            return Tab.noType;
        }
        return obj.getType();
    }

    @Override
    public void visit(Type type) {
        String typeName = type.getTypeName();
        type.struct = resolveType(typeName);
    }

    private static Struct getTypeOfVariableOrConst(SyntaxNode declaration) {
        SyntaxNode current = declaration;
        while (!(current instanceof VarDeclaration || current instanceof ConstDeclaration)) {
            current = current.getParent();
        }
        Struct type;
        if (current instanceof VarDeclaration) {
            type = ((VarDeclaration) current).getType().struct;
        } else {
            type = ((ConstDeclaration) current).getType().struct;
        }

        return type;
    }

    @Override
    public void visit(VarDeclarationSingleVar varDeclarationSingleVar) {
        String variableName = varDeclarationSingleVar.getVarName();
        if (Tab.find(variableName) != Tab.noObj) {
            error("Greska pri definiciji promenljive " + variableName + ": ime vec postoji.");
        } else {
            Struct type = getTypeOfVariableOrConst(varDeclarationSingleVar);
            Tab.insert(Obj.Var, variableName, type);
        }
    }

    @Override
    public void visit(VarDeclarationSingleArray varDeclarationSingleArray) {
        String variableName = varDeclarationSingleArray.getVarName();
        if (Tab.find(variableName) != Tab.noObj) {
            error("Greska pri definiciji promenljive " + variableName + ": ime vec postoji.");
        } else {
            Struct type = getTypeOfVariableOrConst(varDeclarationSingleArray);
            Struct arrayType = new Struct(Struct.Array, type);
            Tab.insert(Obj.Var, variableName, arrayType);
        }
    }

    @Override
    public void visit(ConstDeclarationNum constDeclarationNum) {
        String constantName = constDeclarationNum.getConstName();
        if (Tab.find(constantName) != Tab.noObj) {
            error("Greska pri definiciji konstante " + constantName + ": ime vec postoji.");
        } else {
            Struct type = getTypeOfVariableOrConst(constDeclarationNum);
            if (type.getKind() != Struct.Int) {
                error("Greska pri dodeli vrednosti konstanti " + constantName + ": ocekivan int, dodeljen tip " + type.getKind());
            } else {
                Obj constant = Tab.insert(Obj.Con, constantName, type);
                constant.setAdr(constDeclarationNum.getConstValue());
            }
        }
    }

    @Override
    public void visit(ConstDeclarationChar constDeclarationChar) {
        String constantName = constDeclarationChar.getConstName();
        if (Tab.find(constantName) != Tab.noObj) {
            error("Greska pri definiciji konstante " + constantName + ": ime vec postoji.");
        } else {
            Struct type = getTypeOfVariableOrConst(constDeclarationChar);
            if (type.getKind() != Struct.Char) {
                error("Greska pri dodeli vrednosti konstanti " + constantName + ": ocekivan char, dodeljen tip " + type.getKind());
            } else {
                Obj constant = Tab.insert(Obj.Con, constantName, type);
                constant.setAdr(constDeclarationChar.getConstValue());
            }
        }
    }

    @Override
    public void visit(ConstDeclarationBool constDeclarationBool) {
        String constantName = constDeclarationBool.getConstName();
        if (Tab.find(constantName) != Tab.noObj) {
            error("Greska pri definiciji konstante " + constantName + ": ime vec postoji.");
        } else {
            Struct type = getTypeOfVariableOrConst(constDeclarationBool);
            if (type.getKind() != Struct.Char) {
                error("Greska pri dodeli vrednosti konstanti " + constantName + ": ocekivan char, dodeljen tip " + type.getKind());
            } else {
                Obj constant = Tab.insert(Obj.Con, constantName, type);
                constant.setAdr(constDeclarationBool.getConstValue() ? 1 : 0);
            }
        }
    }

    @Override
    public void visit(MethodName methodName) {
        String name = methodName.getMethodName();
        MethodReturnType returnTypeNode = ((MethodDeclaration) methodName.getParent()).getMethodReturnType();

        Struct type;
        if (returnTypeNode instanceof MethodReturnTypeVoid) {
            type = Tab.noType;
        } else {
            type = resolveType(((MethodReturnTypeName) returnTypeNode).getTypeName());
        }

        if (Tab.find(name) != Tab.noObj) {
            error("Greska pri definiciji metode " + methodName + ": ime vec postoji.");
        } else {
            currMethod = Tab.insert(Obj.Meth, name, type);
            methodName.obj = currMethod;
            Tab.openScope();
        }
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        Tab.chainLocalSymbols(currMethod);
        Tab.closeScope();
        currMethod = null;
    }

    private void handleFormalParam(Struct type, String name, boolean isArray) {
        Struct paramType = type;
        if (isArray) {
            paramType = new Struct(Struct.Array, type);
        }

        if (Tab.find(name) != Tab.noObj) {
            error("Greska pri definiciji parametra metode " + currMethod.getName() + " - " + name + ": ime vec postoji.");
        } else {
            Obj param = Tab.insert(Obj.Var, name, paramType);
            param.setFpPos(currMethod.getLevel());
            currMethod.setLevel(currMethod.getLevel() + 1);
        }
    }

    @Override
    public void visit(FormalParamType formalParam) {
        Struct type = formalParam.getType().struct;
        String name = formalParam.getParamName();
        handleFormalParam(type, name, false);
    }

    @Override
    public void visit(FormalParamArray formalParam) {
        Struct type = formalParam.getType().struct;
        String name = formalParam.getParamName();
        handleFormalParam(type, name, true);
    }

    @Override
    public void visit(DesignatorIdentifier designatorIdentifier) {
        String name = designatorIdentifier.getName();
        Obj obj = Tab.find(name);
        if (obj == Tab.noObj) {
            error("Nije pronadjeno ime: " + name);
        }
        designatorIdentifier.obj = obj;
    }

    @Override
    public void visit(DesignatorArray designatorArray) {
        Obj obj = designatorArray.getDesignator().obj;

        if (obj.getType().getKind() != Struct.Array) {
            error("Pokusaj dereferenciranja promenljive koja nije niz: " + ((DesignatorIdentifier) designatorArray.getDesignator()).getName());
            designatorArray.obj = Tab.noObj;
        } else {
            designatorArray.obj = new Obj(Obj.Elem, "", obj.getType().getElemType());
        }

        if (designatorArray.getExpr().struct != Tab.find("int").getType()) {
            error("Nizovi se mogu adresirati samo intovima.");
        }

    }

    @Override
    public void visit(FactorBoolConst factorBoolConst) {
        factorBoolConst.struct = Tab.find("bool").getType();
    }

    @Override
    public void visit(FactorCharConst factorCharConst) {
        factorCharConst.struct = Tab.find("char").getType();
    }

    @Override
    public void visit(FactorDesignator factorDesignator) {
        factorDesignator.struct = factorDesignator.getDesignator().obj.getType();
    }

    @Override
    public void visit(FactorExpr factorExpr) {
        factorExpr.struct = factorExpr.getExpr().struct;
    }

    @Override
    public void visit(FactorNew factorNew) {
        Struct type = factorNew.getType().struct;
        factorNew.struct = new Struct(Struct.Array, type);
    }

    @Override
    public void visit(FactorNumConst factorNumConst) {
        factorNumConst.struct = Tab.find("int").getType();
    }

    @Override
    public void visit(TermFactor termFactor) {
        termFactor.struct = termFactor.getFactor().struct;
    }

    @Override
    public void visit(TermList termList) {
        Struct intType = Tab.find("int").getType();
        if (termList.getFactor().struct != intType) {
            error("Matematicke operacije moguce samo nad intovima.");
        }
        termList.struct = intType;
    }

    @Override
    public void visit(ExpressionTerm expressionTerm) {
        expressionTerm.struct = expressionTerm.getTerm().struct;
    }

    @Override
    public void visit(ExpressionAddop expressionAddop) {
        Struct intType = Tab.find("int").getType();
        if (expressionAddop.getTerm().struct != intType) {
            error("Matematicke operacije moguce samo nad intovima.");
        }
        expressionAddop.struct = intType;
    }

    @Override
    public void visit(Expression expression) {
        expression.struct = expression.getExprList().struct;
    }

    @Override
    public void visit(ExpressionMinus expressionMinus) {
        Struct intType = Tab.find("int").getType();
        if (expressionMinus.getExprList().struct != intType) {
            error("Matematicke operacije moguce samo nad intovima.");
        }
        expressionMinus.struct = intType;
    }

    @Override
    public void visit(DesignatorIncrement designatorIncrement) {
        if (designatorIncrement.getDesignator().obj.getType() != Tab.find("int").getType()) {
            error("matematicke operacije moguce samo nad intovima.");
        }
    }

    @Override
    public void visit(DesignatorDecrement designatorDecrement) {
        if (designatorDecrement.getDesignator().obj.getType() != Tab.find("int").getType()) {
            error("Matematicke operacije moguce samo nad intovima.");
        }
    }

    @Override
    public void visit(DesignatorAssignment designatorAssignment) {
        if (!designatorAssignment.getExpr().struct.assignableTo(designatorAssignment.getDesignator().obj.getType())) {
            System.out.println("Struct: " + designatorAssignment.getExpr().struct.getKind());
            System.out.println("Obj: " + designatorAssignment.getDesignator().obj.getName() + " Struct: " + designatorAssignment.getDesignator().obj.getKind());
            error_with_sym("Pokusaj dodele neodgovarajuceg tipa.", designatorAssignment);
        }
    }

    @Override
    public void visit(LabelName labelName) {
        String name = labelName.getLabelName();
        if (labels.containsKey(name) && labels.get(name)) {
            error("Visestruka definicija labele: " + name);
        } else {
            labels.put(name, true);
        }
    }

    @Override
    public void visit(SingleStatementGoto singleStatementGoto) {
        String labelName = singleStatementGoto.getLabelName();
        if (!labels.containsKey(labelName)) {
            labels.put(labelName, false);
        }
    }
}
