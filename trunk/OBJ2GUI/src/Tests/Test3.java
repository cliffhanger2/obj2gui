package Tests;

import OBJ2GUI.Annotations.GUI_CLASS;
import OBJ2GUI.Annotations.GUI_FIELD_TYPE;

@GUI_CLASS(type=GUI_CLASS.Type.BoxLayout, BoxLayout_property=GUI_CLASS.Type_BoxLayout.Y)
//@GUI_CLASS(type=GUI_CLASS.Type.TabbedPane, BoxLayout_property=GUI_CLASS.Type_BoxLayout.Y)
public class Test3 {

	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.PANELISABLE)
	Test2 Test1 = new Test2();
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.PANELISABLE)
	Test2 Test2 = new Test2();
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.PANELISABLE)
	Test2 Test3 = new Test2();
	@GUI_FIELD_TYPE(type=GUI_FIELD_TYPE.Type.PANELISABLE)
	Test2 Test4 = new Test2();
	public Test2 getTest1() {
		return Test1;
	}
	public void setTest1(Test2 test1) {
		this.Test1 = test1;
	}
	public Test2 getTest2() {
		return Test2;
	}
	public void setTest2(Test2 test2) {
		this.Test2 = test2;
	}
	public Test2 getTest3() {
		return Test3;
	}
	public void setTest3(Test2 test3) {
		this.Test3 = test3;
	}
	public Test2 getTest4() {
		return Test4;
	}
	public void setTest4(Test2 test4) {
		this.Test4 = test4;
	}
}
