package miso.distil.documentServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlInterfaceView;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlFreeMarker;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.htmlObjects.*;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicInterfaceSpark;

import miso.distil.documentServices.basic.BasicDocumentParam;
import miso.distil.documentServices.basic.BasicDocumentSpark;
import miso.distil.documentServices.htmlCover.HtmlDocumentSpark;
import miso.distil.documentServices.Document;

/**
 * Auto-generated custom html spark server.
 * 
 * @author miso.distil.codeGenerator.
 */
public class CustomDocumentHtml implements HtmlInterfaceView<Document>, BasicInterfaceSpark
{
	/**
	 * Auto-generated custom spark service. It overwrites some html URL's.
	 */
	@Override
	public void runService() {

		// To overwrite the default constructions of HTML
		// Be careful: you need to modify the method previously
		// HtmlDocumentSpark.overWriteInfoReadOne();
		// HtmlDocumentSpark.overWriteInfoReadAll();
		// HtmlDocumentSpark.overWriteSearchForm();
		// HtmlDocumentSpark.overWriteUpdateForm();
		// HtmlDocumentSpark.overWriteUploadForm();
	}

	/**
	 * Auto-generated method to customice the information from an artifact.
	 * 
	 * @param document Document to read.
	 * @return list with entries to show in html.
	 */
	@Override
	public List<HtmlEntry> constructInfoReadOne(Document document) {
		List<HtmlEntry> entries = new ArrayList<HtmlEntry>();
			// Add the information you want, line per line
			entries.add(new HtmlEntry(document.getFilename(), EntrySize.H3));
			// ..
		return entries;
	}

	/**
	 * Auto-generated method to customice the information from an artifact's list.
	 * 
	 * @param documents list of Document to read.
	 * @return list with lists of entries to show in html.
	 */
	@Override
	public List<List<HtmlEntry>> constructInfoReadAll(List<Document> documents) {
		List<List<HtmlEntry>> multientries = new ArrayList<List<HtmlEntry>>();
		// Add the information you want, line per line, from various Documents
		for(Document document : documents) {
			List<HtmlEntry> entries = new ArrayList<HtmlEntry>();
			entries.add(new HtmlEntry(document.getFilename(), EntrySize.H4));
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
		HtmlForm form = new HtmlForm(HtmlDocumentSpark.SearchHTML, "document-search-form", HtmlFreeMarker.ENCTYPE_DEFAULT, "Search", "GET");
		viewObjects.put(HtmlFreeMarker.FORM, form);

		// Then, whatever you want in your Form: SelectBox, Text, Radio, Hidden, File
		Map<String, List<HtmlSelectBox>> selectbox = new HashMap<String, List<HtmlSelectBox>>();
		List<HtmlSelectBox> boxes = new ArrayList<HtmlSelectBox>();
		boxes.add(new HtmlSelectBox("Option 1", "Option1"));
		boxes.add(new HtmlSelectBox("Option 2", "Option2"));
		// ...
		selectbox.put(BasicDocumentParam.Search_query, boxes);
		// ...
		viewObjects.put(HtmlFreeMarker.SELECTBOX, selectbox);
							
		List<HtmlText> texts = new ArrayList<HtmlText>();
		texts.add(new HtmlText(BasicDocumentParam.Search_value, "", "Search (value)", "search", "Enter what do you want to search"));
		// ..
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		radios.add(new HtmlRadio(BasicDocumentParam.Search_synonyms, "Synonyms", "synonyms", true));
		// ..
		viewObjects.put(HtmlFreeMarker.RADIOS, radios);

		// ..

		return viewObjects;
	}

	/**
	 * Auto-generated method to customice the update form
	 * 
	 * @param document Document to update.
	 * @return special map of SPARK to show objects in HTML.
	 */
	@Override
	public Map<String, Object> constructUpdateForm(Document document) {
		Map<String, Object> viewObjects = new HashMap<String, Object>();

		// You need to add first a Form
		HtmlForm form = new HtmlForm(BasicDocumentSpark.UpdateJson, "document-update-form", HtmlFreeMarker.ENCTYPE_DEFAULT, "Update", "POST");
		viewObjects.put(HtmlFreeMarker.FORM, form);

		// Then, whatever you want in your Form: Text, Radio, Hidden, File
		List<HtmlText> texts = new ArrayList<HtmlText>();
		// texts.add(new HtmlText(BasicDocumentParam.T, document.getT(), "T (t1,t2,t3,...)", "t", ""));
		// ..
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		// List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		// radios.add(new HtmlRadio(BasicDocumentParam.Bool, "Bool", "bool", true));
		// ..
		// viewObjects.put(HtmlFreeMarker.RADIOS, radios);

		List<HtmlHidden> hiddens = new ArrayList<HtmlHidden>();
		hiddens.add(new HtmlHidden(BasicDocumentParam.IdPost, document.getObjectid()));
		// ..
		viewObjects.put(HtmlFreeMarker.HIDDENS, hiddens);

		List<HtmlFile> file = new ArrayList<HtmlFile>();
		file.add(new HtmlFile(BasicDocumentParam.File, "Choose your document", "file"));
		// ..
		viewObjects.put(HtmlFreeMarker.FILE, file);

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
		HtmlForm form = new HtmlForm(BasicDocumentSpark.UploadJson, "document-upload-form", HtmlFreeMarker.ENCTYPE_DEFAULT, "Upload", "POST");
		viewObjects.put(HtmlFreeMarker.FORM, form);

		// Then, whatever you want in your Form: Text, Radio, Hidden, File
		List<HtmlText> texts = new ArrayList<HtmlText>();
		// texts.add(new HtmlText(BasicDocumentParam.T, "", "T (t1,t2,t3,...)", "t", "Enter new t"));
		// ..
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		// List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		// radios.add(new HtmlRadio(BasicDocumentParam.Bool, "Bool", "bool", true));
		// ..
		// viewObjects.put(HtmlFreeMarker.RADIOS, radios);

		List<HtmlHidden> hiddens = new ArrayList<HtmlHidden>();
		hiddens.add(new HtmlHidden(BasicDocumentParam.IdPost, "This is a secret!"));
		// ..
		viewObjects.put(HtmlFreeMarker.HIDDENS, hiddens);

		List<HtmlFile> file = new ArrayList<HtmlFile>();
		file.add(new HtmlFile(BasicDocumentParam.File, "Choose your document", "file"));
		// ..
		viewObjects.put(HtmlFreeMarker.FILE, file);

		return viewObjects;
	}
}
