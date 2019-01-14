package pl.beder.coreservices.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import pl.beder.coreservices.domain.Request;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlRequestMapper {
  private static final ObjectReader MAPPER =
      new XmlMapper()
              .setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
              .readerFor(new TypeReference<List<Request>>() {});

  public List<Request> toObjs(File src) throws IOException {
    return MAPPER.readValue(src);
  }
}
