package controller;

import model.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.MapPropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import util.ConnectionProvider;

public class ProductDao {

	NamedParameterJdbcTemplate template;
	private final static String CREATE = "Insert into products (name,producer,price) VALUES (:name,:producer,:price);";

	private final static String READone = "Select * from products WHERE producer=:producer;";
	private final static String GETAll = "Select * from products;";

	public ProductDao() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
	}

	public List<Product> getAll() {
		List<Product> allProductsList = template.query(GETAll, BeanPropertyRowMapper.newInstance(Product.class));

		return allProductsList;
	}

	public int addProduct(Product prod) {
		int result = 0;
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(prod);
		template.update(CREATE, source);
		return result  =1;
	}
	public List<Product> get1byProducer (String producer) {
		String get1ByName = ("Select * from products WHERE name=:name;");
		
		
		
		
		Product prod = new Product();
		SqlParameterSource source = new MapSqlParameterSource("producer", producer);
		List<Product> prodList= template.query(READone,source,BeanPropertyRowMapper.newInstance(Product.class));
		
	return prodList;
	}
}
