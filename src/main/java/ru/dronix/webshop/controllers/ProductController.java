package ru.dronix.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dronix.webshop.service.CategoryService;
import ru.dronix.webshop.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("listProducts",this.productService.getAllProducts());
		model.addAttribute("sort","Без сортировки");

		categories(model);

		return "index";
	}

	@RequestMapping(value = "/sort/{method}")
	public String sorting(@PathVariable("method")String method,Model model){
		switch (method){
			case "ascPrice":
				model.addAttribute("listProducts",this.productService.getProductsAscPrice());
				model.addAttribute("sort","От дешовых к дорогим");
				categories(model);
				break;
			case "descPrice":
				model.addAttribute("listProducts",this.productService.getProductsDescPrice());
				model.addAttribute("sort","От дорогих к дешовым");
				categories(model);
				break;
			case "popular":
				model.addAttribute("listProducts",this.productService.getProductsPopular());
				model.addAttribute("sort","Популярное");
				categories(model);
				break;
			case "new":
				model.addAttribute("listProducts",this.productService.getProductsNew());
				model.addAttribute("sort","Новинки");
				categories(model);
				break;
			case "asc":
				model.addAttribute("listProducts",this.productService.getProductsAsc());
				model.addAttribute("sort","От А до Я");
				categories(model);
				break;
		}

		return "index";
	}

	@RequestMapping(value = "/sort/{type}/{brand}")
	public String sortByBrand(@PathVariable("brand")String brand,
							  @PathVariable("type")String type,
							  Model model){
		model.addAttribute("listProducts",this.productService.getProductsByBrandByType(brand,type));
		model.addAttribute("sort",brand);
		categories(model);

		return "index";
	}

	private void categories(Model model){
		model.addAttribute("mobiles",this.categoryService.getBrandsByType("mobile"));
		model.addAttribute("notebooks",this.categoryService.getBrandsByType("notebook"));
		model.addAttribute("notepads",this.categoryService.getBrandsByType("notepad"));
	}

}