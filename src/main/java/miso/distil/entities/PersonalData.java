package miso.distil.entities;

import java.util.List;

/**
 * Auto-generated entity class.
 * 
 * @author miso.distil.codeGenerator.
 */
public class PersonalData {

	// Attributes
	private String author;
	private String source;
	private List<String> tags;
	private String fileextension;

	/**
	 * Empty constructor.
	 */
	public PersonalData() {}
	
	/**
	 * Full constructor.
	 * 
	* @param author Attribute author.
	* @param source Attribute source.
	* @param tags Attribute tags.
	* @param fileextension Attribute fileextension.
	 */
	public PersonalData(String author, String source, List<String> tags, String fileextension) {
	
		this.author = author.toLowerCase();
		this.source = source.toLowerCase();
		this.tags = tags;
		for(int i=0; i < this.tags.size(); i++) {
			this.tags.set(i, this.tags.get(i).toLowerCase());
		}
		this.fileextension = fileextension.toLowerCase();
	}

	/**
	 * To get author
	 *
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * To set author
	 *
	 * @param author new author
	 */
	public void setAuthor(String author) {
		this.author = author.toLowerCase();
	}
	/**
	 * To get source
	 *
	 * @return source
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * To set source
	 *
	 * @param source new source
	 */
	public void setSource(String source) {
		this.source = source.toLowerCase();
	}
	/**
	 * To get tags
	 *
	 * @return tags
	 */
	public List<String> getTags() {
		return tags;
	}
	
	/**
	 * To set tags
	 *
	 * @param tags new tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
		for(int i=0; i < this.tags.size(); i++) {
			this.tags.set(i, this.tags.get(i).toLowerCase());
		}
	}
	/**
	 * To get fileextension
	 *
	 * @return fileextension
	 */
	public String getFileextension() {
		return fileextension;
	}
	
	/**
	 * To set fileextension
	 *
	 * @param fileextension new fileextension
	 */
	public void setFileextension(String fileextension) {
		this.fileextension = fileextension.toLowerCase();
	}

	// To string method

	@Override
	public String toString() {
		return super.toString() +
		"( author : " + author.toString() + " ) " + 
		"( source : " + source.toString() + " ) " + 
		"( tags : " + tags.toString() + " ) " + 
		"( fileextension : " + fileextension.toString() + " )";
	}
}
