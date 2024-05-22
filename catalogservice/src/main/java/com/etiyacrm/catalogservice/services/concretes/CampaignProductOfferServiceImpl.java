package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.CampaignProductOffer;
import com.etiyacrm.catalogservice.repositories.CampaignProductOfferRepository;
import com.etiyacrm.catalogservice.services.abstracts.CampaignProductOfferService;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOffer.CreateCampaignProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOffer.UpdateCampaignProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaignProductOffer.*;
import com.etiyacrm.catalogservice.services.mappers.CampaignProductOfferMapper;
import com.etiyacrm.common.business.paging.PageInfo;
import com.etiyacrm.common.business.responses.GetListResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CampaignProductOfferServiceImpl implements CampaignProductOfferService {
    CampaignProductOfferRepository campaignProductOfferRepository;

    @Override
    public CreatedCampaignProductOfferResponse add(CreateCampaignProductOfferRequest createCampaignProductOfferRequest) {
       CampaignProductOffer campaignProductOffer=CampaignProductOfferMapper.INSTANCE.campaignProductOfferFromCreateCampaignProductOfferRequest(createCampaignProductOfferRequest);
       CampaignProductOffer createdCampaignProductOffer=campaignProductOfferRepository.save(campaignProductOffer);

       CreatedCampaignProductOfferResponse response=CampaignProductOfferMapper.INSTANCE.createdCampaignProductOfferResponseFromCampaignProductOffer(createdCampaignProductOffer);
       return response;

    }

    @Override
    public UpdatedCampaignProductOfferResponse update(UpdateCampaignProductOfferRequest updateCampaignProductOfferRequest) {
       CampaignProductOffer campaignProductOffer=CampaignProductOfferMapper.INSTANCE.campaignProductOfferFromUpdateCampaignProductOfferRequest(updateCampaignProductOfferRequest);
       CampaignProductOffer updatedCampaignProductOffer=campaignProductOfferRepository.save(campaignProductOffer);

       UpdatedCampaignProductOfferResponse response=CampaignProductOfferMapper.INSTANCE.updatedCampaignProductOfferResponseFromCampaignProductOffer(updatedCampaignProductOffer);
       return response;
    }

    @Override
    public GetCampaignProductOfferResponse getById(String id) {
        CampaignProductOffer campaignProductOffer = campaignProductOfferRepository.findById(id).get();
        GetCampaignProductOfferResponse response = CampaignProductOfferMapper.INSTANCE.getCampaignProductOfferResponseFromCampaignProductOffer(campaignProductOffer);
        return response;
    }

    @Override
    public GetListResponse<GetAllCampaignProductOfferResponse> getAllWithPaging(PageInfo pageInfo) {
        Pageable pageable= PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<CampaignProductOffer> response=campaignProductOfferRepository.findAll(pageable);

        GetListResponse<GetAllCampaignProductOfferResponse> responses=CampaignProductOfferMapper.INSTANCE.pageInfoResponseFromPageCampaignProductOffer(response);
        responses.setHasNext(response.hasNext());
        responses.setHasPrevious(response.hasPrevious());
        responses.setPage(pageInfo.getPage());
        return responses;
    }


    @Override
    public DeletedCampaignProductOfferResponse softDelete(String id) {
        CampaignProductOffer campaignProductOffer= campaignProductOfferRepository.findById(id).get();
        campaignProductOffer.setDeletedDate(LocalDateTime.now());
        CampaignProductOffer deletedCampaignProductOffer= campaignProductOfferRepository.save(campaignProductOffer);
        DeletedCampaignProductOfferResponse response=CampaignProductOfferMapper.INSTANCE.deletedCampaignProductOfferResponseFromCampaignProductOffer(deletedCampaignProductOffer);
        return response;
    }


}
