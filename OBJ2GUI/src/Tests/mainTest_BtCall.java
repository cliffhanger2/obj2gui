package Tests;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import OBJ2GUI.JWPanel;
import OBJ2GUI.ParseurAnnotations;
import OBJ2GUI.Events.MyChangedEvent;
import OBJ2GUI.Events.MyEventListener;

public class mainTest_BtCall {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	//    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	//    UIManager.installLookAndFeel("Kunststoff", "com.incors.plaf.kunststoff.KunststoffLookAndFeel");
	//   UIManager.setLookAndFeel("com.incors.plaf.kunststoff.KunststoffLookAndFeel");
	//    UIManager.put("controlText", Color.black);
	    
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
			
		
		//ParseurAnnotations p = new ParseurAnnotations();
		
		 final Test_boutonCall objet = new Test_boutonCall();
			
			JFrame frame = new JFrame();
			frame.setSize(640,610);
			frame.setPreferredSize(new Dimension(640,640));
			frame.setVisible(true);
			frame.setLayout(new BorderLayout());
			  JWPanel panel=null;
			try
			{
				
			
			// Crée ces 3 panels sans ajouter la variable change listener qui pompe les ressources si 10000 de changements
				 panel = (JWPanel) ParseurAnnotations.CreatePanelFromObject("Main configuration", objet,false);

				 panel.addMyEventListener(new MyEventListener()
					{
						public void myEventOccurred(MyChangedEvent e)
						{
							try
							{
						//		panel.refresh("Panel",objet);
							} catch (Exception e1)
							{
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
			} catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			
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
					objet.debug();
		//			panel.fireMyEvent(new MyChangedEvent(this,null));
				}
			});
			
			JButton button2 =  new JButton();
			button2.setText("Refresh Panel");
			button2.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					try {
		//				ParseurAnnotations.Refresh_PanelEditor_For_Object("", panel,objet,panel,false);
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
				//	objet.addObjets();
					try {
				//		ParseurAnnotations.Refresh_PanelEditor_For_Object("", panel,objet,panel,false);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			
			frame.add(button,BorderLayout.SOUTH);
			frame.add(button2,BorderLayout.NORTH);
			frame.add(button3,BorderLayout.EAST);
			
			frame.validate();
			frame.pack();
		    }
		});
	    
		//SwingUtilities.updateComponentTreeUI(frame);
	}

}
