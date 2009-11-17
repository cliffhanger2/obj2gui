package OBJ2GUI.Listeners;

import java.awt.Component;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import OBJ2GUI.JWPanel;

/**
 * 
 * @author Warnotte Renaud 2007
 *
 *TODO : Deconne cette merde ....
 */
public class SimpleTableModelListener extends BaseListener implements TableModelListener {

	Class<?> return_type = null;
	Component jtf = null; // Un Tableau
	Method set = null;
	Method get = null;
	Object obj1 = null;
	
		
	public SimpleTableModelListener(Class<?> return_type1, Component jtf1, Method set1, Method get1,Object obj2, JWPanel parent_panel) {
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
	
	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
      //  String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        
        //Object[] value = { 0 };
        Object[] value = null;
		try {
			value = (Object[]) get.invoke(obj1);
		} catch (IllegalArgumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvocationTargetException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	
	//	Object o = null;
		Method m = null;

        try {
        	m = obj1.getClass().getMethod(set.getName(), value.getClass());
        	Class<?> cellClass = value[row].getClass();
        	Constructor<?> cons = Cherche_Constructeur_avec_String_en_param(cellClass.getConstructors());
        	Object newobj = cons.newInstance(""+data);
        	value[row] = newobj; // Value
        	m.invoke(obj1, new Object [] {value});
        	sendRefresh(jtf);
        } catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    }

	private Constructor<?> Cherche_Constructeur_avec_String_en_param(
			Constructor<?>[] constructors) {
		for (int i = 0 ;i< constructors.length;i++)
		{
			Constructor<?> c = constructors[i];
			if (c.getParameterTypes()[0]==String.class)
				return c;
		}
		return null;
	}
}
