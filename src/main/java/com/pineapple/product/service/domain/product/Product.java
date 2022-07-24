package com.pineapple.product.service.domain.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pineapple.product.service.restapi.serialization.DecimalSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="pna_product")
@Getter
@Setter
public class Product {
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name="descr")
    private String description;

    @Column(name="descr_add")
    private String additionalDescription;

    private String model;

    @JsonSerialize(using = DecimalSerializer.class)
    private BigDecimal price;

    @JsonSerialize(using = DecimalSerializer.class)
    private BigDecimal discount;

    @JsonSerialize(using = DecimalSerializer.class)
    private BigDecimal weight;

    private String dimensions;

    @Column(name="packing_weight")
    @JsonSerialize(using = DecimalSerializer.class)
    private BigDecimal packingWeight;

    @Column(name="packing_dim")
    private String packingDimensions;

    private Boolean active;

    public void update(final Product product){
        setName(product.getName());
        setDescription(product.getDescription());
        setAdditionalDescription(product.getAdditionalDescription());
        setModel(product.getModel());
        setPrice(product.getPrice());
        setDiscount(product.getDiscount());
        setWeight(product.getWeight());
        setDimensions(product.getDimensions());
        setPackingWeight(product.getPackingWeight());
        setPackingDimensions(product.getPackingDimensions());
        setActive(product.getActive());

    }
}
