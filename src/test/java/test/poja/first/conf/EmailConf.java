package test.poja.first.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import test.poja.first.PojaGenerated;

@PojaGenerated
public class EmailConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.ses.source", () -> "dummy-ses-source");
  }
}
