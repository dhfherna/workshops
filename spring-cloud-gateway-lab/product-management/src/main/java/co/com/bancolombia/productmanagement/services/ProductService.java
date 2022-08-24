package co.com.bancolombia.productmanagement.services;

import co.com.bancolombia.productmanagement.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private List<ProductDTO> listProducts;

    public List<ProductDTO> listProducts() {
        return listProducts;
    }

    public ProductDTO getProductById(Integer id) {
        return listProducts.stream()
                .filter(product -> id.equals(product.getId()))
                .findFirst()
                .orElse(null);
    }

    public ProductDTO createProduct(ProductDTO insert) {
        insert.setId(listProducts.size()+1);
        listProducts.add(insert);
        return insert;
    }
}
