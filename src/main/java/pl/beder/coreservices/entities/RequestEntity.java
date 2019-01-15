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

  @Column(length = 6)
  private String clientId;

  private long requestId;
  private String name;
  private int quantity;
  private double price;

  public static RequestEntity fromDomain(Request domainObject) {
    return builder()
        .clientId(domainObject.getClientId())
        .requestId(domainObject.getRequestId())
        .name(domainObject.getName())
        .quantity(domainObject.getQuantity())
        .price(domainObject.getPrice())
        .build();
  }
}
