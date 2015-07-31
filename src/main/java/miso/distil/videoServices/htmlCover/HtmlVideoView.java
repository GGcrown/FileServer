package miso.distil.videoServices.htmlCover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlInterfaceView;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlFreeMarker;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.htmlObjects.*;
import miso.carrascal.cloudModelServices.utils.Utils;

import miso.distil.videoServices.basic.BasicVideoParam;
import miso.distil.videoServices.basic.BasicVideoSpark;
import miso.distil.videoServices.Video;

/**
 * Auto-generated html view methods.
 * 
 * @author miso.distil.codeGenerator.
 */
public class HtmlVideoView implements HtmlInterfaceView<Video>{

	/**
	 * Auto-generated method to construct the information from an artifact.
	 * 
	 * @param video Video to read.
	 * @return list with entries to show in html.
	 */
	@Override
	public List<HtmlEntry> constructInfoReadOne(Video video) {
		List<HtmlEntry> entries = new ArrayList<HtmlEntry>();
		entries.add(new HtmlEntry(video.getFilename(), EntrySize.H3));
		entries.add(new HtmlEntry(video.getCreatedatString(), EntrySize.H4));
		entries.add(new HtmlEntry("FileSize (bytes): " + video.getFilesize().toString(), EntrySize.H4));
		entries.add(new HtmlEntry("ObjectId : " + video.getObjectid().toString(), EntrySize.H4));
		entries.add(new HtmlEntry("videoinfo.author : " + video.getVideoinfo().getAuthor(), EntrySize.H5));
		entries.add(new HtmlEntry("videoinfo.source : " + video.getVideoinfo().getSource(), EntrySize.H5));
		entries.add(new HtmlEntry("videoinfo.tags : " + Utils.listToString(video.getVideoinfo().getTags()), EntrySize.H5));				
		entries.add(new HtmlEntry("videoinfo.fileextension : " + video.getVideoinfo().getFileextension(), EntrySize.H5));
		entries.add(new HtmlEntry("length : " + video.getLength().toString(), EntrySize.H5));
		entries.add(new HtmlEntry(HtmlVideoLinks.getDownloadJsonLink(video), EntrySize.H5));
		entries.add(new HtmlEntry(HtmlVideoLinks.getDeleteFormJsonLink(video), EntrySize.H5));

		return entries;
	}

	/**
	 * Auto-generated method to construct the information from an artifact's list.
	 * 
	 * @param videos list of Video to read.
	 * @return list with lists of entries to show in html.
	 */
	@Override
	public List<List<HtmlEntry>> constructInfoReadAll(List<Video> videos) {
		List<List<HtmlEntry>> multientries = new ArrayList<List<HtmlEntry>>();
			for(Video video : videos) {
				List<HtmlEntry> entries = new ArrayList<HtmlEntry>();
				entries.add(new HtmlEntry(HtmlVideoLinks.getReadHtmlLink(video), EntrySize.H3));
				entries.add(new HtmlEntry(video.getCreatedatString(), EntrySize.H4));
				entries.add(new HtmlEntry(HtmlVideoLinks.getReadJsonLink(video), EntrySize.H5));
				entries.add(new HtmlEntry(HtmlVideoLinks.getDeleteFormJsonLink(video), EntrySize.H5));
				multientries.add(entries);
			}

		return multientries;
	}

	/**
	 * Auto-generated method to construct the search form.
	 * 
	 * @return special map of SPARK to show objects in HTML.
	 */
	@Override
	public Map<String, Object> constructSearchForm() {
		Map<String, Object> viewObjects = new HashMap<String, Object>();

		HtmlForm form = new HtmlForm(HtmlVideoSpark.SearchHTML, "video-search-form", HtmlFreeMarker.ENCTYPE_DEFAULT, "Search", "GET");
		viewObjects.put(HtmlFreeMarker.FORM, form);
		
		Map<String, List<HtmlSelectBox>> selectbox = new HashMap<String, List<HtmlSelectBox>>();
		List<HtmlSelectBox> boxes = new ArrayList<HtmlSelectBox>();
		boxes.add(new HtmlSelectBox("videoinfo.author", "videoinfo.author"));
		boxes.add(new HtmlSelectBox("videoinfo.source", "videoinfo.source"));
		boxes.add(new HtmlSelectBox("videoinfo.tags", "videoinfo.tags"));
		boxes.add(new HtmlSelectBox("videoinfo.fileextension", "videoinfo.fileextension"));
		boxes.add(new HtmlSelectBox("length", "length"));
		selectbox.put(BasicVideoParam.Search_query, boxes);
		viewObjects.put(HtmlFreeMarker.SELECTBOX, selectbox);

		List<HtmlText> texts = new ArrayList<HtmlText>();
		texts.add(new HtmlText(BasicVideoParam.Search_value, "", "Value", "search", "Enter what do you want to search"));
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		radios.add(new HtmlRadio(BasicVideoParam.Search_synonyms, "Synonyms", "synonyms", true));
		viewObjects.put(HtmlFreeMarker.RADIOS, radios);

		return viewObjects;
	}

	/**
	 * Auto-generated method to construct the upload form.
	 * 
	 * @return special map of SPARK to show objects in HTML.
	 */
	@Override
	public Map<String, Object> constructUploadForm() {
		Map<String, Object> viewObjects = new HashMap<String, Object>();

		HtmlForm form = new HtmlForm(BasicVideoSpark.UploadJson, "video-upload-form", HtmlFreeMarker.ENCTYPE_FILE, "Upload", "POST");
		viewObjects.put(HtmlFreeMarker.FORM, form);

		List<HtmlText> texts = new ArrayList<HtmlText>();
		texts.add(new HtmlText(BasicVideoParam.Author_videoinfo, "", "videoinfo.author", "author", "Enter valid String"));
		texts.add(new HtmlText(BasicVideoParam.Source_videoinfo, "", "videoinfo.source", "source", "Enter valid String"));
		texts.add(new HtmlText(BasicVideoParam.Tags_videoinfo, "", "videoinfo.tags (tags1,tags2,...)", "tags", "Enter new list of valid String"));
		texts.add(new HtmlText(BasicVideoParam.Length, "", "length", "length", "Enter valid Double"));
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		viewObjects.put(HtmlFreeMarker.RADIOS, radios);

		List<HtmlFile> file = new ArrayList<HtmlFile>();
		file.add(new HtmlFile(BasicVideoParam.File, "Choose your video", "file"));
		viewObjects.put(HtmlFreeMarker.FILE, file);

		return viewObjects;
	}
}
