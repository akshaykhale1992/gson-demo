package gson.akshay.com.gsondemo;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Akshay on 4/19/2016.
 */
public class Utility {
    public static String jsonData = "";
    public static String getJson(final String apiUrl){
        AsyncTask<String,String,String> asynTask = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                try {
                    URL url = new URL(apiUrl);
                    HttpURLConnection connection =
                            (HttpURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));
                    String data = "";
                    String finalData = "";
                    while ((data = br.readLine()) != null){
                        finalData += data;
                    }
                    return finalData;
                } catch (Exception e) {
                    return e.getMessage();
                }
            }

            @Override
            protected void onPostExecute(String s) {
                jsonData = s;
            }
        };

        asynTask.execute();
        return jsonData;
    }
}
