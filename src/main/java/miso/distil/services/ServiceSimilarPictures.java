package miso.distil.services;

import miso.carrascal.cloudModelServices.abstractServices.services.MultiServiceAbstractJson;

/**
 * Auto-generated multi service class.
 * 
 * @author miso.distil.codeGenerator.
 */
public class ServiceSimilarPictures extends MultiServiceAbstractJson {

	/**
	 * Auto-generated multi service constructor.
	 */
	public ServiceSimilarPictures() {
		super(false);
		addService(new ServiceStatisticsPic());
		addService(new ServiceComparePictures());
	}
}
