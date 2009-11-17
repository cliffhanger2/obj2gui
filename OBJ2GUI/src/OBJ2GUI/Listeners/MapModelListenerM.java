package OBJ2GUI.Listeners;

import java.util.AbstractMap;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import OBJ2GUI.JWPanel;
import OBJ2GUI.ParseurAnnotations;

/**
 * 
 * @author Warnotte Renaud 2007
 *
 */
public class MapModelListenerM extends BaseListener implements ListSelectionListener {

	JList jtf = null; // La Liste
	//AbstractList elements = null; // Les elements	de la JListe --> J'aimerai pouvoir me fier au jtf.getSelectedValue() a la place de jouer avec l'index au #65789354 
	AbstractMap<?,?> elements = null; // Les elements	de la JListe --> Les Clées 
//	AbstractMap theMapItself = null; // Les elements	de la JListe --> Les Elements 
	
	JPanel pane = null; // Le panel qui sera celui a mettre d'un element de la JList
	
	//public ListModelListenerM(JList jtf1, JPanel panel, AbstractList elements)
	public MapModelListenerM(JList jtf1, JPanel panel, AbstractMap<?,?> elements, JWPanel parent_panel)
	{
		super(parent_panel);
		this.elements = elements;
		this.jtf = jtf1;
		this.pane = panel;
	}
	
	public void valueChanged(javax.swing.event.ListSelectionEvent e)
	{
		// Si le user selectionne un element de la JList alors on rafraichis le panel cible avec l'objet selectionnée dans la liste en demandant au super generateur
		// Recupere la clés selctionnée
		Object obj = jtf.getSelectedValue();
		try
		{
			// Recupere l'objet a partir de la AbstractMap (grace a la clé)
			Object obj1 = elements.get(obj);
			ParseurAnnotations.Refresh_PanelEditor_For_Object("",pane,obj1,parent_panel, false);
		} 
		catch (Exception e1)
		{
		e1.printStackTrace();
		}
	}
}
