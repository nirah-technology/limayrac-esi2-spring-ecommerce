package fr.nirahtech.limayrac.ecommerce;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/products")
public class ProductsEcommerceRestController implements ProductsApi {

    private final ProductsService productsService;

    public ProductsEcommerceRestController(
        @Autowired ProductsService productsService
    ) {
        this.productsService = productsService;
    }

    @GetMapping("")
    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return this.productsService.getAllProducts(pageable);
    }

    @GetMapping(value="/{id}")
    @Override
    public Optional<Product> findProductById(@RequestParam(value = "id", required = true) Long id) {
        return this.productsService.findProductById(id);
    }

    @PostMapping(value="", consumes = "application/json")
    @Override
    public void saveProduct(@RequestBody(required = true) Product product) {
        this.productsService.saveProduct(product);
    }

    @DeleteMapping(value="/{id}")
    @Override
    public void deleteProduct(@RequestParam(value = "id", required = true) Long id) {
        this.productsService.deleteProduct(id);
    }
    
}
