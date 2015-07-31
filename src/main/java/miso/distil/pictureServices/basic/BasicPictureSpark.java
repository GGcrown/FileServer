package miso.distil.pictureServices.basic;

import static spark.Spark.post;
import static spark.Spark.get;

import miso.distil.pictureServices.PictureJson;

import miso.carrascal.cloudModelServices.abstractServices.basic.JsonTransformer;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicInterfaceSpark;

/**
 * Auto-generated spark server.
 * 
 * @author miso.distil.codeGenerator.
 */
public final class BasicPictureSpark implements BasicInterfaceSpark {

	// URL's
	public static String ReadJson = "/json/picture/read/";
	public static String ReadIdJson = ReadJson + BasicPictureParam.IdGet;
	public static String ReadAllJson = "/json/picture/all";
	public static String SearchJson = "/json/picture/search";
	public static String UploadJson = "/json/picture/upload";
	public static String DeleteJson = "/json/picture/delete";
	public static String DownloadJson = "/json/picture/download/zip/";
	public static String DownloadIdJson = DownloadJson + BasicPictureParam.IdGet;

	/**
	 * Auto-generated spark service. It initializes all url's.
	 */
	@Override
	public void runService() {

		PictureJson Json = new PictureJson();

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
