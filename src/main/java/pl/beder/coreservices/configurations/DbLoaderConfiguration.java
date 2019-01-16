package pl.beder.coreservices.configurations;

import java.io.File;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.beder.coreservices.domain.Request;
import pl.beder.coreservices.loader.DbLoader;
import pl.beder.coreservices.mappers.CsvRequestMapper;
import pl.beder.coreservices.mappers.XmlRequestMapper;
import pl.beder.coreservices.repositories.RequestRepository;

@Configuration
public class DbLoaderConfiguration implements CommandLineRunner {

  private ApplicationContext context;
  private RequestRepository repository;

  public DbLoaderConfiguration(ApplicationContext context, RequestRepository repository) {
    this.context = context;
    this.repository = repository;
  }

  @Bean
  public CsvRequestMapper csvRequestMapper() {
    return new CsvRequestMapper();
  }

  @Bean
  public XmlRequestMapper xmlRequestMapper() {
    return new XmlRequestMapper();
  }

  @Bean
  public DbLoader dbLoader() {
    return new DbLoader(repository);
  }

  @Override
  public void run(String... args) throws Exception {
    File csvFile = context.getResource("classpath:input.csv").getFile();
    File xmlFile = context.getResource("classpath:input.xml").getFile();
    List<Request> requests = csvRequestMapper().toObjs(csvFile);
    List<Request> xmlRequests = xmlRequestMapper().toObjs(xmlFile);

    requests.addAll(xmlRequests);

    dbLoader().load(requests);
  }
}
