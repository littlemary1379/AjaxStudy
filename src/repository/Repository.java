package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBconnection;
import model.Product;


public class Repository {
	public static final String TAG="Repository : ";
	public static Repository instance = new Repository();
	public Repository() {}
	public static Repository getInstance() {
		return instance;
	}
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public int deletebyId(int id) {
		final String SQL="delete from item where id = ?";
		try {
			conn=DBconnection.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"orderbyId : "+e.getMessage());
		}
		return -1;
	}
	
	public List<Product> orderbyCount() {
		final String SQL="Select * from item order by count desc";
		List<Product> products=new ArrayList<>();
		try {
			conn=DBconnection.getConnection();
			pstmt=conn.prepareStatement(SQL);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Product product=new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("count")
						);
				products.add(product);
			}
			return products;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"orderbyId : "+e.getMessage());
		}
		
		
		return null;
	}
	
	
	public List<Product> orderbyPrice() {
		final String SQL="Select * from item order by price desc";
		List<Product> products=new ArrayList<>();
		try {
			conn=DBconnection.getConnection();
			pstmt=conn.prepareStatement(SQL);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Product product=new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("count")
						);
				products.add(product);
			}
			return products;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"orderbyId : "+e.getMessage());
		}
		
		
		return null;
	}
	
	public List<Product> orderbyId() {
		final String SQL="Select * from item order by id asc";
		List<Product> products=new ArrayList<>();
		try {
			conn=DBconnection.getConnection();
			pstmt=conn.prepareStatement(SQL);
			
			rs=pstmt.executeQuery();
			System.out.println("여기까진 오나?");
			while(rs.next()) {
				Product product=new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("count")
						);
				products.add(product);
			}
			return products;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"orderbyId : "+e.getMessage());
		}
		
		
		return null;
	}
}
