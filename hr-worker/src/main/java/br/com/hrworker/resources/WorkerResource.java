package br.com.hrworker.resources;

import br.com.hrworker.entities.Worker;
import br.com.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {

  @Autowired private WorkerRepository workerRepository;

  @Autowired private Environment environment;

  private static Logger LOGGER = LoggerFactory.getLogger(WorkerResource.class);

  @GetMapping
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok().body(workerRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {

    LOGGER.info("PORT = {}", environment.getProperty("local.server.port"));

    Optional<Worker> optionalWorker = workerRepository.findById(id);
    if (optionalWorker.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(optionalWorker.get());
  }

}
