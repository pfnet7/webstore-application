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

    public Offer getOfferById(Long id) {
        return offerMapper.selectOfferById(id);
    }

    public Offer updateOffer(Long id, Offer offer) {
        offerMapper.updateOffer(id, offer);
        return offer;
    }

    public void deleteOfferById(Long id) {
        offerMapper.deleteOfferById(id);
    }

}
