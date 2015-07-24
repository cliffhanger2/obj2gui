# Object 2 Gui #

## Introduction ##

This project aim to generate automatically GUI corresponding to an existing instance of object, helping developer to win time on first stage of (GUI) development.

Generation is based on variables annotations with multiple parameters, helping to design more sophisticated GUI.

Works as simple as it needs only some lines of code to generate a "JPanel" reflecting an objects where variables becomes viewable/editable.

All input controls are normally done automatically to forbid bad input of the user avoiding developer headache. (eg : Textfield binded to an Integer : user shouldn't be allowed to put non digit characters).

## Functions ##

- Support unboxed,boxed variables : int, float, double, Int, Float, array[.md](.md), array[.md](.md)[.md](.md), Date and more.

- Different type of Swing/Swingx Object available for each kinds of variables
(Eg : a Integer variable could be represented as a TextField or a Slider; an enumeration could be represented as a JList or a Combobox).
JTextField, JSlider, JCombobox, JList, JXDatePicker, RotativeSlider, JWSlider (custom and fun sliders)...

- Support Collections using JList to select which object to GUIiffy. (Object contained in collections).

- XML files available for customizing labels/tool-tip of the generated components.

- Recursive introspection (A object could contains other objects that will be encap in a TaskPane like panel).

- Event system to be noticed of all changed values in objects. (Needed for eg to repaint something or do an action if something has to be reflected somewhere).

- Different Layout available (BoxLayout, Grid, NullLayout) to construct the gui.

## How to use ##

### Creating the GUI from an object instance ###

```
Test objet = new Test();
JWPanel panel = (JWPanel) ParseurAnnotations.CreatePanelFromObject(objet);
```

when of course, you defined Test with all Annotations required.

### Exemple 1 ###

```

// Define the general Layout used by the future panel.
@GUI_CLASS(type=GUI_CLASS.Type.BoxLayout, BoxLayout_property=GUI_CLASS.Type_BoxLayout.Y) 
public class Test
{
	public enum Rank { DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE };    
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.LIST)
	private Rank Enum_2 = Rank.TEN;
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.TEXTFIELD)
	private float Valeur1 = 12.5f;
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.SLIDER, min=0, max=10, divider=1000)
	private float Valeur2 = 0f;
        ...
        all getters/setters of these variables (used by reflection to get values)
        ...
}

```


This will result in something like that :

![http://renaud.warnotte.be/images/stories/Own/screenshot_obj2gui_1.jpg](http://renaud.warnotte.be/images/stories/Own/screenshot_obj2gui_1.jpg)


### Exemple 2 ###


```
public enum Rank { DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE };    
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.LIST)
private Rank Enum_2 = Rank.TEN;
	  
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.TEXTFIELD)
private float Valeur1 = 12.5f;
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.SLIDER, min=0, max=10, divider=1000)
private float Valeur2 = 0.125f;
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.SLIDER, min=0, max=5000, divider=1, slider_type=GUI_FIELD_TYPE.Type_SLIDER.FLAT)
private Integer Valeur3 = 50;
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.SLIDER, min=0, max=5, divider=1, slider_type=GUI_FIELD_TYPE.Type_SLIDER.FLAT)
private float Valeur4 = 4f;
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.SLIDER, min=0, max=50, divider=10, slider_type=GUI_FIELD_TYPE.Type_SLIDER.FLAT)
private int Valeur4Bis = 4;
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.SLIDER, slider_type=GUI_FIELD_TYPE.Type_SLIDER.ROTATIVE)
private int Valeur5 = 50;
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.CHECKBOX)
private boolean Boolean1 = false;
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.CHECKBOX)
private boolean Boolean2 = true;
	
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.COLOR)
private JWColor Couleur = new JWColor(0,0,0,255);
	
	
@GUI_FIELD_TYPE()
private String String1 = "Salut mon enfant";
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.TEXTFIELD)
private String String2 = "Salut mon enfant";
	
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.CALENDAR)
private Date Date_Sys = new Date();
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.CALENDAR)
private Date Date_Fixed = new Date(15,12,2005);
	
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.COMBO)
private Rank Enum_1 = Rank.THREE;
	        
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.LIST)
private Float []Float_list={1f,2f,4f,9f,95f,100f,200.5f};

@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.ARRAYLIKE)
private Float []Float_sub_array={5f,4f,3f,8f,9f,10f,0.5f};
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.ARRAYLIKE)
	private Float [][]Float_DUOsub_array=
	{{1f,4f,3f,8f,9f,10f,0.5f},
	 {2.23f,4f,3f,8f,9f,10f,0.5f},
	 {3f,4f,3f,8f,9f,10f,0.5f},
	 {4f,4.44f,3f,8f,9f,10f,0.5f}};
    
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.PANELISABLE)
private Test2 Test_sub_object = new Test2();

@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.LISTLIKE)
private Vector<Object> Vector_Objets = new Vector<Object>();
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.LISTLIKE)
private ArrayList<Object> ArrayList_Objets = new ArrayList<Object>();
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.LISTLIKE)
private LinkedList<Object> LinkedList_Objets = new LinkedList<Object>();
    
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.MAPLIKE)
private HashMap<String, Object> Hashmap_Objets_intkey = new HashMap<String, Object> ();
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.MAPLIKE)
private HashMap<Integer, Object> Hashmap_Objets_stringkey = new HashMap<Integer, Object> ();
    
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.SETLIKE)
private HashSet<Object> HashSet = new HashSet<Object>(); 
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.ARRAYLIKE)
private Object []EDIT_MixedObject1DArray = {0,new String("Bloating"),"Extraordinary", 5.5f};
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.ARRAYLIKE)
private String [][]String2DArray=
{
	{"I'm a pure string 1-1", "I'm a pure string 2-1"},
	{"I'm a pure string 2-1", "I'm a pure string 2-2"},
};
@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.ARRAYLIKE)
private Object [][]Object2DArrayMixedTypes=
{
	{1.2f,"<- This is a float"},
	{"This is a integer ->",2}
};
```

will give you :

![http://renaud.warnotte.be/images/stories/Own/screenshot_obj2gui_21.jpg](http://renaud.warnotte.be/images/stories/Own/screenshot_obj2gui_21.jpg)

### Exemple 3 - Using the myEventOccurred to be noticed of user change ###

```
JWPanel panel = (JWPanel) ParseurAnnotations.CreatePanelFromObject(objet);
panel.addMyEventListener(new MyEventListener()
{
  public void myEventOccurred(MyChangedEvent e)
  {
    // That is called if user changes the value of inside components.
    System.err.println("*** Object has changed, make the needed things ...");
  }
});
```

### Exemple 4 - Load / Saving labels of generated GUI for customisation ###

This method is used if you want more user friendly labels (and tool-tips) instead of variables names.

1) Save the panel and it's current Labels in a XML file by doing :

Saving labels into a file (needed the first time)
```
   GUI2XMLLabel.SaveLabel(panel, "labels.xml"); // Panel is the generated panel.
```

2) Edit eventually this file to change the labels and tool-tips.

3) Load the label inside application by doing :

```
   GUI2XMLLabel.LoadLabel(panel, "labels.xml"); // Panel is the generated panel.
```


OBJ2GUI Version 2.0 is on the road. It'll now be able to play with list of object (instead of only one), making all merge/avg/sum/other of properties, creating the gui ... etc ... a pleasure for lazy coders and nearly full automatic binding.

Note of 21/05/2014 : Also want to add non annotated class support by mapping defintion or something.
