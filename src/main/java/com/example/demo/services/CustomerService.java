package com.example.demo.services;

import com.example.demo.controlers.ExceptionHandlers.ResourceNotFoundException;
import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    if (updatedCustomer.getFirstName() != null) {
                        customer.setFirstName(updatedCustomer.getFirstName());
                    }
                    if (updatedCustomer.getLastName() != null) {
                        customer.setLastName(updatedCustomer.getLastName());
                    }
                    if (updatedCustomer.getMiddleName() != null) {
                        customer.setMiddleName(updatedCustomer.getMiddleName());
                    }
                    if (updatedCustomer.getEmail() != null) {
                        customer.setEmail(updatedCustomer.getEmail());
                    }
                    if (updatedCustomer.getPhoneNumber() != null) {
                        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
                    }
                    if (updatedCustomer.getBirthDate() != null) {
                        customer.setBirthDate(updatedCustomer.getBirthDate());
                    }
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id "+ id +" not found"));
    }

    public Boolean checkCustomerExists(Long id) {
        return customerRepository.existsById(id);
    }

    public Customer deleteCustomerAttributes(Long id, List<String> attributeNames) {
        return customerRepository.findById(id)
                .map(customer -> {
                    for (String attributeName : attributeNames) {
                        switch (attributeName) {
                            case "firstName":
                                customer.setFirstName(null);
                                break;
                            case "lastName":
                                customer.setLastName(null);
                                break;
                            case "middleName":
                                customer.setMiddleName(null);
                                break;
                            case "email":
                                customer.setEmail(null);
                                break;
                            case "phoneNumber":
                                customer.setPhoneNumber(null);
                                break;
                            case "birthDate":
                                customer.setBirthDate(null);
                                break;
                            default:
                                throw new IllegalArgumentException("Invalid attribute name: " + attributeName);
                        }
                    }
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }
}
