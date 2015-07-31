package miso.distil.pictureServices;

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
import miso.distil.pictureServices.Picture;
import miso.distil.pictureServices.basic.BasicPictureParam;
import miso.distil.entities.PersonalData;

/**
 * Auto-generated custom json methods.
 * 
 * @author miso.distil.codeGenerator.
 */
public class PictureJson extends BasicAbstractJson<Picture> {

	 /**
	 * Auto-generated empty constructor.
	 */
	 public PictureJson() {
	 	super(Picture.class);	
	 }

	/**
	 * Auto-generated method to cusomice the upload method
	 * 
	 * @param req Spark request.
	 * @param res Spark response.
	 * @return Picture uploaded or null if error.
	 */
	@Override
	public Picture postUpload(Request req, Response res) {
		// There is a file
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/tmp");
		req.raw().setAttribute("org.eclipse.multipartConfig", multipartConfigElement);

		try {
			// File Information
			Part filePart = req.raw().getPart(BasicPictureParam.File);
		    String fileName = getFileName(filePart);
			long fileSize = filePart.getSize();
		    InputStream fileContent = filePart.getInputStream();

			// Required params
			String author_pictureinfo = req.raw().getParameter(BasicPictureParam.Author_pictureinfo);
			String source_pictureinfo = req.raw().getParameter(BasicPictureParam.Source_pictureinfo);
			List<String> tags_pictureinfo = Utils.stringToListString(req.raw().getParameter(BasicPictureParam.Tags_pictureinfo));
			List<String> peoplepictured = Utils.stringToListString(req.raw().getParameter(BasicPictureParam.Peoplepictured));
			String place = req.raw().getParameter(BasicPictureParam.Place);
			Boolean edited = req.raw().getParameter(BasicPictureParam.Edited).equalsIgnoreCase("true");

			if(fileContent == null || fileName == null) {
				return null;
			}
			if(fileName.isEmpty() ) {
				return null;
			}

			// Not required params and artifact's id
			// Complete these params!
			int indexof = fileName.lastIndexOf('.');
			String fileextension_pictureinfo = "unknown";
			if(indexof >= 0 && indexof < fileName.length()) {
				fileextension_pictureinfo = fileName.substring(indexof);
			}

			//Composed params
			PersonalData pictureinfo = new PersonalData(author_pictureinfo, source_pictureinfo, tags_pictureinfo, fileextension_pictureinfo);

			// Create new Picture
			Picture picture = new Picture(fileName, fileSize, pictureinfo, peoplepictured, place, edited);

			if(!RecordDB.getDefault().save(picture, fileContent)) {
				return null;
			}

			return picture;

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
