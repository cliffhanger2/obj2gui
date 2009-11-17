package OBJ2GUI.Listeners;

import java.awt.Component;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import OBJ2GUI.JWPanel;

/**
 * 
 * @author Warnotte Renaud 2007
 *
 *TODO : Deconne cette merde ....
 */
public class SimpleListeModelListener extends BaseListener implements ListSelectionListener {

	Class<?> return_type = null;
	Component jtf = null; // Un Tableau
	Method set = null;
	Method get = null;
	Object obj1 = null;
		
	public SimpleListeModelListener(Class<?> return_type1, Component jtf1, Method set1, Method get1,Object obj2, JWPanel parent_panel) {
		super(parent_panel);
		this.return_type = return_type1;
		if (this.return_type==null)
		{
			System.err.println("No return type found");
			System.exit(-1);
		}
		this.jtf = jtf1;
		set = set1;
		get = get1;
		this.obj1 = obj2;
	}

	public void valueChanged(ListSelectionEvent arg0) {
		//if (return_type.isEnum()==true)
		{
		Object value = ((JList) jtf).getSelectedValue();
		//if (return_type instanceof int)
		
		Method m;
		try {
			if (return_type.isEnum()==true)
			{
			m = obj1.getClass().getMethod(set.getName(), value.getClass());
			
    	//Constructor cons = Cherche_Constructeur_avec_String_en_param(cellClass.getConstructors());
    	//Object newobj = cons.newInstance(""+data);
    	//value[row] = value; // Value
    	m.invoke(obj1, new Object [] {value});
			}
    	sendRefresh(jtf);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//else
		//	System.err.println("This can only show you the value ...");
		
	}
}
