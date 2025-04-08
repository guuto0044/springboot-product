package io.github.guuto0044.productapi.repository;

import io.github.guuto0044.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
