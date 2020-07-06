package com.assignment.order.model;

import java.io.Serializable;
import java.util.Date;


import com.assignment.order.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order implements Serializable {
    
    private static final long serialVersionUID = 6156896887L;
    
    private Long id;
    @JsonProperty("items")
    private Item[] items;
    @JsonProperty("quantity")
    private Long quantity;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("createdAt")
    private Date createdAt;
    @JsonProperty("deliveryPersonId")
    private Long deliveryPersonId;
    @JsonProperty("tatDelivery")
    private Long tatDelivery;
    
}