package miso.distil.documentServices.basic;

import java.util.ArrayList;
import java.util.List;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicAbstractParam;

/**
 * Auto-generated parameters.
 * 
 * @author miso.distil.codeGenerator.
 */
public class BasicDocumentParam extends BasicAbstractParam {
	// Attributes parameters
	public static String Author_docinfo = "AUTHOR_DOCINFO";
	public static String Source_docinfo = "SOURCE_DOCINFO";
	public static String Tags_docinfo = "TAGS_DOCINFO";
	public static String Isfinished = "ISFINISHED";

	private static List<String> values = new ArrayList<String>();
	/**
	* Auto-generated list with all parameters.
	* 
	* @return list with values.
	*/
	public static List<String> values() {
		if(values.isEmpty()) {
			values.addAll(BasicAbstractParam.values());
			values.add(Author_docinfo);
			values.add(Source_docinfo);
			values.add(Tags_docinfo);
			values.add(Isfinished);
		}
		return values;
	}
}
