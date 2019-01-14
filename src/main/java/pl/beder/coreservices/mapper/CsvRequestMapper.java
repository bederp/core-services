package pl.beder.coreservices.mapper;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import pl.beder.coreservices.domain.Request;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.databind.MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES;

public class CsvRequestMapper {

  private static final CsvSchema SCHEMA = CsvSchema.emptySchema().withHeader();
  private static final ObjectReader MAPPER =
      new CsvMapper()
          .configure(ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
          .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
          .readerFor(Request.class)
          .with(SCHEMA);

  public List<Request> toObjs(File src) throws IOException {
    MappingIterator<Request> iterator = MAPPER.readValues(src);
    return iterator.readAll();
  }
}
