package miso.distil.pictureServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlInterfaceView;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlFreeMarker;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.htmlObjects.*;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicInterfaceSpark;
import miso.distil.pictureServices.basic.BasicPictureParam;
import miso.distil.pictureServices.basic.BasicPictureSpark;
import miso.distil.pictureServices.htmlCover.HtmlPictureSpark;
import miso.distil.pictureServices.Picture;

/**
 * Auto-generated custom html spark server.
 * 
 * @author miso.distil.codeGenerator.
 */
public class CustomPictureHtml implements HtmlInterfaceView<Picture>, BasicInterfaceSpark
{
	/**
	 * Auto-generated custom spark service. It overwrites some html URL's.
	 */
	@Override
	public void runService() {

		// To overwrite the default constructions of HTML
		// Be careful: you need to modify the method previously
		// HtmlPictureSpark.overWriteInfoReadOne();
		// HtmlPictureSpark.overWriteInfoReadAll();
		// HtmlPictureSpark.overWriteSearchForm();
		// HtmlPictureSpark.overWriteUploadForm();
	}

	/**
	 * Auto-generated method to customice the information from an artifact.
	 * 
	 * @param picture Picture to read.
	 * @return list with entries to show in html.
	 */
	@Override
	public List<HtmlEntry> constructInfoReadOne(Picture picture) {
		List<HtmlEntry> entries = new ArrayList<HtmlEntry>();
			// Add the information you want, line per line
			entries.add(new HtmlEntry(picture.getFilename(), EntrySize.H3));
			// ..
		return entries;
	}

	/**
	 * Auto-generated method to customice the information from an artifact's list.
	 * 
	 * @param pictures list of Picture to read.
	 * @return list with lists of entries to show in html.
	 */
	@Override
	public List<List<HtmlEntry>> constructInfoReadAll(List<Picture> pictures) {
		List<List<HtmlEntry>> multientries = new ArrayList<List<HtmlEntry>>();
		// Add the information you want, line per line, from various Pictures
		for(Picture picture : pictures) {
			List<HtmlEntry> entries = new ArrayList<HtmlEntry>();
			entries.add(new HtmlEntry(picture.getFilename(), EntrySize.H4));
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
		HtmlForm form = new HtmlForm(HtmlPictureSpark.SearchHTML, "picture-search-form", HtmlFreeMarker.ENCTYPE_DEFAULT, "Search", "GET");
		viewObjects.put(HtmlFreeMarker.FORM, form);

		// Then, whatever you want in your Form: SelectBox, Text, Radio, Hidden, File
		Map<String, List<HtmlSelectBox>> selectbox = new HashMap<String, List<HtmlSelectBox>>();
		List<HtmlSelectBox> boxes = new ArrayList<HtmlSelectBox>();
		boxes.add(new HtmlSelectBox("Option 1", "Option1"));
		boxes.add(new HtmlSelectBox("Option 2", "Option2"));
		// ...
		selectbox.put(BasicPictureParam.Search_query, boxes);
		// ...
		viewObjects.put(HtmlFreeMarker.SELECTBOX, selectbox);
							
		List<HtmlText> texts = new ArrayList<HtmlText>();
		texts.add(new HtmlText(BasicPictureParam.Search_value, "", "Search (value)", "search", "Enter what do you want to search"));
		// ..
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		radios.add(new HtmlRadio(BasicPictureParam.Search_synonyms, "Synonyms", "synonyms", true));
		// ..
		viewObjects.put(HtmlFreeMarker.RADIOS, radios);

		// ..

		return viewObjects;
	}

	@Override
	public Map<String, Object> constructUploadForm() { 
		Map<String, Object> viewObjects = new HashMap<String, Object>();

		// You need to add first a Form
		HtmlForm form = new HtmlForm(BasicPictureSpark.UploadJson, "picture-upload-form", HtmlFreeMarker.ENCTYPE_DEFAULT, "Upload", "POST");
		viewObjects.put(HtmlFreeMarker.FORM, form);

		// Then, whatever you want in your Form: Text, Radio, Hidden, File
		List<HtmlText> texts = new ArrayList<HtmlText>();
		// texts.add(new HtmlText(BasicPictureParam.T, "", "T (t1,t2,t3,...)", "t", "Enter new t"));
		// ..
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		// List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		// radios.add(new HtmlRadio(BasicPictureParam.Bool, "Bool", "bool", true));
		// ..
		// viewObjects.put(HtmlFreeMarker.RADIOS, radios);

		List<HtmlHidden> hiddens = new ArrayList<HtmlHidden>();
		hiddens.add(new HtmlHidden(BasicPictureParam.IdPost, "This is a secret!"));
		// ..
		viewObjects.put(HtmlFreeMarker.HIDDENS, hiddens);

		List<HtmlFile> file = new ArrayList<HtmlFile>();
		file.add(new HtmlFile(BasicPictureParam.File, "Choose your picture", "file"));
		// ..
		viewObjects.put(HtmlFreeMarker.FILE, file);

		return viewObjects;
	}
}
