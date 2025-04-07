package Util;

import okhttp3.*;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * Author: Sivaraman M
 * User:Sivaraman M
 */
public class TranslateUtil {
    //Generate and use your API Key
    private static final String API_KEY = "934b5ab795mshf1facfcdc77d260p1f3058jsnabb8bc791b92";
    private static final String API_HOST = "rapid-translate-multi-traduction.p.rapidapi.com";

    public static String translateToEnglish(String text) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String jsonBody = "{\"from\":\"auto\",\"to\":\"en\",\"q\":\"" + text + "\"}";
        RequestBody body = RequestBody.create(mediaType, jsonBody);


        Request request = new Request.Builder()
                .url("https://rapid-translate-multi-traduction.p.rapidapi.com/t")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("X-RapidAPI-Key", API_KEY)
                .addHeader("X-RapidAPI-Host", API_HOST)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        String responseBody = response.body().string();

     //   System.out.println("Raw Response: " + responseBody);
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response + "\nBody: " + responseBody);
        }

        JSONArray topArray = new JSONArray(responseBody);
        JSONArray innerArray = topArray.getJSONArray(0);
        return innerArray.getString(0);
    }
    public static boolean isTextSpanish(String text) {
        try {
            String translated = TranslateUtil.translateToEnglish(text);
            return !translated.equalsIgnoreCase(text);
        } catch (IOException e) {
            return false;
        }
    }


}
