package pl.beder.coreservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.beder.coreservices.repositories.RequestRepository;

@RestController
@RequestMapping("/reports")
public class ReportController {

  private RequestRepository repository;

  public ReportController(RequestRepository repository) {
    this.repository = repository;
  }

  @GetMapping(value = "/total-orders-count", produces = "text/xml; charset=utf-8")
  public long toralOrdersCount() {
    return repository.countAllByRequestId();
  }
}
