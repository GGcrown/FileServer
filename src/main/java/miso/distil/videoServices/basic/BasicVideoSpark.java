package miso.distil.videoServices.basic;

import static spark.Spark.post;
import static spark.Spark.get;

import miso.distil.videoServices.VideoJson;

import miso.carrascal.cloudModelServices.abstractServices.basic.JsonTransformer;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicInterfaceSpark;

/**
 * Auto-generated spark server.
 * 
 * @author miso.distil.codeGenerator.
 */
public final class BasicVideoSpark implements BasicInterfaceSpark {

	// URL's
	public static String ReadJson = "/json/video/read/";
	public static String ReadIdJson = ReadJson + BasicVideoParam.IdGet;
	public static String ReadAllJson = "/json/video/all";
	public static String SearchJson = "/json/video/search";
	public static String UploadJson = "/json/video/upload";
	public static String DeleteJson = "/json/video/delete";
	public static String DownloadJson = "/json/video/download/zip/";
	public static String DownloadIdJson = DownloadJson + BasicVideoParam.IdGet;

	/**
	 * Auto-generated spark service. It initializes all url's.
	 */
	@Override
	public void runService() {

		VideoJson Json = new VideoJson();

		get(ReadIdJson, "application/json",
			(request, response) -> {
				Object obj = Json.getRead(request, response);
				response.body((new JsonTransformer()).render(obj));
				return obj;
			}, new JsonTransformer());

		get(ReadAllJson, "application/json",
			(request, response) -> {
				Object obj = Json.getReadAll(request, response);
				response.body((new JsonTransformer()).render(obj));
				return obj;
			}, new JsonTransformer());

		get(SearchJson, "application/json",
			(request, response) -> {
				Object obj = Json.getSearch(request, response);
				response.body((new JsonTransformer()).render(obj));
				return obj;
			}, new JsonTransformer());

		post(UploadJson, "application/json",
			(request, response) -> {
				Object obj = Json.postUpload(request, response);
				response.body((new JsonTransformer()).render(obj));
				return obj;
			}, new JsonTransformer());

		post(DeleteJson, "application/json",
			(request, response) -> {
				Object obj = Json.postDelete(request, response);
				response.body((new JsonTransformer()).render(obj));
				return obj;
			}, new JsonTransformer());

		get(DownloadIdJson, "application/json",
			(request, response) -> {
				Object obj = Json.getDownload(request, response);
				response.body((new JsonTransformer()).render(obj));
				return obj;
			}, new JsonTransformer());
	}
}
