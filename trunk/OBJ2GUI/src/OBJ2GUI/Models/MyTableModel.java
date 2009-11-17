package OBJ2GUI.Models;

import javax.swing.table.AbstractTableModel;

	public class MyTableModel extends AbstractTableModel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 3395934689889647139L;
		private String[] columnNames = null;
	    private Object[][] data = null;

	    public MyTableModel(String []titres, Object [][]data)
	    {
	    	this.setColumnNames(titres);
	    	this.setData(data);
	    }
	    
	    public int getColumnCount() {
	        return columnNames.length;
	    }

	    public synchronized String[] getColumnNames() {
			return columnNames;
		}

		public synchronized void setColumnNames(String[] columnNames) {
			this.columnNames = columnNames;
		}

		public synchronized Object[][] getData() {
			return data;
		}

		public synchronized void setData(Object[][] data) {
			this.data = data;
		}

		public int getRowCount() {
			return data.length;
			
	    }

	    @Override
		public String getColumnName(int col) {
	        return columnNames[col];
	    }

	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }

	    public Class<? extends Object> getColumnClass(int row, int c) {
	    	if (data==null) return null;
	    	if (getValueAt(row, c)==null) return null;
	        return getValueAt(row, c).getClass();
	    }
	  /*  public Class getColumnClass(int c) {
	    	if (data==null) return null;
	    	if (getValueAt(0, c)==null) return null;
	        return getValueAt(0, c).getClass();
	    }*/

	    /*
	     * Don't need to implement this method unless your table's
	     * editable.
	     */
	    @Override
		public boolean isCellEditable(int row, int col) {
	    	return true;
	    	//Note that the data/cell address is constant,
	        //no matter where the cell appears onscreen.
	     
	    }

	    /*
	     * Don't need to implement this method unless your table's
	     * data can change.
	     */
	    @Override
		public void setValueAt(Object value, int row, int col) {
	        data[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }
	   
	
}
