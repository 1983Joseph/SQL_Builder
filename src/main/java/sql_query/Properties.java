package sql_query;

import org.json.*;

public class Properties {

  private JSONArray properties = null;

  public Properties() {}

  public JSONArray getProperties() {
    return properties;
  }

  public void setProperties(String propertiesString) {
    JSONArray objectArray = new JSONArray(propertiesString);
    this.properties = objectArray;
  }

  @Override
  public String toString() {
    return properties.toString();
  }

}
