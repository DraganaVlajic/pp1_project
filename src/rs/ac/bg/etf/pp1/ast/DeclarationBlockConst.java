// generated with ast extension for cup
// version 0.8
// 24/0/2022 2:10:10


package rs.ac.bg.etf.pp1.ast;

public class DeclarationBlockConst extends DeclarationBlock {

    private ConstDeclaration ConstDeclaration;
    private DeclarationBlock DeclarationBlock;

    public DeclarationBlockConst (ConstDeclaration ConstDeclaration, DeclarationBlock DeclarationBlock) {
        this.ConstDeclaration=ConstDeclaration;
        if(ConstDeclaration!=null) ConstDeclaration.setParent(this);
        this.DeclarationBlock=DeclarationBlock;
        if(DeclarationBlock!=null) DeclarationBlock.setParent(this);
    }

    public ConstDeclaration getConstDeclaration() {
        return ConstDeclaration;
    }

    public void setConstDeclaration(ConstDeclaration ConstDeclaration) {
        this.ConstDeclaration=ConstDeclaration;
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
        if(ConstDeclaration!=null) ConstDeclaration.accept(visitor);
        if(DeclarationBlock!=null) DeclarationBlock.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclaration!=null) ConstDeclaration.traverseTopDown(visitor);
        if(DeclarationBlock!=null) DeclarationBlock.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclaration!=null) ConstDeclaration.traverseBottomUp(visitor);
        if(DeclarationBlock!=null) DeclarationBlock.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclarationBlockConst(\n");

        if(ConstDeclaration!=null)
            buffer.append(ConstDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclarationBlock!=null)
            buffer.append(DeclarationBlock.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclarationBlockConst]");
        return buffer.toString();
    }
}
