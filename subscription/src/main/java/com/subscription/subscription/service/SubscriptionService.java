package com.subscription.subscription.service;

import com.subscription.subscription.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    public Subscription createSubscription(Subscription subscription);
    public Subscription updateSubscription(int quantity,String frequency,int subscriptionId);
    public Subscription deleteSubscription(int subscriptionId);

    public List<Subscription> viewSubscription(int customerId);
}
