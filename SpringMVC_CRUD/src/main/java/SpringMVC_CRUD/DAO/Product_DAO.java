package SpringMVC_CRUD.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import SpringMVC_CRUD.Model.Product;

@Component
public class Product_DAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// Create
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.save(product);
	}
	
	@Transactional
	public void updateProduct(Product product) {
		this.hibernateTemplate.update(product);
	}

	// Get All Product
	public List<Product> getProducts() {
		List<Product> product = this.hibernateTemplate.loadAll(Product.class);
		return product;
	}

	
	 //Delete Single Product
	 
	  @Transactional 
	  public void deleteProduct(int pid) 
	  { 
		  Product p = this.hibernateTemplate.load(Product.class, pid);
		  this.hibernateTemplate.delete(p); 
	  }
	 

	// Get the Single Product
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);

	}

}
