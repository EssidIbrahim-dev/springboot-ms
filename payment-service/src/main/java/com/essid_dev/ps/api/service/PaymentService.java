package com.essid_dev.ps.api.service;

import com.essid_dev.ps.api.entity.Payment;
import com.essid_dev.ps.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;
    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId((UUID.randomUUID().toString()));
        return repository.save(payment);
    }

    public String paymentProcessing(){
        return new Random().nextBoolean() ? "success" : "false";
    }

    public Payment findPaymentHistoryByOrderId(int orderId){
        return repository.findByOrderId(orderId);
    }
    public String deletePayment(int id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return "This payment was been deleted successfully";
        }
        else {
            return "Error occured for this method please retry another time";
        }
    }

    public List<Payment> getAllPayments()
    {
        List<Payment> payments = new ArrayList<>();
        repository.findAll().forEach(payment -> payments.add(payment));
        return payments;
    }

    public void saveOrUpdate(Payment payment)
    {
        repository.save(payment);
    }
}
