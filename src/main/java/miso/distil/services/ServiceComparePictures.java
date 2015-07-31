package miso.distil.services;

import java.util.ArrayList;
import java.util.List;

import spark.Request;
import spark.Response;
import miso.carrascal.cloudModelServices.abstractServices.services.ServiceAbstractJson;
import miso.carrascal.cloudModelServices.abstractServices.Persistent;
import miso.carrascal.cloudModelServices.abstractServices.RecordDB;
import miso.distil.entities.PersonalData;
import miso.distil.pictureServices.Picture;

/**
 * Auto-generated service class.
 * 
 * @author miso.distil.codeGenerator.
 */
public class ServiceComparePictures extends ServiceAbstractJson {

	/**
	 * Auto-generated service constructor.
	 */
	public ServiceComparePictures() {
		// Input classes
		addInputClass(PersonalData.class);
		// Output classes
		addOutputClass((new ArrayList<Picture>()).getClass());
	}

	@Override
	protected List<Object> prepareService(Request req, Response res, List<? extends Persistent> artifacts) {
		List<Object> input = new ArrayList<Object>();
		System.out.println("Starting prepare service ComparePictures");

		// Create the input objects to your service and use (or not) the artifacts
		input.add(new Picture());
		
		System.out.println("Finishing prepare service ComparePictures");

		return input;
	}

	@Override
	protected List<Object> exeService(List<Object> input) {
		List<Object> output = new ArrayList<Object>();
		System.out.println("Starting execute service ComparePictures");
		if(!this.testInput(input))
			return output;

		// Take your inputs
		PersonalData personaldata = PersonalData.class.cast(input.get(0));
		// : do something!
		List<Picture> pictures = RecordDB.getDefault().search("source", personaldata.getSource(), false, Picture.class);
		pictures.addAll(RecordDB.getDefault().search("fileextension", personaldata.getFileextension(), false, Picture.class));
		
		// Create your outputs (do something!)
		output.add(pictures);
		System.out.println("Finishing execute service ComparePictures");

		return output;
	}
}
