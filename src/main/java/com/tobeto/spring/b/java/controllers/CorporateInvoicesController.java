package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.abstracts.CorporateInvoiceService;
import com.tobeto.spring.b.java.services.dtos.requests.corporateInvoice.AddCorporateInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.requests.corporateInvoice.UpdateCorporateInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.responses.corporateInvoice.GetCorporateInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/corporate_invoices")
public class CorporateInvoicesController {

    private final CorporateInvoiceService corporateInvoiceService;


    @GetMapping("{id}")
    public GetCorporateInvoiceResponse getById(int id){
        return corporateInvoiceService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCorporateInvoiceRequest addCorporateInvoiceRequest) {
        corporateInvoiceService.add(addCorporateInvoiceRequest);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateCorporateInvoiceRequest updateCorporateInvoiceRequest,@PathVariable int id) {
        corporateInvoiceService.update(updateCorporateInvoiceRequest,id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        corporateInvoiceService.delete(id);
    }

}
