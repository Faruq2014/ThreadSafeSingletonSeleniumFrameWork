package dbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;

public class GetDBdata {
	public synchronized HashMap<String, String> getSqlResultInMap(String sqlQuery) {  
        HashMap<String, String> data_map = new HashMap<>();

		try{  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String url ="jdbc:sqlserver://DESKTOP-INQUNRP\\MSSQLSERVER;"+"databaseName=FaruqAcademy;";

			String user="Faruq";
			String password="1234";
			Connection con=DriverManager.getConnection(url,user,password); 		

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(sqlQuery);  
            ResultSetMetaData rmd = rs.getMetaData();

            while (rs.next()) {            
                for (int i = 1; i <= rmd.getColumnCount(); i++) {
                    data_map.put(rmd.getColumnName(i), rs.getString(i));
                }
            }
            System.out.println(data_map);
			con.close();  
		}catch(Exception e){ System.out.println(e);}
		return data_map;  
	}  

	public static void main(String[] args) {
		//String sid1 = "SELECT * FROM [FaruqAcademy].[dbo].[Students] where studentId=1";
		//String select = "SELECT * FROM Students";
		//String sid1 = "SELECT * FROM Students where studentId=1";
		String sid2 = "SELECT * FROM Students where studentId=2";
		GetDBdata db = new GetDBdata();
		HashMap<String, String> dbData=db.getSqlResultInMap(sid2);
		System.out.println(dbData.get("firstname"));
		System.out.println(dbData.get("phone"));

	}



}
