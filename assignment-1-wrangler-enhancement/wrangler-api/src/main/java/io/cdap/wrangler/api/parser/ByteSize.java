package io.cdap.wrangler.api.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * Parses and converts byte size strings like "10KB", "5MB", "2GB" to bytes.
 */
public class ByteSize {
  private static final Map<String, Long> UNIT_MAP = new HashMap<>();

  static {
    UNIT_MAP.put("B", 1L);
    UNIT_MAP.put("KB", 1024L);
    UNIT_MAP.put("MB", 1024L * 1024);
    UNIT_MAP.put("GB", 1024L * 1024 * 1024);
    UNIT_MAP.put("TB", 1024L * 1024 * 1024 * 1024);
  }

  public static long parse(String value) {
    value = value.trim().toUpperCase();
    for (String unit : UNIT_MAP.keySet()) {
      if (value.endsWith(unit)) {
        String number = value.substring(0, value.length() - unit.length()).trim();
        try {
          return (long)(Double.parseDouble(number) * UNIT_MAP.get(unit));
        } catch (NumberFormatException e) {
          return 0;
        }
      }
    }
    // fallback: try parse as plain bytes
    try {
      return Long.parseLong(value);
    } catch (NumberFormatException e) {
      return 0;
    }
  }
}
