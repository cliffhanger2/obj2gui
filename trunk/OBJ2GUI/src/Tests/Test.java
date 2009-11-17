package Tests;


import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;

import OBJ2GUI.Annotations.GUI_CLASS;
import OBJ2GUI.Annotations.GUI_FIELD_LOCATION;
import OBJ2GUI.Annotations.GUI_FIELD_LOCATIONs;
import OBJ2GUI.Annotations.GUI_FIELD_TYPE;
import WaxLibrary.Swing.Component.JWColor;


@GUI_CLASS(type=GUI_CLASS.Type.BoxLayout, BoxLayout_property=GUI_CLASS.Type_BoxLayout.Y)
//@GUI_CLASS(type=GUI_CLASS.Type.FlowLayout, FlowLayout_property=GUI_CLASS.Type_FlowLayout.CENTER)
//@GUI_CLASS(type=GUI_CLASS.Type.GridLayout, Type_GridLayout_COLUMNS=2)
//@GUI_CLASS(type=GUI_CLASS.Type.GridLayout, Type_GridLayout_ROWS=3)
//@GUI_CLASS(type=GUI_CLASS.Type.GridLayout, Type_GridLayout_COLUMNS=3)

//@GUI_CLASS(type=GUI_CLASS.Type.BoxLayout, BoxLayout_property=GUI_CLASS.Type_BoxLayout.Y)
//Field Location only need si Type==Absolute.
@GUI_FIELD_LOCATIONs({
@GUI_FIELD_LOCATION(cible="Valeur1",bounds="0,0,100,10"),
@GUI_FIELD_LOCATION(cible="Valeur2",bounds="0,10,100,10"),
@GUI_FIELD_LOCATION(cible="Valeur3",bounds="0,20,100,10"),
@GUI_FIELD_LOCATION(cible="Valeur4",bounds="0,30,100,10"),
@GUI_FIELD_LOCATION(cible="Valeur5",bounds="0,40,100,10") 
})

public class Test
{
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
	

	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.VECTOR3D)
	Vector3d Vect = new Vector3d(5,10,15);
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.VECTOR4D)
	Vector4d Vect2 = new Vector4d(5,10,15,25);
	
	
	@GUI_FIELD_TYPE()
	private String String1 = "Salut mon enfant";
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.TEXTFIELD)
	private String String2 = "Salut mon enfant";
	
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.CALENDAR)
	private Date Date_Sys = new Date();
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.CALENDAR)
	//
	private Date Date_Fixed = new Date();
	
	
	
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
    
	public synchronized HashSet<Object> getHashSet() {
		return HashSet;
	}
	public synchronized void setHashSet(HashSet<Object> hashSet) {
		HashSet = hashSet;
	}
	public Test()
    {
		Hashmap_Objets_intkey.put("Cle_1", new Test2());
    	Hashmap_Objets_intkey.put("Cle_2", new Test2());
    	//Hashmap_Objets_intkey.put("Cle_3", 4);
    	Hashmap_Objets_stringkey.put(4567, new Test2());
    	Hashmap_Objets_stringkey.put(8999, new Test2());
    	Test2 t = new Test2();
    	Hashmap_Objets_stringkey.put(6666, t);
    	Hashmap_Objets_stringkey.put(6667, t);
    	Hashmap_Objets_stringkey.put(6669, new Integer(456));
    	
    	HashSet.add(new Test2());
    	HashSet.add(new Test2());
    	GregorianCalendar gc = new GregorianCalendar(2005, 12, 15, 15, 30, 55);
    //	gc.set(2005, 12, 15, 15, 30, 55); // Don't work ?
    	Date_Fixed = gc.getTime();
    	//HashSet.add("Geraldine");
    }
    @Override
	public String toString()
    {
    	return "TestObject";
    }
    public void addObjets()
    {
    	Test2 t = new Test2();
    	Vector_Objets.add(t);
    	ArrayList_Objets.add(t);
    	LinkedList_Objets.add(new Test2());
    	
    }
    
	public void debug()
    {
    	System.err.println("Valeur1 == "+Valeur1);
    	System.err.println("Valeur2 == "+Valeur2);
    	System.err.println("Valeur3 == "+Valeur3);
    	System.err.println("Valeur4 == "+Valeur4);
    	System.err.println("Valeur4Bis == "+Valeur4Bis);
    	System.err.println("Valeur5 == "+Valeur5);

    	System.err.println("String1 == "+String1);
    	System.err.println("Boolean1 == "+Boolean1);
    	System.err.println("Boolean2 == "+Boolean2);
    	
    	System.err.println("Enum_1 == "+Enum_1);
    	System.err.println("Enum_2 == "+Enum_2);
    	for (int i = 0 ; i < Float_list.length;i++)
    	System.err.println("float_list["+i+"] == "+Float_list[i]);
    	
    	System.err.println("Values are []");
		for (int i = 0;i < Float_sub_array.length;i++)
		{
			System.err.println(""+Float_sub_array[i]);
		}
		
		System.err.println("Values are [][]");
		for (int i = 0;i < Float_DUOsub_array.length;i++)
		{
			for (int j = 0;j < Float_DUOsub_array[0].length;j++)
			{
				System.err.printf("%f, ",Float_DUOsub_array[i][j]);
			}
			System.err.println("");
		}
		
		for (int i = 0;i < String2DArray.length;i++)
		{
			for (int j = 0;j < String2DArray[0].length;j++)
			{
				System.err.printf("%16s, ",String2DArray[i][j]);
			}
			System.err.println("");
		}
		
		for (int i = 0;i < Object2DArrayMixedTypes.length;i++)
		{
			for (int j = 0;j < Object2DArrayMixedTypes[0].length;j++)
			{
				System.err.print(Object2DArrayMixedTypes[i][j]);
			}
			System.err.println("");
		}
		
		for (int i = 0;i < EDIT_MixedObject1DArray.length;i++)
		{
			System.err.println(""+EDIT_MixedObject1DArray[i]);
	
		}
		Test_sub_object.debug();
		
		System.err.println("List-Vector");
		for (int i = 0; i<Vector_Objets.size()  ;i++)
		{
			System.err.println("Element "+i);
			((Test2)Vector_Objets.get(i)).debug();
		}
		System.err.println("List-ArrayList");
		for (int i = 0; i<Vector_Objets.size()  ;i++)
		{
			System.err.println("Element "+i);
			((Test2)Vector_Objets.get(i)).debug();
		}
		System.err.println("List-LinkedList");
		for (int i = 0; i<LinkedList_Objets.size()  ;i++)
		{
			System.err.println("Element "+i);
			((Test2)LinkedList_Objets.get(i)).debug();
		}
		
		System.err.println("Hashmap_Objets_intkey");
		for (int i = 0; i<Hashmap_Objets_intkey.keySet().size()  ;i++)
		{
			System.err.println("Element "+i +" with key "+Hashmap_Objets_intkey.keySet().toArray()[i]);
			//Hashmap_Objets_intkey.values().toArray()[i];
			if (Hashmap_Objets_intkey.values().toArray()[i] instanceof Test2)
			((Test2)Hashmap_Objets_intkey.values().toArray()[i]).debug();
			else
				System.err.println(""+Hashmap_Objets_intkey.values().toArray()[i]);
		}
		
		System.err.println("Hashmap_Objets_stringkey");
		for (int i = 0; i<Hashmap_Objets_stringkey.keySet().size()  ;i++)
		{
			System.err.println("Element "+i +" with key "+Hashmap_Objets_stringkey.keySet().toArray()[i]);
			//Hashmap_Objets_intkey.values().toArray()[i];
			if (Hashmap_Objets_stringkey.values().toArray()[i] instanceof Test2)
			((Test2)Hashmap_Objets_stringkey.values().toArray()[i]).debug();
			else
				System.err.println(""+Hashmap_Objets_stringkey.values().toArray()[i]);
		}
		
		
		System.err.println("HashSet");
		for (int i = 0; i<HashSet.size()  ;i++)
		{
			System.err.println("Element "+i);
			//((Test2)HashSet.).debug();
		}
			
		
		
		
		System.err.println("Systeme date "+ Date_Sys);
		System.err.println("Fixed date "+ Date_Fixed);
    }
    
    
	public synchronized boolean isBoolean1() {
		return Boolean1;
	}
	public synchronized Float[][] getfloat_DUOsub_array() {
		return Float_DUOsub_array;
	}
	public synchronized Float[] getfloat_sub_array() {
		return Float_sub_array;
	}
	public synchronized Object[][] getObject2DArrayMixedTypes() {
		return Object2DArrayMixedTypes;
	}
	public synchronized String[][] getString2DArray() {
		return String2DArray;
	}
	public synchronized Object[] getEDIT_MixedObject1DArray() {
		return EDIT_MixedObject1DArray;
	}
	public synchronized Rank getEnum_1() {
		return Enum_1;
	}
	public synchronized Rank getEnum_2() {
		return Enum_2;
	}
	public synchronized String getString1() {
		return String1;
	}
	public synchronized float getValeur1() {
		return Valeur1;
	}
	public synchronized float getValeur2() {
		return Valeur2;
	}
	public synchronized Integer getValeur3() {
		return Valeur3;
	}
	public synchronized float getValeur4() {
		return Valeur4;
	}
	public synchronized int getValeur5() {
		return Valeur5;
	}
	public synchronized boolean isBoolean2() {
		return Boolean2;
	}
	public synchronized void setBoolean1(boolean boolean1) {
		Boolean1 = boolean1;
	}
	public synchronized void setObject2DArrayMixedTypes(
			Object[][] object2DArrayMixedTypes) {
		Object2DArrayMixedTypes = object2DArrayMixedTypes;
	}
	public synchronized void setString2DArray(String[][] string2DArray) {
		String2DArray = string2DArray;
	}
	public synchronized void setEDIT_MixedObject1DArray(Object[] mixedObject1DArray) {
		EDIT_MixedObject1DArray = mixedObject1DArray;
	}
	public synchronized void setEnum_1(Rank enum_1) {
		this.Enum_1 = enum_1;
	}
	public synchronized void setEnum_2(Rank enum_2) {
		this.Enum_2 = enum_2;
	}
	public synchronized void setString1(String string1) {
		String1 = string1;
	}
	public synchronized void setValeur1(float valeur1) {
		Valeur1 = valeur1;
	}
	public synchronized void setValeur2(float valeur2) {
		Valeur2 = valeur2;
	}
	public synchronized void setValeur3(Integer valeur3) {
		Valeur3 = valeur3;
	}
	public synchronized void setValeur4(float valeur4) {
		Valeur4 = valeur4;
	}
	public synchronized void setValeur5(int valeur5) {
		Valeur5 = valeur5;
	}
	public synchronized void setBoolean2(boolean boolean2) {
		Boolean2 = boolean2;
	}
	
	public synchronized Test2 getTest_sub_object() {
		return Test_sub_object;
	}
	public synchronized void setTest_sub_object(Test2 test_sub_object) {
		this.Test_sub_object = test_sub_object;
	}

	public synchronized Vector<Object> getVector_Objets() {
		return Vector_Objets;
	}
	public synchronized void setVector_Objets(Vector<Object> vector_Objets) {
		Vector_Objets = vector_Objets;
	}
	public synchronized Date getDate_Sys() {
		return Date_Sys;
	}
	public synchronized void setDate_Sys(Date date_Sys) {
		this.Date_Sys = date_Sys;
	}
	public synchronized Date getDate_Fixed() {
		return Date_Fixed;
	}
	public synchronized void setDate_Fixed(Date date_Fixed) {
		this.Date_Fixed = date_Fixed;
	}
	public synchronized ArrayList<Object> getArrayList_Objets() {
		return ArrayList_Objets;
	}
	public synchronized void setArrayList_Objets(ArrayList<Object> arrayList_Objets) {
		ArrayList_Objets = arrayList_Objets;
	}
	public synchronized LinkedList<Object> getLinkedList_Objets() {
		return LinkedList_Objets;
	}
	public synchronized void setLinkedList_Objets(
			LinkedList<Object> linkedList_Objets) {
		LinkedList_Objets = linkedList_Objets;
	}
    public synchronized HashMap<String, Object> getHashmap_Objets_intkey() {
		return Hashmap_Objets_intkey;
	}
	public synchronized void setHashmap_Objets_intkey(
			HashMap<String, Object> hashmap_Objets_intkey) {
		this.Hashmap_Objets_intkey = hashmap_Objets_intkey;
	}
	public synchronized HashMap<Integer, Object> getHashmap_Objets_stringkey() {
		return Hashmap_Objets_stringkey;
	}
	public synchronized void setHashmap_Objets_stringkey(
			HashMap<Integer, Object> hashmap_Objets_stringkey) {
		this.Hashmap_Objets_stringkey = hashmap_Objets_stringkey;
	}
	public synchronized String getString2() {
		return String2;
	}
	public synchronized void setString2(String string2) {
		String2 = string2;
	}
	public synchronized Float[] getFloat_list() {
		return Float_list;
	}
	public synchronized void setFloat_list(Float[] float_list) {
		this.Float_list = float_list;
	}
	public synchronized Float[] getFloat_sub_array() {
		return Float_sub_array;
	}
	public synchronized void setFloat_sub_array(Float[] float_sub_array) {
		this.Float_sub_array = float_sub_array;
	}
	public synchronized Float[][] getFloat_DUOsub_array() {
		return Float_DUOsub_array;
	}
	public synchronized void setFloat_DUOsub_array(Float[][] float_DUOsub_array) {
		this.Float_DUOsub_array = float_DUOsub_array;
	}
	public synchronized JWColor getCouleur() {
		return Couleur;
	}
	public synchronized void setCouleur(JWColor couleur) {
		this.Couleur = couleur;
	}
	public synchronized int getValeur4Bis() {
		return Valeur4Bis;
	}
	public synchronized void setValeur4Bis(int valeur4Bis) {
		Valeur4Bis = valeur4Bis;
	}
	public synchronized Vector3d getVect()
	{
		return Vect;
	}
	public synchronized void setVect(Vector3d vect)
	{
		this.Vect = vect;
	}
	public synchronized Vector4d getVect2()
	{
		return Vect2;
	}
	public synchronized void setVect2(Vector4d vect2)
	{
		Vect2 = vect2;
	}
}

//TextField, Slider, ComboBox, JList, DateChooser, ColorChooser, VectorViewer, [][]Viewer

