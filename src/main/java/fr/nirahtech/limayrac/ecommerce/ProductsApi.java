package fr.nirahtech.limayrac.ecommerce;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductsApi {
    Page<Product> getAllProducts(Pageable pageable);
    Optional<Product> findProductById(Long id);

    void saveProduct(Product product);
    void deleteProduct(Long id);
}
