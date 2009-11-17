package OBJ2GUI.ApplicationConfiguratorScanner;

public class NodeScan
{
	Object object = null;
	String varname = "";
	int level = 0;
	boolean isnodescan = true;
	
	NodeScan(Object o, int level, String varname)
	{
		this.level = level;
		object = o;
		this.varname= varname;
		isnodescan = true;
	}
	
	public NodeScan(Object o, int level2, String name, boolean b)
	{
		this.level = level2;
		object = o;
		this.varname= name;
		isnodescan = b;
	}

	@Override
	public String toString()
	{
	/*	
		if (object instanceof Panelisable)
		{
	//	String onlyclass = ((Panelisable)object).getPanelisableName();
		if (isnodescan==true)
		{
			String onlyclass = ((Panelisable)object).getPanelisableName();
			onlyclass = ((Panelisable)object).getPanelisableName();
			//return "N " + onlyclass + " || "+ varname;
			return onlyclass+ "    ["+varname+ "]";
		}
		}
		return "not panelisable";*/
		if (object==null) {return "Null Ptr";}
		String str =object.getClass().getName().toString();
		String [] spl = str.split(".");
		if (spl.length==0)
			return object.getClass().getName();
		return spl[spl.length-1];
		//return("Yop");
		
		/*else
		{
			return "X " + varname;
		}*/
	}
	
}
