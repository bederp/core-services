package pl.beder.coreservices.mapper;

import org.junit.Test;
import pl.beder.coreservices.domain.Request;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvRequestMapperTest {

  @Test
  public void shouldReadSingleObjectFromFile() throws IOException {
    File file = getFile("/singleObject.csv");
    CsvRequestMapper csvRequestMapper = new CsvRequestMapper();
    List<Request> requests = csvRequestMapper.toObjs(file);

    assertThat(requests).hasSize(1);
    assertThat(requests.get(0)).isEqualTo(expectedRequest());
  }

    @Test
    public void shouldReadMultipleObjectFromFile() throws IOException {
        File file = getFile("/multipleObjects.csv");
        CsvRequestMapper csvRequestMapper = new CsvRequestMapper();
        List<Request> requests = csvRequestMapper.toObjs(file);

        assertThat(requests).hasSize(4);
    }

  private Request expectedRequest() {
    return Request.builder()
        .clientId("1")
        .requestId(1)
        .name("Bułka")
        .quantity(1)
        .price(10.00)
        .build();
  }

  private File getFile(String path) {
    URL resource = this.getClass().getResource(path);
    try {
      return Paths.get(resource.toURI()).toFile();
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
