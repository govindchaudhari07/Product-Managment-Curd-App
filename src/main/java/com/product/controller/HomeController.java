package com.product.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Products;
import com.product.service.ProductService;

@RestController
public class HomeController {

	@Autowired
	ProductService productServ;

	@GetMapping("/springstart")
	public String welcome()
	{
		return "welcome hi ";
	}
	@RequestMapping("/home")

	public String home(Model m) {
		System.out.println("first call");
		List<Products> list = productServ.findAll();
		m.addAttribute("all_products", list);
		return "index";
	}

	@RequestMapping(value = "/save_products", method = RequestMethod.GET)
	@ResponseBody
	public void saveProducts(Products products, HttpSession session) {

		System.out.println("  in addd controller  " + products);
		productServ.saveProduct(products);
		System.out.println("     out   ");

	}

	@RequestMapping(value = "/load_form", method = RequestMethod.GET)
	@ResponseBody
	public String loadform() {
		return "add";
	}

	@RequestMapping(value = "/edit_form", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Products> editForm(long id, Model m) {
		Optional<Products> product = productServ.findById(id);

		return product;
	}

	@RequestMapping(value = "/update_products", method = RequestMethod.GET)
	@ResponseBody
	public String updateProducts(@ModelAttribute Products products, HttpSession session) {
		productServ.save(products);
		session.setAttribute("msg", "product update Sucessfully..");

		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public String deleteProducts(Long id, HttpSession session) {
		
		productServ.deleteById(id);
		session.setAttribute("msg", "product delete Sucessfully..");
		return null;

	}

	@RequestMapping(value = "/feth-all-std-list", method = RequestMethod.GET)
	@ResponseBody
	public List<Products> getdata() {
		System.out.println("getting data");
		List<Products> list = productServ.getdataproducts();

		return list;
	}

}
