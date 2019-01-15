package pl.beder.coreservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import pl.beder.coreservices.domain.Request;

/**
 * Object representing Database mapping for {@link Request} domain object.
 */
@Builder
@Entity(name = "REQUEST")
public class RequestEntity {
  @Id @GeneratedValue long id;

  @Column(length = 6, nullable = false)
  private String clientId;

  @Column(nullable = false)
  private String name;

  private double price;
  private int quantity;
  private long requestId;

  /**
   * This method transforms domain object Request into entity representation. I've decided to
   * separate DB concerns from plain entities, hence the cost of mapping but also more clean domain.
   *
   * @param domainObject {@link Request} object to be mapped
   * @return {@link RequestEntity} representing {@link Request} domain object
   */
  public static RequestEntity fromDomain(Request domainObject) {
    return builder()
        .clientId(domainObject.getClientId())
        .name(domainObject.getName())
        .price(domainObject.getPrice())
        .quantity(domainObject.getQuantity())
        .requestId(domainObject.getRequestId())
        .build();
  }
}
