package servletPackage;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebContext implements  ServletContextListener{
	private ServletContext context=null;
	
	@Override
	public void contextDestroyed(ServletContextEvent args){
		context=args.getServletContext();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		context=sce.getServletContext();
		System.out.println("ServiceContextListener started");
	}
	
	
}