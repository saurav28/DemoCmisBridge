package org.saurav.cmisbridge;

import org.apache.chemistry.opencmis.bridge.CachedBindingCmisService;
import org.apache.chemistry.opencmis.bridge.FilterCmisService;
import org.apache.chemistry.opencmis.client.SessionParameterMap;
import org.apache.chemistry.opencmis.client.bindings.CmisBindingFactory;
import org.apache.chemistry.opencmis.client.bindings.spi.http.DefaultHttpInvoker;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.spi.AclService;
import org.apache.chemistry.opencmis.commons.spi.CmisBinding;
import org.apache.chemistry.opencmis.commons.spi.DiscoveryService;
import org.apache.chemistry.opencmis.commons.spi.MultiFilingService;
import org.apache.chemistry.opencmis.commons.spi.NavigationService;
import org.apache.chemistry.opencmis.commons.spi.ObjectService;
import org.apache.chemistry.opencmis.commons.spi.PolicyService;
import org.apache.chemistry.opencmis.commons.spi.RelationshipService;
import org.apache.chemistry.opencmis.commons.spi.RepositoryService;
import org.apache.chemistry.opencmis.commons.spi.VersioningService;

public class CmisBridgeService extends CachedBindingCmisService {
	
	CmisBinding cmisBinding  = null;

	@Override
	public CmisBinding getCmisBindingFromCache() {
		// TODO Auto-generated method stub
		return cmisBinding;
	}

	@Override
	public CmisBinding putCmisBindingIntoCache(CmisBinding binding) {
		// TODO Auto-generated method stub
		return binding;
	}

	@Override
	public CmisBinding createCmisBinding() {
		// TODO Auto-generated method stub
		SessionParameterMap parameters = new SessionParameterMap();
		//connect the file share repository
		parameters.setRepositoryId("test");
		parameters.setBrowserBindingUrl("http://localhost:8080/chemistry-opencmis-server-fileshare/browser");
		parameters.setUserAndPassword("test", "test");
		//parameters.put(SessionParameter.BINDING_TYPE, "browser");
		parameters.put(SessionParameter.CONNECT_TIMEOUT, "60000");
		parameters.put(SessionParameter.READ_TIMEOUT, "900000");

		parameters.put(SessionParameter.HTTP_INVOKER_CLASS, DefaultHttpInvoker.class.getName());
		cmisBinding = CmisBindingFactory.newInstance().createCmisBrowserBinding(parameters);
		return cmisBinding;
	}

	

}
