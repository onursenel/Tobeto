package com.tobeto.spring.b.java.services.concretes;

import com.tobeto.spring.b.java.entities.Customer;
import com.tobeto.spring.b.java.repostories.CustomerRepository;
import com.tobeto.spring.b.java.services.abstracts.CustomerService;
import com.tobeto.spring.b.java.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.java.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.java.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public List<GetCustomerListResponse> getByNameLike(String name) {
        List<Customer> customers = customerRepository.findByNameLike("%"+name+"%");
        List<GetCustomerListResponse> response = new ArrayList<>();

        for (Customer customer:customers) {
            response.add(new GetCustomerListResponse(customer.getId(),customer.getName(),customer.getSurname(),customer.getAddress(),customer.getEmail(),customer.getPhone()));
        }
        return response;
    }

    @Override
    public List<GetCustomerListResponse> getByNameIgnoreCase(String name) {
        List<Customer> customers = customerRepository.findByNameIgnoreCase(name);
        List<GetCustomerListResponse> response = new ArrayList<>();

        for (Customer customer:customers) {
            response.add(new GetCustomerListResponse(customer.getId(),customer.getName(),customer.getSurname(),customer.getAddress(),customer.getEmail(),customer.getPhone()));
        }
        return response;
    }

    @Override
    public List<GetCustomerListResponse> searchCustomerName(String name) {
        return this.customerRepository.search(name);
    }

    @Override
    public List<GetCustomerListResponse> orderName() {
        return customerRepository.orderName();
    }


    @Override
    public List<GetCustomerListResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetCustomerListResponse> getCustomerResponseList = new ArrayList<>();

        for (Customer customer:customers) {
            GetCustomerListResponse response = new GetCustomerListResponse();
            response.setId(customer.getId());
            response.setName(customer.getName());
            response.setSurname(customer.getSurname());
            response.setAddress(customer.getAddress());
            response.setEmail(customer.getEmail());
            response.setPhone(customer.getPhone());
            getCustomerResponseList.add(response);

        }
        return getCustomerResponseList;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse customerDto = new GetCustomerResponse();
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setAddress(customer.getAddress());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());


        return customerDto;

    }

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {
        Customer customer = new Customer();

        customer.setName(addCustomerRequest.getName());
        customer.setSurname(addCustomerRequest.getSurname());
        customer.setAddress(addCustomerRequest.getAddress());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setPhone(addCustomerRequest.getPhone());

        customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest, int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        customer.setName(updateCustomerRequest.getName());
        customer.setSurname(updateCustomerRequest.getSurname());
        customer.setAddress(updateCustomerRequest.getAddress());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setPhone(updateCustomerRequest.getPhone());

        customerRepository.save(customer);

    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);

    }
}
