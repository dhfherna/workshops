package co.com.bancolombia.productmanagement.configuration;

import co.com.bancolombia.productmanagement.dto.ProductDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DummyConfig {

    private List<ProductDTO> listProductsDummy = new ArrayList<>();

    @Bean
    protected List<ProductDTO> getListProductsDummy() {
        listProductsDummy.add(ProductDTO.builder()
                .id(1).name("Leche").description("Leche descremada")
                .build());
        listProductsDummy.add(ProductDTO.builder()
                .id(2).name("Arroz").description("Arroz de coco")
                .build());
        listProductsDummy.add(ProductDTO.builder()
                .id(3).name("Carne").description("Carne de res")
                .build());
        return listProductsDummy;
    }
}
