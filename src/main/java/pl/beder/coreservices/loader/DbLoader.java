package pl.beder.coreservices.loader;

import static java.util.stream.Collectors.toList;

import java.util.List;
import pl.beder.coreservices.domain.Request;
import pl.beder.coreservices.entities.RequestEntity;
import pl.beder.coreservices.repositories.RequestEntityRepository;

/**
 * This class is used to load {@link Request} objects into Database.
 */
public class DbLoader {

  private RequestEntityRepository repository;

  public DbLoader(RequestEntityRepository repository) {
    this.repository = repository;
  }

  /**
   * Maps {@link Request} to {@link RequestEntity} and then persists in them in database.
   * @param requests objects to be persisted into database
   */
  public void load(List<Request> requests) {
    List<RequestEntity> entities =
        requests.stream().map(RequestEntity::fromDomain).collect(toList());
    repository.saveAll(entities);
  }
}
