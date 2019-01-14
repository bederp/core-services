package pl.beder.coreservices.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {
  private String clientId;
  private long requestId;
  private String name;
  private int quantity;
  private double price;
}
