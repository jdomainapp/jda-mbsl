package jda.modules.mbsl.model.graph;

/**
 * @overview 
 *  Represents different types of activity nodes
 *  
 * @author Duc Minh Le (ducmle)
 */
public enum NodeType {
  Action,
  Decision,
  Fork,
  Join,
  Merge,
  // v5.6
  /* coordinates between other nodes, passing along their data. It does not pass its own data (if any) along*/
  Coordinator
  ;
}
