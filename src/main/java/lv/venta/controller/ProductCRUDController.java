package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {
	
	@Autowired
	private IProductCRUDService crudService;
	
	@GetMapping("/all") //localhost:8080/product/crud/all
	public String getProductCRUDAll(Model model) 
	{
		try {
			ArrayList<Product> allProducts = crudService.retrieveAll();
			model.addAttribute("mydata", allProducts);
			return "product-show-all-page";//tiks parādīta producty-show-all-page.html ar visiem produktiem
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/one") //localhost:8080/product/crud/one?id=2
	public String getProductCRUDOne(@RequestParam("id") int id, Model model)
	{
		try
		{
			Product foundProduct = crudService.retrieveById(id);
			model.addAttribute("mydata", foundProduct);
			return "product-show-one-page";//tiks parādīta product-show-one-page.html lapa
		}
		catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
//	
//	@GetMapping("/minmax")
//	public String getProductMinMax(float min, float max) {
//		
//		try {
//			
//		} catch (Exception e) {
//			
//		}
//		return null;
//	}
//	
	
	
	
	
	
	

}