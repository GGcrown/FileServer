package miso.distil;

import miso.carrascal.cloudModelServices.abstractServices.basic.BasicInterfaceSpark;
import miso.carrascal.cloudModelServices.MongoDB;
import miso.carrascal.cloudModelServices.abstractServices.RecordDB;

/**
 * Auto-generated mongo data base.
 * 
 * @author miso.distil.codeGenerator.
 */
public class MongoDataBase implements BasicInterfaceSpark 
{
	private final static String MONGO_URI_0 = "mongodb://user:password@ds053972.mongolab.com:53972/heroku_1pbz17rf";

	/**
	 * Auto-generated spark service to find and activate some Mongo DataBases.
	 */
	@Override
	public void runService() {
		// To create your own DB implementation you need to create a class implementing InterfaceDB
		// CustomDB customDB = new CustomDB();

		// To register them or set default one of them
		// Remember : all auto-generated code use the default DB
		// Integer positionDB = RecordDB.register(customDB); 	// (Use RecordDB.getDB(positionDB) to reach it)
		// RecordDB.setDefault(customDB);						// (Use RecordDB.getDefault() to reach it)

		try {
			MongoDB mongoDB_0 = new MongoDB(MONGO_URI_0);
			Integer positionDB_0 = RecordDB.register(mongoDB_0);
			System.out.println("mongoDB_0 registered in position " + positionDB_0);
			RecordDB.setDefault(mongoDB_0);
			System.out.println("mongoDB_0 set default");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mongoDB_0 has found an exception");
		}

	}
}
