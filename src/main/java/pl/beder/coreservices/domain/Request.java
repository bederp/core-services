package pl.beder.coreservices.domain;

import lombok.Data;

@Data
public class Request {
  private final String clientId;
  private final long requestId;
  private final String name;
  private final int quantity;
  private final double price;
}
