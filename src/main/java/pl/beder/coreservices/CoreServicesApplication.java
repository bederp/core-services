package pl.beder.coreservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.beder.coreservices.mapper.CsvRequestMapper;
import pl.beder.coreservices.mapper.XmlRequestMapper;

@SpringBootApplication
public class CoreServicesApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(CoreServicesApplication.class, args);
  }

  @Bean
  public CsvRequestMapper csvRequestMapper() {
    return new CsvRequestMapper();
  }

  @Bean
  public XmlRequestMapper xmlRequestMapper() {
    return new XmlRequestMapper();
  }

  @Override
  public void run(String... args) throws Exception {
  }
}
