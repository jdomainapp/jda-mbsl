package jda.modules.setup.modules;

import static jda.modules.mccl.conceptmodel.view.RegionName.Add;
import static jda.modules.mccl.conceptmodel.view.RegionName.Chart;
import static jda.modules.mccl.conceptmodel.view.RegionName.Delete;
import static jda.modules.mccl.conceptmodel.view.RegionName.Export;
import static jda.modules.mccl.conceptmodel.view.RegionName.First;
import static jda.modules.mccl.conceptmodel.view.RegionName.Last;
import static jda.modules.mccl.conceptmodel.view.RegionName.New;
import static jda.modules.mccl.conceptmodel.view.RegionName.Next;
import static jda.modules.mccl.conceptmodel.view.RegionName.ObjectScroll;
import static jda.modules.mccl.conceptmodel.view.RegionName.Previous;
import static jda.modules.mccl.conceptmodel.view.RegionName.Print;

import java.util.List;

import jda.modules.mccl.conceptmodel.Configuration;
import jda.modules.mccl.conceptmodel.Configuration.Organisation;
import jda.modules.mccl.conceptmodel.controller.LAName;
import jda.modules.mccl.conceptmodel.dodm.DODMConfig;
import jda.modules.mccl.conceptmodel.module.ApplicationModule;
import jda.modules.mccl.conceptmodel.module.ModuleType;
import jda.modules.mccl.conceptmodel.view.RegionName;
import jda.modules.mccl.conceptmodel.view.RegionType;
import jda.modules.mccl.conceptmodel.view.StyleName;
import jda.modules.mccl.syntax.ModuleDescriptor;
import jda.modules.mccl.syntax.SetUpDesc;
import jda.modules.mccl.syntax.MCCLConstants.AlignmentX;
import jda.modules.mccl.syntax.controller.ControllerDesc;
import jda.modules.mccl.syntax.controller.ControllerDesc.OpenPolicy;
import jda.modules.mccl.syntax.model.ModelDesc;
import jda.modules.mccl.syntax.view.AttributeDesc;
import jda.modules.mccl.syntax.view.ViewDesc;
import jda.modules.setup.commands.CopyResourceFilesCommand;
import jda.mosa.view.View;
import jda.mosa.view.assets.datafields.JLabelField;
import jda.mosa.view.assets.datafields.list.JComboField;
import jda.mosa.view.assets.datafields.text.JPasswordField;
import jda.mosa.view.assets.layout.TabLayoutBuilder;
import jda.mosa.view.assets.layout.TwoColumnLayoutBuilder;
import jda.mosa.view.assets.panels.DefaultPanel;

/**
 * @overview Represents application configuration parameters
 */
@ModuleDescriptor(
    name="ModuleConfiguration",
    modelDesc=@ModelDesc(
      model=Configuration.class
    ),
    viewDesc=@ViewDesc(
      formTitle="Qu???n l?? c???u h??nh ch????ng tr??nh",
      imageIcon="configuration.jpg",
      viewType=RegionType.Data,
      excludeComponents={ 
        // exclude some tool bar buttons and the Actions panel
        //Open, 
        New, Add, Delete, First, Previous, Next, Last, ObjectScroll,
        Chart, Export, Print, 
//        Refresh,
        //Actions
      },
      view=View.class,
      layoutBuilderType=TabLayoutBuilder.class,//TwoColumnLayoutBuilder.class,
      parent=RegionName.Help
      //style=StyleName.DefaultOnWhite
    ),
    controllerDesc=@ControllerDesc(
      defaultCommand=LAName.Open,
      openPolicy=OpenPolicy.O_C,
      isDataFieldStateListener=true
      ),
    type=ModuleType.System,
    isPrimary=true
    ,setUpDesc=@SetUpDesc(postSetUp=CopyResourceFilesCommand.class)   
    )
public class ModuleConfiguration {
  // no title
  @AttributeDesc(label="C???u h??nh ch????ng tr??nh"
      //styleLabel=StyleName.Heading1OnWhite
      )
  private String title;

  @AttributeDesc(label="T??n ch????ng tr??nh",
      type=JLabelField.class
      //styleLabel=StyleName.DefaultOnWhite,
      //styleField=StyleName.DefaultBlue
      )
  private String appName;
  
  @AttributeDesc(label="Phi??n b???n",type=JLabelField.class)  
  private String version;
  @AttributeDesc(label="Th?? m???c ch????ng tr??nh")  
  private String appFolder;
  @AttributeDesc(label="Ng??n ng???",
      type=JComboField.class,
      isStateEventSource=true
      //,type=JLabelField.class
      )
  private String language;

  //v2.8
  @AttributeDesc(label="C???u h??nh CSDL",type=DefaultPanel.class,
      controllerDesc=@ControllerDesc(openPolicy=OpenPolicy.O) 
      )  
  private DODMConfig dodmConfig;
  
  @AttributeDesc(label="V??? c??ng ty",type=DefaultPanel.class,
      //styleLabel=StyleName.Heading4,
      editable=false,
      controllerDesc=@ControllerDesc(openPolicy=OpenPolicy.O) // v2.6.4b
      )
  private Organisation organisation;
  
  @AttributeDesc(label="M??-??un m???c ?????nh")
  private String defaultModule;
  
  @AttributeDesc(label="Th?? m???c c??i ?????t")
  private String setUpFolder;
  
  @AttributeDesc(label="T??n NSD m???c ?????nh"
      ,alignX=AlignmentX.Center)
  private String userName;

  @AttributeDesc(label="M???t kh???u",type=JPasswordField.class
      ,alignX=AlignmentX.Center)
  private String password;
  
  @AttributeDesc(label="T??? l??? k??ch th?????c <br>c???a s??? ch??nh")
  private double mainGUISizeRatio;
  
  @AttributeDesc(label="T??? l??? k??ch th?????c <br>c???a s??? con")
  private double childGUISizeRatio;
  
  @AttributeDesc(label="B???o m???t?", isStateEventSource=true)    
  private boolean useSecurity;
  
  /** 
   * the number of millisecs before the current value on a list of values of 
   * a spinner control is selected 
   * Default: 25secs */
  @AttributeDesc(label="????? tr??? spinner")
  private int listSelectionTimeOut;
  
  /**
   * the location of the custom fonts
   */
  @AttributeDesc(label="Th?? m???c ph??ng")
  private String fontLocation;
  
  /**
   * the location of the images
   */
  @AttributeDesc(label="Th?? m???c ???nh")
  private String imageLocation;
    
  @AttributeDesc(label="C??c m??-??un",
      /*v2.6.4.b: type=JObjectTable.class,
       */
      type=DefaultPanel.class,
      editable=false,
      controllerDesc=@ControllerDesc(
          //openPolicy=OpenPolicy.O_C // v2.6.4b
          // v3.1: objectBrowser=PooledObjectBrowser.class,
          openPolicy=OpenPolicy.O_C
       ), 
      layoutBuilderType=TwoColumnLayoutBuilder.class,
      styleLabel=StyleName.Heading4
      )
  private List<ApplicationModule> modules;    
}