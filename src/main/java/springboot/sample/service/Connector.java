package springboot.sample.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import sprintboot.sample.utility.DriverUtil;

public class Connector {

	private static Logger log = Logger.getLogger(Connector.class);

	private static Driver driver;

	private static final String DB_CONNECT_FAILD_MSG = "データベース接続に失敗しました。";

	private Connector() {}

	/**
	 * 接続情報を元にデータベースへの接続確認を行う処理
	 *
	 * @param clazz    : ドライバクラス名
	 * @param url      : JDBCのURL
	 * @param user     : ユーザー名
	 * @param password : パスワード
	 * @return true:接続OK、false:接続NG
	 */
	public static boolean verify(String clazz,
								 String url,
								 String user,
								 String password) {

		boolean result  = false;
		Connection conn = null;
		try {

			if( null == driver ) {
				driver = DriverUtil.getDriver(clazz);
				log.info("ドライバのロードに成功しました。");
			}

			Properties info = new Properties();
			info.put("user", user);
			info.put("password", password);

			conn = driver.connect(url, info);
			if (conn != null) {
				result = true;
				log.info("DBへの接続に成功しました。");
			}
		} catch (InstantiationException e) {
			log.fatal(DB_CONNECT_FAILD_MSG, e);
		} catch (IllegalAccessException e) {
			log.fatal(DB_CONNECT_FAILD_MSG, e);
		} catch (ClassNotFoundException e) {
			log.fatal(DB_CONNECT_FAILD_MSG, e);
		} catch (SQLException e) {
			log.fatal(DB_CONNECT_FAILD_MSG, e);
		} catch (MalformedURLException e) {
			log.fatal(DB_CONNECT_FAILD_MSG, e);
		} catch (NoClassDefFoundError e) {
			log.fatal(DB_CONNECT_FAILD_MSG, e);
		} catch (IOException e) {
			log.fatal(DB_CONNECT_FAILD_MSG, e);
		} finally {
			closeConnection(conn);
		}

		return result;
	}

	/**
	 * コネクションの解放処理
	 *
	 * @param conn 使用したコネクション
	 */
	private static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				log.info("データベース切断に成功しました。");
				log.info("DB接続が正常に終了しました。");
			} else {
				log.error("コネクションがありません");
				log.error("データベース切断に失敗しました。");
			}
		} catch (SQLException e) {
			log.fatal("データベース切断に失敗しました。", e);
		}
	}
}
