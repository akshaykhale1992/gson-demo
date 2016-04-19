package gson.akshay.com.gsondemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Custom List Adapter Class
 * for Custom ListView
 */
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<HashMap<String, String>> videoData;
    private static LayoutInflater inflater = null;

    public CustomListAdapter(Activity activity, ArrayList<HashMap<String, String>> data) {
        this.activity = activity;
        videoData = data;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return videoData.size();
    }

    @Override
    public Object getItem(int position) {
        return videoData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_item, null);
        TextView videoTitle = (TextView) vi.findViewById(R.id.video_title);
        TextView videoDescription = (TextView) vi.findViewById(R.id.video_description);

        HashMap<String,String> video = new HashMap<String,String>();
        video = videoData.get(position);

        videoTitle.setText(video.get("video_title"));
        videoDescription.setText(video.get("video_description"));
        return vi;
    }
}
