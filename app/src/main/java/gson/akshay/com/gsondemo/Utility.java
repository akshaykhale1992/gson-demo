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

    /**
     * Function which connects to
     * given URL and returns
     * response as String
     * @param apiUrl String URL of API
     * @return String
     */
    public static String getJson(final String apiUrl){
        //Creating Async Task to coneect and get response.
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
