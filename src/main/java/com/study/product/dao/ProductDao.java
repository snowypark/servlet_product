package com.study.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.study.product.config.DBConnectionMgr;
import com.study.product.vo.ProductVo;

public class ProductDao {
	//싱글톤
	
	private static ProductDao instance;
	private DBConnectionMgr pool;
	
	private ProductDao() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public static ProductDao getInstance() {
		if(instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}
	

	
	public ProductVo findProductByProductName(String productName) {
		ProductVo productVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			String sql = "select * from product_tb where product_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				productVo = ProductVo.builder()
						.ProductId(rs.getInt(1))
						.productName(rs.getString(2))
						.productPrice(rs.getInt(3))
						.productSize(rs.getString(4))
						.build();
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return productVo;
	}
	
	public int save(ProductVo productVo) {
		int successCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();

			String sql = "insert into product_tb values(0, ?, ?, ?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // import java.sql
			
			pstmt.setString(1, productVo.getProductName());
			pstmt.setInt(2, productVo.getProductPrice());
			pstmt.setString(3, productVo.getProductSize());
			
			successCount = pstmt.executeUpdate();			
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				productVo.setProductId(rs.getInt(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		
		return successCount;
		
	}
		

}

//public Product findProductByName(String product_name) {
//Connection con = null;
//PreparedStatement pstmt = null;
//ResultSet rs = null;
//Product product = null;		
//
//try {
//	Class.forName("com.mysql.cj.jdbc.Driver"); 			
//	con = DriverManager.getConnection(DBconfig.URL, DBconfig.USERNAME, DBconfig.PASSWORD);
//	String sql = "select * from product_tb where product_name= ?";
//	pstmt = con.prepareStatement(sql);
//	pstmt.setString(1, product_name);
//	rs = pstmt.executeQuery();
//	
//	if(rs.next()) {
//		
//		product = Product.builder()
//				.product_id(rs.getInt(1))
//				.product_name(rs.getString(2))
//				.product_price(rs.getInt(3))
//				.product_size(rs.getString(4))
//				.build();
//		} 
//	} catch(Exception e) {
//			e.printStackTrace();
//			
//	} finally {
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(con != null) {
//					con.close();					
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();					
//		}		
//	}
//return product;
//
//}
//
//
//public int saveProduct(Product product) {
//Connection con = null;
//PreparedStatement pstmt = null;
//int successCount = 0;
//
//try {
//	Class.forName("com.mysql.cj.jdbc.Driver");
//	
//	con = DriverManager.getConnection(DBconfig.URL, DBconfig.USERNAME, DBconfig.PASSWORD);
//	String sql = "insert into product_tb(product_name, product_price, product_size) values(?, ?, ?)";
//	pstmt = con.prepareStatement(sql);
//	pstmt.setString(1, product.getProduct_name());
//	pstmt.setInt(2, product.getProduct_price());
//	pstmt.setString(3, product.getProduct_size());
//	successCount = pstmt.executeUpdate();
//	
//} catch(Exception e) {
//	e.printStackTrace();
//} finally {
//	try {
//		if(pstmt != null) {
//			pstmt.close();
//		}
//		if(con != null) {
//			con.close();					
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//}
//
//return successCount;
//}
//
//public List<Product> getProductListAll() {
//Connection con = null;
//PreparedStatement pstmt = null;
//ResultSet rs = null;
//List<Product> products = new ArrayList<>();
//
//try {			
//	Class.forName("com.mysql.cj.jdbc.Driver"); 
//	
//	con = DriverManager.getConnection(DBconfig.URL, DBconfig.USERNAME, DBconfig.PASSWORD);
//	String sql = "select * from product_tb";
//	pstmt = con.prepareStatement(sql);
//	rs = pstmt.executeQuery();
//	
//	while(rs.next()) {
//		Product product = Product.builder()
//				.product_id(rs.getInt(1))
//				.product_name(rs.getString(2))
//				.product_price(rs.getInt(3))
//				.product_size(rs.getString(4))
//				.build();
//		products.add(product);
//	}
//	
//} catch (Exception e) {
//		e.printStackTrace();
//	
//} finally {
//	try {
//		if(rs != null) {
//			rs.close();
//		}
//		if(pstmt != null) {
//			pstmt.close();
//		}
//		if(con != null) {
//			con.close();					
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//}
//
//return products;
//
//}
