package miso.distil.services;

import miso.carrascal.cloudModelServices.abstractServices.services.MultiServiceAbstractJson;

/**
 * Auto-generated multi service class.
 * 
 * @author miso.distil.codeGenerator.
 */
public class ServiceAnalyse extends MultiServiceAbstractJson {

	/**
	 * Auto-generated multi service constructor.
	 */
	public ServiceAnalyse() {
		super(true);
		addService(new ServiceStatisticsDoc());
		addService(new ServiceDownloadAsTxt());
	}
}
