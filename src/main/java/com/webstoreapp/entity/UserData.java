package com.webstoreapp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserData {

    @Getter(lazy = false)
    @JsonProperty("_links")
    private List<Link> links = new ArrayList<>();

    public UserData addLink(String rel, String href) {
        this.links.add(new Link(rel, href));
        return this;
    }

    private String name;
    private String surname;
    private String streetName;
    private String houseNumber;
    private String appartmentNumber;
    private String postCode;
    private String cityName;
    private String countryName;

}
