package net.unicoen;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import parser.ExprBaseListener;
import parser.ExprParser;

public class MyExprListener extends ExprBaseListener {
  private ExprParser _parser;

  public MyExprListener(ExprParser parser) {
    _parser = parser;
  }

  @Override
  public void enterProg(ExprParser.ProgContext ctx) {
    System.out.println(ctx);
  }

  @Override
  public void exitProg(ExprParser.ProgContext ctx) {
    System.out.println(ctx);
  }

  @Override
  public void enterExpr(ExprParser.ExprContext ctx) {
    System.out.println(ctx);
  }

  @Override
  public void exitExpr(ExprParser.ExprContext ctx) {
    System.out.println(ctx);
  }

  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
    System.out.println(ctx);
  }

  @Override
  public void exitEveryRule(ParserRuleContext ctx) {
    System.out.println(ctx);
  }

  @Override
  public void visitTerminal(TerminalNode node) {
    System.out.println(node);
  }

  @Override
  public void visitErrorNode(ErrorNode node) {
    System.out.println(node);
  }
}
