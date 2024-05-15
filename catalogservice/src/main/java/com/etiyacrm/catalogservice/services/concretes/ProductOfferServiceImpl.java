package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.ProductOffer;
import com.etiyacrm.catalogservice.repositories.ProductOfferRepository;
import com.etiyacrm.catalogservice.services.abstracts.ProductOfferService;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.CreateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.UpdateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.CreatedProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.DeletedProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.GetProductOfferResponse;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.UpdatedProductOfferResponse;
import com.etiyacrm.catalogservice.services.mappers.ProductOfferMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ProductOfferServiceImpl implements ProductOfferService {
    private ProductOfferRepository productOfferRepository;

    @Override
    public CreatedProductOfferResponse add(CreateProductOfferRequest createProductOfferRequest) {
        ProductOffer productOffer = ProductOfferMapper.INSTANCE.productOfferFromCreateProductOfferRequest(createProductOfferRequest);
        ProductOffer createdProductOffer = productOfferRepository.save(productOffer);
        CreatedProductOfferResponse response = ProductOfferMapper.INSTANCE.createdProductOfferResponseFromProductOffer(createdProductOffer);
        return response;
    }

    @Override
    public UpdatedProductOfferResponse update(UpdateProductOfferRequest updateProductOfferRequest) {
        // ProductOffer productOffer = productOfferRepository.findById(updateProductOfferRequest.getId()).get();
        ProductOffer updatedProductOffer = ProductOfferMapper.INSTANCE.productOfferFromUpdateProductOfferRequest(updateProductOfferRequest);
        updatedProductOffer = productOfferRepository.save(updatedProductOffer);
        UpdatedProductOfferResponse response = ProductOfferMapper.INSTANCE.updatedProductOfferResponseFromProductOffer(updatedProductOffer);
        return response;
    }

    @Override
    public GetProductOfferResponse getById(String id) {
        ProductOffer productOffer = productOfferRepository.findById(id).get();
        GetProductOfferResponse response = ProductOfferMapper.INSTANCE.getProductOfferResponseFromProductOffer(productOffer);
        return response;
    }

    @Override
    public DeletedProductOfferResponse softDelete(String id) {
        ProductOffer productOffer = productOfferRepository.findById(id).get();
        productOffer.setDeletedDate(LocalDateTime.now());
        productOfferRepository.save(productOffer);
        DeletedProductOfferResponse response = ProductOfferMapper.INSTANCE.deleteProductOfferResponseFromProductOffer(productOffer);
        return response;
    }

}
