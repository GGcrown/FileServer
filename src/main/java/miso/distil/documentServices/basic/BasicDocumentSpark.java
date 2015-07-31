package miso.distil.documentServices.basic;

import static spark.Spark.post;
import static spark.Spark.get;

import miso.distil.documentServices.DocumentJson;

import miso.carrascal.cloudModelServices.abstractServices.basic.JsonTransformer;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicInterfaceSpark;

/**
 * Auto-generated spark server.
 * 
 * @author miso.distil.codeGenerator.
 */
public final class BasicDocumentSpark implements BasicInterfaceSpark {

	// URL's
	public static String ReadJson = "/json/document/read/";
	public static String ReadIdJson = ReadJson + BasicDocumentParam.IdGet;
	public static String ReadAllJson = "/json/document/all";
	public static String SearchJson = "/json/document/search";
	public static String UpdateJson = "/json/document/update";
	public static String UploadJson = "/json/document/upload";
	public static String DeleteJson = "/json/document/delete";
	public static String DownloadJson = "/json/document/download/zip/";
	public static String DownloadIdJson = DownloadJson + BasicDocumentParam.IdGet;

	/**
	 * Auto-generated spark service. It initializes all url's.
	 */
	@Override
	public void runService() {

		DocumentJson Json = new DocumentJson();

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

		post(UpdateJson, "application/json",
			(request, response) -> {
				Object obj = Json.postUpdate(request, response);
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
