package io.cdap.wrangler.api.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * Parses and converts time duration strings like "150ms", "2s", "5m" to milliseconds.
 */
public class TimeDuration {
  private static final Map<String, Long> UNIT_MAP = new HashMap<>();

  static {
    UNIT_MAP.put("MS", 1L);
    UNIT_MAP.put("S", 1000L);
    UNIT_MAP.put("M", 60 * 1000L);
    UNIT_MAP.put("H", 60 * 60 * 1000L);
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
    // fallback: try parse as plain milliseconds
    try {
      return Long.parseLong(value);
    } catch (NumberFormatException e) {
      return 0;
    }
  }
}
