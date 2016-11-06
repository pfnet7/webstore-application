package com.webstoreapp.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Offer {

    private String title;
    private String description;
    private String imgPath;
    private String category;
    private BigDecimal price;
    private Integer userId;
    private Condition condition;

    public Offer(String title, String description, String imgPath, String category, BigDecimal price, Integer userId, String condition) {
        this.title = title;
        this.description = description;
        this.imgPath = imgPath;
        this.category = category;
        this.price = price;
        this.userId = userId;
        this.condition = Condition.valueOf(condition);
    }

    private enum Condition {
        NEW, USED
    }

}
