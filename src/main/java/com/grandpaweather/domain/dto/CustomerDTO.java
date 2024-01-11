package com.grandpaweather.domain.dto;


import com.grandpaweather.domain.Customer;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String name;
    private String productURI;
    private String productImageURI;
    private double price;
    private int priority;

    public static CustomerDTO createFromEntity(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setName(customer.getName());
        dto.setProductURI(customer.getProductURI());
        dto.setProductImageURI(customer.getProductImageURI());
        dto.setPrice(customer.getPrice());
        dto.setPriority(customer.getPriority());
        return dto;

    }

}
