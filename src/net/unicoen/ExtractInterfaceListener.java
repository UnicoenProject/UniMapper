package net.unicoen;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import parser.JavaBaseListener;
import parser.JavaParser;

public class ExtractInterfaceListener extends JavaBaseListener {
  JavaParser parser;

  public ExtractInterfaceListener(JavaParser parser) {
    this.parser = parser;
  }

  /** Listen to matches of classDeclaration */
  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
    String ruleOmittedName = getRuleName(ctx);
    System.out.println("<" + ruleOmittedName + ">");
    //if (ctx.getChildCount() == 1) {
      //ParseTree t = ctx.getChild(0);
      //System.out.println("  " + ctx.getText());
    //}
  }

  private String getRuleName(ParserRuleContext ctx) {
    String ruleClass = ctx.getClass().getName();
    String ruleName = ruleClass.split("\\$")[1];
    String ruleOmittedName = ruleName.substring(0, ruleName.length() - 7);
    return ruleOmittedName;
  }
  
  @Override
  public void exitEveryRule(ParserRuleContext ctx) {
    String ruleOmittedName = getRuleName(ctx);
    System.out.println("</" + ruleOmittedName + ">");
  }
  
  @Override
  public void visitTerminal(TerminalNode node) {
    int terminalNodeType = node.getSymbol().getType();
    if (terminalNodeType == -1) {
      return;
    }
    String terminalNodeName = parser.getTokenNames()[terminalNodeType];
    String startTag = "<" + terminalNodeName + ">";
    String endTag = "</" + terminalNodeName + ">";
    System.out.println(startTag + node.getText() + endTag);
  }
}
