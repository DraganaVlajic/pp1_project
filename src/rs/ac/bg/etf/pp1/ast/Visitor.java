// generated with ast extension for cup
// version 0.8
// 24/0/2022 2:10:10


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Designator Designator);
    public void visit(Factor Factor);
    public void visit(Mulop Mulop);
    public void visit(MethodReturnType MethodReturnType);
    public void visit(VarDeclarationSingle VarDeclarationSingle);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ConstDeclarationList ConstDeclarationList);
    public void visit(ExprList ExprList);
    public void visit(Expr Expr);
    public void visit(VarDeclarationMethod VarDeclarationMethod);
    public void visit(FormalParamList FormalParamList);
    public void visit(FormalParam FormalParam);
    public void visit(SingleStatement SingleStatement);
    public void visit(PrintConst PrintConst);
    public void visit(Addop Addop);
    public void visit(VarDeclarationList VarDeclarationList);
    public void visit(ConstDeclarationSingle ConstDeclarationSingle);
    public void visit(Statement Statement);
    public void visit(DeclarationBlock DeclarationBlock);
    public void visit(MethodDeclarationList MethodDeclarationList);
    public void visit(FormalParams FormalParams);
    public void visit(Term Term);
    public void visit(StatementList StatementList);
    public void visit(Type Type);
    public void visit(FactorNew FactorNew);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorBoolConst FactorBoolConst);
    public void visit(FactorCharConst FactorCharConst);
    public void visit(FactorNumConst FactorNumConst);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMul MulopMul);
    public void visit(TermList TermList);
    public void visit(TermFactor TermFactor);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(ExpressionAddop ExpressionAddop);
    public void visit(ExpressionTerm ExpressionTerm);
    public void visit(ExpressionMinus ExpressionMinus);
    public void visit(Expression Expression);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(DesignatorIdentifier DesignatorIdentifier);
    public void visit(DesignatorDecrement DesignatorDecrement);
    public void visit(DesignatorIncrement DesignatorIncrement);
    public void visit(DesignatorAssignment DesignatorAssignment);
    public void visit(PrintConstEmpty PrintConstEmpty);
    public void visit(PrintConstPresent PrintConstPresent);
    public void visit(SingleStatementGoto SingleStatementGoto);
    public void visit(SingleStatementPrint SingleStatementPrint);
    public void visit(SingleStatementRead SingleStatementRead);
    public void visit(SingleStatementDesignator SingleStatementDesignator);
    public void visit(StatementListMultiple StatementListMultiple);
    public void visit(StatementListSingle StatementListSingle);
    public void visit(Statements Statements);
    public void visit(LabelName LabelName);
    public void visit(StatementListBase StatementListBase);
    public void visit(StatementWithLabel StatementWithLabel);
    public void visit(StatementSingle StatementSingle);
    public void visit(VarDeclarationMethodEmpty VarDeclarationMethodEmpty);
    public void visit(VarDeclarationMethodPresent VarDeclarationMethodPresent);
    public void visit(FormalParamArray FormalParamArray);
    public void visit(FormalParamType FormalParamType);
    public void visit(FormalParamMultiple FormalParamMultiple);
    public void visit(FormalParamSingle FormalParamSingle);
    public void visit(FormalParamsEmpty FormalParamsEmpty);
    public void visit(FormalParamsPresent FormalParamsPresent);
    public void visit(MethodReturnTypeVoid MethodReturnTypeVoid);
    public void visit(MethodReturnTypeName MethodReturnTypeName);
    public void visit(MethodName MethodName);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(MethodDeclarationListEmpty MethodDeclarationListEmpty);
    public void visit(MethodDeclarationListMethod MethodDeclarationListMethod);
    public void visit(ConstDeclarationBool ConstDeclarationBool);
    public void visit(ConstDeclarationNum ConstDeclarationNum);
    public void visit(ConstDeclarationChar ConstDeclarationChar);
    public void visit(ConstDeclarationListMultiple ConstDeclarationListMultiple);
    public void visit(ConstDeclarationListElem ConstDeclarationListElem);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(VarDeclarationSingleArray VarDeclarationSingleArray);
    public void visit(VarDeclarationSingleVar VarDeclarationSingleVar);
    public void visit(VarDeclarationListMultiple VarDeclarationListMultiple);
    public void visit(VarDeclarationListElem VarDeclarationListElem);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(DeclarationBlockEmpty DeclarationBlockEmpty);
    public void visit(DeclarationBlockConst DeclarationBlockConst);
    public void visit(DeclarationBlockVar DeclarationBlockVar);
    public void visit(ProgramBegin ProgramBegin);
    public void visit(Program Program);

}
