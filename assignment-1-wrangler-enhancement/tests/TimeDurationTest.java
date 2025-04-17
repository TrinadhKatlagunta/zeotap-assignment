package tests;

import io.cdap.wrangler.api.parser.TimeDuration;
import org.junit.Assert;
import org.junit.Test;

public class TimeDurationTest {

  @Test
  public void testParseTimeDurations() {
    Assert.assertEquals(150L, TimeDuration.parse("150ms"));
    Assert.assertEquals(2000L, TimeDuration.parse("2s"));
    Assert.assertEquals(300000L, TimeDuration.parse("5m"));
    Assert.assertEquals(3600000L, TimeDuration.parse("1h"));
    Assert.assertEquals(100L, TimeDuration.parse("100"));
    Assert.assertEquals(0L, TimeDuration.parse("abc"));
  }
}
