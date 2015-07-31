package miso.distil.videoServices;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import spark.Request;
import spark.Response;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;

import miso.carrascal.cloudModelServices.abstractServices.RecordDB;
import miso.carrascal.cloudModelServices.utils.Utils;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicAbstractJson;
import miso.distil.videoServices.Video;
import miso.distil.videoServices.basic.BasicVideoParam;
import miso.distil.entities.PersonalData;

/**
 * Auto-generated custom json methods.
 * 
 * @author miso.distil.codeGenerator.
 */
public class VideoJson extends BasicAbstractJson<Video> {

	 /**
	 * Auto-generated empty constructor.
	 */
	 public VideoJson() {
	 	super(Video.class);	
	 }

	/**
	 * Auto-generated method to cusomice the upload method
	 * 
	 * @param req Spark request.
	 * @param res Spark response.
	 * @return Video uploaded or null if error.
	 */
	@Override
	public Video postUpload(Request req, Response res) {
		// There is a file
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/tmp");
		req.raw().setAttribute("org.eclipse.multipartConfig", multipartConfigElement);

		try {
			// File Information
			Part filePart = req.raw().getPart(BasicVideoParam.File);
		    String fileName = getFileName(filePart);
			long fileSize = filePart.getSize();
		    InputStream fileContent = filePart.getInputStream();

			// Required params
			String author_videoinfo = req.raw().getParameter(BasicVideoParam.Author_videoinfo);
			String source_videoinfo = req.raw().getParameter(BasicVideoParam.Source_videoinfo);
			List<String> tags_videoinfo = Utils.stringToListString(req.raw().getParameter(BasicVideoParam.Tags_videoinfo));
			Double length = Double.parseDouble(req.raw().getParameter(BasicVideoParam.Length));

			if(fileContent == null || fileName == null) {
				return null;
			}
			if(fileName.isEmpty() ) {
				return null;
			}

			// Not required params and artifact's id
			// Complete these params!
			int indexof = fileName.lastIndexOf('.');
			String fileextension_videoinfo = "unknown";
			if(indexof >= 0 && indexof < fileName.length()) {
				fileextension_videoinfo = fileName.substring(indexof);
			}

			//Composed params
			PersonalData videoinfo = new PersonalData(author_videoinfo, source_videoinfo, tags_videoinfo, fileextension_videoinfo);

			// Create new Video
			Video video = new Video(fileName, fileSize, videoinfo, length);

			if(!RecordDB.getDefault().save(video, fileContent)) {
				return null;
			}

			return video;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ServletException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
