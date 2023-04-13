package com.example.demo.services;

import com.example.demo.controlers.ExceptionHandlers.ResourceNotFoundException;
import com.example.demo.models.Subscription;
import com.example.demo.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Boolean existsSubscriptionWithQuotationUUID(UUID quotationUUID) {
        return subscriptionRepository.existsByQuotationUUID(quotationUUID);
    }
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription with id $id not found"));
    }
}
