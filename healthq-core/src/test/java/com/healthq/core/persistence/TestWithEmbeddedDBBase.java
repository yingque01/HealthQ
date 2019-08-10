package com.healthq.core.persistence;

import static com.wix.mysql.distribution.Version. v5_7_latest;
//import static com.wix.mysql.ScriptResolver.classPathScripts;
import static com.wix.mysql.ScriptResolver.classPathScript;
//import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import java.time.ZoneId;
import java.util.TimeZone;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;
//import com.wix.mysql.config.SchemaConfig;

public class TestWithEmbeddedDBBase {

	private static EmbeddedMysql embeddedMysql;

	@BeforeClass
	public static void _setupBeforeClass() {

		MysqldConfig config = MysqldConfig.aMysqldConfig(v5_7_latest)
				.withPort(3307)
				.withTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")))
				.withUser("test", "test").build();

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
				.addSchema("healthq", classPathScript("db/HealthQDB.sql"))
				.start();
	}

	@AfterClass
	public static void _tearDownAfterClass() {

		if (null != embeddedMysql) {

			embeddedMysql.stop();

		}

	}

}