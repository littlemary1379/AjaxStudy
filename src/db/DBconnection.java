package db;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBconnection {
	public static final String TAG="DBconnection : ";
	public static Connection getConnection() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			System.out.println(TAG+"DB연결 성공");
			Connection conn = ds.getConnection();
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"DB 연결 실패 : "+e.getMessage());
			return null;
		}
	}
}
