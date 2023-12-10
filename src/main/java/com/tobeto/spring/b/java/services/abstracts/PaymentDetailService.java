package com.tobeto.spring.b.java.services.abstracts;

import com.tobeto.spring.b.java.services.dtos.requests.paymentDetail.AddPaymentDetailRequest;
import com.tobeto.spring.b.java.services.dtos.requests.paymentDetail.UpdatePaymentDetailRequest;
import com.tobeto.spring.b.java.services.dtos.responses.paymentDetail.GetPaymentDetailResponse;

public interface PaymentDetailService {

    GetPaymentDetailResponse getById(int id);
    void add(AddPaymentDetailRequest addPaymentDetailRequest);
    void update(UpdatePaymentDetailRequest updatePaymentDetailRequest,int id);
    void delete(int id);
}
