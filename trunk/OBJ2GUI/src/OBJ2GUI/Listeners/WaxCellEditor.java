package OBJ2GUI.Listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class WaxCellEditor extends DefaultCellEditor {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6841784655451474464L;
	JTextField ftf;
    private Integer minimum, maximum;
    private boolean DEBUG = false;
    int row, col;
    Object value;
    JTable table = null;

    public WaxCellEditor(int min, int max) {
        super(new JTextField());
        ftf = (JTextField)getComponent();
        minimum = new Integer(min);
        maximum = new Integer(max);

        //ftf.setValue(0);
        ftf.setHorizontalAlignment(SwingConstants.TRAILING);
    //   ftf.setFocusLostBehavior(JTextField.PERSIST);

        //React when the user presses Enter while the editor is
        //active.  (Tab is handled as specified by
        //JTextField's focusLostBehavior property.)
        ftf.getInputMap().put(KeyStroke.getKeyStroke(
                                        KeyEvent.VK_ENTER, 0),
                                        "check");
        ftf.getActionMap().put("check", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		if (!ftf.isValid()) { //The text is invalid.
                    if (userSaysRevert()) { //reverted
		        ftf.postActionEvent(); //inform the editor
		    }

                } else
			//  ftf.commitEdit();     //so use it.
			ftf.postActionEvent(); //stop editing
            }
        });
    }

    //Override to invoke setValue on the formatted text field.
    @Override
	public Component getTableCellEditorComponent(JTable table,
            Object value1, boolean isSelected,
            int row, int column) {
        JTextField ftf =
            (JTextField)super.getTableCellEditorComponent(
                table, value1, isSelected, row, column);
        this.row = row;
        this.col = column;
        this.value = value1;
        this.table = table;
        ftf.setText(""+value1);
        return ftf;
    }

    //Override to ensure that the value remains an Integer.
    @Override
	public Object getCellEditorValue() {
    	System.err.println("Attente d'un type "+table.getValueAt(row, col).getClass()+" dans la cellule");
    	
    	JTextField ftf = (JTextField)getComponent();
    	Object o = ftf.getText();
    	Class<?> cellClass = value.getClass();
    	Constructor<?> cons = Cherche_Constructeur_avec_String_en_param(cellClass.getConstructors());
    	Object newobj = null;
    	try {
    		newobj = cons.newInstance(""+ o);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return value;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return value;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return value;
		} catch (InvocationTargetException e) {
			System.err.println("Invalid Value =="+value);
			return value;
		}
    	
    	
    	if (o instanceof Integer) {
            return o;
        } else if (o instanceof Number) {
            return new Integer(((Number)o).intValue());
        } else {
            if (DEBUG) {
                System.out.println("getCellEditorValue: o isn't a Number");
            }
            return newobj;
          
        }
    }

    //Override to check whether the edit is valid,
    //setting the value if it is and complaining if
    //it isn't.  If it's OK for the editor to go
    //away, we need to invoke the superclass's version 
    //of this method so that everything gets cleaned up.
    @Override
	public boolean stopCellEditing() {
    	JTextField ftf = (JTextField)getComponent();
    	System.err.println("contient : "+ftf.getText());
    	return super.stopCellEditing();
    //	 return false; //don't let the editor go away
   // 	return true;
    /*    if (ftf.isValid()) {
            
            	ftf.validate();
            return true;
                //ftf.commitEdit();
         //   } catch (java.text.ParseException exc) { }
	    
        } else { //text is invalid
            if (!userSaysRevert()) { //user wants to edit
            	 return false; //don't let the editor go away
	    } 
        }
        return super.stopCellEditing();*/
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

    /** 
     * Lets the user know that the text they entered is 
     * bad. Returns true if the user elects to revert to
     * the last good value.  Otherwise, returns false, 
     * indicating that the user wants to continue editing.
     */
    protected boolean userSaysRevert() {
     //   Toolkit.getDefaultToolkit().beep();
        ftf.selectAll();
        Object[] options = {"Edit",
                            "Revert"};
        int answer = JOptionPane.showOptionDialog(
            SwingUtilities.getWindowAncestor(ftf),
            "The value must be an integer between "
            + minimum + " and "
            + maximum + ".\n"
            + "You can either continue editing "
            + "or revert to the last valid value.",
            "Invalid Text Entered",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE,
            null,
            options,
            options[1]);
	    
        if (answer == 1) { //Revert!
        	 ftf.setText(ftf.getText());
	    return true;
        }
	return false;
    }
}