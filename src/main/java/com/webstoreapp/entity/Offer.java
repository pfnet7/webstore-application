package com.webstoreapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Offer {

    @Getter(lazy = false)
    @JsonProperty("_links")
    private List<Link> links = new ArrayList<>();

    public Offer addLink(String rel, String href) {
        this.links.add(new Link(rel, href));
        return this;
    }

    @JsonIgnore
    private Integer id;

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
