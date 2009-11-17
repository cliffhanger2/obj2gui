package OBJ2GUI.Events;

import java.util.EventObject;

//Declare the event. It must extend EventObject.
public class MyChangedEvent extends EventObject {
    /**
	 * 
	 */
	private static final long	serialVersionUID	= -8942475752564844776L;
	Object OrignalComponent = null;
    public MyChangedEvent(Object source, Object value) {
		super(source);
		this.OrignalComponent=value;
	        
    }
    public synchronized Object getOrignalComponent() {
        return OrignalComponent;
    }
    public synchronized void setOrignalComponent(Object orignalComponent) {
        OrignalComponent = orignalComponent;
    }
}