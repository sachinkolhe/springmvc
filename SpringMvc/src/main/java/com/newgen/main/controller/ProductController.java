package com.newgen.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.newgen.main.entites.Product;
import com.newgen.main.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //listing all the products
    @GetMapping
    public String listProducts(Model model) {
    	
    	//Step 1: fetching data from database
        List<Product> products = productService.findAll();
        
        
        
        //Step 2: setting up our model - spring model
        model.addAttribute("products", products);
        
        //Step 3: return a view: list
        return "list";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
    	
    	//this is new request . we are putting empty object in the model
        model.addAttribute("product", new Product());
    
        //this is view new.jsp
        return "new";
    
    }

    @PostMapping
    public String saveProduct(@ModelAttribute("product") Product product) {
        
    	//Step 1: saving the data into database
    	productService.save(product);
        
    	//Step 2: redirecting to another url
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        
    	//Step 1: fetch the data from database by id
    	Product product = productService.findById(id);
        
    	//Step 2: put the data into model
        model.addAttribute("product", product);
        
        //Step 3: returna view "edit"
        return "edit"; // WEB-INF/jsp/<edit>.jsp
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product) {
        product.setId(id);
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
