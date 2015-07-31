package miso.distil.pictureServices.htmlCover;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlInterfaceJson;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlFreeMarker;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlInterfaceView;
import miso.carrascal.cloudModelServices.utils.Utils;

import miso.distil.pictureServices.PictureJson;
import miso.distil.pictureServices.CustomPictureHtml;
import miso.distil.pictureServices.Picture;

/**
 * Auto-generated html methods.
 * 
 * @author miso.distil.codeGenerator.
 */
public class HtmlPictureJson implements HtmlInterfaceJson {

	private PictureJson Json = new PictureJson();
	private HtmlPictureView View = new HtmlPictureView();
	private HtmlInterfaceView<Picture> customView;

	/**
	 * Auto-generated empty constructor. To use auto-generated HtmlPictureView.
	 */
	public HtmlPictureJson() {
		customView = View;
	}

	/**
	 * Auto-generated constructor with a custom view.
	 * 
	 * @param View Custom View.
	 */
	public HtmlPictureJson(CustomPictureHtml View) {
		customView = View;
	}

	/**
	 * Auto-generated method to read the information from an artifact.
	 * 
	 * @param req Spark request.
	 * @param res Spark response.
	 * @return special structure for SPARK.
	 */
	@Override
	public ModelAndView getRead(Request req, Response res) {
		Map<String, Object> viewObjects = new HashMap<String, Object>();

		Picture picture = (Picture) Json.getRead(req, res);
		if(picture == null) {
			viewObjects.put(HtmlFreeMarker.ERROR, "Picture not found in data base");
		} else {
			viewObjects.put(HtmlFreeMarker.ENTRIES, customView.constructInfoReadOne(picture));
		}
		viewObjects.put(HtmlFreeMarker.TEMPLATE, HtmlFreeMarker.READ_HTML);

		return HtmlFreeMarker.closeHtml(viewObjects);
	}

	/**
	 * Auto-generated method to read the information from an artifact's list.
	 * 
	 * @param req Spark request.
	 * @param res Spark response.
	 * @return special structure for SPARK.
	 */
	@Override
	public ModelAndView getReadAll(Request req, Response res) {
		Map<String, Object> viewObjects = new HashMap<String, Object>();

		ArrayList<Picture> pictures = new ArrayList<Picture>();
		pictures.addAll(Json.getReadAll(req, res));
		viewObjects.put(HtmlFreeMarker.MULTI_ENTRIES, customView.constructInfoReadAll(pictures));
		viewObjects.put(HtmlFreeMarker.COUNT, pictures.size());
		viewObjects.put(HtmlFreeMarker.TEMPLATE, HtmlFreeMarker.LIST_HTML);

		return HtmlFreeMarker.closeHtml(viewObjects);
	}

	/**
	 * Auto-generated method to construct the search form.
	 * 
	 * @return special structure for SPARK.
	 */
	@Override
	public ModelAndView getSearchForm() {
		Map<String, Object> viewObjects = new HashMap<String, Object>();
		viewObjects = View.constructSearchForm();
		viewObjects.put(HtmlFreeMarker.TEMPLATE, HtmlFreeMarker.FORM_HTML); 
	
		return HtmlFreeMarker.closeHtml(viewObjects);
	}

	/**
	 * Auto-generated method to read the information from the result list of a search.
	 * 
	 * @param req Spark request.
	 * @param res Spark response.
	 * @return special structure for SPARK.
	 */
	@Override
	public ModelAndView getSearch(Request req, Response res) {	
		Map<String, Object> viewObjects = new HashMap<String, Object>();

		ArrayList<Picture> pictures = new ArrayList<Picture>();
		pictures.addAll(Json.getSearch(req, res));
		if(pictures.isEmpty()) {
			viewObjects = View.constructSearchForm();
			viewObjects.put(HtmlFreeMarker.TEMPLATE, HtmlFreeMarker.FORM_HTML); 
			viewObjects.put(HtmlFreeMarker.EMPTY, "Picture not found in data base");
			viewObjects.put(HtmlFreeMarker.SYNONYMS_VALUES, Utils.listToString(Json.getSynonymsValue(req, res)));
		} else {	
			viewObjects = new HashMap<String, Object>();
			viewObjects.put(HtmlFreeMarker.MULTI_ENTRIES, customView.constructInfoReadAll(pictures));
			viewObjects.put(HtmlFreeMarker.COUNT, pictures.size());
			viewObjects.put(HtmlFreeMarker.SYNONYMS_VALUES, Utils.listToString(Json.getSynonymsValue(req, res)));
			viewObjects.put(HtmlFreeMarker.TEMPLATE, HtmlFreeMarker.LIST_HTML);
		}

		return HtmlFreeMarker.closeHtml(viewObjects);
	}

	/**
	 * Auto-generated method to construct the upload form.
	 * 
	 * @param req Spark request.
	 * @param res Spark response.
	 * @return special structure for SPARK.
	 */
	@Override
	public ModelAndView getUploadForm(Request req, Response res) {
		Map<String, Object> viewObjects = new HashMap<String, Object>();
		viewObjects = customView.constructUploadForm();
		viewObjects.put(HtmlFreeMarker.TEMPLATE, HtmlFreeMarker.FORM_HTML); 

		return HtmlFreeMarker.closeHtml(viewObjects);
	}

}
