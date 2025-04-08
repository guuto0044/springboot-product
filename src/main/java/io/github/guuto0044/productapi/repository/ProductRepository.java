package io.github.guuto0044.productapi.repository;

import io.github.guuto0044.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {

    List<Product>findByDescription(String description);

}
