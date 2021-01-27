package br.com.hrpayroll.services;

import br.com.hrpayroll.entities.Payment;
import br.com.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;


    public Payment getPayment(Long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId.toString());
        Worker worker = restTemplate.getForObject(workerHost + "workers/{id}", Worker.class, uriVariables);
        if (worker == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
