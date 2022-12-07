// generated with ast extension for cup
// version 0.8
// 24/0/2022 2:10:10


package rs.ac.bg.etf.pp1.ast;

public class DeclarationBlockVar extends DeclarationBlock {

    private VarDeclaration VarDeclaration;
    private DeclarationBlock DeclarationBlock;

    public DeclarationBlockVar (VarDeclaration VarDeclaration, DeclarationBlock DeclarationBlock) {
        this.VarDeclaration=VarDeclaration;
        if(VarDeclaration!=null) VarDeclaration.setParent(this);
        this.DeclarationBlock=DeclarationBlock;
        if(DeclarationBlock!=null) DeclarationBlock.setParent(this);
    }

    public VarDeclaration getVarDeclaration() {
        return VarDeclaration;
    }

    public void setVarDeclaration(VarDeclaration VarDeclaration) {
        this.VarDeclaration=VarDeclaration;
    }

    public DeclarationBlock getDeclarationBlock() {
        return DeclarationBlock;
    }

    public void setDeclarationBlock(DeclarationBlock DeclarationBlock) {
        this.DeclarationBlock=DeclarationBlock;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclaration!=null) VarDeclaration.accept(visitor);
        if(DeclarationBlock!=null) DeclarationBlock.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclaration!=null) VarDeclaration.traverseTopDown(visitor);
        if(DeclarationBlock!=null) DeclarationBlock.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclaration!=null) VarDeclaration.traverseBottomUp(visitor);
        if(DeclarationBlock!=null) DeclarationBlock.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclarationBlockVar(\n");

        if(VarDeclaration!=null)
            buffer.append(VarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclarationBlock!=null)
            buffer.append(DeclarationBlock.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclarationBlockVar]");
        return buffer.toString();
    }
}
