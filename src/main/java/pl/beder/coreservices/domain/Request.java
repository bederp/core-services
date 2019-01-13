package pl.beder.coreservices.domain;

import lombok.Data;

@Data
public class Request {
    final String clientId;
    final long requestId;
    final String name;
    final int quantity;
    final double price;
}
