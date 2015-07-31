package miso.distil.documentServices;

import miso.carrascal.cloudModelServices.abstractServices.Persistent;

import miso.distil.entities.PersonalData;
import java.util.List;


/**
 * Auto-generated artifact class.
 * 
 * @author miso.distil.codeGenerator.
 */
public class Document extends Persistent {

	private static final long serialVersionUID = 1L;
	// Attributes
	private PersonalData docinfo;
	private List<String> coauthors;
	private Boolean isfinished;

	/**
	 * Empty constructor.
	 */
	public Document() {
		super();
	}

	/**
	 * Full constructor.
	 * 
	 * @param filename Name file. 
	 * @param filesize File size.
	* @param docinfo Attribute docinfo.
	* @param coauthors Attribute coauthors.
	* @param isfinished Attribute isfinished.
	 */
	public Document(String filename, long filesize, PersonalData docinfo, List<String> coauthors, Boolean isfinished) {
	
		super(filename, filesize);
	
		this.docinfo = docinfo;
		this.coauthors = coauthors;
		for(int i=0; i < this.coauthors.size(); i++) {
			this.coauthors.set(i, this.coauthors.get(i).toLowerCase());
		}
		this.isfinished = isfinished;
	}

	/**
	 * To get docinfo
	 *
	 * @return docinfo
	 */
	public PersonalData getDocinfo() {
		return docinfo;
	}
	
	/**
	 * To set docinfo
	 *
	 * @param docinfo new docinfo
	 */
	public void setDocinfo(PersonalData docinfo) {
		this.docinfo = docinfo;
	}
	/**
	 * To get coauthors
	 *
	 * @return coauthors
	 */
	public List<String> getCoauthors() {
		return coauthors;
	}
	
	/**
	 * To set coauthors
	 *
	 * @param coauthors new coauthors
	 */
	public void setCoauthors(List<String> coauthors) {
		this.coauthors = coauthors;
		for(int i=0; i < this.coauthors.size(); i++) {
			this.coauthors.set(i, this.coauthors.get(i).toLowerCase());
		}
	}
	/**
	 * To get isfinished
	 *
	 * @return isfinished
	 */
	public Boolean getIsfinished() {
		return isfinished;
	}
	
	/**
	 * To set isfinished
	 *
	 * @param isfinished new isfinished
	 */
	public void setIsfinished(Boolean isfinished) {
		this.isfinished = isfinished;
	}

	// To string method

	@Override
	public String toString() {
		return super.toString() +
		"( docinfo : " + docinfo.toString() + " ) " + 
		"( coauthors : " + coauthors.toString() + " ) " + 
		"( isfinished : " + isfinished.toString() + " )";
	}
}
