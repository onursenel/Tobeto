package com.tobeto.spring.b.java.services.concretes;



import com.tobeto.spring.b.java.entities.IndividualInvoice;
import com.tobeto.spring.b.java.entities.InvoiceDetail;
import com.tobeto.spring.b.java.repostories.InvoiceDetailRepository;
import com.tobeto.spring.b.java.services.abstracts.InvoiceDetailService;

import com.tobeto.spring.b.java.services.dtos.requests.invoiceDetail.AddInvoiceDetailRequest;
import com.tobeto.spring.b.java.services.dtos.requests.invoiceDetail.UpdateInvoiceDetailRequest;
import com.tobeto.spring.b.java.services.dtos.responses.invoiceDetail.GetInvoiceDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InvoiceDetailManager implements InvoiceDetailService{
    private final InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public GetInvoiceDetailResponse getById(int id) {
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findById(id).orElseThrow();


        GetInvoiceDetailResponse invoiceDetailDto = new GetInvoiceDetailResponse();
        invoiceDetailDto.setDescription(invoiceDetail.getDescription());
        invoiceDetailDto.setType(invoiceDetail.getType());

        return invoiceDetailDto;

    }

    @Override
    public void add(AddInvoiceDetailRequest addInvoiceDetailRequest) {
        InvoiceDetail invoiceDetail = new InvoiceDetail();

        invoiceDetail.setDescription(addInvoiceDetailRequest.getDescription());
        invoiceDetail.setType(addInvoiceDetailRequest.getType());

        invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public void update(UpdateInvoiceDetailRequest updateInvoiceDetailRequest,int id) {
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findById(id).orElseThrow();

        invoiceDetail.setDescription(updateInvoiceDetailRequest.getDescription());
        invoiceDetail.setType(updateInvoiceDetailRequest.getType());

        invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public void delete(int id) {
        invoiceDetailRepository.deleteById(id);
    }
}
