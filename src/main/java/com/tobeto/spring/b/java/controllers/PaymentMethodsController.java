package com.tobeto.spring.b.java.controllers;


import com.tobeto.spring.b.java.services.abstracts.PaymentMethodService;
import com.tobeto.spring.b.java.services.dtos.requests.paymentMethod.AddPaymentMethodRequest;
import com.tobeto.spring.b.java.services.dtos.requests.paymentMethod.UpdatePaymentMethodRequest;
import com.tobeto.spring.b.java.services.dtos.responses.paymentMethod.GetPaymentMethodResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/payment_methods")
public class PaymentMethodsController {
    private final PaymentMethodService paymentMethodService;


    @GetMapping("{id}")
    public GetPaymentMethodResponse getById(@PathVariable int id) {
        return paymentMethodService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddPaymentMethodRequest addPaymentMethodRequest) {
        paymentMethodService.add(addPaymentMethodRequest);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdatePaymentMethodRequest updatePaymentMethodRequest,@PathVariable int id) {
        paymentMethodService.update(updatePaymentMethodRequest,id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentMethodService.delete(id);
    }


}
