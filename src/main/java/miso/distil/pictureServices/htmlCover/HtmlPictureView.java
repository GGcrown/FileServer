package miso.distil.pictureServices.htmlCover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlInterfaceView;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.HtmlFreeMarker;
import miso.carrascal.cloudModelServices.abstractServices.htmlCover.htmlObjects.*;
import miso.carrascal.cloudModelServices.utils.Utils;

import miso.distil.pictureServices.basic.BasicPictureParam;
import miso.distil.pictureServices.basic.BasicPictureSpark;
import miso.distil.pictureServices.Picture;

/**
 * Auto-generated html view methods.
 * 
 * @author miso.distil.codeGenerator.
 */
public class HtmlPictureView implements HtmlInterfaceView<Picture>{

	/**
	 * Auto-generated method to construct the information from an artifact.
	 * 
	 * @param picture Picture to read.
	 * @return list with entries to show in html.
	 */
	@Override
	public List<HtmlEntry> constructInfoReadOne(Picture picture) {
		List<HtmlEntry> entries = new ArrayList<HtmlEntry>();
		entries.add(new HtmlEntry(picture.getFilename(), EntrySize.H3));
		entries.add(new HtmlEntry(picture.getCreatedatString(), EntrySize.H4));
		entries.add(new HtmlEntry("FileSize (bytes): " + picture.getFilesize().toString(), EntrySize.H4));
		entries.add(new HtmlEntry("ObjectId : " + picture.getObjectid().toString(), EntrySize.H4));
		entries.add(new HtmlEntry("pictureinfo.author : " + picture.getPictureinfo().getAuthor(), EntrySize.H5));
		entries.add(new HtmlEntry("pictureinfo.source : " + picture.getPictureinfo().getSource(), EntrySize.H5));
		entries.add(new HtmlEntry("pictureinfo.tags : " + Utils.listToString(picture.getPictureinfo().getTags()), EntrySize.H5));				
		entries.add(new HtmlEntry("pictureinfo.fileextension : " + picture.getPictureinfo().getFileextension(), EntrySize.H5));
		entries.add(new HtmlEntry("peoplepictured : " + Utils.listToString(picture.getPeoplepictured()), EntrySize.H5));				
		entries.add(new HtmlEntry("place : " + picture.getPlace(), EntrySize.H5));
		entries.add(new HtmlEntry(HtmlPictureLinks.getDownloadJsonLink(picture), EntrySize.H5));
		entries.add(new HtmlEntry(HtmlPictureLinks.getDeleteFormJsonLink(picture), EntrySize.H5));

		return entries;
	}

	/**
	 * Auto-generated method to construct the information from an artifact's list.
	 * 
	 * @param pictures list of Picture to read.
	 * @return list with lists of entries to show in html.
	 */
	@Override
	public List<List<HtmlEntry>> constructInfoReadAll(List<Picture> pictures) {
		List<List<HtmlEntry>> multientries = new ArrayList<List<HtmlEntry>>();
			for(Picture picture : pictures) {
				List<HtmlEntry> entries = new ArrayList<HtmlEntry>();
				entries.add(new HtmlEntry(HtmlPictureLinks.getReadHtmlLink(picture), EntrySize.H3));
				entries.add(new HtmlEntry(picture.getCreatedatString(), EntrySize.H4));
				entries.add(new HtmlEntry(HtmlPictureLinks.getReadJsonLink(picture), EntrySize.H5));
				entries.add(new HtmlEntry(HtmlPictureLinks.getDeleteFormJsonLink(picture), EntrySize.H5));
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

		HtmlForm form = new HtmlForm(HtmlPictureSpark.SearchHTML, "picture-search-form", HtmlFreeMarker.ENCTYPE_DEFAULT, "Search", "GET");
		viewObjects.put(HtmlFreeMarker.FORM, form);
		
		Map<String, List<HtmlSelectBox>> selectbox = new HashMap<String, List<HtmlSelectBox>>();
		List<HtmlSelectBox> boxes = new ArrayList<HtmlSelectBox>();
		boxes.add(new HtmlSelectBox("pictureinfo.author", "pictureinfo.author"));
		boxes.add(new HtmlSelectBox("pictureinfo.source", "pictureinfo.source"));
		boxes.add(new HtmlSelectBox("pictureinfo.tags", "pictureinfo.tags"));
		boxes.add(new HtmlSelectBox("pictureinfo.fileextension", "pictureinfo.fileextension"));
		boxes.add(new HtmlSelectBox("peoplepictured", "peoplepictured"));
		boxes.add(new HtmlSelectBox("place", "place"));
		boxes.add(new HtmlSelectBox("edited", "edited"));
		selectbox.put(BasicPictureParam.Search_query, boxes);
		viewObjects.put(HtmlFreeMarker.SELECTBOX, selectbox);

		List<HtmlText> texts = new ArrayList<HtmlText>();
		texts.add(new HtmlText(BasicPictureParam.Search_value, "", "Value", "search", "Enter what do you want to search"));
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		radios.add(new HtmlRadio(BasicPictureParam.Search_synonyms, "Synonyms", "synonyms", true));
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

		HtmlForm form = new HtmlForm(BasicPictureSpark.UploadJson, "picture-upload-form", HtmlFreeMarker.ENCTYPE_FILE, "Upload", "POST");
		viewObjects.put(HtmlFreeMarker.FORM, form);

		List<HtmlText> texts = new ArrayList<HtmlText>();
		texts.add(new HtmlText(BasicPictureParam.Author_pictureinfo, "", "pictureinfo.author", "author", "Enter valid String"));
		texts.add(new HtmlText(BasicPictureParam.Source_pictureinfo, "", "pictureinfo.source", "source", "Enter valid String"));
		texts.add(new HtmlText(BasicPictureParam.Tags_pictureinfo, "", "pictureinfo.tags (tags1,tags2,...)", "tags", "Enter new list of valid String"));
		texts.add(new HtmlText(BasicPictureParam.Peoplepictured, "", "peoplepictured (peoplepictured1,peoplepictured2,...)", "peoplepictured", "Enter new list of valid String"));
		texts.add(new HtmlText(BasicPictureParam.Place, "", "place", "place", "Enter valid String"));
		viewObjects.put(HtmlFreeMarker.TEXTS, texts);

		List<HtmlRadio> radios = new ArrayList<HtmlRadio>();
		radios.add(new HtmlRadio(BasicPictureParam.Edited, "edited", "edited", true));
		viewObjects.put(HtmlFreeMarker.RADIOS, radios);

		List<HtmlFile> file = new ArrayList<HtmlFile>();
		file.add(new HtmlFile(BasicPictureParam.File, "Choose your picture", "file"));
		viewObjects.put(HtmlFreeMarker.FILE, file);

		return viewObjects;
	}
}
