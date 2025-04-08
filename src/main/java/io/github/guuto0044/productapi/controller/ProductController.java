package io.github.guuto0044.productapi.controller;

import io.github.guuto0044.productapi.model.Product;
import io.github.guuto0044.productapi.repository.ProductRepository;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @PostMapping("/post")
    public Product save(@RequestBody Product product){
        String id = UUID.randomUUID().toString();
        product.setId(id);
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable String id){
//        Optional<Product>findbyId = productRepository.findById(id);
//        return findbyId.orElseGet(null);
        return productRepository.findById(id).orElseGet(null);
    }

    @PutMapping("/{id}")
    public void Updated(@PathVariable String id, @RequestBody Product product){
        product.setId(id);
        productRepository.save(product);
    }

    @GetMapping("/description")
    public List<Product>findByDescription(@RequestParam String description){
        return productRepository.findByDescription(description);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        productRepository.deleteById(id);
    }

}
