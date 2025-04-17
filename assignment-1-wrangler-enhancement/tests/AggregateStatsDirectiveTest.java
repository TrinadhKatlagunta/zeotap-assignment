package tests;

import io.cdap.wrangler.api.Row;
import io.cdap.wrangler.directives.AggregateStatsDirective;
import io.cdap.wrangler.api.parser.Arguments;
import io.cdap.wrangler.api.parser.TextDirectiveContext;
import io.cdap.wrangler.api.parser.TextDirectiveArguments;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AggregateStatsDirectiveTest {

  @Test
  public void testAggregateStatsDirective() throws Exception {
    Row row1 = new Row("data1", 1024);
    row1.add("data2", 2048);
    
    Row row2 = new Row("data1", 512);
    row2.add("data2", 512);

    List<Row> rows = Arrays.asList(row1, row2);

    AggregateStatsDirective directive = new AggregateStatsDirective();
    Arguments arguments = new TextDirectiveArguments("data1", "data2", "total", "average");
    directive.initialize(arguments, new TextDirectiveContext());

    List<Row> result = directive.execute(rows, null);

    Assert.assertEquals(3072.0, result.get(0).getValue("total"));
    Assert.assertEquals(1536.0, result.get(0).getValue("average"));
    Assert.assertEquals(1024.0, result.get(1).getValue("total"));
    Assert.assertEquals(512.0, result.get(1).getValue("average"));
  }
}
