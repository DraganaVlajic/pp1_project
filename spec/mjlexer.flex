package rs.ac.bg.etf.pp1;
import java_cup.runtime.Symbol;


%%

%{

    private Symbol newSymbol(int type){
        return new Symbol(type, yyline + 1, yycolumn);
    }

    private Symbol newSymbol(int type, Object value){
        return new Symbol(type, yyline + 1, yycolumn, value);
    }

%}

%eofval{
    return newSymbol(sym.EOF);
%eofval}



%cup
%line
%column

%xstate COMMENT

%%

" "     { }
"\b"    { }
"\f"    { }
"\t"    { }
"\r\n"  { }
"\n"    { }

"program" { return newSymbol(sym.PROGRAM); }
"read"    { return newSymbol(sym.READ); }
"print"   { return newSymbol(sym.PRINT); }
"goto"    { return newSymbol(sym.GOTO); }
"new"     { return newSymbol(sym.NEW); }

"const"   { return newSymbol(sym.CONST); }
"void"    { return newSymbol(sym.VOID); }

"{"       { return newSymbol(sym.CURLY_PAREN_LEFT); }
"}"       { return newSymbol(sym.CURLY_PAREN_RIGHT); }
"["       { return newSymbol(sym.SQUARE_PAREN_LEFT); }
"]"       { return newSymbol(sym.SQUARE_PAREN_RIGHT); }
"("       { return newSymbol(sym.PAREN_LEFT); }
")"       { return newSymbol(sym.PAREN_RIGHT); }

"="       { return newSymbol(sym.EQUALS); }
"++"      { return newSymbol(sym.PLUS_PLUS); }
"--"      { return newSymbol(sym.MINUS_MINUS); }
"+"       { return newSymbol(sym.PLUS); }
"-"       { return newSymbol(sym.MINUS); }
"*"       { return newSymbol(sym.MUL); }
"/"       { return newSymbol(sym.DIV); }
"%"       { return newSymbol(sym.MOD); }

";"       { return newSymbol(sym.SEMICOLON); }
":"       { return newSymbol(sym.COLON); }
","       { return newSymbol(sym.COMMA); }

[0-9]+                { return newSymbol(sym.CONST_NUM, new Integer(yytext())); }
'.'                   { return newSymbol(sym.CONST_CHAR, yytext().charAt(1)); }
"true"                { return newSymbol(sym.CONST_BOOL, true); }
"false"               { return newSymbol(sym.CONST_BOOL, false); }
[a-zA-Z][a-zA-Z0-9_]* { return newSymbol(sym.IDENTIFIER, yytext()); }

"//" { yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL);}
<COMMENT> "\n" { yybegin(YYINITIAL);}


. { System.out.println("Pronadjen ilegalni karakter: ''"+ yytext() + "', Linija/kolona: " + (yyline + 1) + "/" + yycolumn); }


