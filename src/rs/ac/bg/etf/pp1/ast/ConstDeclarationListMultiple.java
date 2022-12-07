// generated with ast extension for cup
// version 0.8
// 24/0/2022 2:10:10


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationListMultiple extends ConstDeclarationList {

    private ConstDeclarationSingle ConstDeclarationSingle;
    private ConstDeclarationList ConstDeclarationList;

    public ConstDeclarationListMultiple (ConstDeclarationSingle ConstDeclarationSingle, ConstDeclarationList ConstDeclarationList) {
        this.ConstDeclarationSingle=ConstDeclarationSingle;
        if(ConstDeclarationSingle!=null) ConstDeclarationSingle.setParent(this);
        this.ConstDeclarationList=ConstDeclarationList;
        if(ConstDeclarationList!=null) ConstDeclarationList.setParent(this);
    }

    public ConstDeclarationSingle getConstDeclarationSingle() {
        return ConstDeclarationSingle;
    }

    public void setConstDeclarationSingle(ConstDeclarationSingle ConstDeclarationSingle) {
        this.ConstDeclarationSingle=ConstDeclarationSingle;
    }

    public ConstDeclarationList getConstDeclarationList() {
        return ConstDeclarationList;
    }

    public void setConstDeclarationList(ConstDeclarationList ConstDeclarationList) {
        this.ConstDeclarationList=ConstDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclarationSingle!=null) ConstDeclarationSingle.accept(visitor);
        if(ConstDeclarationList!=null) ConstDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclarationSingle!=null) ConstDeclarationSingle.traverseTopDown(visitor);
        if(ConstDeclarationList!=null) ConstDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclarationSingle!=null) ConstDeclarationSingle.traverseBottomUp(visitor);
        if(ConstDeclarationList!=null) ConstDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationListMultiple(\n");

        if(ConstDeclarationSingle!=null)
            buffer.append(ConstDeclarationSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclarationList!=null)
            buffer.append(ConstDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationListMultiple]");
        return buffer.toString();
    }
}
