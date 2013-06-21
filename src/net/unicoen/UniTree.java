package net.unicoen;

import java.util.ArrayList;
import java.util.List;

public class UniTree {
  private UniTree _parent = null;
  private UniTree _current;
  private List<UniTree> _children = new ArrayList<UniTree>();
  
  public UniTree(UniTree parent, List<UniTree> children, List<UniTree> sibling) {
    this._parent = parent;
    this._children = children;
  }
}
