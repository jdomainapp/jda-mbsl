package jda.modules.mbsl.model.graph;

import jda.modules.common.exceptions.NotPossibleException;
import jda.mosa.module.ModuleService;

/**
 * @overview 
 *  Coordinator Node is a Node that does not pass its data out to the outgoing edges. Instead, it passes the original input data out.
 *  
 *  <br>Coordinator nodes are typically used to capture coordinated tasks. 
 *  
 * @author Duc Minh Le (ducmle)
 *
 * @version 5.6
 */
public class CoordinatorNode extends Node {

  /**
   * @effects 
   *
   */
  public CoordinatorNode(String label, Class refCls, Class serviceCls) {
    super(label, refCls, serviceCls);
    // TODO Auto-generated constructor stub
  }

  /**
   * @effects 
   * 
   * @version 
   */
  @Override
  protected void execOffer(Node src, ModuleService actMService, Object[] args,
      Object... results) throws NotPossibleException {
      // coordinator node does not pass its data out, it passes the original data out instead
      getOut().get(0).exec(actMService, args);
  }

}
