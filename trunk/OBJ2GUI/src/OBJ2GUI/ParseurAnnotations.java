	package OBJ2GUI;

	
	
	
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;

import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXList;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.decorator.HighlighterFactory;

import OBJ2GUI.Annotations.GUI_CLASS;
import OBJ2GUI.Annotations.GUI_FIELD_LOCATION;
import OBJ2GUI.Annotations.GUI_FIELD_LOCATIONs;
import OBJ2GUI.Annotations.GUI_FIELD_TYPE;
import OBJ2GUI.Annotations.GUI_CLASS.Type_BoxLayout;
import OBJ2GUI.Annotations.GUI_CLASS.Type_FlowLayout;
import OBJ2GUI.Annotations.GUI_FIELD_TYPE.Type_SLIDER;
import OBJ2GUI.ApplicationConfiguratorScanner.ApplicationConfigurator;
import OBJ2GUI.Events.MyChangedEvent;
import OBJ2GUI.Events.MyEventListener;
import OBJ2GUI.Listeners.ListModelListenerM;
import OBJ2GUI.Listeners.MapModelListenerM;
import OBJ2GUI.Listeners.SetModelListenerM;
import OBJ2GUI.Listeners.SimpleListeModelListener;
import OBJ2GUI.Listeners.SimpleModelListener;
import OBJ2GUI.Listeners.SimpleModelListener2;
import OBJ2GUI.Listeners.SimpleTableModelListener;
import OBJ2GUI.Listeners.TemplateTableModelListener;
import OBJ2GUI.Listeners.WaxCellEditor;
import OBJ2GUI.Models.MyTableModel;
import WaxLibrary.Swing.Component.DialogConfigurationJXTable;
import WaxLibrary.Swing.Component.GUI_Vector3d;
import WaxLibrary.Swing.Component.GUI_Vector4d;
import WaxLibrary.Swing.Component.JColorChooserButton;
import WaxLibrary.Swing.Component.JFontChooserCombo;
import WaxLibrary.Swing.Component.JWColor;
import WaxLibrary.Swing.Component.DateChooser.JXDateTimePicker;
import WaxLibrary.Swing.Component.WaxSlider.WFlatSlider;
import WaxLibrary.Swing.Component.WaxSlider.WRoundSlider;


@SuppressWarnings("deprecation")
public class ParseurAnnotations {

	public static boolean TaskPanelAlwaysCollpased = true;
	private static boolean VERBOSE=false;

	/**
	 * @param args
	 * @throws Exception 
	 */
	/*
	public static void main(Strifng[] args) throws Exception {
		//ParseurAnnotations p = new ParseurAnnotations();
		
		final Test objet = new Test();
		
		JFrame frame = new JFrame();
		frame.setSize(320,200);
		frame.setPreferredSize(new Dimension(320,200));
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		// Crée ces 3 panels sans ajouter la variable change listener qui pompe les ressources si 10000 de changements
		final JPanel panel = CreatePanelFromObject("Main configuration", objet);
		//obj1.addVariableChangeListener( new ModificationListener(panObj,obj1));
	
		// Ajoute du panel dans la frame
		//frame.add(new JScrollPane(panel),BorderLayout.CENTER);
		frame.add(new JScrollPane(panel),BorderLayout.CENTER);
		JButton button =  new JButton();
		button.setText("Debug");
		button.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
		//		objet.debug();
			}
		});
		
		JButton button2 =  new JButton();
		button2.setText("Refresh Panel");
		button2.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				try {
					Refresh_PanelEditor_For_Object("", panel,objet, null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton button3 =  new JButton();
		button3.setText("Add Object to Vector of Object");
		button3.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				objet.addObjets();
			}
		});
		
		
		frame.add(button,BorderLayout.SOUTH);
		frame.add(button2,BorderLayout.NORTH);
		frame.add(button3,BorderLayout.EAST);
		
		frame.validate();
		frame.pack();
	}*/

	ParseurAnnotations() throws Exception
	{
		
	}
	
	public static JFrame CreateFrameFromObject(String Frametitle, Object object, MyEventListener eventListener) throws Exception
	{
	
	//	 final Test objet = new Test();
			
		 JFrame frame = new JFrame();
			frame.setSize(400,400);
			frame.setPreferredSize(new Dimension(400,400));
			frame.setVisible(true);
			frame.setLayout(new BorderLayout());
			
			// Crée ces 3 panels sans ajouter la variable change listener qui pompe les ressources si 10000 de changements
			final JWPanel panel = (JWPanel) ParseurAnnotations.CreatePanelFromObject(Frametitle, object,false);

			panel.addMyEventListener(eventListener);
			/*panel.addMyEventListener(new MyEventListener()
			{
				public void myEventOccurred(MyChangedEvent e)
				{
					System.err.println("*** Object has changed make the needed things ...");
				}
			});*/
			
			
			//obj1.addVariableChangeListener( new ModificationListener(panObj,obj1));
		
			// Ajoute du panel dans la frame
			//frame.add(new JScrollPane(panel),BorderLayout.CENTER);
			frame.add(new JScrollPane(panel),BorderLayout.CENTER);
			frame.validate();
			frame.setTitle(Frametitle);
			frame.pack();
			return frame;
	}
	
	/**
	 * Rafraichis un panel avec un nouvel objet a refleter. (Supprime les elements du panel et en recree des nouveaux).
	 * @param PanelTitle JPanel title in case of title border
	 * @param Panel_to_refresh JPanel source to modify.
	 * @param object_to_bind Object to reflect.
	 * @param parent_panel Put this Same as Panel_to_refresh (???).
	 * @param TreeMode (deprecated) put false;
	 * @throws Exception
	 */
	public static void Refresh_PanelEditor_For_Object(String PanelTitle, JPanel Panel_to_refresh, Object object_to_bind, JWPanel parent_panel, boolean TreeMode) throws Exception {
		JPanel jpnew = CreatePanelFromObject(PanelTitle,object_to_bind,0, parent_panel,TreeMode);
		// TODO : Je pense que le code qui suit n'est pas ncessaaire dans notre cas vu que ca devrait deja etre bon en sortant le panel de la creation
		Component [] cps = jpnew.getComponents();
		// Transvase les nouveaus elements ou affiches qu'il y'a une probleme
		if (cps.length!=0)
		{
			Panel_to_refresh.removeAll();
			for (int i=0;i<cps.length;i++)
			{
				Component c = cps[i];
				Panel_to_refresh.add(c);
			}
			Panel_to_refresh.revalidate();
			Panel_to_refresh.setBorder(BorderFactory.createTitledBorder(null, PanelTitle, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jpnew=null;	
		}	
		else
		{
			Panel_to_refresh = new JPanel();
			JLabel lbl = new JLabel("Panel Refreshed but, nothing inside");
			lbl.setText("Panel Refreshed but, nothing inside");
			Panel_to_refresh.add(lbl);
		}
	}
	public static JPanel CreatePanelFromObject(String PanelTitle, Object object_to_bind) throws Exception
	{
		return CreatePanelFromObject(PanelTitle, object_to_bind,0,null, false);
	}
	public static JPanel CreatePanelFromObject(String PanelTitle, Object object_to_bind, boolean TreeMode) throws Exception
	{
		return CreatePanelFromObject(PanelTitle, object_to_bind,0,null, TreeMode);
	}
	@SuppressWarnings("deprecation")
	public static JPanel CreatePanelFromObject(String PanelTitle, Object object_to_bind, int depth, JWPanel parent_panel, boolean TreeMode) throws Exception {
		
		boolean TabbedPaneStyle = false;
		boolean TreePaneStyle = false; 
		if (object_to_bind==null)
			return new JWPanel();
		// On récupère la classe de l'objet :
		Class<?> classInstance = object_to_bind.getClass();
		
		
		
		JWPanel panel = new JWPanel();
		panel.setBackground(new Color(238,238,238));
		panel.setName("Panel de "+object_to_bind);
		
		if (parent_panel!=null)
			panel.addMyEventListener(parent_panel);
		
		panel.setBorder(BorderFactory.createTitledBorder(null, PanelTitle, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		
		GUI_CLASS annotation = classInstance.getAnnotation(GUI_CLASS.class);
		if (annotation==null)
		{
			throw new Exception("Class "+classInstance+" doesn't have annotation GUI_CLASS");
		}
		if (annotation.type()==GUI_CLASS.Type.TabbedPane)
		{
			TabbedPaneStyle=true;
			panel.setLayout(new BorderLayout());
			
		}
		if (annotation.type()==GUI_CLASS.Type.TreePane)
		{
			TreeMode=true;
			TreePaneStyle=true;
		}
		if ((TreePaneStyle==true) && (depth==0))
		{
		// TODO : 
		//Cree un PANEL a gauche avec l'arbre, et un PANEL avec le futur contenu;
			panel = new ApplicationConfigurator(object_to_bind);
			return panel;
		}
		
		if (annotation==null)
		if (object_to_bind instanceof Integer)
		{
			JComponent component = new JTextField(""+object_to_bind);
			component.setEnabled(false);
			SimpleModelListener2 sdl = new SimpleModelListener2(component, object_to_bind, panel);
			((JTextField)component).addActionListener(sdl);
			JPanel jp = new JPanel();
			jp.add(component);
			return jp;
		}
		
		Vector<JComponent> normals = new Vector<JComponent>();
		Vector<JComponent> complex = new Vector<JComponent>();
		
 		// 1) Traite les champs de la classe
		// Recuperer les champs pour avoir les annotations ...
		//Field f [] = classInstance.getDeclaredFields();
		Vector<?> v = getAllFields(classInstance);
		Field f [] = new Field[v.size()];
		for (int i = 0 ; i < v.size();i++)
			f[i]=(Field) v.get(i);
		
		for (int i = 0 ; i < f.length; i++)
		{
			// Prendre l'annotation du champs si elle existe sinon on ne traite pas
			GUI_FIELD_TYPE anot  = f[i].getAnnotation(GUI_FIELD_TYPE.class);
			if (anot!=null)
			{
				String field_name = f[i].getName();
				if (VERBOSE==true)
				System.err.printf("FIELD[%32s]::TYPE ---%s\r\n",field_name,anot);
				// Recuperer le couple GET/SET ou GET si Read/Only :)
				//boolean ReadOnly = false;
				
				Method method_get = null;
				Method method_set=null;
				JComponent component = null;
				
				// Est-ce un bouton ou bien un truc normale.
				if (anot.type()!=GUI_FIELD_TYPE.Type.METHOD_CALL)
				{
					// Recuperer les infos de l'annotation
					String method_get_name = "get"+field_name;
					if ((f[i].getType()==Boolean.class) || (f[i].getType()==boolean.class))
						method_get_name = "is"+field_name;
					
					try
					{
						method_get = classInstance.getMethod(method_get_name);
					}
					catch(Exception e)
					{
						throw new Exception("Impossible de trouve la methode "+method_get_name+"() dans la classe "+classInstance.getName());
					}
					//final Class<?> return_type = ;
					
					try {
						method_set = classInstance.getMethod("set"+field_name,method_get.getReturnType());
					} catch (SecurityException e) {
						throw e;
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					component = getComponent(anot,object_to_bind, method_get, method_set, /*Object Objet_Parent,*/ depth, panel, TreeMode );
				}
				else
				{
					component = getBoutonCallMethod(anot, object_to_bind,panel);
					//	getComponent(anot,object_to_bind, method_get, method_set, /*Object Objet_Parent,*/ depth, panel, TreeMode );
				}
				
				// Creer le component en fonctionn des infos
				
				// TODO : 
				//if (ReadOnly==true)
				//	component.setEnabled(false);
				if 	((component instanceof JCheckBox)		
						|| (component instanceof JTextField)		
						|| (component instanceof JSlider)			
						|| (component instanceof WRoundSlider)		
						|| (component instanceof WFlatSlider)
						|| (component instanceof JColorChooserButton)
						|| (component instanceof JComboBox)
						|| (component instanceof JButton)
						|| (component instanceof JList)			
						|| (component instanceof JXDatePicker))		
					normals.add(component);
				else
				{
					if (TreeMode==false)
					complex.add(component);
				}
			}
		}
		
		// Parcourir les 2 listes
		
		JComponent container = null;
		if (TabbedPaneStyle==false)
		{
			container = new JXTaskPaneContainer();
			container.setName(""+object_to_bind.getClass().getName());
			container.setBackground(panel.getBackground());
		}
		else
		{
			container = new JTabbedPane();
			container.setName(""+object_to_bind.getClass().getName());
		}
		
		// Parcour les methodes qui donne un Panel Complex (donc taskapanelisable)
		for (int i=0;i<complex.size();i++)
		{
			JComponent meth = complex.elementAt(i);
			JComponent Pane = null;
			if (TabbedPaneStyle==true)
			{
				Pane = new JXPanel();
				((JXPanel)Pane).setName(meth.getName());
			}
			else
			{
				Pane = new JXTaskPane();
				((JXTaskPane)Pane).setTitle(meth.getName());
				((JXTaskPane)Pane).setName(meth.getName());
				
				if (TaskPanelAlwaysCollpased==true)
					((JXTaskPane)Pane).setCollapsed(true);
				else
					((JXTaskPane)Pane).setCollapsed(false);
			//	((JXTaskPane)Pane).setExpanded(false);
			}
			Pane.add(meth, BorderLayout.CENTER);
			meth.setBorder(null);
			if (TabbedPaneStyle==false)
				container.add(meth.getName(), Pane);
			else
			//	((JTabbedPane)container).addTab(meth.getName(),new JScrollPane(Pane));
				((JTabbedPane)container).addTab(meth.getName(),new JScrollPane(Pane));
		}
		//container.setBorder(new DropShadowBorder());
		
		//Font Font_Panel_Name = new Font("Dialog", Font.BOLD, 12);
		//Color Color_Panel = new Color(51, 51, 51);
		// Place une bordure de titre pour ce panel avc le type/nom de l'objet
		if (PanelTitle!=null)	
			PanelTitle = "Viewer/Editeur ";
		//if (depth==0)
		//	System.err.println("Root Directory");
	
		//JXTaskPane containerSimple = new JXTaskPane();
		// Parcour les methodes qui donne un Panel Complex (donc taskapanelisable)
		for (int i=0;i<normals.size();i++)
		{
			JComponent comp = normals.elementAt(i);
			comp.setOpaque(false);
			JPanel pan = new JPanel();
			GridLayout gd = new GridLayout();
			gd.setRows(1);
			pan.setLayout(gd);
			
			if 	((comp instanceof JTextField)		
				//	|| (comp instanceof JSlider)			
				//	|| (comp instanceof WRoundSlider)		
				//	|| (comp instanceof WFlatSlider)		
					|| (comp instanceof JComboBox)
					|| (comp instanceof JSlider)
					|| (comp instanceof JColorChooserButton)
					|| (comp instanceof WFlatSlider)		
					|| (comp instanceof WRoundSlider)
					|| (comp instanceof JList)			
					|| (comp instanceof JXDatePicker))		
			{
			JLabel label = new JLabel(comp.getName());
			label.setName(comp.getName());
			label.setOpaque(false);
			comp.setOpaque(true);
			pan.add(label, BorderLayout.EAST);
			}
			pan.add(comp,BorderLayout.CENTER);
			pan.doLayout();
			pan.setOpaque(false);
			panel.add(pan);
			panel.setOpaque(false);
			
			
		}
		
		if (complex.size()!=0)
			panel.add(container,BorderLayout.CENTER);
		
		
		
		
		if (TabbedPaneStyle==false)
		{
		// Recupere l'annotation globale de la classe
		if (annotation!=null)
		{
			if (VERBOSE){
		System.err.println("CLASS               ---"+annotation);
		System.err.println("Type =="+annotation.type());}
		// Determine le layout et le parametre
		// TODO : Changer ceci pas un truc generic en mettant un nom correcte dans les enums
		AssigneLayoutToPanel(panel, annotation);
		
		// TODO : Gere le Layout si jamais c'est un NULL LAYOUT && s'il y'as des annotation
		 GUI_FIELD_LOCATIONs anots  = classInstance.getAnnotation(GUI_FIELD_LOCATIONs.class);
		 if (anots!=null)
		 {
			 for ( GUI_FIELD_LOCATION t : anots.value() )
		 	{
				 if (VERBOSE==true)
			 System.err.println("CLASS::FIELDLOCATION---"+t);
		 	}
		 }
		}
		else
		{
			//throw new Exception("Impossible de trouver l'annotation GUI_CLASS dans la classe "+classInstance);
		}
		}
		
		//panel.validate();
		 return panel;
	}

	/**
	 * Crée un bouton pour les annotation CALLBACK afin d'appeler la methode demandée dans la classe.
	 * @param anot Annotations
	 * @param object_to_bind Objet a binder.
	 * @param parent_panel Panel parent pour la messagerie.
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	private static JComponent getBoutonCallMethod(GUI_FIELD_TYPE anot, final Object object_to_bind, final JWPanel parent_panel) throws SecurityException, NoSuchMethodException
	{
		final String name = anot.method_name();
		final Method method_to_call = object_to_bind.getClass().getMethod(name);
		
		JButton button = new JButton();
		button.setText(name);
		button.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent e) {
		    	try
				{
		    		// Appelle la methode qui est bindée au bouton.
		    		method_to_call.invoke(object_to_bind);
					// Envoye un evenement au "client" afin qu'il sache qu'il s'est passé un truc. (et que donc il doit probablement refresh).
					parent_panel.fireMyEvent(new MyChangedEvent(this,null));
				} 
		    	catch (IllegalArgumentException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	catch (IllegalAccessException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
		    	catch (InvocationTargetException e1)
				{
		    		System.err.println(""+object_to_bind+" cannot found method "+name);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		
	
		return button;
	}

	private static Vector<Field> getAllFields(Class<?> classInstance) {
		
		Vector<Field> retour = new Vector<Field>();
		Field []fields = classInstance.getDeclaredFields();
		for (int i = 0 ; i < fields.length;i++)
			retour.add(fields[i]);
		
		Class<?> parentclass = classInstance.getSuperclass();
		if (parentclass!=null)
		{
			Vector<Field> r = getAllFields(parentclass); 
			for (int i = 0 ; i < r.size();i++)
				retour.add(r.get(i));
		}
		return retour;
	}

	private static void AssigneLayoutToPanel(JPanel panel, GUI_CLASS annotation) throws Exception {
		LayoutManager layout = null;
	
		if (annotation==null)
			throw new Exception("Not default layout available now ...");
		if (annotation.type()==GUI_CLASS.Type.FlowLayout)
		{
			layout = new FlowLayout();
			Type_FlowLayout properties = annotation.FlowLayout_property();
			if (properties==Type_FlowLayout.LEFT)
				((FlowLayout)layout).setAlignment(FlowLayout.LEFT);
			if (properties==Type_FlowLayout.CENTER)
				((FlowLayout)layout).setAlignment(FlowLayout.CENTER);
			if (properties==Type_FlowLayout.RIGHT)
				((FlowLayout)layout).setAlignment(FlowLayout.RIGHT);
			
		}
		if (annotation.type()==GUI_CLASS.Type.Absolute)
		{
			throw new Exception("Absolute layout not available now ...");
		}
		if (annotation.type()==GUI_CLASS.Type.GridLayout)
		{
			layout = new GridLayout();
			int rows = annotation.Type_GridLayout_ROWS();
			int cols = annotation.Type_GridLayout_COLUMNS();
			//if (cols!=-1)
				((GridLayout)layout).setColumns(cols);
			//if (rows!=-1)
				((GridLayout)layout).setRows(rows);
			
		}
		if (annotation.type()==GUI_CLASS.Type.BoxLayout)
		{
			layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
			Type_BoxLayout properties = annotation.BoxLayout_property();
			if (properties!=null)
			{
				if (properties==Type_BoxLayout.X)
					layout = new BoxLayout(panel, BoxLayout.X_AXIS);
				if (properties==Type_BoxLayout.Y)
					layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
				if (properties==Type_BoxLayout.LINE)
					layout = new BoxLayout(panel, BoxLayout.LINE_AXIS);
				if (properties==Type_BoxLayout.PAGE)
					layout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
			}
						
		}
		// Assigne le layout au panel de l'objet
		panel.setLayout(layout);
	}

	private static JComponent getComponent(GUI_FIELD_TYPE anot,Object ObjectToMap, Method method_get, Method method_set/*, Object Objet_Parent*/, int depth, JWPanel parent_panel, boolean TreeMode) throws Exception {
		GUI_FIELD_TYPE.Type type_var = anot.type();
		
		JComponent component = null;
		if (VERBOSE==true)
		System.err.println("Veux créer un "+anot);
		//return new JLabel(""+ObjectToMap);
		// Recuperer la valeur de la variable en utilisant son GET
		Object Value = lancerMethode(ObjectToMap ,null, method_get.getName());
		
		//type_var = GUI_FIELD_TYPE.Type.TEXTFIELD;
		if (type_var == GUI_FIELD_TYPE.Type.LIST)
		{
			component = createComponent_LIST(ObjectToMap, method_get.getReturnType(), Value);
		}
		if (type_var == GUI_FIELD_TYPE.Type.CHECKBOX)
		{
			component = new JCheckBox(method_get.getName().substring(2));
			((JCheckBox) component).setSelected((Boolean)Value);
		}
		if (type_var == GUI_FIELD_TYPE.Type.ARRAYLIKE)
		{
			component = createComponent_ARRAY(ObjectToMap,Value, method_get, method_set, parent_panel );
		}
		if (type_var == GUI_FIELD_TYPE.Type.FONT)
		{
			component = createComponent_FONT(ObjectToMap,Value, method_get, method_set );
		}
		if (type_var == GUI_FIELD_TYPE.Type.CALENDAR)
		{
			component = createComponent_CALENDAR(ObjectToMap,Value, method_get, method_set );
		}
		if (type_var == GUI_FIELD_TYPE.Type.COLOR)
		{
			JWColor col = (JWColor) Value;
			component = new JColorChooserButton(col);
		}
		if (type_var == GUI_FIELD_TYPE.Type.COMBO)
		{
			component = createComponent_ENUM(ObjectToMap, method_get.getReturnType(), Value);
		}
		if ((type_var == GUI_FIELD_TYPE.Type.PANELISABLE) && (TreeMode==false))
		{
			component = CreatePanelFromObject(""+Value, Value,depth+1, parent_panel, false);
		}
		if ((type_var == GUI_FIELD_TYPE.Type.VECTOR3D) && (TreeMode==false))
		{
			component = new GUI_Vector3d("Vector3d",(Vector3d)Value);
				
				//CreatePanelFromObject(""+Value, Value,depth+1, parent_panel, false);
		}
		if ((type_var == GUI_FIELD_TYPE.Type.VECTOR4D) && (TreeMode==false))
		{
			component = new GUI_Vector4d("Vector4d",(Vector4d)Value);
				
				//CreatePanelFromObject(""+Value, Value,depth+1, parent_panel, false);
		}
		if (type_var == GUI_FIELD_TYPE.Type.SLIDER)	
		{
			float divider = new Float(anot.divider()); // TODO : C'est pas un float ???
			int min = new Integer(anot.min());
			int max = new Integer(anot.max());
			Float vv = new Float(""+Value);
			
			if (anot.slider_type()==Type_SLIDER.NORMAL)
			{
				component = new JSlider(min, max);
				((JSlider)component).setValue(vv.intValue());
				((JSlider)component).setPaintTicks(true);
				((JSlider)component).setPaintLabels(true);
				((JSlider)component).setMajorTickSpacing((max-min)/10);
				((JSlider)component).setMinorTickSpacing((max-min)/20);
			}
			anot.slider_type();
			if (anot.slider_type()==Type_SLIDER.FLAT)
			{
				component = new WFlatSlider(min, max);
				((WFlatSlider)component).setDivider(divider);
				((WFlatSlider)component).setValue((int) (vv*divider));
			}
			anot.slider_type();
			if (anot.slider_type()==Type_SLIDER.ROTATIVE)
			{
				component = new WRoundSlider(min, max);
				((WRoundSlider)component).setTickDivider((max-min)/10);
				((WRoundSlider)component).setDivider(divider);
				((WRoundSlider)component).setEnableTickString(false);
				((WRoundSlider)component).setEnableAntialiasing(true);
				((WRoundSlider)component).setValue((int) (vv*divider));
			}
		}
		if (type_var == GUI_FIELD_TYPE.Type.TEXTFIELD)
		{
			component = new JTextField(""+Value);
		}
		if (type_var == GUI_FIELD_TYPE.Type.LISTLIKE)
		{
			component = createComponent_LIST_LIKE(Value,parent_panel, method_get.getName());
		}
		if (type_var == GUI_FIELD_TYPE.Type.SETLIKE)
		{
			component = createComponent_SET_LIKE(Value,parent_panel, method_get.getName());
		}
		if (type_var == GUI_FIELD_TYPE.Type.MAPLIKE)
		{
			component = createComponent_HASH_LIKE(Value,parent_panel, method_get.getName());
		}
		if (type_var == GUI_FIELD_TYPE.Type.UNKNOWN)
		{
			component = new JTextField("Unknown type =="+Value);
			//throw new Exception("Unkown type is not available now");
		}
		if (component == null)
		{
			if (VERBOSE)
			System.err.println("No component created :[");
			return new JLabel("UNAIVAILABLE COMPONENT "+ObjectToMap+ " with type == "+anot.type());
		}
		
		Class<?> return_type = method_get.getReturnType();
		
		
		// Ajoute un listener pour le controle
		SimpleModelListener list = new SimpleModelListener(return_type,component, method_set,method_get , ObjectToMap, parent_panel);
		if 		(component instanceof JCheckBox)		((JCheckBox)component).addActionListener(list);
		else if (component instanceof JTextField)		((JTextField)component).addActionListener(list);
		else if (component instanceof JSlider)			((JSlider)component).addChangeListener(list);
		else if (component instanceof WRoundSlider)		((WRoundSlider)component).addChangeListener(list);
		else if (component instanceof WFlatSlider)		((WFlatSlider)component).addChangeListener(list);
		else if (component instanceof JColorChooserButton)
		{
			// A cause du foutu AddActionListener dans le construteur de JCOlorChooserButton
			// Il faut que je puisse rajouter le 2 eme listener mais qui s'execute bien apres l'action du jcolorchooserbutton
			// ((JColorChooserButton)component).addChangeListener(list);
			ActionListener[] e = ((JColorChooserButton) component).getActionListeners();
			for (int i = 0; i < e.length; i++)
			{
				((JColorChooserButton) component).removeActionListener(e[i]);
			}
			((JColorChooserButton) component).addActionListener(list);
			for (int i = 0; i < e.length; i++)
			{
				((JColorChooserButton) component).addActionListener(e[i]);
			}

		}
		else if (component instanceof JComboBox)		((JComboBox)component).addActionListener(list);
		else if (component instanceof JList)			((JList)component).addListSelectionListener(new SimpleListeModelListener(return_type,component, method_set,method_get , ObjectToMap,parent_panel));
		else if (component instanceof JXDatePicker)		((JXDatePicker)component).addActionListener(list);
		if (Value instanceof Boolean)
			component.setName(""+method_get.getName().substring(2));
		else
		    component.setName(""+method_get.getName().substring(3));
		
		component.setToolTipText("I'm the tooltips of "+component.getName());
		if (method_set==null)
		{
			
			System.err.println("Warning - No set Method "+method_get.getName());
			component.setEnabled(false);
			component.setBackground(Color.RED);
		}
		if (component instanceof JScrollPane)
		{
			((JScrollPane)component).getViewport().setToolTipText("I'm the tooltips of "+component.getName());
			
		}
		return component;						
	}
	
	private static JComponent createComponent_LIST(Object objectToMap, Class<?> return_type, Object value) {
		DefaultListModel dlm = new DefaultListModel();
		JList binded_component = new JList(dlm);
		
		// Si c'est un enum alors faire une liste avec un seul choix
		if (return_type.isEnum())
		{
			Object elements[] = return_type.getEnumConstants();
			//binded_component.setSelectionMode(Selection.SINGLE);
			for (int i = 0 ; i < elements.length;i++)
				dlm.add(i, elements[i]);
			binded_component.setSelectedValue(value, true);
		}
		else
		    if (return_type.toString().contains("["))
		{
			Object elements[] = (Object[])value;
			//binded_component.setSelectionMode(Selection.SINGLE);
			for (int i = 0 ; i < elements.length;i++)
				dlm.add(i, elements[i]);
			//binded_component.setSelectedValue(value, true);
			
		}
		
			else
			    if (return_type==Vector.class)
			{
				Vector<?> elements = (Vector<?>)value;
				//binded_component.setSelectionMode(Selection.SINGLE);
				for (int i = 0 ; i < elements.size();i++)
					dlm.add(i, elements.get(i));
			}
		else
		{
			if (VERBOSE)
			System.err.println("Not ready yet");
		}
		
		return binded_component;
	}
	private static JComponent createComponent_LIST_LIKE(Object objectToMap,JWPanel parent_panel, String named) {
		JComponent binded_component=null;
		JPanel p = new JPanel();
		//p.setLayout(new BorderLayout());
		BoxLayout bl1 = new BoxLayout(p, BoxLayout.Y_AXIS);
		p.setLayout(bl1);
		binded_component = new JPanel();
		binded_component.setLayout(new BorderLayout());
		p.add(new JLabel("Rien a afficher pour le moment =)"));
		
		binded_component.add(new JScrollPane(Cree_un_Panel_Liste((AbstractList<?>)objectToMap, p, parent_panel, named)), BorderLayout.WEST);
		binded_component.add(new JScrollPane(p), BorderLayout.CENTER);
		return binded_component; 
	}
	
	private static JComponent createComponent_HASH_LIKE(Object objectToMap,JWPanel parent_panel, String named) {
		JComponent binded_component=null;
		JPanel p = new JPanel();
		//p.setLayout(new BorderLayout());
		BoxLayout bl1 = new BoxLayout(p, BoxLayout.Y_AXIS);
		p.setLayout(bl1);
		binded_component = new JPanel();
		binded_component.setLayout(new BorderLayout());
		p.add(new JLabel("Rien a afficher pour le moment =)"));
		binded_component.add(new JScrollPane(Cree_un_Panel_Map((AbstractMap<?, ?>)objectToMap, p, parent_panel, named)), BorderLayout.WEST);
		binded_component.add(new JScrollPane(p), BorderLayout.CENTER);
		return binded_component; 
	}

	private static JComponent createComponent_SET_LIKE(Object objectToMap,JWPanel parent_panel, String named) {
		JComponent binded_component=null;
		JPanel p = new JPanel();
		//p.setLayout(new BorderLayout());
		BoxLayout bl1 = new BoxLayout(p, BoxLayout.Y_AXIS);
		p.setLayout(bl1);
		binded_component = new JPanel();
		binded_component.setLayout(new BorderLayout());
		p.add(new JLabel("Rien a afficher pour le moment =)"));
		binded_component.add(new JScrollPane(Cree_un_Panel_Set((AbstractSet<?>)objectToMap, p,parent_panel, named)), BorderLayout.WEST);
		binded_component.add(new JScrollPane(p), BorderLayout.CENTER);
		return binded_component; 
	}
	
	private static JComponent createComponent_ENUM(Object objectToMap, Class<?> return_type, Object value) {
		JComponent binded_component = new JComboBox(return_type.getEnumConstants());
		((JComboBox)binded_component).setSelectedItem(value);
		((JComboBox)binded_component).setOpaque(true);
		return binded_component; 
	}
	private static JComponent createComponent_ARRAY(Object parent ,Object Values, Method get1, Method set1,JWPanel parent_panel)
	{
		JComponent component = null;
		if (get1.getReturnType().toString().contains("[["))
		{
			Object [][] k = (Object[][])Values;
			component = createComponent_ARRAY_2D(parent,k, get1, set1, parent_panel );
		}
		else
		if (get1.getReturnType().toString().contains("["))
		{
			Object [] k = (Object[])Values;
			component = createComponent_ARRAY_1D(parent,k, get1, set1 , parent_panel);
		}
		else
			System.err.println("Unknown type of ARRAY");
		return new JScrollPane(component);
	}
	private static JComponent createComponent_CALENDAR(Object parent ,Object Value, Method get1, Method set1)
	{
	    
	   JXDateTimePicker component = new JXDateTimePicker();
	 //   JXDatePicker component = new JXDatePicker();
	    //JXDatePicker
		component.setDate((Date) Value);
		component.setLinkDate(System.currentTimeMillis(), "La date actuelle est {0}");
		return component;
	}
	
	private static JComponent createComponent_FONT(Object parent ,Object Value, Method get1, Method set1)
	{
		JFontChooserCombo component = new JFontChooserCombo();
		component.setSelectedItem(Value);
		return component;
	}
	private static JComponent createComponent_ARRAY_1D(Object parent ,Object [] vector, Method get1, Method set1, JWPanel parent_panel)
	{
		
		//JScrollPane pane = new JScrollPane();
		//DefaultListModel dlm = new DefaultListModel();
		String [] str = {"Titre"};
		Object [] [] obj  = new Object[vector.length][1];
		for (int i = 0; i < vector.length;i++)
			obj[i][0]=vector[i];
		
		MyTableModel tab_model =  new MyTableModel(str,obj);
		final JXTable table = new JXTable(tab_model);
		table.setHighlighters(HighlighterFactory.createAlternateStriping(new Color(0,0,255,127), Color.WHITE));
	
		table.setRolloverEnabled(true);
		table.setColumnControlVisible(true);
		table.setDefaultEditor(Object.class, new WaxCellEditor(0, 0));
		table.getModel().addTableModelListener(new SimpleTableModelListener(obj.getClass() , table, set1, get1, parent, parent_panel));
		table.packAll();
		
		JPopupMenu popup = new JPopupMenu();
		JMenuItem menu = new JMenuItem("Filtrage/Search");
		menu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				DialogConfigurationJXTable dialog = new DialogConfigurationJXTable(new JFrame(),table);
				dialog.setVisible(true);
			}
		});
		popup.add(menu);
		table.setComponentPopupMenu(popup);

		//pane.add(table);
		return table;
	}
	private static JComponent createComponent_ARRAY_2D(Object parent ,Object [][] vector, Method get1, Method set1,JWPanel parent_panel)
	{
		
		String [] str = new String[vector[0].length];
		for (int i = 0; i < vector[0].length;i++)
			str[i]="Item "+i;
		
		MyTableModel tab_model =  new MyTableModel(str,vector);
		final JXTable table = new JXTable(tab_model);
		
		// Highlights
		table.setHighlighters(HighlighterFactory.createAlternateStriping(new Color(0,0,255,127), Color.WHITE));
		 
		table.setRolloverEnabled(true);
		
		table.setColumnControlVisible(true);
		table.setDefaultEditor(Object.class, new WaxCellEditor(0,0));
		table.getModel().addTableModelListener(new TemplateTableModelListener(table, set1, get1, parent, parent_panel));
		table.packAll();
		
		JPopupMenu popup = new JPopupMenu();
		JMenuItem menu = new JMenuItem("Filtrage/Search");
		menu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				DialogConfigurationJXTable dialog = new DialogConfigurationJXTable(new JFrame(),table);
				dialog.setVisible(true);
			}
		});
		popup.add(menu);
		table.setComponentPopupMenu(popup);

		
		return table;
	}
	
	/**
	 * Cree un panel a partir d'un vecteur. Ce panel va comporter une Jlist des elements du vecteur ainsi que 
	 * le panel properties associés a l'elment selectionné dans la liste.
	 * @param vector Le vecteur d'elements
	 * @param pane La ou on vx mettre le panel des proprietées de l'element de la liste selectionné
	 * @return
	 */
	private static JComponent Cree_un_Panel_Liste(AbstractList<?> vector, final JPanel pane,JWPanel parent_panel, String named)
	{
		final AbstractList<?> v5 = vector;
		DefaultListModel dlm = new DefaultListModel();
		final JXList listM = new JXList(dlm);
		listM.setName(named);
		for (int k=0;k<v5.size();k++)
		{
			dlm.addElement(v5.get(k));
		}
		
		listM.addListSelectionListener(new ListModelListenerM(listM, pane,vector, parent_panel));
		return listM;
	}
	
	private static JComponent Cree_un_Panel_Map(AbstractMap<?, ?> vector, JPanel pane,JWPanel parent_panel, String named) {
		final AbstractMap<?, ?> v5 = vector;
		DefaultListModel dlm = new DefaultListModel();
		final JXList listM = new JXList(dlm);
		listM.setName(named);
		Object[] Keys = v5.keySet().toArray();
		for (int k=0;k<Keys.length;k++)
		{
			dlm.addElement(Keys[k]);
		}
		
		listM.addListSelectionListener(new MapModelListenerM(listM, pane, vector, parent_panel));
		return listM;
	}
	
	private static JComponent Cree_un_Panel_Set(AbstractSet<?> vector, JPanel pane, JWPanel parent_panel, String named) {
		final AbstractSet<?> v5 = vector;
		DefaultListModel dlm = new DefaultListModel();
		final JXList listM = new JXList(dlm);
		listM.setName(named);
		Object[] Keys = v5.toArray();
		for (int k=0;k<Keys.length;k++)
		{
			dlm.addElement(Keys[k]);
		}
		
		listM.addListSelectionListener(new SetModelListenerM(listM, pane, vector, parent_panel));
		return listM;
	}
	
	
	//// REFLECTION /////////
	@SuppressWarnings("unchecked")
	static Object lancerMethode(Object o, Object[] args, String nomMethode) throws Exception
	{
	  Class[] paramTypes = null;
	  if(args != null)
	  {
	    paramTypes = new Class[args.length];
	    for(int i=0;i<args.length;++i)
	      paramTypes[i] = args[i].getClass();
	  }
	  Method m = o.getClass().getMethod(nomMethode,paramTypes);
	  return m.invoke(o,args);
	}
}
