/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package sql_query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author seryozha
 */
public class SQLProperties {

  private static final Logger logger = Logger.getLogger(SQLProperties.class.getName());

  private String dbSchemaName = "";
  private String dbTableName = "";
  private List<String> dbTableNames = new ArrayList<>();
  private JSONArray conditions = new JSONArray();

  /**
   * 
   * @param dbSchemaName the specified schema name
   * @param dbTableName the specified table name
   */
  public SQLProperties(String dbSchemaName, String dbTableName) {
    this.dbSchemaName = dbSchemaName;
    this.dbTableName = dbTableName;
  }

  /**
   * 
   * @param dbSchemaName the specified schema name
   * @param dbTableNames the specified tables names by List type
   */
  public SQLProperties(String dbSchemaName, List<String> dbTableNames) {
    this.dbSchemaName = dbSchemaName;
    this.dbTableNames = dbTableNames;
  }

  /**
   * 
   * @param dbSchemaName the specified schema name
   * @param dbTableName the specified table name
   * @param condition the specified condition of SQL query
   */
  public SQLProperties(String dbSchemaName, String dbTableName, JSONArray condition) {
    this.dbSchemaName = dbSchemaName;
    this.dbTableName = dbTableName;
    this.conditions = condition;
  }

  /**
   * 
   * @param dbSchemaName the specified schema name
   * @param dbTableNames the specified table by List type
   * @param condition the specified condition of SQL query
   */
  public SQLProperties(String dbSchemaName, List<String> dbTableNames, JSONArray condition) {
    this.dbSchemaName = dbSchemaName;
    this.dbTableNames = dbTableNames;
    this.conditions = condition;
  }

  /**
   * @return the dbSchemaName
   */
  public String getDbSchemaName() {
    return dbSchemaName;
  }

  /**
   * @param dbSchemaName the dbSchemaName to set
   */
  public void setDbSchemaName(String dbSchemaName) {
    this.dbSchemaName = dbSchemaName;
  }

  /**
   * @return the dbTableName
   */
  public String getDbTableName() {
    return dbTableName;
  }

  /**
   * @param dbTableName the dbTableName to set
   */
  public void setDbTableName(String dbTableName) {
    if (!this.dbTableNames.isEmpty()) {
      logger.log(Level.WARNING, "TODO");
      return;
    }
    this.dbTableName = dbTableName;
  }

  /**
   * @return the dbTableNames
   */
  public List<String> getDbTableNames() {
    return dbTableNames;
  }

  /**
   * @param dbTableNames the dbTableNames to set
   */
  public void setDbTableNames(List<String> dbTableNames) {
    if (!this.dbTableName.isEmpty()) {
      logger.log(Level.WARNING, "TODO");
      return;
    }
    this.dbTableNames = dbTableNames;
  }

  /**
   * @param dbTableName the dbTableName to add into dbTableNames
   */
  public void addDbTableNames(String dbTableName) {
    if (!this.dbTableName.isEmpty()) {
      logger.log(Level.WARNING, "TODO");
      return;
    }
    this.dbTableNames.add(dbTableName);
  }

  /**
   * @return the condition
   */
  public JSONArray getCondition() {
    return conditions;
  }

  /**
   * @param condition the condition to set
   */
  public void setCondition(JSONArray condition) {
    this.conditions = condition;
  }

  /**
   * @param condition the condition to add
   */
  public void addCondition(JSONObject condition) {
    this.conditions.put(condition);
  }

  /**
   *
   * @param columnName the column name
   * @param value the value
   * @param operation the operation
   */
  public void addCondition(String columnName, String value, String operation) {
    this.conditions.put(new JSONObject().put("columnName", columnName).put("value", value)
        .put("operation", operation));
  }

  /**
   *
   * @param enumValue the Operation name
   * @return the specified value of operation
   */
  public String getOperation(String enumValue) {
    return Operations.valueOf(enumValue).toString();
  }

  private enum Operations {

    equal("="), notEqual("<>"), grOrEqual(">="), lessOrEqual("<="), gr(">"), less("<"), like("like");

    private final String operation;

    private Operations(String element) {
      this.operation = element;
    }

    @Override
    public String toString() {
      return operation;
    }
  }
}
