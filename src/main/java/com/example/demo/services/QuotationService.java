package com.example.demo.services;

import com.example.demo.models.Quotation;
import com.example.demo.repositories.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {
    @Autowired
    private QuotationRepository quotationRepository;

    public List<Quotation> getAllQuotations() {
        return quotationRepository.findAll();
    }

    public Quotation createQuotation(Quotation quotation) {
        return quotationRepository.save(quotation);
    }
}