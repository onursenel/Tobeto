package com.tobeto.spring.b.java.controllers;

import com.tobeto.spring.b.java.services.abstracts.InvoiceDetailService;
import com.tobeto.spring.b.java.services.dtos.requests.invoiceDetail.AddInvoiceDetailRequest;
import com.tobeto.spring.b.java.services.dtos.requests.invoiceDetail.UpdateInvoiceDetailRequest;
import com.tobeto.spring.b.java.services.dtos.responses.invoiceDetail.GetInvoiceDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/invoice_details")
public class InvoiceDetailsController {

    private final InvoiceDetailService invoiceDetailService;


    @GetMapping("{id}")
    public GetInvoiceDetailResponse getById(@PathVariable int id) {
        return invoiceDetailService.getById(id);
    }


    @PostMapping
    public void add(@RequestBody AddInvoiceDetailRequest addInvoiceDetailRequest) {
        invoiceDetailService.add(addInvoiceDetailRequest);
    }


    @PutMapping("{id}")
    public void update(@RequestBody UpdateInvoiceDetailRequest updateInvoiceDetailRequest,@PathVariable int id) {
        invoiceDetailService.update(updateInvoiceDetailRequest,id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        invoiceDetailService.delete(id);
    }
}
