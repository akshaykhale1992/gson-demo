package gson.akshay.com.gsondemo;

/**
 * Created by Akshay on 4/19/2016.
 */
public class YoutubeResponse {
    public String kind;
    public YoutubeVideo[] items;

    public class YoutubeVideo{
        public String kind;
        public Snippet snippet;
    }

    public class Snippet{
        public String title, description;
    }
}
