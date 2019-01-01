package org.saurav.cmisbridge;

import org.apache.chemistry.opencmis.bridge.AbstractBridgeServiceFactory;
import org.apache.chemistry.opencmis.bridge.FilterCmisService;
import org.apache.chemistry.opencmis.commons.server.CallContext;

public class CmisBridgeServiceFactory extends AbstractBridgeServiceFactory {

	@Override
	protected FilterCmisService createService(CallContext context) {
		// TODO Auto-generated method stub
		return new CmisBridgeService();
	}

}
