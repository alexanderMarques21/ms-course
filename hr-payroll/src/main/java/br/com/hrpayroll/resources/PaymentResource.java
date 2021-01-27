package br.com.hrpayroll.resources;

import br.com.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<?> getPayment(@PathVariable Long workerId, @PathVariable int days) {
        return ResponseEntity.ok().body(paymentService.getPayment(workerId, days));

    }
}
