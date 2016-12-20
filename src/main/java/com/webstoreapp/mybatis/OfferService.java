package com.webstoreapp.mybatis;

import javax.inject.Inject;

import com.webstoreapp.entity.Offer;
import org.mybatis.cdi.Mapper;

public class OfferService {

    @Inject
    @Mapper
    private OfferMapper offerMapper;

    public Offer createOffer(Offer offer) {
        offerMapper.insertOffer(offer);
        return offer;
    }

    public Offer getOfferById(Integer id) {
        return offerMapper.selectOfferById(id);
    }

    public Offer updateOffer(Integer id, Offer offer) {
        offerMapper.updateOffer(id, offer);
        return offer;
    }

    public void deleteOfferById(Integer id) {
        offerMapper.deleteOfferById(id);
    }

}
