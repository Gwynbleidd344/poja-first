package test.poja.first.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import test.poja.first.PojaGenerated;

@PojaGenerated
public class BucketConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.s3.bucket", () -> "dummy-bucket");
  }
}
