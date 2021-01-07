package org.zerock.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;
//오라클 클라우드 연결하기.
@Log4j
public class JDBCTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
		//오라클 12c 버전 
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "c##mydbms";
		String password = "admin";
		
		//오라클 브라우저로 연결
//		String url = "jdbc:oracle:thin:@db202101041015_high?TNS_ADMIN=/home/opc/wallet";
//		String user = "admin";
//		String password = "QAZwsxedc123";
		
		try(
			Connection conn = DriverManager.getConnection(url, user, password);
				) {
			assertNotNull(conn);
		}catch(Exception e) {
			fail(e.getMessage());
			log.info(e);
		}
	}
}
