package com.tobeto.spring.b.java.services.concretes;


import com.tobeto.spring.b.java.entities.PaymentMethod;
import com.tobeto.spring.b.java.repostories.PaymentDetailRepository;
import com.tobeto.spring.b.java.repostories.PaymentMethodRepository;
import com.tobeto.spring.b.java.services.abstracts.PaymentMethodService;
import com.tobeto.spring.b.java.services.dtos.requests.paymentMethod.AddPaymentMethodRequest;
import com.tobeto.spring.b.java.services.dtos.requests.paymentMethod.UpdatePaymentMethodRequest;
import com.tobeto.spring.b.java.services.dtos.responses.paymentMethod.GetPaymentMethodResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentMethodManager implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;
    @Override
    public GetPaymentMethodResponse getById(int id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow();

        GetPaymentMethodResponse paymentMethodDto = new GetPaymentMethodResponse();
        paymentMethodDto.setType(paymentMethod.getType());
        paymentMethodDto.setMoneyType(paymentMethod.getMoneyType());

        return paymentMethodDto;
    }

    @Override
    public void add(AddPaymentMethodRequest addPaymentMethodRequest) {
        PaymentMethod paymentMethod = new PaymentMethod();


        paymentMethod.setType(addPaymentMethodRequest.getType());
        paymentMethod.setCreditCardInformation(addPaymentMethodRequest.getCreditCardInformation());
        paymentMethod.setMoneyType(addPaymentMethodRequest.getMoneyType());

        paymentMethodRepository.save(paymentMethod);

    }

    @Override
    public void update(UpdatePaymentMethodRequest updatePaymentMethodRequest, int id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow();

        paymentMethod.setType(updatePaymentMethodRequest.getType());
        paymentMethod.setCreditCardInformation(updatePaymentMethodRequest.getCreditCardInformation());
        paymentMethod.setMoneyType(updatePaymentMethodRequest.getMoneyType());

        paymentMethodRepository.save(paymentMethod);

    }

    @Override
    public void delete(int id) {
        paymentMethodRepository.deleteById(id);

    }
}
