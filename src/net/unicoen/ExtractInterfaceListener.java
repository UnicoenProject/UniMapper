package net.unicoen;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import parser.JavaBaseListener;
import parser.JavaParser;

public class ExtractInterfaceListener extends JavaBaseListener {
  JavaParser parser;
  Stack<UniTree> stack = new Stack<UniTree>();

  public ExtractInterfaceListener(JavaParser parser) {
    this.parser = parser;
  }

  /** Listen to matches of classDeclaration */
  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
    UniTree node = new UniTree(ctx);
    stack.push(node);
  }

  @Override
  public void exitEveryRule(ParserRuleContext ctx) {
    UniTree node = stack.pop();
    if (!stack.isEmpty()) {
      UniTree parent = stack.peek();
      node.setParent(parent);
      parent.addChild(node);
    }
    else UniTree.setTopNode(node);
  }

  @Override
  public void visitTerminal(TerminalNode node) {
  }
}
