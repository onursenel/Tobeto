package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.abstracts.PaymentDetailService;
import com.tobeto.spring.b.java.services.dtos.requests.paymentDetail.AddPaymentDetailRequest;
import com.tobeto.spring.b.java.services.dtos.requests.paymentDetail.UpdatePaymentDetailRequest;
import com.tobeto.spring.b.java.services.dtos.responses.paymentDetail.GetPaymentDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/payment_details")
public class PaymentDetailsController {
    private final PaymentDetailService paymentDetailService;


    @GetMapping("{id}")
    public GetPaymentDetailResponse getById(@PathVariable int id) {
        return paymentDetailService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddPaymentDetailRequest addPaymentDetailRequest) {
        paymentDetailService.add(addPaymentDetailRequest);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdatePaymentDetailRequest updatePaymentDetailRequest,@PathVariable int id) {
        paymentDetailService.update(updatePaymentDetailRequest,id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentDetailService.delete(id);
    }


}
