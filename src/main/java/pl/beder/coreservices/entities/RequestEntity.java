package pl.beder.coreservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import pl.beder.coreservices.domain.Request;

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
