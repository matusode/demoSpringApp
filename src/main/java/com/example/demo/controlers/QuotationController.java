package com.example.demo.controlers;

import com.example.demo.models.Quotation;
import com.example.demo.services.CustomerService;
import com.example.demo.services.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotations")
public class QuotationController {

    private QuotationService quotationService;
    private CustomerService customerService;

    public QuotationController(QuotationService quotationService, CustomerService customerService) {
        this.quotationService = quotationService;
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Quotation>> getAllQuotations() {
        List<Quotation> quotations = quotationService.getAllQuotations();
        return new ResponseEntity<>(quotations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Quotation> createQuotation(@RequestBody Quotation quotation) {
        if (quotation.getCustomer().getId() == null) {
            customerService.createCustomer(quotation.getCustomer());
        }
        Quotation newQuotation = quotationService.createQuotation(quotation);
        return new ResponseEntity<>(newQuotation, HttpStatus.CREATED);
    }
}