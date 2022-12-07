package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.mj.runtime.Code;

import java.io.*;

public class Compiler {

    public static void main(String[] args) {
        for (String arg : args) {
            Reader fileReader = null;
            try {
                fileReader = new FileReader(arg);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (fileReader != null) {
                try {
                    String[] argNameParts = arg.split("\\.");
                    String outputFileName;
                    if (argNameParts.length == 1) {
                        outputFileName = arg + ".obj";
                    } else {
                        outputFileName = argNameParts[0] + ".obj";
                    }
                    System.out.println(outputFileName);
                    doCompileSource(fileReader, new FileOutputStream(outputFileName));
                    System.out.println("Fajl " + arg + " je uspesno kompajliran. Izlaz: " + outputFileName);
                } catch (FileNotFoundException e) {
                    System.out.println("Nije pronadjen fajl " + e.getMessage());
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("Greska pri kompilaciji fajla! Greska:");
                    e.printStackTrace();
                }
            }
        }
    }

    public static void doCompileSource(Reader inputReader, OutputStream outputStream) throws Exception {
        Yylex lexer = new Yylex(inputReader);
        MJParser parser = new MJParser(lexer);
        Symbol root = parser.parse();
        Program program = (Program) root.value;

        System.out.println(program.toString(""));

        SemanticPass semanticPass = new SemanticPass();
        program.traverseBottomUp(semanticPass);

        if (semanticPass.hadError()) {
            System.out.println("Kompilacija je obustavljena");
        } else {
            CodeGenerationPass codeGenerationPass = new CodeGenerationPass(program);
            program.traverseBottomUp(codeGenerationPass);

            Code.write(outputStream);
        }
    }

}
