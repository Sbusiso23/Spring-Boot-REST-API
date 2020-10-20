package com.example.category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.products.ProductRepository;

@RestController
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/category/nje")
	public String nje() {
		return "Okay it's working";
	}
	
	@GetMapping("/category")
	public Iterable<Category> index(){
		return categoryRepo.findAll();
	}
	
	@GetMapping("/category/{id}")
	public Optional<Category> show(@PathVariable Long id){
		return categoryRepo.findById(id);	
	}
	
	@PostMapping("/category/store")
	public ResponseEntity<String> store(@RequestBody Category category){
		categoryRepo.save(category);
		return new ResponseEntity<String>("Category Created", HttpStatus.CREATED);
	}
	
//	@GetMapping("/{id}/products")
//	public
}


