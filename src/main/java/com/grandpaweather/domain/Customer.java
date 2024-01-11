package com.grandpaweather.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer  {

    private String name;
    private String productURI;
    private String productImageURI;
    private double price;
    private int priority;

}
