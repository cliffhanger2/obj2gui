package OBJ2GUI;

import javax.swing.JPanel;

import OBJ2GUI.Events.MyChangedEvent;
import OBJ2GUI.Events.MyEventListener;

public class JWPanel extends JPanel implements MyEventListener {


	 /**
	 * 
	 */
	private static final long serialVersionUID = -1753616508798326883L;


	// Create the listener list
   //public javax.swing.event.EventListenerList listenerList =
   //    new javax.swing.event.EventListenerList();

   
	
	/**
	 * This is the default constructor
	 */
	public JWPanel() {
		super();
		//this.setSize(new Dimension(1024,1024));
		//this.setPreferredSize(new Dimension(800,600));
		//this.setMinimumSize(new Dimension(800,600));
	}

    // This methods allows classes to register for MyEvents
    public void addMyEventListener(MyEventListener listener) {
    	//System.err.println(this.getName()+" Adding a listener "+listener); 
        listenerList.add(MyEventListener.class, listener);
    }

    // This methods allows classes to unregister for MyEvents
    public void removeMyEventListener(MyEventListener listener) {
        listenerList.remove(MyEventListener.class, listener);
    }

    // This private class is used to fire MyEvents
    public void fireMyEvent(MyChangedEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i=0; i<listeners.length; i+=2) {
            if (listeners[i]==MyEventListener.class) {
            	//System.err.println("Transmit the event" +((MyEventListener)listeners[i+1]));
            	((MyEventListener)listeners[i+1]).myEventOccurred(evt);
            }
        }
    }

    // Transmet au panel parent ?!
	public void myEventOccurred(MyChangedEvent evt) {
	//	System.err.println("Received an event" +this.getName());
		fireMyEvent(evt);
	}

	
	public void refresh(String panelName, Object objet) throws Exception
	{
		ParseurAnnotations.Refresh_PanelEditor_For_Object("", this,objet,this,false);
	}

}
