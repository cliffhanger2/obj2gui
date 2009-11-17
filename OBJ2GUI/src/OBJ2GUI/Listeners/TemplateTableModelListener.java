package OBJ2GUI.Listeners;

import java.awt.Component;
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
 */
public class TemplateTableModelListener extends BaseListener implements TableModelListener {

	Component jtf = null; // Un Tableau
	Method set = null;
	Method get = null;
	Object obj1 = null;
	
	public TemplateTableModelListener(Component jtf1, Method set1, Method get1,Object obj2, JWPanel parent_panel) {
		super(parent_panel);
		this.jtf = jtf1;
		set = set1;
		get = get1;
		this.obj1 = obj2;
	}
	
	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        //String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        
        // Recupere la valeur de la variable de l'objet
        Object[][] value = null;
		try {
			value = (Object[][]) get.invoke(obj1);
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
        	value[row][column] = data;
        	// Assigne la nouvelle valeur a la variable de l'objet de destination
        	m = obj1.getClass().getMethod(set.getName(), value.getClass());
        	//m.invoke(obj1, value);
        	m.invoke(obj1, (Object)value);
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
		}
    }
}
