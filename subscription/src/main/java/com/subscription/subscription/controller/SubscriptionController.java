package com.subscription.subscription.controller;

import com.subscription.subscription.dto.SubscriptionRequest;
import com.subscription.subscription.dto.SubscriptionResponse;
import com.subscription.subscription.entity.Subscription;
import com.subscription.subscription.service.SubscriptionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    SubscriptionServiceImp subscriptionService;

    @PostMapping("/create")
    public ResponseEntity<SubscriptionResponse> createSubscription(@RequestBody Subscription subscription) {

        Subscription createdSub = subscriptionService.createSubscription(subscription);
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.setCustomerId(subscription.getCustomerId());
        subscriptionResponse.setProductId(subscription.getProductId());
        subscriptionResponse.setPricePerUnit(subscription.getPricePerUnit());
        subscriptionResponse.setFrequency(subscription.getFrequency());
        subscriptionResponse.setStartDate(subscription.getStartDate());
        subscriptionResponse.setEndDate(subscription.getEndDate());
        subscriptionResponse.setQuantity(subscription.getQuantity());
        subscriptionResponse.setProductName(subscription.getProductName());
        subscriptionResponse.setMessage("data insert sucessfully");

        return new ResponseEntity<SubscriptionResponse>(subscriptionResponse, HttpStatus.CREATED);
    }
  @PostMapping("/update")
  public ResponseEntity<SubscriptionResponse> updateSubscription(@RequestBody SubscriptionRequest subscriptionRequest,@PathVariable int subscriptionId){
        Subscription updateSub = subscriptionService.updateSubscription(subscriptionRequest.getQuantity(),subscriptionRequest.getFrequency(), subscriptionId);
      SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
      subscriptionResponse.setQuantity(updateSub.getQuantity());
      subscriptionResponse.setFrequency(updateSub.getFrequency());
      subscriptionResponse.setMessage("Subscription updated successfully.");
      return new ResponseEntity<SubscriptionResponse>(subscriptionResponse, HttpStatus.CREATED);

  }
    @DeleteMapping("/delete")
    public ResponseEntity<SubscriptionResponse> deleteSubscription(@RequestBody SubscriptionRequest subscriptionRequest,@PathVariable int subscriptionId){
        Subscription updateSub = subscriptionService.deleteSubscription(subscriptionId);
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();

        subscriptionResponse.setMessage("Subscription deleted successfully.");
        return new ResponseEntity<SubscriptionResponse>(subscriptionResponse, HttpStatus.CREATED);

    }
    @GetMapping("/view")
    public List<Subscription>getAllSub(@RequestBody SubscriptionRequest subscriptionRequest,@PathVariable int customerId){
        List<Subscription>viewAll =subscriptionService.viewSubscription(customerId);
        if(viewAll!= null)
        {
            return viewAll;
        }
        return null;
    }


}
