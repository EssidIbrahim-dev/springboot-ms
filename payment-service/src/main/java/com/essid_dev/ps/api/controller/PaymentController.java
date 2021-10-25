package com.essid_dev.ps.api.controller;

import com.essid_dev.ps.api.entity.Payment;
import com.essid_dev.ps.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping ("/Payments")
    private List<Payment> getAllPayments()
    {
        return service.getAllPayments();
    }

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        return service.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId){
        return service.findPaymentHistoryByOrderId(orderId);
    }

    @DeleteMapping(value="/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> deleteCandidate(@PathVariable(value= "id") int id){
        return new ResponseEntity<>(service.deletePayment(id),HttpStatus.OK);
    }

    @PutMapping("/payment")
    private Payment update(@RequestBody Payment payment)
    {
        service.saveOrUpdate(payment);
        return payment;
    }


}
