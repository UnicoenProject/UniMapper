package net.unicoen;

import org.antlr.v4.runtime.TokenStream;

import parser.JavaBaseListener;
import parser.JavaParser;

public class ExtractInterfaceListener extends JavaBaseListener {
  JavaParser parser;

  public ExtractInterfaceListener(JavaParser parser) {
    this.parser = parser;
  }

  /** Listen to matches of classDeclaration */
  @Override
  public void enterNormalClassDeclaration(JavaParser.NormalClassDeclarationContext ctx) {
    System.out.println("interface I" + ctx.Identifier() + " {");
  }

  @Override
  public void exitNormalClassDeclaration(JavaParser.NormalClassDeclarationContext ctx) {
    System.out.println("}");
  }

  /** Listen to matches of methodDeclaration */
  @Override
  public void enterMemberDecl(JavaParser.MemberDeclContext ctx) {
    TokenStream tokens = parser.getTokenStream(); // need parser to get tokens
    String type = "void";
    if (ctx.Identifier() != null) {
      type = tokens.getText(ctx.Identifier().getSourceInterval());
    }
//    String args = tokens.getText(ctx.formalParameters());
//    System.out.println("\t" + type + " " + ctx.Identifier() + args + ";");
  }
}
