package com.webstoreapp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Offer {

    private String title;
    private String description;
    private String imgPath;
    private BigDecimal price;
    private Integer userId;
    private Category category;
    private Condition condition;

    public Offer(String title, String description, String imgPath, String category, BigDecimal price, Integer userId, String condition) {
        this.title = title;
        this.description = description;
        this.imgPath = imgPath;
        this.category = Category.valueOf(category);
        this.price = price;
        this.userId = userId;
        this.condition = Condition.valueOf(condition);
    }

    private enum Condition {
        NEW, USED
    }

    private enum Category {
        ANTIQUES, ART, BABY, BEAUTY, BOOKS, BUSINESS, CLOTHING, GAMES, HEALTH, JEWELRY, MUSIC, OTHER, PET, PHOTOGRAPHY, SPORT, TOYS
    }

}
