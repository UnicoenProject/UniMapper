package net.unicoen;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ExprLexer lexer = new ExprLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    JavaParser parser = new JavaParser(tokens);
    ParserRuleContext<Token> tree = parser.compilationUnit(); // parse
    ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
    ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
    walker.walk(extractor, tree); // initiate walk of tree with listener
  }

}
