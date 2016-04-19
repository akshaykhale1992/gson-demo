package gson.akshay.com.gsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String apiResponseString;
    ListView listView;
    EditText editTextView;
    Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        apiResponseString = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectViews();
        searchButton.setOnClickListener(this);
    }

    private void selectViews(){
        listView = (ListView) findViewById(R.id.video_details);
        editTextView = (EditText) findViewById(R.id.editText);
        searchButton = (Button) findViewById(R.id.search_button);
    }

    @Override
    public void onClick(View v) {
        try {
            String apiUrl = getResources().getString(R.string.youtube_api_url).toString();
            apiUrl = apiUrl + editTextView.getText().toString();
            apiResponseString = Utility.getJson(apiUrl);

            ArrayList<HashMap <String,String>> listItems = new ArrayList();
            if(apiResponseString != null && apiResponseString != ""){
                Gson gson = new Gson();
                YoutubeResponse youtubeResponse = gson.fromJson(apiResponseString, YoutubeResponse.class);
                for(int i=0;i < youtubeResponse.items.length;i++) {
                    HashMap<String,String> videoData = new HashMap<>();
                    videoData.put("video_title", youtubeResponse.items[i].snippet.title);
                    videoData.put("video_description", youtubeResponse.items[i].snippet.description);
                    listItems.add(videoData);
                }
            }
            CustomListAdapter customListAdapter = new CustomListAdapter(this, listItems);
            listView.setAdapter(customListAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
