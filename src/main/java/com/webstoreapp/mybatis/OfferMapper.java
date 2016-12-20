package com.webstoreapp.mybatis;

import com.webstoreapp.entity.Offer;
import org.apache.ibatis.annotations.Param;

public interface OfferMapper {

    void insertOffer(Offer offer);

    Offer selectOfferById(Integer id);

    void updateOffer(@Param("id") Integer id, @Param("offer") Offer offer);

    void deleteOfferById(Integer id);

}
