package fr.nirahtech.limayrac.ecommerce;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductsService implements ProductsApi {

    private final ProductsRepository productsRepository;

    public ProductsService(
        @Autowired ProductsRepository productsRepository
    ) {
        this.productsRepository = productsRepository;
    }


    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productsRepository.findById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productsRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
    
}
