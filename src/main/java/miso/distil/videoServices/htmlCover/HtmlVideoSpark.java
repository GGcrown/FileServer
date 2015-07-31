package miso.distil.videoServices.htmlCover;

import static spark.Spark.get;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.List;

import miso.carrascal.cloudModelServices.abstractServices.basic.BasicInterfaceSpark;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlFreeMarker;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.htmlObjects.HtmlSelectBox;

import miso.distil.videoServices.basic.BasicVideoParam;
import miso.distil.videoServices.CustomVideoHtml;
import miso.distil.videoServices.htmlCover.HtmlVideoJson;

/**
 * Auto-generated html spark server.
 * 
 * @author miso.distil.codeGenerator.
 */
public final class HtmlVideoSpark implements BasicInterfaceSpark {

	/**
	 * Read html url.
	 */
	public static String ReadHTML = "/html/video/read/";
	/**
	 * Read html with id url.
	 */
	public static String ReadIdHTML = ReadHTML + BasicVideoParam.IdGet;
	/**
	 * Read all html url.
	 */
	public static String ReadAllHTML = "/html/video/all";
	/**
	 * Search html url.
	 */
	public static String SearchHTML = "/html/video/search";
	/**
	 * Get search form html url.
	 */
	public static String SearchFormHTML = "/html/video/search/form";
	/**
	 * Get upload form html url.
	 */
	public static String UploadFormHTML = "/html/video/upload";

	/**
	 * Auto-generated html spark service. It initializes all html url's.
	 */
	@Override
	public void runService() {

		HtmlVideoJson HTML = new HtmlVideoJson();

		get(ReadIdHTML,
			(request, response) -> HTML.getRead(request, response), 
			new FreeMarkerEngine());

		get(ReadAllHTML,
			(request, response) -> HTML.getReadAll(request, response),
			new FreeMarkerEngine());

		get(SearchFormHTML,
			(request, response) -> HTML.getSearchForm(), 
			new FreeMarkerEngine());

		get(SearchHTML,
			(request, response) -> HTML.getSearch(request, response), 
			new FreeMarkerEngine());

		get(UploadFormHTML,
			(request, response) -> HTML.getUploadForm(request, response),
			new FreeMarkerEngine());

		this.addLayout();
	}

	/**
	 * Auto-generated layout service. It add's to the html layout some permanents links.
	 */
	private void addLayout() {
		List<HtmlSelectBox> layouts = new ArrayList<HtmlSelectBox>();
		layouts.add(new HtmlSelectBox("Read all videos" , ReadAllHTML));
		layouts.add(new HtmlSelectBox("Upload video" , UploadFormHTML));
		layouts.add(new HtmlSelectBox("Search video" , SearchFormHTML));
		HtmlFreeMarker.addLayout("Video", layouts);
	}

	/**
	 * HtmlVideoJson with CustomVideoHtml to overwrite html services.
	 */
	private static HtmlVideoJson HTML = new HtmlVideoJson(new CustomVideoHtml());

	/**
	 * Auto-generated method to overwrite the information from an artifact.
	 */
	public static void overWriteInfoReadOne() {
		get(ReadIdHTML,
			(request, response) -> HTML.getRead(request, response), 
			new FreeMarkerEngine());
	}

	/**
	 * Auto-generated method to overwrite the information from an artifact's list.
	 */
	public static void overWriteInfoReadAll() {
		get(ReadAllHTML,
			(request, response) -> HTML.getReadAll(request, response), 
			new FreeMarkerEngine());

		get(SearchHTML,
			(request, response) -> HTML.getSearch(request, response), 
			new FreeMarkerEngine());
	}

	/**
	 * Auto-generated method to overwrite the search form.
	 */
	public static void overWriteSearchForm() {
		get(SearchFormHTML,
			(request, response) -> HTML.getSearchForm(), 
			new FreeMarkerEngine());
	}

	/**
	 * Auto-generated method to overwrite the upload form.
	 */
	public static void overWriteUploadForm() {
		get(UploadFormHTML,
			(request, response) -> HTML.getUploadForm(request, response), 
			new FreeMarkerEngine());
	}
}
