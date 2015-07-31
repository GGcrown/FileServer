package miso.distil.services;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


import static spark.Spark.post;
import static spark.Spark.after;

import com.google.gson.JsonSyntaxException;

import miso.carrascal.cloudModelServices.abstractServices.basic.JsonTransformer;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicInterfaceSpark;
import miso.carrascal.cloudModelServices.abstractServices.Persistent;
import miso.carrascal.cloudModelServices.abstractServices.RecordDB;

import miso.distil.pictureServices.basic.BasicPictureParam;
import miso.distil.pictureServices.basic.BasicPictureSpark;
import miso.distil.pictureServices.Picture;
import miso.distil.documentServices.basic.BasicDocumentParam;
import miso.distil.documentServices.basic.BasicDocumentSpark;
import miso.distil.documentServices.Document;
import miso.distil.videoServices.basic.BasicVideoParam;
import miso.distil.videoServices.basic.BasicVideoSpark;
import miso.distil.videoServices.Video;

/**
 * Auto-generated services spark server
 * 
 * @author miso.distil.codeGenerator
 */
public final class ServicesSpark implements BasicInterfaceSpark {

	// URL's
	public static String DownloadAuthorUrl = "/service/downloadauthor/";
	public static String SimilarPicturesUrl = "/service/similarpictures/";
	public static String StatisticsPicUrl = "/service/statisticspic/";
	public static String ComparePicturesUrl = "/service/comparepictures/";
	public static String AnalyseUrl = "/service/analyse/";
	public static String StatisticsDocUrl = "/service/statisticsdoc/";
	public static String DownloadAsTxtUrl = "/service/downloadastxt/";

	/**
	 * Auto-generated services spark service. It initializes all services url's
	 * 
	 * @author miso.distil.codeGenerator
	 */
	@Override
	public void runService() {

		ServiceDownloadAuthor serviceDownloadAuthor = new ServiceDownloadAuthor();
		post(DownloadAuthorUrl, "application/json",
			(request, response) -> {
				return serviceDownloadAuthor.runService(request, response, new ArrayList<Persistent>());
			}, new JsonTransformer());


		ServiceSimilarPictures serviceSimilarPictures = new ServiceSimilarPictures();
		post(SimilarPicturesUrl, "application/json",
			(request, response) -> {
				return serviceSimilarPictures.runService(request, response, new ArrayList<Persistent>());
			}, new JsonTransformer());


		ServiceStatisticsPic serviceStatisticsPic = new ServiceStatisticsPic();
		post(StatisticsPicUrl, "application/json",
			(request, response) -> {
				return serviceStatisticsPic.runService(request, response, new ArrayList<Persistent>());
			}, new JsonTransformer());


		ServiceComparePictures serviceComparePictures = new ServiceComparePictures();
		post(ComparePicturesUrl, "application/json",
			(request, response) -> {
				return serviceComparePictures.runService(request, response, new ArrayList<Persistent>());
			}, new JsonTransformer());


		ServiceAnalyse serviceAnalyse = new ServiceAnalyse();
		post(AnalyseUrl, "application/json",
			(request, response) -> {
				return serviceAnalyse.runService(request, response, new ArrayList<Persistent>());
			}, new JsonTransformer());


		ServiceStatisticsDoc serviceStatisticsDoc = new ServiceStatisticsDoc();
		post(StatisticsDocUrl, "application/json",
			(request, response) -> {
				return serviceStatisticsDoc.runService(request, response, new ArrayList<Persistent>());
			}, new JsonTransformer());


		ServiceDownloadAsTxt serviceDownloadAsTxt = new ServiceDownloadAsTxt();
		post(DownloadAsTxtUrl, "application/json",
			(request, response) -> {
				return serviceDownloadAsTxt.runService(request, response, new ArrayList<Persistent>());
			}, new JsonTransformer());


		after(BasicPictureSpark.DownloadIdJson, "application/json",
				(request, response) -> {
					String id = request.params(BasicPictureParam.IdGet);
					Picture artifact = RecordDB.getDefault().readOne(id, Picture.class);
					List<Picture> list = new ArrayList<Picture>();
					list.add(artifact);
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("Download", artifact);
					map.put("DownloadAuthor", serviceDownloadAuthor.runService(request, response, list));
					response.body((new JsonTransformer()).render(map));
				});

		after(BasicPictureSpark.UploadJson, "application/json",
				(request, response) -> {
					try {
						Picture artifact = JsonTransformer.fromJson(response.body(), Picture.class);
						List<Picture> list = new ArrayList<Picture>();
						list.add(artifact);
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("Update", artifact);
						map.put("SimilarPictures", serviceSimilarPictures.runService(request, response, list));
						response.body((new JsonTransformer()).render(map));
					} catch (JsonSyntaxException e) {
						e.printStackTrace();
					}
				});

		after(BasicDocumentSpark.DownloadIdJson, "application/json",
				(request, response) -> {
					String id = request.params(BasicDocumentParam.IdGet);
					Document artifact = RecordDB.getDefault().readOne(id, Document.class);
					List<Document> list = new ArrayList<Document>();
					list.add(artifact);
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("Download", artifact);
					map.put("DownloadAuthor", serviceDownloadAuthor.runService(request, response, list));
					response.body((new JsonTransformer()).render(map));
				});

		after(BasicDocumentSpark.UploadJson, "application/json",
				(request, response) -> {
					try {
						Document artifact = JsonTransformer.fromJson(response.body(), Document.class);
						List<Document> list = new ArrayList<Document>();
						list.add(artifact);
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("Update", artifact);
						map.put("Analyse", serviceAnalyse.runService(request, response, list));
						response.body((new JsonTransformer()).render(map));
					} catch (JsonSyntaxException e) {
						e.printStackTrace();
					}
				});

		after(BasicVideoSpark.DownloadIdJson, "application/json",
				(request, response) -> {
					String id = request.params(BasicVideoParam.IdGet);
					Video artifact = RecordDB.getDefault().readOne(id, Video.class);
					List<Video> list = new ArrayList<Video>();
					list.add(artifact);
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("Download", artifact);
					map.put("DownloadAuthor", serviceDownloadAuthor.runService(request, response, list));
					response.body((new JsonTransformer()).render(map));
				});
	}
}
