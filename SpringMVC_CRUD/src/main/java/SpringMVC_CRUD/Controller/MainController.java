package SpringMVC_CRUD.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import SpringMVC_CRUD.DAO.Product_DAO;
import SpringMVC_CRUD.Model.Product;

@Controller
public class MainController {
	
	@Autowired
	private Product_DAO product_DAO;
	
	@RequestMapping("/")
	public String home(Model m) 
	{
		List<Product>  products = product_DAO.getProducts();
		m.addAttribute("products",products);
		
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product ,HttpServletRequest request) 
	{
		System.out.println(product);
		product_DAO.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request) 
	{
		this.product_DAO.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
		
	}
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId")int pid ,Model model) 
	{
		Product product = this.product_DAO.getProduct(pid);
		model.addAttribute("product",product);
		return "update_form";
	}

}
