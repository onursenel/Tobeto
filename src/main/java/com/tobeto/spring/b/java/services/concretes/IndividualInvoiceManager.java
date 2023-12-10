package com.tobeto.spring.b.java.services.concretes;

import com.tobeto.spring.b.java.entities.Brand;
import com.tobeto.spring.b.java.entities.IndividualInvoice;
import com.tobeto.spring.b.java.repostories.IndividualInvoiceRepository;
import com.tobeto.spring.b.java.services.abstracts.IndividualInvoiceService;
import com.tobeto.spring.b.java.services.dtos.requests.individualInvoice.AddIndividualInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.requests.individualInvoice.UpdateIndividualInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.individualInvoice.GetIndividualInvoiceListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.individualInvoice.GetIndividualInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class IndividualInvoiceManager implements IndividualInvoiceService {

    private final IndividualInvoiceRepository individualInvoiceRepository;


    @Override
    public List<GetIndividualInvoiceListResponse> getByNameLike(String name) {
        List<IndividualInvoice> individualInvoices = individualInvoiceRepository.findByNameLike("%"+name+"%");
        List<GetIndividualInvoiceListResponse> response = new ArrayList<>();

        for (IndividualInvoice individualInvoice:individualInvoices) {
            response.add(new GetIndividualInvoiceListResponse(individualInvoice.getName(),individualInvoice.getSurname(),individualInvoice.getAmount()));

        }
        return response;
    }

    @Override
    public List<GetIndividualInvoiceListResponse> getByAddress(String address) {
        List<IndividualInvoice> individualInvoices = individualInvoiceRepository.findByAddress(address);
        List<GetIndividualInvoiceListResponse> response = new ArrayList<>();

        for (IndividualInvoice individualInvoice:individualInvoices) {
            response.add(new GetIndividualInvoiceListResponse(individualInvoice.getName(),individualInvoice.getSurname(),individualInvoice.getAmount()));

        }
        return response;
    }

    @Override
    public List<GetIndividualInvoiceListResponse> searchName(String name) {
        return individualInvoiceRepository.searchName(name);
    }

    @Override
    public List<GetIndividualInvoiceListResponse> orderAmount() {
        return individualInvoiceRepository.orderAmount();
    }

    @Override
    public List<GetIndividualInvoiceListResponse> getAll() {
        List<IndividualInvoice> individualInvoices = individualInvoiceRepository.findAll();
        List<GetIndividualInvoiceListResponse> getIndividualInvoiceResponseList = new ArrayList<>();

        for (IndividualInvoice individualInvoice:individualInvoices) {
            GetIndividualInvoiceListResponse response = new GetIndividualInvoiceListResponse();
            response.setName(individualInvoice.getName());
            response.setSurname(individualInvoice.getSurname());
            response.setAmount(individualInvoice.getAmount());
            getIndividualInvoiceResponseList.add(response);

        }
        return getIndividualInvoiceResponseList;
    }

    @Override
    public GetIndividualInvoiceResponse getById(int id) {
        IndividualInvoice individualInvoice = individualInvoiceRepository.findById(id).orElseThrow();

        //mapping
        GetIndividualInvoiceResponse individualInvoiceDto = new GetIndividualInvoiceResponse();
        individualInvoiceDto.setName(individualInvoice.getName());
        individualInvoiceDto.setAmount(individualInvoice.getAmount());

        return individualInvoiceDto;
    }

    @Override
    public void add(AddIndividualInvoiceRequest addIndividualInvoiceRequest) {
        IndividualInvoice individualInvoice = new IndividualInvoice();

        individualInvoice.setName(addIndividualInvoiceRequest.getName());
        individualInvoice.setSurname(addIndividualInvoiceRequest.getSurname());
        individualInvoice.setAmount(addIndividualInvoiceRequest.getAmount());
        individualInvoice.setAddress(addIndividualInvoiceRequest.getAddress());

        individualInvoiceRepository.save(individualInvoice);

    }

    @Override
    public void update(UpdateIndividualInvoiceRequest updateIndividualInvoiceRequest, int id) {
        IndividualInvoice individualInvoice = individualInvoiceRepository.findById(id).orElseThrow();

        individualInvoice.setName(updateIndividualInvoiceRequest.getName());
        individualInvoice.setSurname(updateIndividualInvoiceRequest.getSurname());
        individualInvoice.setAmount(updateIndividualInvoiceRequest.getAmount());
        individualInvoice.setAddress(updateIndividualInvoiceRequest.getAddress());

        individualInvoiceRepository.save(individualInvoice);

    }

    @Override
    public void delete(int id) {
        individualInvoiceRepository.deleteById(id);
    }
}
