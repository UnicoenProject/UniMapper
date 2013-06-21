package net.unicoen;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

public class UniTree {
  private static UniTree TOP_NODE;
  private ParserRuleContext _current;
  private UniTree _parent = null;
  private UniTree _prev = null;
  private UniTree _next = null;
  private List<UniTree> _children = new ArrayList<UniTree>();

  public UniTree(ParserRuleContext ctx) {
    this._current = ctx;
  }

  public static void setTopNode(UniTree node) {
    TOP_NODE = node;
  }

  public void setParent(UniTree parent) {
    this._parent = parent;
  }

  public void setPrev(UniTree prev) {
    this._prev = prev;
  }

  public void setNext(UniTree next) {
    this._next = next;
  }

  public void addChild(UniTree child) {
    _children.add(child);
  }

  public ParserRuleContext getCurrent() {
    return this._current;
  }

  public static UniTree getTopNode() {
    return TOP_NODE;
  }

  public UniTree getParent() {
    return this._parent;
  }

  public UniTree getPrev() {
    return this._prev;
  }

  public UniTree getNext() {
    return this._next;
  }

  public List<UniTree> getChildren() {
    return this._children;
  }
}
