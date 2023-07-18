package com.pms.service;

import java.util.List;

import com.pms.dao.ProductDAO;
import com.pms.pojo.Products;

public class ProductService implements ProductServiceInterface {
	
	private static ProductDAO dao = null;

	static {
		dao = new ProductDAO();
	}
	
	@Override
	public int insertProduct(Products product) {
		return dao.insertProduct(product);
	}

	@Override
	public int updateProduct(Products product) {
		return dao.updateProduct(product);
	}

	@Override
	public int deleteProduct(int pid) {
		return dao.deleteProduct(pid);
	}

	@Override
	public Products selectProduct(int pid) {
		return dao.selectProduct(pid);
	}

	@Override
	public List<Products> selectAll() {
		return dao.selectAll();
	}

	@Override
	public void close() {
		dao.close();
	}
	
	public static boolean inputValidation(int pid) {
		ProductDAO dao = new ProductDAO();
		if(dao.selectProduct(pid)!=null) {
			return false;
		}
		return true;
	}
	
	public static boolean inputValidationModify(int pid) {
		if(dao.selectProduct(pid)==null) {
			return false;
		}
		return true;
	}
	
}