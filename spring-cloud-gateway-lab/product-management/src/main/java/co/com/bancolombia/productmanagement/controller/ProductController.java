package co.com.bancolombia.productmanagement.controller;

import co.com.bancolombia.productmanagement.dto.ProductDTO;
import co.com.bancolombia.productmanagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService prodService;

    @GetMapping("/list")
    private ResponseEntity<List<ProductDTO>> listProducts() {
        return ResponseEntity.ok(prodService.listProducts());
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(prodService.getProductById(id));
    }

    @PostMapping("/create")
    private ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO request) {
        return ResponseEntity.ok(prodService.createProduct(request));
    }
}
