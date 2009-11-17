package OBJ2GUI.ApplicationConfiguratorScanner;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

import OBJ2GUI.Annotations.GUI_CLASS;

@Deprecated
public class ApplicationConfiguratorScanner
{
	static boolean VERBOSE_DEBUG=true;
	
	public static void main(String[] args) throws Exception
	{
	/*	final View_Options obj1 = new View_Options();
		// Parse une classe a la recherche de sous classes
		int level = 0;
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Root");
	    //Vector results = new Vector();
		ScanArboClasses(level,obj1, top);*/
		
	}
	
	public static void ScanArboClasses(int level, Object obj1, DefaultMutableTreeNode top) throws IllegalArgumentException, IllegalAccessException
	{
		if (obj1==null)
		{
			System.err.println("Null :| Null");
			return;
		}
		Class<?> c = obj1.getClass();
		Field []fields = c.getDeclaredFields();
		// Premiere passe ... 
		if (level==0)
		if (is_or_parent_panelisable_class(c)==true)
		{
			if (VERBOSE_DEBUG==true)
			System.err.println(level+") "+c.getName()+" : "+ c.getClass() +" V = "+ obj1);
		}
		// Parcours les variables fils a la recherche de classes Panelisable 
		for (int j =0;j<fields.length;j++)
		{
			Class<?> c2 = fields[j].getType();
			if (c2==Vector.class)
			{
				if (VERBOSE_DEBUG==true)
				System.err.println("Vector detected "+fields[j]);
				fields[j].setAccessible(true);
				Object o = fields[j].get(obj1);
				Vector<?> v = (Vector<?>) o;
				if (fields[j].getName().startsWith("EDI")==false)
					continue;
				if (v==null) {
					continue;
				}
				for (int z=0;z<v.size();z++)
				{
				 
					Object k = v.elementAt(z);
					String nom = k.getClass().getName();
					nom = nom.substring(nom.lastIndexOf(".")+1);
					if (VERBOSE_DEBUG==true)
					System.err.println(level+")"+c2.getName()+" : "+ c2.getClass() +" V = "+ k);
					//boolean panelisable =false;
					NodeScan node = new NodeScan(k,level, nom+"_"+z);
					//resultats.add(node);	
					DefaultMutableTreeNode Mnode = new DefaultMutableTreeNode(node);
					top.add(Mnode);
					ScanArboClasses(level+1,k,Mnode);
				}
			}
			if (c2==Array.class)
			{
				if (VERBOSE_DEBUG==true)
				System.err.println("Vector detected");
				fields[j].setAccessible(true);
				Object o = fields[j].get(obj1);
				Vector<?> v = (Vector<?>) o;
				for (int z=0;z<v.size();z++)
				{
				 
					Object k = v.elementAt(z);
					String nom = k.getClass().getName();
					nom = nom.substring(nom.lastIndexOf(".")+1);
					if (VERBOSE_DEBUG==true)
					System.err.println(level+")"+c2.getName()+" : "+ c2.getClass() +" V = "+ k);
				//	boolean panelisable =false;
					NodeScan node = new NodeScan(k,level, nom+"_"+z);
					//resultats.add(node);	
					DefaultMutableTreeNode Mnode = new DefaultMutableTreeNode(node);
					top.add(Mnode);
					ScanArboClasses(level+1,k,Mnode);
				}
			}
			else
			// Si classe ou parent implement panelisable alors on rajoute
			
			
			if (is_or_parent_panelisable_class(c2)==true)
			{
				fields[j].setAccessible(true);
				Object o = fields[j].get(obj1);
				NodeScan node = new NodeScan(o, level, fields[j].getName());
				DefaultMutableTreeNode Mnode = new DefaultMutableTreeNode(node);
				top.add(Mnode);
				if (VERBOSE_DEBUG==true)
				System.err.println(level+")"+c2.getName()+" : "+ c2.getClass() +" V = "+ o);
				ScanArboClasses(level+1,o,Mnode);
			}
		}
	}
	
	
	/**
	 * Cherche a partir d'une classe si la classe ou un de ses parent implemente Panelisable
	 * @param c la Class
	 * @return
	 */
	private static boolean is_or_parent_panelisable_class(Class<?> c)
	{
		GUI_CLASS annotation = c.getAnnotation(GUI_CLASS.class);
		if (annotation!=null) 
			return true;
		Class<?> ifs [] = c.getInterfaces();
		for (int i =0;i<ifs.length;i++)
		{
			annotation = ifs[i].getAnnotation(GUI_CLASS.class);
			if (annotation!=null) 
			//if (ifs[i]==Panelisable.class)
				return true;
		}
		if (c.getSuperclass()!=null)
		if (is_or_parent_panelisable_class(c.getSuperclass())==true)
			return true;
		return false;
	}

	
}
