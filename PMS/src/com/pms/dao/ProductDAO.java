package com.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pms.pojo.Products;
import com.pms.util.DBUtil;

public class ProductDAO {
	
	Connection conn = null;
	
	public ProductDAO(){
		conn = DBUtil.getDBConnection();
	}
	
	public int insertProduct(Products product) {
		int value = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into products values(?, ?, ?, ?)");
			
			stmt.setInt(1, product.getPid());
			stmt.setString(2, product.getPname());
			stmt.setDouble(3, product.getPrice());
			stmt.setDate(4, product.getDom());
			
			value = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	public int updateProduct(Products product) {
		int value = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("update products set pname = ?, price = ?, dom = ? where pid = ?");
			
			stmt.setInt(4, product.getPid());
			stmt.setString(1, product.getPname());
			stmt.setDouble(2, product.getPrice());
			stmt.setDate(3, product.getDom());
			
			value = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	public int deleteProduct(int pid) {
		int value = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from products where pid = ?");
			
			stmt.setInt(1, pid);
			
			value = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public Products selectProduct(int pid) {
		Products obj = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from products where pid = ?");
			
			stmt.setInt(1, pid);
			
			ResultSet record = stmt.executeQuery();
			
			if(!record.next()) {
				return null;
			}
			
			record = stmt.executeQuery();
			
			record.next();
			
			obj = new Products();
			obj.setPid(record.getInt("pid"));
			obj.setPname(record.getString("pname"));
			obj.setPrice(record.getDouble("price"));
			obj.setDom(record.getDate("dom"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public List<Products> selectAll() {
		List<Products> list = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from products");
			
			ResultSet records = stmt.executeQuery();
			
			while(records.next()) {
				Products obj = new Products();
				
				obj.setPid(records.getInt("pid"));
				obj.setPname(records.getString("pname"));
				obj.setPrice(records.getDouble("price"));
				obj.setDom(records.getDate("dom"));
				
				list.add(obj);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void close() {
		try {
			conn.close();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}