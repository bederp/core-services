package pl.beder.coreservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import pl.beder.coreservices.configurations.DbLoaderConfiguration;

@SpringBootApplication
@Import(DbLoaderConfiguration.class)
public class CoreServicesApplication implements CommandLineRunner {

  ApplicationContext context;

  public CoreServicesApplication(ApplicationContext context) {
    this.context = context;
  }

  public static void main(String[] args) {
    SpringApplication.run(CoreServicesApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    DbLoaderConfiguration loader = (DbLoaderConfiguration) context.getBean("dbLoaderConfiguration");
    loader.run();
  }
}
