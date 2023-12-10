package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.paymentMethod.AddPaymentMethodRequest;
import com.tobeto.spring.b.java.services.dtos.requests.paymentMethod.UpdatePaymentMethodRequest;
import com.tobeto.spring.b.java.services.dtos.responses.paymentMethod.GetPaymentMethodResponse;

public interface PaymentMethodService {

    GetPaymentMethodResponse getById(int id);
    void add(AddPaymentMethodRequest addPaymentMethodRequest);
    void update(UpdatePaymentMethodRequest updatePaymentMethodRequest,int id);
    void delete(int id);

}
