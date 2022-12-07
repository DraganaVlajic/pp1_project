// generated with ast extension for cup
// version 0.8
// 24/0/2022 2:10:10


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationListElem extends VarDeclarationList {

    private VarDeclarationSingle VarDeclarationSingle;

    public VarDeclarationListElem (VarDeclarationSingle VarDeclarationSingle) {
        this.VarDeclarationSingle=VarDeclarationSingle;
        if(VarDeclarationSingle!=null) VarDeclarationSingle.setParent(this);
    }

    public VarDeclarationSingle getVarDeclarationSingle() {
        return VarDeclarationSingle;
    }

    public void setVarDeclarationSingle(VarDeclarationSingle VarDeclarationSingle) {
        this.VarDeclarationSingle=VarDeclarationSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclarationSingle!=null) VarDeclarationSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclarationSingle!=null) VarDeclarationSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclarationSingle!=null) VarDeclarationSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationListElem(\n");

        if(VarDeclarationSingle!=null)
            buffer.append(VarDeclarationSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationListElem]");
        return buffer.toString();
    }
}
