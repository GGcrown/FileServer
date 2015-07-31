package miso.distil.services;

import miso.distil.documentServices.Document;
import miso.distil.pictureServices.Picture;
import miso.distil.videoServices.Video;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import spark.Request;
import spark.Response;
import miso.carrascal.cloudModelServices.abstractServices.services.ServiceAbstractJson;
import miso.carrascal.cloudModelServices.abstractServices.Persistent;
import miso.carrascal.cloudModelServices.abstractServices.RecordDB;
import miso.carrascal.cloudModelServices.utils.RecordDownload;

/**
 * Auto-generated service class.
 * 
 * @author miso.distil.codeGenerator.
 */
public class ServiceDownloadAuthor extends ServiceAbstractJson {

	/**
	 * Auto-generated service constructor.
	 */
	public ServiceDownloadAuthor() {
		// Input classes
		addInputClass(Response.class);
		addInputClass(Video.class);
		// Output classes
	}

	@Override
	protected List<Object> prepareService(Request req, Response res, List<? extends Persistent> artifacts) {
		List<Object> input = new ArrayList<Object>();
		System.out.println("Starting prepare service DownloadAuthor");
		

		input.add(res);
		// Create the input objects to your service and use (or not) the artifacts
		if(artifacts.size() == 1) {
			input.add(artifacts.get(0));
		} else {
			input.add(new Video());
		}
		
		System.out.println("Finishing prepare service DownloadAuthor");

		return input;
	}

	@Override
	protected List<Object> exeService(List<Object> input) {
		List<Object> output = new ArrayList<Object>();
		System.out.println("Starting execute service DownloadAuthor");
		if(!this.testInput(input))
			return output;
		// do something!

		Response res = Response.class.cast(input.get(0));

		if(input.get(1) instanceof Picture) {
			Picture pic = Picture.class.cast(input.get(1));
			List<Picture> pictures = RecordDB.getDefault().search("pictureinfo.author", pic.getPictureinfo().getAuthor(), false, Picture.class);
			for(Picture picture : pictures) {
				if(!picture.getObjectid().equalsIgnoreCase(pic.getObjectid())) {
					InputStream IS = RecordDB.getDefault().getInputStream(picture.getObjectid(), Picture.class);
					RecordDownload.addDownload(res, IS, picture.getFilename());
				}
			}
			
		} else if(input.get(1) instanceof Document) {
			Document doc = Document.class.cast(input.get(1));
			List<Document> documents = (List<Document>) RecordDB.getDefault().search("docinfo.author", doc.getDocinfo().getAuthor(), false, Document.class);
			for(Document document : documents) {
				if(!document.getObjectid().equalsIgnoreCase(doc.getObjectid())) {
					InputStream IS = RecordDB.getDefault().getInputStream(document.getObjectid(), Document.class);
					RecordDownload.addDownload(res, IS, document.getFilename());
				}
			}
		} else if(input.get(1) instanceof Video) {
			Video vid = Video.class.cast(input.get(1));
			List<Video> videos = (List<Video>) RecordDB.getDefault().search("videoinfo.author", vid.getVideoinfo().getAuthor(), false, Video.class);
			for(Video video : videos) {
				if(!video.getObjectid().equalsIgnoreCase(vid.getObjectid())) {
					InputStream IS = RecordDB.getDefault().getInputStream(video.getObjectid(), Video.class);
					System.out.println("id " + video.getObjectid() + " name " + video.getFilename());
					RecordDownload.addDownload(res, IS, video.getFilename());
				}
			}
		}
		System.out.println("Finishing execute service DownloadAuthor");

		return output;
	}
}
