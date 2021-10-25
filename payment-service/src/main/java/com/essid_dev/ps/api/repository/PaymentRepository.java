package com.essid_dev.ps.api.repository;

import com.essid_dev.ps.api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment findByOrderId(int orderId);
}
