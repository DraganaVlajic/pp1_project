// generated with ast extension for cup
// version 0.8
// 24/0/2022 2:10:10


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationMethodPresent extends VarDeclarationMethod {

    private VarDeclaration VarDeclaration;
    private VarDeclarationMethod VarDeclarationMethod;

    public VarDeclarationMethodPresent (VarDeclaration VarDeclaration, VarDeclarationMethod VarDeclarationMethod) {
        this.VarDeclaration=VarDeclaration;
        if(VarDeclaration!=null) VarDeclaration.setParent(this);
        this.VarDeclarationMethod=VarDeclarationMethod;
        if(VarDeclarationMethod!=null) VarDeclarationMethod.setParent(this);
    }

    public VarDeclaration getVarDeclaration() {
        return VarDeclaration;
    }

    public void setVarDeclaration(VarDeclaration VarDeclaration) {
        this.VarDeclaration=VarDeclaration;
    }

    public VarDeclarationMethod getVarDeclarationMethod() {
        return VarDeclarationMethod;
    }

    public void setVarDeclarationMethod(VarDeclarationMethod VarDeclarationMethod) {
        this.VarDeclarationMethod=VarDeclarationMethod;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclaration!=null) VarDeclaration.accept(visitor);
        if(VarDeclarationMethod!=null) VarDeclarationMethod.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclaration!=null) VarDeclaration.traverseTopDown(visitor);
        if(VarDeclarationMethod!=null) VarDeclarationMethod.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclaration!=null) VarDeclaration.traverseBottomUp(visitor);
        if(VarDeclarationMethod!=null) VarDeclarationMethod.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationMethodPresent(\n");

        if(VarDeclaration!=null)
            buffer.append(VarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclarationMethod!=null)
            buffer.append(VarDeclarationMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationMethodPresent]");
        return buffer.toString();
    }
}
