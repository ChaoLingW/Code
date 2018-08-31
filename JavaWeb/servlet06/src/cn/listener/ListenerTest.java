package cn.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerTest implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    
    	System.out.println("add");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println("");
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    }
	
}
