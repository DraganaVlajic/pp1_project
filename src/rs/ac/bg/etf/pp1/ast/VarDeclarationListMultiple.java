// generated with ast extension for cup
// version 0.8
// 24/0/2022 2:10:10


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationListMultiple extends VarDeclarationList {

    private VarDeclarationSingle VarDeclarationSingle;
    private VarDeclarationList VarDeclarationList;

    public VarDeclarationListMultiple (VarDeclarationSingle VarDeclarationSingle, VarDeclarationList VarDeclarationList) {
        this.VarDeclarationSingle=VarDeclarationSingle;
        if(VarDeclarationSingle!=null) VarDeclarationSingle.setParent(this);
        this.VarDeclarationList=VarDeclarationList;
        if(VarDeclarationList!=null) VarDeclarationList.setParent(this);
    }

    public VarDeclarationSingle getVarDeclarationSingle() {
        return VarDeclarationSingle;
    }

    public void setVarDeclarationSingle(VarDeclarationSingle VarDeclarationSingle) {
        this.VarDeclarationSingle=VarDeclarationSingle;
    }

    public VarDeclarationList getVarDeclarationList() {
        return VarDeclarationList;
    }

    public void setVarDeclarationList(VarDeclarationList VarDeclarationList) {
        this.VarDeclarationList=VarDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclarationSingle!=null) VarDeclarationSingle.accept(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclarationSingle!=null) VarDeclarationSingle.traverseTopDown(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclarationSingle!=null) VarDeclarationSingle.traverseBottomUp(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationListMultiple(\n");

        if(VarDeclarationSingle!=null)
            buffer.append(VarDeclarationSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclarationList!=null)
            buffer.append(VarDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationListMultiple]");
        return buffer.toString();
    }
}
