// generated with ast extension for cup
// version 0.8
// 24/0/2022 2:10:10


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationSingleVar extends VarDeclarationSingle {

    private String varName;

    public VarDeclarationSingleVar (String varName) {
        this.varName=varName;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationSingleVar(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationSingleVar]");
        return buffer.toString();
    }
}
