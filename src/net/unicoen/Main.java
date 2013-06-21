package net.unicoen;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import parser.JavaLexer;
import parser.JavaParser;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    CharStream input = new ANTLRInputStream("public class Test {\nint zero() {\nreturn 0;}}");
    JavaLexer lexer = new JavaLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    JavaParser parser = new JavaParser(tokens);
    ParserRuleContext tree = parser.compilationUnit(); // parse
    ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
    ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
    walker.walk(extractor, tree); // initiate walk of tree with listener
    System.out.println(UniTree.getTopNode().getCurrent().getClass().getName());
  }

}
