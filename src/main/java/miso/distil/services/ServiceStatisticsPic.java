package miso.distil.services;

import java.util.ArrayList;
import java.util.List;

import spark.Request;
import spark.Response;
import miso.carrascal.cloudModelServices.abstractServices.services.ServiceAbstractJson;
import miso.carrascal.cloudModelServices.abstractServices.Persistent;
import miso.distil.pictureServices.Picture;
import miso.distil.entities.PersonalData;

/**
 * Auto-generated service class.
 * 
 * @author miso.distil.codeGenerator.
 */
public class ServiceStatisticsPic extends ServiceAbstractJson {

	/**
	 * Auto-generated service constructor.
	 */
	public ServiceStatisticsPic() {
		// Input classes
		addInputClass(Picture.class);
		// Output classes
		addOutputClass(PersonalData.class);
	}

	@Override
	protected List<Object> prepareService(Request req, Response res, List<? extends Persistent> artifacts) {
		List<Object> input = new ArrayList<Object>();
		System.out.println("Starting prepare service StatisticsPic");

		// Create the input objects to your service and use (or not) the artifacts
		if(artifacts.size() == 1) {
			input.add(artifacts.get(0));
		} else {
			input.add(new Picture());
		}
		System.out.println("Finishing prepare service StatisticsPic");
		return input;
	}

	@Override
	protected List<Object> exeService(List<Object> input) {
		List<Object> output = new ArrayList<Object>();
		System.out.println("Starting execute service StatisticsPic");
		if(!this.testInput(input))
			return output;

		// Take your inputs
		Picture picture = Picture.class.cast(input.get(0));
		//  do something!

		// Create your outputs (do something!)
		output.add(picture.getPictureinfo());
		System.out.println("Finishing execute service StatisticsPic");

		return output;
	}
}
