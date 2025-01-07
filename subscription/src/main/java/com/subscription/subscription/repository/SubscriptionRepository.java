package com.subscription.subscription.repository;

import com.subscription.subscription.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    Optional<Subscription> findById(int  id);
    List<Subscription> findByCustomerId(int customerId);

}
