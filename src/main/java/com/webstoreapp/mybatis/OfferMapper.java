package com.webstoreapp.mybatis;

import com.webstoreapp.entity.Offer;
import org.apache.ibatis.annotations.Param;

public interface OfferMapper {

    void insertOffer(Offer offer);

    Offer selectOfferById(Long id);

    void updateOffer(@Param("id") Long id, @Param("offer") Offer offer);

    void deleteOfferById(Long id);

}
