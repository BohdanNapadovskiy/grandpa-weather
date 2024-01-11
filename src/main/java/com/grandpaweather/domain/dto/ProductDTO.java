package com.grandpaweather.domain.dto;


import com.grandpaweather.domain.Product;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String id;
    private String category;
    private String name;
    private List<CustomerDTO> customers;
    private int priority;



    public static ProductDTO buildDTOFromEntity(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId()) ;
        dto.setCategory(product.getCategory());
        dto.setName(product.getName());
        dto.setCustomers(product.getCustomers().stream().map(CustomerDTO::createFromEntity).collect(Collectors.toList()));
        dto.setPriority(product.getPriority());
        return dto;
    }

}
