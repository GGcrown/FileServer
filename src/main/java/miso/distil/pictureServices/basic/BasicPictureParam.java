package miso.distil.pictureServices.basic;

import java.util.ArrayList;
import java.util.List;
import miso.carrascal.cloudModelServices.abstractServices.basic.BasicAbstractParam;

/**
 * Auto-generated parameters.
 * 
 * @author miso.distil.codeGenerator.
 */
public class BasicPictureParam extends BasicAbstractParam {
	// Attributes parameters
	public static String Author_pictureinfo = "AUTHOR_PICTUREINFO";
	public static String Source_pictureinfo = "SOURCE_PICTUREINFO";
	public static String Tags_pictureinfo = "TAGS_PICTUREINFO";
	public static String Peoplepictured = "PEOPLEPICTURED";
	public static String Place = "PLACE";
	public static String Edited = "EDITED";

	private static List<String> values = new ArrayList<String>();
	/**
	* Auto-generated list with all parameters.
	* 
	* @return list with values.
	*/
	public static List<String> values() {
		if(values.isEmpty()) {
			values.addAll(BasicAbstractParam.values());
			values.add(Author_pictureinfo);
			values.add(Source_pictureinfo);
			values.add(Tags_pictureinfo);
			values.add(Peoplepictured);
			values.add(Place);
			values.add(Edited);
		}
		return values;
	}
}
