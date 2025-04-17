package io.cdap.wrangler.directives;

import io.cdap.wrangler.api.*;
import io.cdap.wrangler.api.parser.*;
import io.cdap.wrangler.api.Row;
import io.cdap.wrangler.api.Directive;
import io.cdap.wrangler.api.DirectiveContext;

import java.util.ArrayList;
import java.util.List;

/**
 * A directive to compute total and average for BYTE_SIZE and TIME_DURATION fields.
 */
@Directive(
  name = "aggregate-stats",
  usage = "aggregate-stats <column1> <column2> <totalColName> <avgColName>",
  description = "Aggregates byte size or time duration values into total and average"
)
public class AggregateStatsDirective implements Executable {

  private String col1;
  private String col2;
  private String totalColName;
  private String avgColName;

  @Override
  public List<Argument> defineArguments() {
    List<Argument> args = new ArrayList<>();
    args.add(Argument.of("col1", ArgumentType.STRING));
    args.add(Argument.of("col2", ArgumentType.STRING));
    args.add(Argument.of("totalColName", ArgumentType.STRING));
    args.add(Argument.of("avgColName", ArgumentType.STRING));
    return args;
  }

  @Override
  public void initialize(Arguments args, Context ctx) throws DirectiveParseException {
    this.col1 = args.value("col1");
    this.col2 = args.value("col2");
    this.totalColName = args.value("totalColName");
    this.avgColName = args.value("avgColName");
  }

  @Override
  public List<Row> execute(List<Row> rows, DirectiveContext ctx) {
    double total = 0;
    for (Row row : rows) {
      Object val1 = row.getValue(col1);
      Object val2 = row.getValue(col2);
      double sum = toDouble(val1) + toDouble(val2);
      row.addOrSet(totalColName, sum);
      row.addOrSet(avgColName, sum / 2);
    }
    return rows;
  }

  private double toDouble(Object obj) {
    if (obj instanceof Number) {
      return ((Number) obj).doubleValue();
    }
    if (obj instanceof String) {
      try {
        return Double.parseDouble((String) obj);
      } catch (NumberFormatException e) {
        return 0;
      }
    }
    return 0;
  }
}
