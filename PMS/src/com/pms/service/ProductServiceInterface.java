package com.pms.service;

import java.util.List;

import com.pms.pojo.Products;

public interface ProductServiceInterface {
	
	public int insertProduct(Products product);
	public int updateProduct(Products product);
	public int deleteProduct(int pid);
	public Products selectProduct(int pid);
	public List<Products> selectAll();
	public void close();
	
}