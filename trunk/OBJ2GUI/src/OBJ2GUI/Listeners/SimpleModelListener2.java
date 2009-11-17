package OBJ2GUI.Listeners;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jdesktop.swingx.JXDatePicker;

import OBJ2GUI.JWPanel;
import WaxLibrary.Swing.Component.WaxSlider.WFlatSlider;
import WaxLibrary.Swing.Component.WaxSlider.WRoundSlider;
import WaxLibrary.Swing.Component.WaxSlider.WSlider;


/**
 * 
 * @author Warnotte Renaud 2007
 *
 */
public class SimpleModelListener2 extends BaseListener implements ActionListener, ChangeListener {

	Class<?> return_type = null;
	Component jtf = null;
	Object obj1 = null;

	/**
	 * Listener d'evenement d'un component. Il faut le type de retour, le
	 * component, la methode Set et la methode Get correspondant ansi que
	 * l'objet en lui meme
	 * 
	 * @param return_type1 Le type de la valeur
	 * @param jtf1 un Component
	 * @param set1 method set de la valeur
	 * @param get1 method get de la valeur
	 * @param obj2 Objet a regarder
	 */
	public SimpleModelListener2(Component jtf1, Object obj2, JWPanel parent_panel) {
		super(parent_panel);
		this.return_type = obj2.getClass();
		this.jtf = jtf1;
		this.obj1 = obj2;
	}

	/**
	 * Control type textfield CheckBox, JComboBox
	 */
	public void actionPerformed(java.awt.event.ActionEvent e) {

		Object NewValue = null;

		// Regarde si c'est pas un type Enum -> JComboBox
		Object obj [] = return_type.getEnumConstants();
		if (obj!=null)
		{
		/*	Object valeur =((JComboBox) jtf).getSelectedObjects()[0];
			System.err.println("Valeur choisie = "+valeur);
			Class c = return_type;
			
			Method m;
			try {
			//	m = obj1.getClass().getMethod(set.getName(), c);
				/*Object o = m.invoke(obj1, valeur);
		/*	} catch (SecurityException e1) {
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
			}*/
		}
		else
		{
			if ((return_type.getName().contains("Date")))
			{
				NewValue = ((JXDatePicker)jtf).getDate();
				System.err.println("Date");
			}
			else
			if ((return_type.getName().contains("Boolean"))
					|| (return_type.getName().contains("boolean")))
				NewValue = "" + ((JCheckBox) jtf).isSelected();
			else
			{
				if ((return_type.getName().contains("Color"))
						|| (return_type.getName().contains("color")))
				{
					System.err.println("fpokzopkezop");
					NewValue = ((JTextField) jtf).getText();
				}
				else
				{
					NewValue = ((JTextField) jtf).getText();
				}
				
			}
			assign_value(NewValue);
		}
		
	}
	
	/**
	 * Control type JSlider
	 */
	public void stateChanged(ChangeEvent arg0)
	{
		String NewValue = null;

		if (jtf instanceof WFlatSlider)
		{
			NewValue = ""+((WFlatSlider) jtf).getValue();
			Float f = new Float(NewValue);
			NewValue = ""+f;
		}
		if (jtf instanceof WSlider)
		{
			NewValue = ""+((WSlider) jtf).getValue();
			Float f = new Float(NewValue)/((WSlider) jtf).divider;
			NewValue = ""+f;
		}
		else
		if (jtf instanceof WRoundSlider)
		{
			NewValue = ""+((WRoundSlider) jtf).getValue();
			Float f = new Float(NewValue);//((WRoundSlider) jtf).getDivider();
			//Float f = Float f = new Float(NewValue)/((WSlider) jtf).divider;
			NewValue = ""+f;
		}
		if (jtf instanceof JSlider)
		{
			NewValue = ""+((JSlider) jtf).getValue();
			Float f = new Float(NewValue);
			NewValue = ""+f;
		}
		
		assign_value(NewValue);
	}

	/**
	 * Assigne une valeur (JTextField, Slider, CheckBox)
	 * @param Valeur a assigner
	 */
	private void assign_value(Object newValue)
	{
		Object[] value = { 0 };
	
		//Class<?> c = null;
		
			if (return_type.getName().contains("Date")) {
			//	c = Date.class;
				value[0] = newValue;
			}
			else
			if (return_type.getName().contains("Long")) {
			//	c = Long.class;
				value[0] = new Long(""+newValue);
			} else if (return_type.getName().contains("Integer")) {
			//	c = Integer.class;
				value[0] = new Integer(""+newValue);
			} else if (return_type.getName().contains("Double")) {
			//	c = Double.class;
				value[0] = new Double(""+newValue);
			} else if (return_type.getName().contains("Float")) {
			//	c = Float.class;
				value[0] = new Float(""+newValue);
			} else if (return_type.getName().contains("Boolean")) {
			//	c = Boolean.class;
				value[0] = new Boolean(""+newValue);
			} else if (return_type.getName().contains("String")) {
			//	c = String.class;
				value[0] = new String(""+newValue);
			} else if (return_type.getName().contains("long")) {
			//	c = long.class;
				value[0] = new Long(new Float(""+newValue).longValue());
			} else if (return_type.getName().contains("int")) {
			//	c = int.class;
				value[0] = new Integer(new Float(""+newValue).intValue());
			} else if (return_type.getName().contains("double")) {
			//	c = double.class;
				value[0] = new Double(""+newValue);
			} else if (return_type.getName().contains("float")) {
			//	c = float.class;
				value[0] = new Float(""+newValue);
			} else if (return_type.getName().contains("boolean")) {
			//	c = boolean.class;
				value[0] = new Boolean(""+newValue);
			} 
			else if (return_type.getName().contains("Color")) {
			//	c = Color.class;
				value[0] = new Integer(""+newValue);
			} 
		
			obj1=((Integer)value[0]).intValue();
		
		//System.err.println("" + obj1);
		sendRefresh(jtf);
		// System.err.println("Hash "+obj1.hashCode());
	}

}