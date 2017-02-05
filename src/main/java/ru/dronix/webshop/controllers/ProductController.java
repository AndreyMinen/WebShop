package ru.dronix.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dronix.webshop.service.CategoryService;
import ru.dronix.webshop.service.ProductService;

import javax.servlet.http.HttpServletRequest;


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
		model.addAttribute("link","sort");

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

	@RequestMapping(value = "/types/{type}")
	public String listByTypes(@PathVariable("type")String type,Model model){
		model.addAttribute("listProducts",this.productService.getProductsByType(type));
		model.addAttribute("link","types/"+type);

		changeType(model,type);

		categories(model);

		return "index";
	}

	@RequestMapping(value = "/types/{type}/{sort}")
	public String listByTypes(@PathVariable("type")String type,
							  @PathVariable("sort")String sort,
							  Model model){
		model.addAttribute("listProducts",this.productService.getProductsByTypeSort(type, sort));
		model.addAttribute("link","types/"+type);



		changeType(model,type);
		categories(model);

		return "index";
	}

	@RequestMapping(value = "/list/{type}/{brand}")
	public String listProducts(@PathVariable("type")String type,
							   @PathVariable("brand")String brand,
							   Model model){
		model.addAttribute("listProducts",this.productService.getProductsByBrandByType(brand,type));
		model.addAttribute("sort",brand);
		model.addAttribute("link",String.format("list/%s/%s",type,brand));

		categories(model);
		return "index";
	}

	@RequestMapping(value = "/list/{type}/{brand}/{sort}")
	public String listProductsSort(@PathVariable("type")String type,
								   @PathVariable("brand")String brand,
								   @PathVariable("sort")String sort,
								   Model model){
		model.addAttribute("listProducts",this.productService.getProductsByBrandByTypeSort(type,brand,sort));
		model.addAttribute("link",String.format("list/%s/%s",type,brand));

		changeSort(sort,model);
		categories(model);
		return "index";
	}

	@RequestMapping(value = "/filter")
	public String filter(HttpServletRequest request,Model model){
		StringBuilder query=new StringBuilder("SELECT * FROM db_shop.table_products");
		query.append(" WHERE price BETWEEN "
				+request.getParameterValues("start_price")[0]
				+" AND "
				+request.getParameterValues("end_price")[0]
				+" AND visible='1' AND");

		for(String brand:request.getParameterValues("brands")){
			query.append(" brand='"+brand+"' OR");
		}

		model.addAttribute("listProducts",this.productService.createSQLQuery(query.toString().substring(0,query.length()-3)));

		categories(model);
		return "index";
	}

	private void categories(Model model){
		model.addAttribute("mobiles",this.categoryService.getBrandsByType("mobile"));
		model.addAttribute("notebooks",this.categoryService.getBrandsByType("notebook"));
		model.addAttribute("notepads",this.categoryService.getBrandsByType("notepad"));
	}

	private void changeSort(String sort,Model model){
		switch (sort){
			case "ascPrice":
				model.addAttribute("sort","От дешовых к дорогим");
				break;
			case "descPrice":
				model.addAttribute("sort","От дорогих к дешовым");
				break;
			case "popular":
				model.addAttribute("sort","Популярное");
				break;
			case "new":
				model.addAttribute("sort","Новинки");
				break;
			case "asc":
				model.addAttribute("sort","От А до Я");
				break;
		}
	}

	private void changeType(Model model,String type){
		switch (type){
			case "mobile":
				model.addAttribute("sort","Мобильные телефоны");
				break;
			case "notebook":
				model.addAttribute("sort","Ноутбуки");
				break;
			case "notepad":
				model.addAttribute("sort","Планшеты");
				break;
		}
	}

}