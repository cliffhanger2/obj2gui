package OBJ2GUI.Listeners;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jdesktop.swingx.JXDatePicker;

import OBJ2GUI.JWPanel;
import WaxLibrary.Swing.Component.JColorChooserButton;
import WaxLibrary.Swing.Component.JFontChooserCombo;
import WaxLibrary.Swing.Component.JWColor;
import WaxLibrary.Swing.Component.WaxSlider.WFlatSlider;
import WaxLibrary.Swing.Component.WaxSlider.WRoundSlider;
import WaxLibrary.Swing.Component.WaxSlider.WSlider;


/**
 * 
 * @author Warnotte Renaud 2007
 *
 */
public class SimpleModelListener extends BaseListener implements ActionListener, ChangeListener {

	Class<?> return_type = null;
	Component jtf = null;
	Method set = null;
	Method get = null;
	Object obj1 = null;

	public synchronized Method getGet() {
		return get;
	}


	public synchronized void setGet(Method get) {
		this.get = get;
	}


	public synchronized Component getJtf() {
		return jtf;
	}


	public synchronized void setJtf(Component jtf) {
		this.jtf = jtf;
	}


	public synchronized Object getObj1() {
		return obj1;
	}


	public synchronized void setObj1(Object obj1) {
		this.obj1 = obj1;
	}


	public synchronized Class<?> getReturn_type() {
		return return_type;
	}


	public synchronized void setReturn_type(Class<?> return_type) {
		this.return_type = return_type;
	}


	public synchronized Method getSet() {
		return set;
	}


	public synchronized void setSet(Method set) {
		this.set = set;
	}


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
	public SimpleModelListener(Class<?> return_type1, Component jtf1, Method set1, Method get1,Object obj2, JWPanel parent_panel ) {
		super(parent_panel);
		this.return_type = return_type1;
		this.jtf = jtf1;
		set = set1;
		get = get1;
		this.obj1 = obj2;
		this.parent_panel = parent_panel;
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
			Object valeur =((JComboBox) jtf).getSelectedObjects()[0];
			//System.err.println("Valeur choisie = "+valeur);
			Class<?> c = return_type;
			
			Method m;
			try {
				m = obj1.getClass().getMethod(set.getName(), c);
				/*Object o = */m.invoke(obj1, valeur);
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
		else
		{
			if ((return_type.getName().contains("Date")))
			{
				NewValue = ((JXDatePicker)jtf).getDate();
			//	System.err.println("Date");
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
				//	System.err.println("fpokzopkezop");
					NewValue = ((JColorChooserButton) jtf).getCol();
				}
				else
				if (jtf instanceof JFontChooserCombo)
				{
					NewValue = ((JFontChooserCombo) jtf).getSelectedItem();
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
			Float f = new Float(NewValue);//((PanelRoundBT) jtf).getDivider();
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
		Object o = null;
		Method m = null;
		Class<?> c = null;
		try {
			if (return_type.getName().contains("Date")) {
				c = Date.class;
				value[0] = newValue;
			}
			else
			if (return_type.getName().contains("Long")) {
				c = Long.class;
				value[0] = new Long(""+newValue);
			} else if (return_type.getName().contains("Integer")) {
				c = Integer.class;
				if (((String)newValue).contains("."))
				newValue = ((String)newValue).substring(0, ((String)newValue).indexOf("."));
				value[0] = new Integer(""+newValue);
				
			} else if (return_type.getName().contains("Double")) {
				c = Double.class;
				value[0] = new Double(""+newValue);
			} else if (return_type.getName().contains("Float")) {
				c = Float.class;
				value[0] = new Float(""+newValue);
			} else if (return_type.getName().contains("Boolean")) {
				c = Boolean.class;
				value[0] = new Boolean(""+newValue);
			} else if (return_type.getName().contains("String")) {
				c = String.class;
				value[0] = new String(""+newValue);
			} else if (return_type.getName().contains("long")) {
				c = long.class;
				if (((String)newValue).contains("."))
				newValue = ((String)newValue).substring(0, ((String)newValue).indexOf("."));
				value[0] = new Long(new Float(""+newValue).longValue());
			} else if (return_type.getName().contains("int")) {
				c = int.class;
				if (((String)newValue).contains("."))
				newValue = ((String)newValue).substring(0, ((String)newValue).indexOf("."));
				value[0] = new Integer(new Float(""+newValue).intValue());
			} else if (return_type.getName().contains("double")) {
				c = double.class;
				value[0] = new Double(""+newValue);
			} else if (return_type.getName().contains("float")) {
				c = float.class;
				value[0] = new Float(""+newValue);
			} else if (return_type.getName().contains("boolean")) {
				c = boolean.class;
				value[0] = new Boolean(""+newValue);
			} 
			else
			if (return_type.getName().contains("Color")) {
				c = JWColor.class;
				JWColor cm = (JWColor)newValue;
				if (cm==null) return;
				value[0] = cm;//new JWColor(cm.getRed(),cm.getGreen(),cm.getBlue(),cm.getAlpha());
			} 
		} catch (java.lang.NumberFormatException NE) {
			System.err.println("Ne me donne pas de truc toxique à manger, j'annule et j'undo ;)");
			try {
				
				o = get.invoke(obj1);
			} catch (SecurityException e1) {
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
			String oldValue = "" + o;
			if (jtf instanceof JTextField)
			((JTextField) jtf).setText("" + oldValue);
			return;
		}
		try {
			m = obj1.getClass().getMethod(set.getName(), c);
			o = m.invoke(obj1, value);
			sendRefresh(jtf);
			
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	//	System.err.println("" + obj1);
		// System.err.println("Hash "+obj1.hashCode());
	}

}