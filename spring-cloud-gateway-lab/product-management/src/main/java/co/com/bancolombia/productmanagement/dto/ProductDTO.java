package co.com.bancolombia.productmanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
}
