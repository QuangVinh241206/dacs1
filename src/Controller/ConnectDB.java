/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.*;
/**
 *
 * @author vinhn
 */
public class ConnectDB {
    public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://LAPTOP-IJE704M9:1433; databaseName=QuanLyKhoHangDienThoai; encrypt=true; trustServerCertificate=true";
			String userName = "sa";
			String password = "241206";
			conn = DriverManager.getConnection(url, userName, password);			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return conn;
    }
}
