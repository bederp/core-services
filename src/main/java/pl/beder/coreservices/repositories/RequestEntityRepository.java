package pl.beder.coreservices.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.beder.coreservices.entities.RequestEntity;

public interface RequestEntityRepository extends CrudRepository<RequestEntity, Long> {}
