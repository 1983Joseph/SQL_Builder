package sql_query;

import java.lang.reflect.Method;

import org.jooq.impl.DSL;

public class Main {

  private static String properties =
      "[{\"field\":\"v1\", \"operation\":\"equal\", \"value\":\"v3\"},"
      + "{\"field\":\"v1\", \"operation\":\"like\", \"value\":\"v3\"},"
      + "{\"field\":\"v1\", \"operation\":\"greaterOrEqual\", \"value\":\"v3\"},"
      + "{\"field\":\"v1\", \"operation\":\"gt\", \"value\":\"v3\"}]";
  static SqlBuilder sqlBuilder = new SqlBuilder();
  static Properties prop = new Properties();

  public static void main(String[] args) {
    prop.setProperties(properties);
    System.out.println("-------" + prop.toString());
     Method[] method = DSL.field("").getClass().getSuperclass().getMethods();
     for (int i = 0; i < method.length; i++){
     System.out.println("+++" + method[i]);
     }
    // try {
    // Method method2 =
    // DSL.field("").getClass().getSuperclass().getDeclaredMethod("equal", new Class[]{});
    // System.out.println("-------------- " + method2);
    // } catch (NoSuchMethodException e) {
    // System.out.println("---1 " + e.getMessage());
    // } catch (SecurityException e) {
    // System.out.println("---2 " + e.getMessage());
    // }
    // System.out.println("---" + generateSQLWithWhereInInline(""));
    // System.out.println("---" + generateSQLWithWhereInInlineOne(""));
    // System.out.println("---" + generateSQLWithWhereInInlineSecond(""));
    // System.out.println("---" + generateSQLWithWhereInInlineThree(""));
    // System.out.println("---" + generateSQLWithWhereInInlineCherr(""));
    // System.out.println("---" + sqlString(generatePartSQL()));
    System.out.println("---  "
        + sqlBuilder.generateSQLWithSpecifiedConditions(sqlBuilder.getTableByName("Table"), sqlBuilder.getConditions(prop
            .getProperties())));
  }

}
