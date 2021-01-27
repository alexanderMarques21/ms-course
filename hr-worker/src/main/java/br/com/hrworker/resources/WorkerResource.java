package br.com.hrworker.resources;

import br.com.hrworker.entities.Worker;
import br.com.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

  @Autowired private WorkerRepository workerRepository;

  @GetMapping
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok().body(workerRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Optional<Worker> optionalWorker = workerRepository.findById(id);
    if (optionalWorker.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(optionalWorker.get());
  }
}
