package Tests;


import OBJ2GUI.Annotations.GUI_CLASS;
import OBJ2GUI.Annotations.GUI_FIELD_TYPE;

@GUI_CLASS(type=GUI_CLASS.Type.BoxLayout, BoxLayout_property=GUI_CLASS.Type_BoxLayout.X)
public class Test2 {
	public enum Rank { BEURRE, FERME, VACHE, YAOURTH };    

	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.TEXTFIELD)
	private float Test2_Valeur1 = 12.5f;
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.SLIDER, min=0, max=10, divider=1000)
	private float Test2_Valeur2 = 125f;
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.COMBO, min=0, max=10, divider=1000)
	private Rank Rank_1 = Rank.FERME;
	
	public void debug()
	{
		System.err.println("Test2_Valuer1 == "+Test2_Valeur1);
		System.err.println("Test2_Valeur1 == "+Test2_Valeur2);
		System.err.println("rank_1 == "+Rank_1);
	}
	
	@Override
	public String toString()
	{
		return "TestObject2";
	}
	
	public synchronized float getTest2_Valeur1() {
		return Test2_Valeur1;
	}

	public synchronized void setTest2_Valeur1(float test2_Valeur1) {
		Test2_Valeur1 = test2_Valeur1;
	}

	public synchronized float getTest2_Valeur2() {
		return Test2_Valeur2;
	}

	public synchronized void setTest2_Valeur2(float test2_Valeur2) {
		Test2_Valeur2 = test2_Valeur2;
	}

	public synchronized Rank getRank_1() {
		return Rank_1;
	}

	public synchronized void setRank_1(Rank rank_1) {
		this.Rank_1 = rank_1;
	}
		
		
}
