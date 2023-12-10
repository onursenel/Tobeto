package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.abstracts.IndividualInvoiceService;
import com.tobeto.spring.b.java.services.dtos.requests.individualInvoice.AddIndividualInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.requests.individualInvoice.UpdateIndividualInvoiceRequest;
import com.tobeto.spring.b.java.services.dtos.responses.individualInvoice.GetIndividualInvoiceListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.individualInvoice.GetIndividualInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/individual_invoices")
public class IndividualInvoicesController {
    private final IndividualInvoiceService individualInvoiceService;

    @GetMapping("getAll")
    public List<GetIndividualInvoiceListResponse> getAll(){
        return individualInvoiceService.getAll();
    }


    @GetMapping("{id}")
    public GetIndividualInvoiceResponse getById(@PathVariable int id) {
        return individualInvoiceService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddIndividualInvoiceRequest addIndividualInvoiceRequest) {
       individualInvoiceService.add(addIndividualInvoiceRequest);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateIndividualInvoiceRequest updateIndividualInvoiceRequest,@PathVariable int id) {
        individualInvoiceService.update(updateIndividualInvoiceRequest,id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        individualInvoiceService.delete(id);
    }


    @GetMapping("individualInvoiceName")
    public List<GetIndividualInvoiceListResponse> getByNameLike(@RequestParam String name){
        return this.individualInvoiceService.getByNameLike(name);
    }

    @GetMapping("individualNameAddress")
    public List<GetIndividualInvoiceListResponse> getByAddress(@RequestParam String address){
        return this.individualInvoiceService.getByAddress(address);
    }

    @GetMapping("JPQLIndividualInvoiceName")
    public List<GetIndividualInvoiceListResponse> searchName(@RequestParam String name){
        return this.individualInvoiceService.searchName(name);
    }

    @GetMapping("orderAmount")
    public List<GetIndividualInvoiceListResponse> orderAmount(){
        return this.individualInvoiceService.orderAmount();
    }

}
