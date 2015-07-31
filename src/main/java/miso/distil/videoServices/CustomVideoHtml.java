package miso.distil.videoServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlInterfaceView;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlFreeMarker;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.htmlObjects.*;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicInterfaceSpark;

import miso.distil.videoServices.basic.BasicVideoParam;
import miso.distil.videoServices.basic.BasicVideoSpark;
import miso.distil.videoServices.htmlCover.HtmlVideoSpark;
import miso.distil.videoServices.Video;

/**
 * Auto-generated custom html spark server.
 * 
 * @author miso.distil.codeGenerator.
 */
public class CustomVideoHtml implements HtmlInterfaceView<Video>, BasicInterfaceSpark
{
	/**
	 * Auto-generated custom spark service. It overwrites some html URL's.
	 */
	@Override
	public void runService() {

		// To overwrite the default constructions of HTML
		// Be careful: you need to modify the method previously
		// HtmlVideoSpark.overWriteInfoReadOne();
		// HtmlVideoSpark.overWriteInfoReadAll();
		// HtmlVideoSpark.overWriteSearchForm();
		// HtmlVideoSpark.overWriteUploadForm();
	}

	/**
	 * Auto-generated method to customice the information from an artifact.
	 * 
	 * @param video Video to read.
	 * @return list with entries to show in html.
	 */
	@Override
	public List<HtmlEntry> constructInfoReadOne(Video video) {
		List<HtmlEntry> entries = new ArrayList<HtmlEntry>();
			// Add the information you want, line per line
			entries.add(new HtmlEntry(video.getFilename(), EntrySize.H3));
			// ..
		return entries;
	}

	/**
	 * Auto-generated method to customice the information from an artifact's list.
	 * 
	 * @param videos list of Video to read.
	 * @return list with lists of entries to show in html.
	 */
	@Override
	public List<List<HtmlEntry>> constructInfoReadAll(List<Video> videos) {
		List<List<HtmlEntry>> multientries = new ArrayList<List<HtmlEntry>>();
		// Add the information you want, line per line, from various Videos
		for(Video video : videos) {
			List<HtmlEntry> entries = new ArrayList<HtmlEntry>();
			entries.add(new HtmlEntry(video.getFilename(), EntrySize.H4));
			// ..
			multientries.add(entries);
		}
		return multientries;
	}

	/**
	 * Auto-generated method to customice the search form
	 * 
	 * @return special map of SPARK to show objects in HTML.
	 */
	@Override
	public Map<String, Object> constructSearchForm() {
		Map<String, Object> viewObjects = new HashMap<String, Object>();

		// You need to add first a Form
		HtmlForm form = new HtmlForm(HtmlVideoSpark.SearchHTML, "video-search-form", HtmlFreeMarker.ENCTYPE_DEFAULT, "Search", "GET");
		viewObjects.put(HtmlFreeMarker.FORM, form);

		// Then, whatever you want in your Form: SelectBox, Text, Radio, Hidden, File
		Map<String, List<HtmlSelectBox>> selectbox = new HashMap<String, List<HtmlSelectBox>>();
		List<HtmlSelectBox> boxes = new ArrayList<HtmlSelectBox>();
		boxes.add(new HtmlSelectBox("Option 1", "Option1"));
		boxes.add(new HtmlSelectBox("Option 2", "Option2"));
		// ...
		selectbox.put(BasicVideoParam.Search_query, boxes);
		// ...
		viewObjects.put(HtmlFreeMarker.SELECTBOX, selectbox);
							
		List<HtmlText> texts = new ArrayList<HtmlText>();
		texts.add(new HtmlText(BasicVideoParam.Search_value, "", "Search (value)", "search", "Enter what do you want to search"));
		// ..
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		radios.add(new HtmlRadio(BasicVideoParam.Search_synonyms, "Synonyms", "synonyms", true));
		// ..
		viewObjects.put(HtmlFreeMarker.RADIOS, radios);

		// ..

		return viewObjects;
	}

	/**
	 * Auto-generated method to customice the upload form
	 * 
	 * @return special map of SPARK to show objects in HTML.
	 */
	@Override
	public Map<String, Object> constructUploadForm() {
		Map<String, Object> viewObjects = new HashMap<String, Object>();

		// You need to add first a Form
		HtmlForm form = new HtmlForm(BasicVideoSpark.UploadJson, "video-upload-form", HtmlFreeMarker.ENCTYPE_DEFAULT, "Upload", "POST");
		viewObjects.put(HtmlFreeMarker.FORM, form);

		// Then, whatever you want in your Form: Text, Radio, Hidden, File
		List<HtmlText> texts = new ArrayList<HtmlText>();
		// texts.add(new HtmlText(BasicVideoParam.T, "", "T (t1,t2,t3,...)", "t", "Enter new t"));
		// ..
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		// List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		// radios.add(new HtmlRadio(BasicVideoParam.Bool, "Bool", "bool", true));
		// ..
		// viewObjects.put(HtmlFreeMarker.RADIOS, radios);

		List<HtmlHidden> hiddens = new ArrayList<HtmlHidden>();
		hiddens.add(new HtmlHidden(BasicVideoParam.IdPost, "This is a secret!"));
		// ..
		viewObjects.put(HtmlFreeMarker.HIDDENS, hiddens);

		List<HtmlFile> file = new ArrayList<HtmlFile>();
		file.add(new HtmlFile(BasicVideoParam.File, "Choose your video", "file"));
		// ..
		viewObjects.put(HtmlFreeMarker.FILE, file);

		return viewObjects;
	}
}
