package com.example.demo.repositories;

import com.example.demo.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Query("SELECT COUNT(s) > 0 FROM Subscription s WHERE s.quotation.uuid = ?1")
    boolean existsByQuotationUUID(UUID quotationUUID);
}
