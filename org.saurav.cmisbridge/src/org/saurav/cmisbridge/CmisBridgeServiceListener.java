package org.saurav.cmisbridge;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.chemistry.opencmis.commons.server.CmisServiceFactory;
import org.apache.chemistry.opencmis.server.impl.CmisRepositoryContextListener;

public class CmisBridgeServiceListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		CmisBridgeServiceFactory cmisBridgeServieFactory = new CmisBridgeServiceFactory();
		sce.getServletContext().setAttribute(CmisRepositoryContextListener.SERVICES_FACTORY, cmisBridgeServieFactory);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		CmisServiceFactory factory = (CmisServiceFactory) sce.getServletContext().getAttribute(CmisRepositoryContextListener.SERVICES_FACTORY);
		if (factory != null) {
			factory.destroy();
		}
		
	}

}
