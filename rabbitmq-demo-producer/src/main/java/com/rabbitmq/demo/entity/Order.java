package com.rabbitmq.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private String id;
    private String name;
}
