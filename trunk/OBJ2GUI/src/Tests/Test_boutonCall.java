package Tests;


import OBJ2GUI.Annotations.GUI_CLASS;
import OBJ2GUI.Annotations.GUI_FIELD_TYPE;

@GUI_CLASS(type=GUI_CLASS.Type.BoxLayout, BoxLayout_property=GUI_CLASS.Type_BoxLayout.X)
public class Test_boutonCall {
	public enum Rank { BEURRE, FERME, VACHE, YAOURTH };    

	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.TEXTFIELD)
	private float Valeur1 = 12.5f;
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.TEXTFIELD)
	private float Valeur2 = 12.5f;
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.COMBO, min=0, max=10, divider=1000)
	private Rank Rank_1 = Rank.FERME;
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.METHOD_CALL, method_name="callTest")
	private Object Bouton_1 = null; // Px importe son type en fait.
	
	public void debug()
	{
		System.err.println("Test2_Valuer1 == "+Valeur1);
		System.err.println("Test2_Valeur1 == "+Valeur2);
		System.err.println("Rank_1 == "+Rank_1);
	}
	
	public void callTest()
	{
		Valeur1 = 666;
		Valeur2 = 999;
		Rank_1 = Rank.BEURRE;
	}
	
	@Override
	public String toString()
	{
		return "TestObject2";
	}

	public synchronized float getValeur1()
	{
		return Valeur1;
	}

	public synchronized void setValeur1(float valeur1)
	{
		Valeur1 = valeur1;
	}

	public synchronized float getValeur2()
	{
		return Valeur2;
	}

	public synchronized void setValeur2(float valeur2)
	{
		Valeur2 = valeur2;
	}

	public synchronized Rank getRank_1()
	{
		return Rank_1;
	}

	public synchronized Object getBouton_1()
	{
		return Bouton_1;
	}

	public synchronized void setBouton_1(Object bouton_1)
	{
		Bouton_1 = bouton_1;
	}

	public synchronized void setRank_1(Rank rank_1)
	{
		Rank_1 = rank_1;
	}
		
}
