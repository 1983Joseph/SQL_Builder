package sql_query;

public class Constants {
  
  public final String OPERATION = "operation";
  public final String FIELD = "field";
  public final String VALUE = "value";
  
  private static Constants instance = null;

  public Constants() {
    
  }

  public static Constants getInstance() {
      if (instance == null) {
          instance = new Constants();
      }
      return instance;
  }

}
