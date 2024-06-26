package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.ProductOffer;
import com.etiyacrm.catalogservice.repositories.ProductOfferRepository;
import com.etiyacrm.catalogservice.services.abstracts.ProductOfferService;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.CreateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productOffer.UpdateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productOffer.*;
import com.etiyacrm.catalogservice.services.mappers.ProductOfferMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductOfferServiceImpl implements ProductOfferService {
    private ProductOfferRepository productOfferRepository;

    @Override
    public CreatedProductOfferResponse add(CreateProductOfferRequest createProductOfferRequest) {
        ProductOffer productOffer =
                ProductOfferMapper.INSTANCE.productOfferFromCreateProductOfferRequest(createProductOfferRequest);
        ProductOffer createdProductOffer = productOfferRepository.save(productOffer);

        CreatedProductOfferResponse createdProductOfferResponse =
                ProductOfferMapper.INSTANCE.createdProductOfferResponseFromProductOffer(createdProductOffer);

        return createdProductOfferResponse;
    }

    @Override
    public UpdatedProductOfferResponse update(UpdateProductOfferRequest updateProductOfferRequest) {
        ProductOffer productOffer =
                ProductOfferMapper.INSTANCE.productOfferFromUpdateProductOfferRequest(updateProductOfferRequest);
        //productOffer.setId(updateProductOfferRequest.getId());
        productOffer.setUpdatedDate(LocalDateTime.now());
        ProductOffer updatedProductOffer = productOfferRepository.save(productOffer);

        UpdatedProductOfferResponse updatedProductOfferResponse =
                ProductOfferMapper.INSTANCE.updatedProductOfferResponseFromProductOffer(updatedProductOffer);

        return updatedProductOfferResponse;
    }

    @Override
    public List<GetAllProductOfferResponse> getAll() {
        List<ProductOffer> productOfferList = productOfferRepository.findAll();
        List<GetAllProductOfferResponse> getAllProductOfferResponseList =
                productOfferList.stream().map(ProductOfferMapper.INSTANCE::getAllProductOfferResponseFromProductOffer)
                        .collect(Collectors.toList());

        return getAllProductOfferResponseList;
    }

    @Override
    public GetProductOfferResponse getById(String id) {
        ProductOffer productOffer = productOfferRepository.findById(id).get();
        GetProductOfferResponse getProductOfferResponse =
                ProductOfferMapper.INSTANCE.getProductOfferResponseFromCProductOffer(productOffer);

        return getProductOfferResponse;
    }

    @Override
    public DeletedProductOfferResponse delete(String id) {
        ProductOffer productOffer = productOfferRepository.findById(id).get();
        productOffer.setId(id);
        productOffer.setDeletedDate(LocalDateTime.now());
        ProductOffer deletedProductOffer = productOfferRepository.save(productOffer);

        DeletedProductOfferResponse deletedProductOfferResponse =
                ProductOfferMapper.INSTANCE.deletedProductOfferResponseFromProductOffer(deletedProductOffer);

        return deletedProductOfferResponse;
    }

}
