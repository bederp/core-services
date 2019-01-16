package pl.beder.coreservices;

import static org.springframework.util.ResourceUtils.getFile;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.beder.coreservices.domain.Request;
import pl.beder.coreservices.loader.DbLoader;
import pl.beder.coreservices.mappers.CsvRequestMapper;
import pl.beder.coreservices.mappers.XmlRequestMapper;
import pl.beder.coreservices.repositories.RequestRepository;

@SpringBootApplication
public class CoreServicesApplication implements CommandLineRunner {

  ApplicationContext context;

  public CoreServicesApplication(ApplicationContext context) {
    this.context = context;
  }

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

  @Bean
  public DbLoader dbLoader(RequestRepository repository) {
    return new DbLoader(repository);
  }

  @Override
  public void run(String... args) throws Exception {
    List<Request> requests = csvRequestMapper().toObjs(getFile("classpath:input.csv"));
    List<Request> xmlRequests = xmlRequestMapper().toObjs(getFile("classpath:input.xml"));

    requests.addAll(xmlRequests);

    DbLoader dbLoader = (DbLoader) context.getBean("dbLoader");
    dbLoader.load(requests);
  }
}
