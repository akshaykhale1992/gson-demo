package gson.akshay.com.gsondemo;

/**
 * Created by Akshay on 4/19/2016.
 * This is the class which
 * gets mapped to the JSON
 * response returned by
 * Youtube API.
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
