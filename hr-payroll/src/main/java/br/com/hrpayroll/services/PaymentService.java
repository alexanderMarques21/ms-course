package br.com.hrpayroll.services;

import br.com.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days) {
        return new Payment("Ted",200.0,days);
    }
}
