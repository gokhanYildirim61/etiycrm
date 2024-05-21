package com.etiyacrm.basketservice.services.concretes;

import com.etiyacrm.basketservice.clients.CatalogServiceClient;
import com.etiyacrm.basketservice.dtos.responses.GetCatalogProductOfferResponse;
import com.etiyacrm.basketservice.entities.Basket;
import com.etiyacrm.basketservice.entities.BasketItem;
import com.etiyacrm.basketservice.repositories.BasketRepository;
import com.etiyacrm.basketservice.services.abstracts.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {
    private BasketRepository basketRepository;
    private CatalogServiceClient catalogServiceClient;

    @Override
    public void add(String productOfferId) {
        Basket basket=new Basket();
        GetCatalogProductOfferResponse getCatalogProductOfferResponse=
                catalogServiceClient.getById(productOfferId);
        BasketItem basketItem=new BasketItem();
        basketItem.setProductOfferId(productOfferId);
        basketItem.setPrice(getCatalogProductOfferResponse.);
        basketItem.setProductOfferName(getCatalogProductOfferResponse;
    }
}
