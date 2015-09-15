package rmsscripts.dataimport;

import java.sql.Connection;
import java.sql.DriverManager;

import rmsscripts.dataimport.conf.DBConfig;

public class ConnectPool {
	// sqlServer的连接地址
	static String sqlServerUrl = "jdbc:jtds:sqlserver://192.168.1.20:1433;instance=sharepoint;DatabaseName=jfjdsxczx_db;user=sa;password=boful123$;socketTimeout=60";

	private static Connection sqlServerConnection;
	private static Connection bmcConnection;
	private static Connection rmsConnection;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			sqlServerConnection = DriverManager.getConnection(sqlServerUrl);
			bmcConnection = DriverManager.getConnection(DBConfig.bmcDBUrl,
					DBConfig.bmcDBUser, DBConfig.bmcDBPassword);
			rmsConnection = DriverManager.getConnection(DBConfig.rmsDBUrl,
					DBConfig.rmsDBUser, DBConfig.rmsDBPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		if (sqlServerConnection != null) {
			sqlServerConnection.close();
		}
		if (bmcConnection != null) {
			bmcConnection.close();
		}
		if (rmsConnection != null) {
			rmsConnection.close();
		}
	}

	public static Connection getSqlServerConnection() {
		return sqlServerConnection;
	}

	public static void setSqlServerConnection(Connection sqlServerConnection) {
		ConnectPool.sqlServerConnection = sqlServerConnection;
	}

	public static Connection getBmcConnection() {
		return bmcConnection;
	}

	public static void setBmcConnection(Connection bmcConnection) {
		ConnectPool.bmcConnection = bmcConnection;
	}

	public static Connection getRmsConnection() {
		return rmsConnection;
	}

	public static void setRmsConnection(Connection rmsConnection) {
		ConnectPool.rmsConnection = rmsConnection;
	}

}
