package com.loiter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.util.Assert;

public class Demo {
    public static void main(String[] args) {
        System.out.println("hello, world");
        String jsonstr = "{\"name\": {\"width\": \"23px\", \"color\": \"#232342\", \"height\": 23 }}";
//        jsonstr = null;
        Assert.notNull(jsonstr, "jsonStr should not null ");
        Gson gson = new Gson();
        JsonObject returnData = JsonParser.parseString(jsonstr).getAsJsonObject();
        System.out.println(returnData);
        System.out.println(returnData instanceof JsonObject);
        JsonObject jsonObject = returnData.deepCopy();
        JsonObject name = returnData.getAsJsonObject("name");
        System.out.println("name is " + name);
        returnData.addProperty("address", "Beijing");
        System.out.println(returnData);
        System.out.println(jsonObject);
        System.out.println(returnData.getAsJsonObject());
        returnData.keySet().forEach(System.out::println);
        System.out.println(returnData.getAsJsonObject("name").get("color"));

    }
}
