package rmsscripts.dataimport.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBConfig {
	private static final File configFile = new File(DBConfig.class.getResource(
			"/dbconfig.properties").getFile());
	public static final String rmsDBUrl;
	public static final String rmsDBUser;
	public static final String rmsDBPassword;
	public static final String rmsMasterId;

	public static final String bmcDBUrl;
	public static final String bmcDBUser;
	public static final String bmcDBPassword;
	private static final Logger logger = Logger.getLogger(DBConfig.class);
	static {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(configFile));
		} catch (IOException e) {
			logger.error(e);
		}

		rmsDBUrl = properties.getProperty("db.rms.url");
		rmsDBUser = properties.getProperty("db.rms.user");
		rmsDBPassword = properties.getProperty("db.rms.password");
		rmsMasterId = properties.getProperty("db.rms.master.id");

		bmcDBUrl = properties.getProperty("db.bmc.url");
		bmcDBUser = properties.getProperty("db.bmc.user");
		bmcDBPassword = properties.getProperty("db.bmc.password");
		logger.debug("rms数据库地址:" + rmsDBUrl);
		logger.debug("rms数据库用户:" + rmsDBUser);
		logger.debug("rms数据库密码:" + rmsDBPassword);

		logger.debug("bmc数据库地址:" + bmcDBUrl);
		logger.debug("bmc数据库用户:" + bmcDBUser);
		logger.debug("bmc数据库密码:" + bmcDBPassword);

	}

}
