package br.com.hrpayroll.services;

import br.com.hrpayroll.entities.Payment;
import br.com.hrpayroll.entities.Worker;
import br.com.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;


    public Payment getPayment(Long workerId, int days) {

        ResponseEntity<Worker> workerResponse = workerFeignClient.findById(workerId);

        if (!workerResponse.getStatusCode().is2xxSuccessful()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Worker worker = workerResponse.getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
