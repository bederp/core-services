package pl.beder.coreservices.mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.util.ResourceUtils.getFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import pl.beder.coreservices.domain.Request;

public class XmlRequestMapperTest {

  @Test
  public void shouldReadSingleObjectFromFile() throws IOException {
    File file = getFile("classpath:singleObject.xml");
    XmlRequestMapper xmlRequestMapper = new XmlRequestMapper();
    List<Request> requests = xmlRequestMapper.toObjs(file);

    assertThat(requests).hasSize(1);
    assertThat(requests.get(0)).isEqualTo(expectedRequest());
  }

  @Test
  public void shouldReadMultipleObjectFromFile() throws IOException {
    File file = getFile("classpath:multipleObjects.xml");
    XmlRequestMapper xmlRequestMapper = new XmlRequestMapper();
    List<Request> requests = xmlRequestMapper.toObjs(file);

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
}
