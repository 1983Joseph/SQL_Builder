package sql_query;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;
import org.json.JSONArray;
import org.json.JSONObject;

public class SqlBuilder {

  public Method method = null;
  public String value = "";
  public Condition c = null;
  public static DSLContext sql = null;
  Constants cons = null;

  public SqlBuilder() {
    cons = cons.getInstance();
    Settings settings = new Settings().withStatementType(StatementType.STATIC_STATEMENT);
    SqlBuilder.sql = DSL.using(SQLDialect.MYSQL, settings);
  }

  static {
    LogManager.getLogManager().reset();
  }

  public String generateSQLWithSpecifiedConditions(Table<Record> table, List<Condition> conditions) {
    return SqlBuilder.sql.selectCount().from(table).where(conditions).getSQL();
  }

  public List<Condition> getConditions(JSONArray properties) {
    List<Condition> conditions = new ArrayList<>();
    for (int i = 0; i < properties.length(); i++) {
      JSONObject properte = properties.getJSONObject(i);
      Method method = getSpecifiedOperation(properte.getString(cons.OPERATION));
      Condition condition =
          getSingleCondition(getFieldByName(properte.getString(cons.FIELD)), method,
              properte.getString(cons.VALUE));
      conditions.add(condition);
    }
    return conditions;
  }

  public Condition getSingleCondition(Field<Object> field, Method method, Object value) {
    Condition condition = null;
    try {
      method.setAccessible(true);
      Object conditionObject = method.invoke(field, (Object) value);
      condition = (Condition) conditionObject;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return condition;
  }

  public Method getSpecifiedOperation(String operation) {
    Method method = null;
    Class<?> cls = Object.class;
    try {
      if(operation.equals("like")){
        cls = String.class;
      }
      method =
          getFieldByName("").getClass().getSuperclass().getDeclaredMethod(operation, cls);
      System.out.println("---1 " + method);
    } catch (NoSuchMethodException e) {
      System.out.println("---c error 1 " + e.getMessage());
    } catch (SecurityException e) {
      System.out.println("---c error 2 " + e.getMessage());
    }
    return method;
  }

  public Field<Object> getFieldByName(String fieldName) {
    return DSL.field(fieldName);
  }

  public Field<?> getFieldByNameAndDataType(String fieldName, Class<?> cls) {
    return DSL.field(fieldName, cls);
  }

  public Table<Record> getTableByName(String tableName) {
    return DSL.table(tableName);
  }

}
