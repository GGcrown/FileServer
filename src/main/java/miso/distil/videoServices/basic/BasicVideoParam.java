package miso.distil.videoServices.basic;

import java.util.ArrayList;
import java.util.List;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicAbstractParam;

/**
 * Auto-generated parameters.
 * 
 * @author miso.distil.codeGenerator.
 */
public class BasicVideoParam extends BasicAbstractParam {
	// Attributes parameters
	public static String Author_videoinfo = "AUTHOR_VIDEOINFO";
	public static String Source_videoinfo = "SOURCE_VIDEOINFO";
	public static String Tags_videoinfo = "TAGS_VIDEOINFO";
	public static String Length = "LENGTH";

	private static List<String> values = new ArrayList<String>();
	/**
	* Auto-generated list with all parameters.
	* 
	* @return list with values.
	*/
	public static List<String> values() {
		if(values.isEmpty()) {
			values.addAll(BasicAbstractParam.values());
			values.add(Author_videoinfo);
			values.add(Source_videoinfo);
			values.add(Tags_videoinfo);
			values.add(Length);
		}
		return values;
	}
}
