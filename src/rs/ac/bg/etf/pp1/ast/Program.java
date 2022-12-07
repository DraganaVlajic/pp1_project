// generated with ast extension for cup
// version 0.8
// 24/0/2022 2:10:10


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ProgramBegin ProgramBegin;
    private DeclarationBlock DeclarationBlock;
    private MethodDeclarationList MethodDeclarationList;

    public Program (ProgramBegin ProgramBegin, DeclarationBlock DeclarationBlock, MethodDeclarationList MethodDeclarationList) {
        this.ProgramBegin=ProgramBegin;
        if(ProgramBegin!=null) ProgramBegin.setParent(this);
        this.DeclarationBlock=DeclarationBlock;
        if(DeclarationBlock!=null) DeclarationBlock.setParent(this);
        this.MethodDeclarationList=MethodDeclarationList;
        if(MethodDeclarationList!=null) MethodDeclarationList.setParent(this);
    }

    public ProgramBegin getProgramBegin() {
        return ProgramBegin;
    }

    public void setProgramBegin(ProgramBegin ProgramBegin) {
        this.ProgramBegin=ProgramBegin;
    }

    public DeclarationBlock getDeclarationBlock() {
        return DeclarationBlock;
    }

    public void setDeclarationBlock(DeclarationBlock DeclarationBlock) {
        this.DeclarationBlock=DeclarationBlock;
    }

    public MethodDeclarationList getMethodDeclarationList() {
        return MethodDeclarationList;
    }

    public void setMethodDeclarationList(MethodDeclarationList MethodDeclarationList) {
        this.MethodDeclarationList=MethodDeclarationList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramBegin!=null) ProgramBegin.accept(visitor);
        if(DeclarationBlock!=null) DeclarationBlock.accept(visitor);
        if(MethodDeclarationList!=null) MethodDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramBegin!=null) ProgramBegin.traverseTopDown(visitor);
        if(DeclarationBlock!=null) DeclarationBlock.traverseTopDown(visitor);
        if(MethodDeclarationList!=null) MethodDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramBegin!=null) ProgramBegin.traverseBottomUp(visitor);
        if(DeclarationBlock!=null) DeclarationBlock.traverseBottomUp(visitor);
        if(MethodDeclarationList!=null) MethodDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgramBegin!=null)
            buffer.append(ProgramBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclarationBlock!=null)
            buffer.append(DeclarationBlock.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclarationList!=null)
            buffer.append(MethodDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
