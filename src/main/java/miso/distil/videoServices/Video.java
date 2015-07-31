package miso.distil.videoServices;

import miso.carrascal.cloudModelServices.abstractServices.Persistent;

import miso.distil.entities.PersonalData;

/**
 * Auto-generated artifact class.
 * 
 * @author miso.distil.codeGenerator.
 */
public class Video extends Persistent {

	private static final long serialVersionUID = 1L;
	// Attributes
	private PersonalData videoinfo;
	private Double length;

	/**
	 * Empty constructor.
	 */
	public Video() {
		super();
	}

	/**
	 * Full constructor.
	 * 
	 * @param filename Name file. 
	 * @param filesize File size.
	* @param videoinfo Attribute videoinfo.
	* @param length Attribute length.
	 */
	public Video(String filename, long filesize, PersonalData videoinfo, Double length) {
	
		super(filename, filesize);
	
		this.videoinfo = videoinfo;
		this.length = length;
	}

	/**
	 * To get videoinfo
	 *
	 * @return videoinfo
	 */
	public PersonalData getVideoinfo() {
		return videoinfo;
	}
	
	/**
	 * To set videoinfo
	 *
	 * @param videoinfo new videoinfo
	 */
	public void setVideoinfo(PersonalData videoinfo) {
		this.videoinfo = videoinfo;
	}
	/**
	 * To get length
	 *
	 * @return length
	 */
	public Double getLength() {
		return length;
	}
	
	/**
	 * To set length
	 *
	 * @param length new length
	 */
	public void setLength(Double length) {
		this.length = length;
	}

	// To string method

	@Override
	public String toString() {
		return super.toString() +
		"( videoinfo : " + videoinfo.toString() + " ) " + 
		"( length : " + length.toString() + " )";
	}
}
