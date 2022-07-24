package org.saurav.cmisbridge;

import static org.apache.chemistry.opencmis.server.shared.AbstractCmisHttpServlet.PARAM_CALL_CONTEXT_HANDLER;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.chemistry.opencmis.commons.impl.dataobjects.BindingsObjectFactoryImpl;
import org.apache.chemistry.opencmis.commons.spi.BindingsObjectFactory;
import org.apache.chemistry.opencmis.server.impl.browser.CmisBrowserBindingServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

@Configuration
@Lazy(value = false)
public class BridgeCMISConfig implements ServletContextAware {
	 private static final String CMIS_HANDLER =
		      "org.apache.chemistry.opencmis.server.shared.BasicAuthCallContextHandler";
	 private ServletContext servletContext;
	
	 @Bean
	  public CmisBrowserBindingServlet cmisBrowserServlet() {
		 
		 CmisBrowserBindingServlet cmisBrowserBindingServlet = new CmisBrowserBindingServlet();
		 servletContext.addListener(new CmisBridgeServiceListener());
	    return cmisBrowserBindingServlet;
	  }

	  @Bean
	  public BindingsObjectFactory bindingsObjectFactory() {
	    return new BindingsObjectFactoryImpl();
	  }

	  
	  @Bean
	  public ServletRegistrationBean<CmisBrowserBindingServlet> cmisBrowserServletRegistration(
	      CmisBrowserBindingServlet servlet) {
	    ServletRegistrationBean<CmisBrowserBindingServlet> registrationBean =
	        new ServletRegistrationBean<>(servlet, "/browser/*");
	    registrationBean.setName("cmisbrowser");
	    
	    	
	    registrationBean.getInitParameters().put(PARAM_CALL_CONTEXT_HANDLER, CMIS_HANDLER);
	    return registrationBean;

}

	

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
}
