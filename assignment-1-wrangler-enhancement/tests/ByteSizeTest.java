package tests;

import io.cdap.wrangler.api.parser.ByteSize;
import org.junit.Assert;
import org.junit.Test;

public class ByteSizeTest {

  @Test
  public void testParseByteSizes() {
    Assert.assertEquals(1024L, ByteSize.parse("1KB"));
    Assert.assertEquals(1048576L, ByteSize.parse("1MB"));
    Assert.assertEquals(1073741824L, ByteSize.parse("1GB"));
    Assert.assertEquals(1536L, ByteSize.parse("1.5KB"));
    Assert.assertEquals(500L, ByteSize.parse("500"));
    Assert.assertEquals(0L, ByteSize.parse("invalid"));
  }
}
