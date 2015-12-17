package sql_query;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class Util {
  
  private static String generateSQLWithWhereInInlineOne(String... businessGroupProcesses) {
    Field<String>[] fields = new Field[businessGroupProcesses.length];
    for (int i = 0; i < businessGroupProcesses.length; i++)
      fields[i] = DSL.inline(businessGroupProcesses[i]);

    return DSL.using(SQLDialect.MYSQL)
        .selectDistinct(DSL.field("Business Group").as("Business_Group"))
        .from(DSL.table("SOME_TABLE")).where(DSL.field("Business Group Process").in(fields))
        .getSQL();
  }

  public static String generateSQLWithWhereInInline(String businessGroupProcess) {
    DSLContext create = DSL.using(SQLDialect.MYSQL);
    return create.selectDistinct(DSL.field("Business Group").as("Business_Group"))
        .from(DSL.table("SOME_TABLE"))
        .where(DSL.field("Business Group Process").in(DSL.inline(businessGroupProcess))).getSQL();
  }

  private static String generateSQLWithWhereInInlineSecond(String... businessGroupProcesses) {
    Settings settings = new Settings().withStatementType(StatementType.STATIC_STATEMENT);

    return DSL.using(SQLDialect.MYSQL, settings)
        .selectDistinct(DSL.field("Business Group").as("Business_Group"))
        .from(DSL.table("SOME_TABLE"))
        .where(DSL.field("Business Group Process").in(businessGroupProcesses)).getSQL();
  }

  private static String generateSQLWithWhereInInlineThree(String... businessGroupProcesses) {
    Settings settings = new Settings().withStatementType(StatementType.STATIC_STATEMENT);

    return DSL.using(SQLDialect.MYSQL, settings)
        .selectDistinct(DSL.field("Business Group").as("Business_Group"))
        .from(DSL.table("SOME_TABLE"))
        .where(DSL.field("Business Group Process").in(businessGroupProcesses)).getSQL();
  }
  
  private static String generateSQLWithWhereInInlineCherr(String... businessGroupProcesses) {
    Settings settings = new Settings().withStatementType(StatementType.STATIC_STATEMENT);
    return DSL.using(SQLDialect.MYSQL, settings).selectCount().from(DSL.table("SOME_TABLE"))
        .where(DSL.field("Business").equal("ttt")).getSQL();
  }

  private static SelectConditionStep<Record1<Integer>> generatePartSQL() {
    Settings settings = new Settings().withStatementType(StatementType.STATIC_STATEMENT);
    return DSL.using(SQLDialect.MYSQL, settings).selectCount().from(DSL.table("SOME_TABLE"))
        .where(DSL.field("Business").equal("ttt"));
  }

  private static String sqlString(SelectConditionStep<Record1<Integer>> tt) {
    return tt.getSQL();
  }

  public static List<Condition> getConditions() {
    List<Condition> conditions = new ArrayList<>();
    conditions.add(DSL.field("Business").equal("ttt"));
    conditions.add(DSL.field("jobe", SQLDataType.VARCHAR).equal(""));
    conditions.add(DSL.field("Jobs").greaterOrEqual(55));
    conditions.add(DSL.field("Jobs").lessOrEqual("uuu"));
    conditions.add(DSL.field("Jobs").like("iii").or(true));
    Condition c1 = DSL.field("Jobs").in(1, 2, 3);
    Condition c2 = DSL.field("Jobs").in(DSL.field("aaaa"));
    Condition c3 = c1.or(c2);
    Condition c4 = c2.or(c1);
    Condition c5 = c3.or(c1);
    conditions.add(c3);
    conditions.add(c4);
    conditions.add(c5);
    return conditions;
  }

}
