// generated with ast extension for cup
// version 0.8
// 24/0/2022 2:10:10


package rs.ac.bg.etf.pp1.ast;

public class LabelName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String labelName;

    public LabelName (String labelName) {
        this.labelName=labelName;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName=labelName;
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
        buffer.append("LabelName(\n");

        buffer.append(" "+tab+labelName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LabelName]");
        return buffer.toString();
    }
}
