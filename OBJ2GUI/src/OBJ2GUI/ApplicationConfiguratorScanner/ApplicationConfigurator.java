package OBJ2GUI.ApplicationConfiguratorScanner;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import OBJ2GUI.JWPanel;
import OBJ2GUI.ParseurAnnotations;

@Deprecated
public class ApplicationConfigurator extends JWPanel
{
	public static Object obj1 = null;
	
	private static final long serialVersionUID = 1L;

	public Component THIS = this;

	private DefaultMutableTreeNode dtm = new DefaultMutableTreeNode("Main");  //  @jve:decl-index=0:
	private TreeModel tmodel = new DefaultTreeModel(dtm);  //  @jve:decl-index=0:
	private JWPanel jPanel_MIDDLE = null;

	private JScrollPane jScrollPane_TREE = null;

	private JTree jTree = null;
	
//	private JButton jButton_REFRESH_TREE = null;


	@SuppressWarnings("unused")
	private NodeScan nodeSelected;

	//private JButton jButton_REFRESH_PANEL = null;

	/**
	 * This method initializes jPanel_MIDDLE	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws Exception 
	 */
	private JWPanel getJPanel_MIDDLE() throws Exception
	{
		if (jPanel_MIDDLE == null)
		{
			jPanel_MIDDLE = (JWPanel)ParseurAnnotations.CreatePanelFromObject("Main configuration",  null, true);
			jPanel_MIDDLE.setPreferredSize(new Dimension(300, 300));
		}
		return jPanel_MIDDLE;
	}


	/**
	 * This method initializes jScrollPane_TREE	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_TREE()
	{
		if (jScrollPane_TREE == null)
		{
			jScrollPane_TREE = new JScrollPane();
		//	jScrollPane_TREE.setPreferredSize(new Dimension(400, 200));
			jScrollPane_TREE.setViewportView(getJTree());
		}
		return jScrollPane_TREE;
	}


	/**
	 * This method initializes jTree	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getJTree()
	{
		if (jTree == null)
		{
			jTree = new JTree();
			jTree.setModel(tmodel);
			jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener()
			{
				
				public void valueChanged(javax.swing.event.TreeSelectionEvent e)
				{
					DefaultMutableTreeNode nodeM = (DefaultMutableTreeNode)
                    jTree.getLastSelectedPathComponent();
					if (nodeM == null) {nodeSelected=null;return;}
					if (nodeM.getUserObject() instanceof NodeScan)
					{
					NodeScan node = (NodeScan) nodeM.getUserObject();
					System.out.println("jTree valueChanged() == "+node); // TODO Auto-generated Event stub valueChanged()
					nodeSelected= node;
					 			
					 try
					{
						 if (node.isnodescan==true)
							 ParseurAnnotations.Refresh_PanelEditor_For_Object(node.toString(), jPanel_MIDDLE, node.object, jPanel_MIDDLE, true);
						 jPanel_MIDDLE.validate();
						 jPanel_MIDDLE.repaint();
						 // TODO : Pq dois-je faire ca ?
						 jPanel_MIDDLE.setLayout(new BoxLayout(jPanel_MIDDLE, BoxLayout.Y_AXIS));
						 validate();
						repaint();
					} catch (Exception e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					else
					{
						System.err.println("Ceci n'est pas un noeud NodeScan");
					}
				}
			});
			
		}
		return jTree;
	}




	/**
	 * This method initializes jButton_REFRESH_TREE	
	 * 	
	 * @return javax.swing.JButton	
	 */
	/*private JButton getJButton_REFRESH_TREE()
	{
		if (jButton_REFRESH_TREE == null)
		{
			jButton_REFRESH_TREE = new JButton("Refresh tree");
			jButton_REFRESH_TREE.setText("Refresh tree");
			jButton_REFRESH_TREE.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					refresh_dtm_tree();
				}
			});
		}
		return jButton_REFRESH_TREE;
	}*/


	/**
	 * This method initializes jButton_REFRESH_PANEL	
	 * 	
	 * @return javax.swing.JButton	
	 */
	/*private JButton getJButton_REFRESH_PANEL()
	{
		if (jButton_REFRESH_PANEL == null)
		{
			jButton_REFRESH_PANEL = new JButton();
			jButton_REFRESH_PANEL.setText("Refresh Panel");
			jButton_REFRESH_PANEL.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					refresh_panel_inside();
				}
			});
		}
		return jButton_REFRESH_PANEL;
	}*/


	/**
	 * Petit test ...
	 * @param args
	 */
	public static void main(String[] args)
	{
	//	final ApplicConfigTestObject obj = new ApplicConfigTestObject();  //  @jve:decl-index=0:
		// TODO Auto-generated method stub
	/*	SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				ApplicationConfigurator thisClass =null;
				try
				{
					JFrame frame = new JFrame();
					thisClass = new ApplicationConfigurator(obj);
					frame.setContentPane(thisClass);
					frame.setVisible(true);
					frame.setPreferredSize(new Dimension(640,640));
					frame.validate();

					Thread t = new Thread() {
				        private Random rand = new Random();

						@Override
						public void run() {
				        	while (true)
				        	{
				        		//System.err.println("Refresh value");
				        		try {
									Thread.sleep(250);	
									} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
									obj.setEDI_VAR2(rand.nextFloat());
									obj.setEDI_VAR2(rand.nextFloat());
									obj.setEDI_BOOL2(rand.nextBoolean());
									obj.setEDI_BOOL1(rand.nextBoolean());
									
								//	obj.subtestobj.setEDI_float_sub1_1(rand.nextFloat());
									obj.subtestobj.EDI_subsubtestobject_1.setEDI_float_sub2_3(rand.nextFloat());
									obj.subtestobj.EDI_subsubtestobject_1.setEDI_float_sub2_2(rand.nextFloat());
									obj.subtestobj.EDI_subsubtestobject_2.setEDI_float_sub2_2(rand.nextFloat());
				        	}
				        }
				      };
				      t.start();
				
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		*/
		
		
		
		
	}

	/**
	 * This is the default constructor
	 * @throws Exception 
	 */
	public ApplicationConfigurator(Object mainapss) throws Exception
	{
		super();
		THIS = this;
		obj1 = mainapss;
		initialize();
		refresh_dtm_tree();
		
//		 Rafraichir automatique le panel central
	/*	Thread_refresh_panel = new Thread() {
		        public void run() {
		        	while (true)
	        		{
		        	try
					{
		        		Thread.sleep(500);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 //   refresh_panel_inside();
	        		}
		        }

				
		 };
		 Thread_refresh_panel.start();*/
		 
//		 Rafraichir automatique le panel central
		/* Thread_tree = new Thread() {
			        public void run() {
			        	while (true)
		        		{
			        	try
						{
			        		Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							refresh_dtm_tree();
		        		}
			        }

					
			 };
			 Thread_tree.start();*/
		
	}
/*
	private void refresh_panel_inside()
	{
		if (nodeSelected == null) return;
		NodeScan node = nodeSelected;
		
		 Point point;
         point = MouseInfo.getPointerInfo ().getLocation ();
		
         Rectangle bounds = this.getBounds();
		if (bounds.contains(point)==false)
		{
			System.err.println("Will not refresh cause mouse not iniside General Panel");
		}
         
		System.out.println("Refresh panel inside == "+node); 
		
		try
		{
			 if (node.isnodescan==true) 
				 ParseurAnnotations.Refresh_PanelEditor_For_Object(node.toString(), jPanel_MIDDLE, node.object, jPanel_MIDDLE, true);
		} catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jPanel_MIDDLE.validate();
		jPanel_MIDDLE.repaint();
		validate();
		repaint();
		
	}*/
	
	private void refresh_dtm_tree()
	{
		//TreePath TP =jTree.getSelectionPath();
		
		dtm.removeAllChildren();
		try
		{
			
			ApplicationConfiguratorScanner.ScanArboClasses(0,obj1, dtm);
		} catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmodel = new DefaultTreeModel(dtm);
		jTree.setModel(tmodel);
		expandAll();
	//	jTree.setSelectionPath(TP);
		
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws Exception 
	 */
	private void initialize() throws Exception
	{
		//this.setSize(300,200);
		this.setLayout(new BorderLayout());
		this.add(getJPanel_MIDDLE(), BorderLayout.CENTER);
		this.add(getJScrollPane_TREE(), BorderLayout.WEST);
	//	this.add(getJButton_REFRESH_TREE(), BorderLayout.NORTH);
	//	this.add(getJButton_REFRESH_PANEL(), BorderLayout.SOUTH);
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
		{
			@Override
			public void mouseMoved(java.awt.event.MouseEvent e)
			{
			//	Point mouse1 = e.getLocationOnScreen();
			//	System.err.println("M = "+mouse1);
			}
		});
		
	}

	public void expandAll()
	{
		int row = 0;

		while (row < jTree.getRowCount())
		{
			jTree.expandRow(row);
			row++;
		}
	}
	
	

	public void expandAll2Last()
	{
		// expand to the last leaf from the root
		DefaultMutableTreeNode root;
		root = (DefaultMutableTreeNode)jTree.getModel().getRoot();
		jTree.scrollPathToVisible(new TreePath(root.getLastLeaf().getPath()));
	}

	public void collapseAll()
	{
		int row = jTree.getRowCount()-1;

		while (row >= 0)
		{
			jTree.collapseRow(row);
			row--;
		}
	}
}
