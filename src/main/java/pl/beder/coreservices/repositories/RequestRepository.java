package pl.beder.coreservices.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.beder.coreservices.entities.RequestEntity;

public interface RequestRepository extends CrudRepository<RequestEntity, Long> {

  @Query(value = "SELECT COUNT(*) FROM (SELECT COUNT(*) FROM REQUEST GROUP BY REQUEST_ID)", nativeQuery = true)
  long countAllByRequestId();
}
