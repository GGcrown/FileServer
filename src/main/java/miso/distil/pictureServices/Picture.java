package miso.distil.pictureServices;

import miso.carrascal.cloudModelServices.abstractServices.Persistent;

import miso.distil.entities.PersonalData;
import java.util.List;


/**
 * Auto-generated artifact class.
 * 
 * @author miso.distil.codeGenerator.
 */
public class Picture extends Persistent {

	private static final long serialVersionUID = 1L;
	// Attributes
	private PersonalData pictureinfo;
	private List<String> peoplepictured;
	private String place;
	private Boolean edited;

	/**
	 * Empty constructor.
	 */
	public Picture() {
		super();
	}

	/**
	 * Full constructor.
	 * 
	 * @param filename Name file. 
	 * @param filesize File size.
	* @param pictureinfo Attribute pictureinfo.
	* @param peoplepictured Attribute peoplepictured.
	* @param place Attribute place.
	* @param edited Attribute edited.
	 */
	public Picture(String filename, long filesize, PersonalData pictureinfo, List<String> peoplepictured, String place, Boolean edited) {
	
		super(filename, filesize);
	
		this.pictureinfo = pictureinfo;
		this.peoplepictured = peoplepictured;
		for(int i=0; i < this.peoplepictured.size(); i++) {
			this.peoplepictured.set(i, this.peoplepictured.get(i).toLowerCase());
		}
		this.place = place.toLowerCase();
		this.edited = edited;
	}

	/**
	 * To get pictureinfo
	 *
	 * @return pictureinfo
	 */
	public PersonalData getPictureinfo() {
		return pictureinfo;
	}
	
	/**
	 * To set pictureinfo
	 *
	 * @param pictureinfo new pictureinfo
	 */
	public void setPictureinfo(PersonalData pictureinfo) {
		this.pictureinfo = pictureinfo;
	}
	/**
	 * To get peoplepictured
	 *
	 * @return peoplepictured
	 */
	public List<String> getPeoplepictured() {
		return peoplepictured;
	}
	
	/**
	 * To set peoplepictured
	 *
	 * @param peoplepictured new peoplepictured
	 */
	public void setPeoplepictured(List<String> peoplepictured) {
		this.peoplepictured = peoplepictured;
		for(int i=0; i < this.peoplepictured.size(); i++) {
			this.peoplepictured.set(i, this.peoplepictured.get(i).toLowerCase());
		}
	}
	/**
	 * To get place
	 *
	 * @return place
	 */
	public String getPlace() {
		return place;
	}
	
	/**
	 * To set place
	 *
	 * @param place new place
	 */
	public void setPlace(String place) {
		this.place = place.toLowerCase();
	}
	/**
	 * To get edited
	 *
	 * @return edited
	 */
	public Boolean getEdited() {
		return edited;
	}
	
	/**
	 * To set edited
	 *
	 * @param edited new edited
	 */
	public void setEdited(Boolean edited) {
		this.edited = edited;
	}

	// To string method

	@Override
	public String toString() {
		return super.toString() +
		"( pictureinfo : " + pictureinfo.toString() + " ) " + 
		"( peoplepictured : " + peoplepictured.toString() + " ) " + 
		"( place : " + place.toString() + " ) " + 
		"( edited : " + edited.toString() + " )";
	}
}
