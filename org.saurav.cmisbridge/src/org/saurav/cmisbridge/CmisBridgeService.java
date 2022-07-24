package org.saurav.cmisbridge;

import java.util.List;

import org.apache.chemistry.opencmis.bridge.CachedBindingCmisService;
import org.apache.chemistry.opencmis.client.SessionParameterMap;
import org.apache.chemistry.opencmis.client.bindings.CmisBindingFactory;
import org.apache.chemistry.opencmis.client.bindings.spi.http.DefaultHttpInvoker;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ExtensionsData;
import org.apache.chemistry.opencmis.commons.data.RepositoryInfo;
import org.apache.chemistry.opencmis.commons.spi.CmisBinding;

public class CmisBridgeService extends CachedBindingCmisService {
	
	CmisBinding cmisBinding  = null;
	
	@Override
	public CmisBinding getCmisBindingFromCache() {
		return cmisBinding;
	}

	@Override
	public CmisBinding putCmisBindingIntoCache(CmisBinding binding) {
		return binding;
	}

	@Override
	public CmisBinding createCmisBinding() {
		
		SessionParameterMap parameters = new SessionParameterMap();
		//connect the file share repository
		parameters.setRepositoryId(Constants.REPO_ID);
		parameters.setBrowserBindingUrl(Constants.REPO_URL);
		parameters.setUserAndPassword(Constants.REPO_USERNAME, Constants.REPO_PASSWORD);
		//parameters.put(SessionParameter.BINDING_TYPE, "browser");
		parameters.put(SessionParameter.CONNECT_TIMEOUT, "60000");
		parameters.put(SessionParameter.READ_TIMEOUT, "900000");

		parameters.put(SessionParameter.HTTP_INVOKER_CLASS, DefaultHttpInvoker.class.getName());
		cmisBinding = CmisBindingFactory.newInstance().createCmisBrowserBinding(parameters);
		return cmisBinding;
	}

	

}
