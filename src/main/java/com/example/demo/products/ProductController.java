package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/")
	public Iterable<Product> index(){
		return productRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> show(@PathVariable Long id) {
		if(productRepo.existsById(id))
			return new ResponseEntity<String>(productRepo.find(id).toString(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Product Not Found", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> store(@RequestBody Product product) {
		productRepo.save(product);
		return new ResponseEntity<String>("Product Created!", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Product product)
	{
		if(productRepo.existsById(id)) {
			Product prod = productRepo.findById(id).get();
			prod.setName(product.getName());
			prod.setImage(product.getImage());
			prod.setPrice(product.getPrice());
			productRepo.save(prod);
			return new ResponseEntity<String>("Product Updated!!", HttpStatus.OK);
		}else
			return new ResponseEntity<String>("Product Not Found", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> destroy(@PathVariable Long id){
		if(productRepo.existsById(id)) {
			productRepo.deleteById(id);
			return new ResponseEntity<String>("Product Deleted!!", HttpStatus.OK);
		}else
			return new ResponseEntity<String>("Product Not Found", HttpStatus.NOT_FOUND);
	}
	
}

