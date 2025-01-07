package com.subscription.subscription.service;

import com.subscription.subscription.entity.Subscription;
import com.subscription.subscription.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImp implements SubscriptionService{
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Override
    public  Subscription createSubscription(Subscription subscription){
        Subscription createSub = subscriptionRepository.save(subscription);
        return createSub;
    }
    @Override
    public Subscription updateSubscription(int quantity,String frequency,int  subscriptionId){
      Optional<Subscription> existSub = subscriptionRepository.findById(subscriptionId);
      Subscription subscription = existSub.get();
      subscription.setFrequency(frequency);
      subscription.setQuantity(quantity);
       return subscriptionRepository.save(subscription);
    }
    @Override
    public Subscription deleteSubscription(int subscriptionId){
        Optional<Subscription> existSub = subscriptionRepository.findById(subscriptionId);
        Subscription subscription = existSub.get();
        subscriptionRepository.delete(subscription);
        return subscription;
    }

    @Override
    public List<Subscription> viewSubscription(int customerId){
        List<Subscription> viewSub = subscriptionRepository.findByCustomerId( customerId);
        if(viewSub!= null) {
            return viewSub;
        }
        return null;
    }

}
