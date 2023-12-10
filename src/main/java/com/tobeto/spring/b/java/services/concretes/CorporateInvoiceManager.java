package com.tobeto.spring.b.java.services.concretes;

import com.tobeto.spring.b.java.entities.CorporateInvoice;
import com.tobeto.spring.b.java.repostories.CorporateInvoiceRepository;
import com.tobeto.spring.b.java.services.abstracts.CorporateInvoiceService;
import com.tobeto.spring.b.java.services.dtos.requests.corporateInvoice.AddCorporateInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.requests.corporateInvoice.UpdateCorporateInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.responses.corporateInvoice.GetCorporateInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CorporateInvoiceManager implements CorporateInvoiceService {

    private final CorporateInvoiceRepository corporateInvoiceRepository;


    @Override
    public GetCorporateInvoiceResponse getById(int id) {
        CorporateInvoice corporateInvoice = corporateInvoiceRepository.findById(id).orElseThrow();

        //mapping
        GetCorporateInvoiceResponse corporateInvoiceDto= new GetCorporateInvoiceResponse();
        corporateInvoiceDto.setContactName(corporateInvoice.getContactName());
        corporateInvoiceDto.setAmount(corporateInvoice.getAmount());

        return corporateInvoiceDto;
    }

    @Override
    public void add(AddCorporateInvoiceRequest addCorporateInvoiceRequest) {


        CorporateInvoice corporateInvoice = new CorporateInvoice();

        corporateInvoice.setContactName(addCorporateInvoiceRequest.getContactName());
        corporateInvoice.setContactAddress(addCorporateInvoiceRequest.getContactAddress());
        corporateInvoice.setPhoneNumber(addCorporateInvoiceRequest.getPhoneNumber());
        corporateInvoice.setTaxNumber(addCorporateInvoiceRequest.getTaxNumber());
        corporateInvoice.setAmount(addCorporateInvoiceRequest.getAmount());

        corporateInvoiceRepository.save(corporateInvoice);

    }

    @Override
    public void update(UpdateCorporateInvoiceRequest updateCorporateInvoiceRequest,int id) {
        CorporateInvoice corporateInvoice = corporateInvoiceRepository.findById(id).orElseThrow();

        corporateInvoice.setContactName(updateCorporateInvoiceRequest.getContactName());
        corporateInvoice.setContactAddress(updateCorporateInvoiceRequest.getContactAddress());
        corporateInvoice.setPhoneNumber(updateCorporateInvoiceRequest.getPhoneNumber());
        corporateInvoice.setTaxNumber(updateCorporateInvoiceRequest.getTaxNumber());
        corporateInvoice.setAmount(updateCorporateInvoiceRequest.getAmount());


        corporateInvoiceRepository.save(corporateInvoice);

    }

    @Override
    public void delete(int id) {
        corporateInvoiceRepository.deleteById(id);
    }
}
