package java;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sample {

    private final static Logger logger = LoggerFactory.getLogger(JsonParser.class);

    public static void main(String[] args) {
        logger.info("Anwendung startet");
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse("{\"name\": \"Luca\"}");
        logger.info("Json erfolgreich geparst");

        JsonObject object = element.getAsJsonObject();
        String name = object.get("name").getAsString();
        System.out.println(name);
        logger.info("Name: {}", name);

        String json = "{\"nae\": \"Alicia\"}";
        String extractedName = getNameFromJson(json);
        System.out.println(extractedName);
    }

    public static String getNameFromJson(String json) {

        if (json == null) {
            throw new NullPointerException("input must not be null");
        }

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);

        JsonObject object = element.getAsJsonObject();

        if (object.get("name") == null) {
            throw new IllegalArgumentException("input must have key \"name\"");
        }

        return object.get("name").getAsString();
    }

    public static String getNameFromJsonWithExtensions(String json) {

        if (json == null) {
            throw new NullPointerException("input must not be null");
        }

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);

        if (element.isJsonObject()) {
            JsonObject object = element.getAsJsonObject();
            if (object.has("name")) {
                return object.get("name").getAsString();
            }
        }

        // Return a default value or handle the case where "name" is not found in the JSON
        return "Name Not Found";
    }
}