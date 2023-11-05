package t4_webproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbconnect {
		// MySQL JDBC 드라이버를 로드
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int rc = 0;
		String[] namedata;
		double[] latdata;
		double[] longdata;
		
		public dbconnect() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/test";
				// MySQL 서버에 연결
				conn = DriverManager.getConnection(url, "root", "0000");
				System.out.println("connected");
				// 쿼리수행 객체 Statement
				stmt = conn.createStatement();
			
				String sql = "SELECT latitude,longitude,name FROM labelingtest";
				
				rs = stmt.executeQuery(sql);
				
				
				while(rs.next()) {
					
					double lati = rs.getDouble(1);
					double longi = rs.getDouble(2);
					String names = rs.getString(3);
					System.out.println(names+" 위도:"+lati+" 경도:"+longi);
					rc=rc+1;
				}			
				System.out.println(rc);
				
				ResultSet rs2 = stmt.executeQuery(sql);
				namedata = new String[rc];
				latdata = new double[rc];
				longdata = new double[rc];
				for (int i = 0; i < rc; i++) {
					if(rs2.next()) {
					namedata[i] = rs2.getString("name");
					latdata[i] = rs2.getDouble("latitude");
					longdata[i] = rs2.getDouble("longitude");}
				}
				
			}
			catch(ClassNotFoundException e) {
				System.out.println("loading failed");
			}
			catch(SQLException e){
				System.out.println("에러: "+e);
			}
			finally {
				try {
					if(conn != null && !conn.isClosed()) {
						conn.close();
					}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}	
		public String[] getName() {
			return namedata;
		}
		public double[] getlatitude() {
			return latdata;
		}
		public double[] getlongitude() {
			return longdata;
		}
		public int getcount() {
			return rc;
		}
		}
		


