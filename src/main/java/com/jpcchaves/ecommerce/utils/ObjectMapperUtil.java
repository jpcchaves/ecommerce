package com.jpcchaves.ecommerce.utils;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.*;
import com.fasterxml.jackson.databind.ser.*;

public class ObjectMapperUtil extends ObjectMapper {
  private static ObjectMapperUtil instance;

  public ObjectMapperUtil() {
  }

  public ObjectMapperUtil(JsonFactory jf) {
    super(jf);
  }

  public ObjectMapperUtil(ObjectMapper src) {
    super(src);
  }

  public ObjectMapperUtil(
      JsonFactory jf,
      DefaultSerializerProvider sp,
      DefaultDeserializationContext dc
  ) {
    super(jf, sp, dc);
  }

  public static synchronized ObjectMapperUtil getInstance() {
    if (instance == null) {
      instance = new ObjectMapperUtil();
    }
    return instance;
  }
}
