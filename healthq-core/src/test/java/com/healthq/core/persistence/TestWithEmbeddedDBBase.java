package com.healthq.core.persistence;

//import static com.wix.mysql.ScriptResolver.classPathScripts;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.distribution.Version.v5_7_latest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import java.time.ZoneId;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.commons.lang3.BooleanUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;
//import com.wix.mysql.config.SchemaConfig;

public class TestWithEmbeddedDBBase {
	private static final String PROP_NAME_DB_SCHEMA   = "healthq.datasource.schema";
	private static final String PROP_NAME_SQL_DDL   = "healthq.datasource.ddl.location";
	private static final String PROP_NAME_ISUSEEMBEDD = "healthq.datasource.istouseembeddeddb";
	private static final String DEFAULT_DB_SCHEMA = "healthq";
	private static final String DEFAULT_SQL_DDL = "db/HealthQDB.sql";
	private static final String DEFAULT_ISTOUSEEMBEDDEDDB = "true";
	
	private static Properties prop;
	
	// isToUseEmbeddedDB == true means run the test cases against a local
	// physical mysql which must be populated with the required DB schema.
	// To do that you also need to point application-test.properties to the
	// physical db. This test scenario is useful to do pre-release using a real
	// DB rather than in-memory.

	// isToUseEmbeddedDB == false means run test cases against the in-memory db.
	// To do this you also need to point application-test.properties to the
	// physical db. This test scenario is useful during development with no
	// overhead of maintaining a real db or protecting data in that db against
	// DELETE related test cases.	
	private static Boolean isToUseEmbeddedDB;
    
	static{
        InputStream is = null;
        try {
            prop = new Properties();
            is = TestWithEmbeddedDBBase.class.getClassLoader().getResourceAsStream("application-test.properties");
            if(is != null)
            	prop.load(is);
            isToUseEmbeddedDB = Boolean.valueOf(getPropertyValue(PROP_NAME_ISUSEEMBEDD,DEFAULT_ISTOUSEEMBEDDEDDB));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
	public static String getPropertyValue(String key, String defaultVal) {
		if (prop == null)
			return defaultVal;
		else
			return prop.getProperty(key) == null ? defaultVal : prop
					.getProperty(key);
	}
	
	private static EmbeddedMysql embeddedMysql;

	@BeforeClass
	public static void _setupBeforeClass() {
		if(BooleanUtils.isFalse(isToUseEmbeddedDB))
			return;
		
		MysqldConfig config = MysqldConfig.aMysqldConfig(v5_7_latest)
				.withPort(3307)
				.withTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")))
				.withUser("test", "test").build();
		
		String schemaToUse = getPropertyValue(PROP_NAME_DB_SCHEMA,DEFAULT_DB_SCHEMA);
		String sqlDDLToUse = getPropertyValue(PROP_NAME_SQL_DDL,DEFAULT_SQL_DDL);

		//Alternative 1: more verbose
		/*SchemaConfig schemaConfig = SchemaConfig.aSchemaConfig("rbwww_utils")
				.withScripts(classPathScript("db/PropertyPublisherDB.sql"))
				.build();

		embeddedMysql = EmbeddedMysql.anEmbeddedMysql(config)
		// use the download config option to set a
		// custom location for the cached mysql executable
		// .withDownloadConfig(DownloadConfig.aDownloadConfig()
				// .withCacheDir("./.embedmysql")
				// .build())
				.addSchema(schemaConfig).start();*/
		
	    //Alternative 2: shorter hand
		embeddedMysql = EmbeddedMysql.anEmbeddedMysql(config)
				.addSchema(schemaToUse, classPathScript(sqlDDLToUse))
				.start();
	}

	@AfterClass
	public static void _tearDownAfterClass() {
		if(BooleanUtils.isFalse(isToUseEmbeddedDB))
			return;
		if (null != embeddedMysql) {
			embeddedMysql.stop();
		}
	}

}