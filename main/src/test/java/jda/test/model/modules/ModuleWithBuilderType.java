package jda.test.model.modules;

import java.awt.event.KeyEvent;
import java.util.List;

import jda.modules.common.types.properties.PropertyDesc;
import jda.modules.common.types.properties.PropertyName;
import jda.modules.dcsl.syntax.Select;
import jda.modules.exportdoc.controller.html.DefaultHtmlDocumentBuilder;
import jda.modules.helpviewer.model.print.PrintDesc;
import jda.modules.helpviewer.model.print.PrintFieldDesc;
import jda.modules.mccl.syntax.MCCLConstants;
import jda.modules.mccl.syntax.ModuleDescriptor;
import jda.modules.mccl.syntax.MCCLConstants.AlignmentX;
import jda.modules.mccl.syntax.MCCLConstants.PageFormat;
import jda.modules.mccl.syntax.view.AttributeDesc;
import jda.modules.mccl.syntax.view.ViewDesc;
import jda.mosa.view.assets.datafields.list.JComboField;
import jda.mosa.view.assets.panels.DefaultPanel;

/**
 * Represents the definition of a report
 * @author dmle
 *
 */
@ModuleDescriptor(
    name="ModuleA",
    viewDesc=@ViewDesc(
      props={
          @PropertyDesc(name=PropertyName.view_toolBar_buttonIconDisplay,
              valueAsString="true",valueType=Boolean.class),
          @PropertyDesc(name=PropertyName.view_toolBar_buttonTextDisplay,
              valueAsString="false",valueType=Boolean.class),
          @PropertyDesc(name=PropertyName.view_searchToolBar_buttonIconDisplay,
              valueAsString="true",valueType=Boolean.class),
          @PropertyDesc(name=PropertyName.view_searchToolBar_buttonTextDisplay,
              valueAsString="false",valueType=Boolean.class),
              /* use these for object form actions
          @PropertyDesc(name=PropertyName.view_objectForm_actions_buttonIconDisplay,
              valueAsString="true",valueType=Boolean.class),
          @PropertyDesc(name=PropertyName.view_objectForm_actions_buttonTextDisplay,
              valueAsString="false",valueType=Boolean.class),
              */
           ////// Keyboard shot-cuts
          @PropertyDesc(name=PropertyName.view_shotcuts_tool_Open, 
            valueAsString=KeyEvent.VK_F2+"", valueType=Integer.class)
         }        
    )
) // end ModuleDescriptor
@PrintDesc(
    pageFormat=PageFormat.Landscape,
    docBuilderType=DefaultHtmlDocumentBuilder.class)
public class ModuleWithBuilderType {
  @AttributeDesc(label="DANH S??CH C?? KH???U CH??A B???U TH???NG")
  private String title;

  @AttributeDesc(label=MCCLConstants.SYMBOL_ContainerHandle,
      editable=false,
      type=DefaultPanel.class                // for data viewing
  )
  @PrintFieldDesc(
      refId="p1",
      isLabelVisible=false,
      printConfig=ModulePrintA.class) 
  private List persons;

  @AttributeDesc(label="Ch???n ch??? k??",
      type=JComboField.class,
      ref=@Select(clazz=Object.class,attributes={"description"}),
      isStateEventSource=true
      )
  @PrintFieldDesc(isVisible=false)  
  private Object sigSelect;

  @AttributeDesc(label="Hi???n th??? <br>ch??? k??",
      alignX=AlignmentX.Right,
      type=DefaultPanel.class
      )
  @PrintFieldDesc(
      refId="p2",         // a separate print area
      isLabelVisible=false)
  private Object sig;
}
