#Gson Demo
This repository demonstrates working of Popular JSON processing Library [Gson](https://github.com/google/gson).

This app Connects to [Youtube API](https://developers.google.com/youtube/) and fetch Channel Video List and shows details in a Custom [Listview](http://developer.android.com/reference/android/widget/ListView.html).

To include Library in Project we have added 

    compile 'com.google.api-client:google-api-client-gson:1.21.0'

to **build.gradle** file in the App folder.

The project contains Four Classes

 1. MainActivity.java: Main Activity file of the Application.
 2. CustomListAdapter: Adapter class extending BaseAdapter for custom ListView
 3. Utility: Class containing helper functions.
 4. YoutubeResponse: Class which gets mapped to the Youtube API response. We are using GSon Library to do the Mapping.

The project has only one Activity the MainActivity with a TextView and a Button for searching channel data based on channel ID entered in TextView.

App Permissions
App uses only `android.permission.INTERNET` permission.