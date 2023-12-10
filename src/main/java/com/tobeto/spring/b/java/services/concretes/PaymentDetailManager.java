package com.tobeto.spring.b.java.services.concretes;

import com.tobeto.spring.b.java.entities.PaymentDetail;
import com.tobeto.spring.b.java.repostories.PaymentDetailRepository;
import com.tobeto.spring.b.java.services.abstracts.PaymentDetailService;
import com.tobeto.spring.b.java.services.dtos.requests.paymentDetail.AddPaymentDetailRequest;
import com.tobeto.spring.b.java.services.dtos.requests.paymentDetail.UpdatePaymentDetailRequest;
import com.tobeto.spring.b.java.services.dtos.responses.paymentDetail.GetPaymentDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class PaymentDetailManager implements PaymentDetailService {

    private final PaymentDetailRepository paymentDetailRepository;

    @Override
    public GetPaymentDetailResponse getById(int id) {
        PaymentDetail paymentDetail = paymentDetailRepository.findById(id).orElseThrow();

        GetPaymentDetailResponse paymentDetailDto = new GetPaymentDetailResponse();

        paymentDetailDto.setTransactionDate(paymentDetail.getTransactionDate());

        return paymentDetailDto;
    }

    @Override
    public void add(AddPaymentDetailRequest addPaymentDetailRequest) {
        PaymentDetail paymentDetail = new PaymentDetail();

        paymentDetail.setTransactionDate(addPaymentDetailRequest.getTransactionDate());

        paymentDetailRepository.save(paymentDetail);
    }

    @Override
    public void update(UpdatePaymentDetailRequest updatePaymentDetailRequest,int id) {
        PaymentDetail paymentDetail = paymentDetailRepository.findById(id).orElseThrow();

        paymentDetail.setTransactionDate(updatePaymentDetailRequest.getTransactionDate());

        paymentDetailRepository.save(paymentDetail);

    }

    @Override
    public void delete(int id) {
        paymentDetailRepository.deleteById(id);

    }
}
