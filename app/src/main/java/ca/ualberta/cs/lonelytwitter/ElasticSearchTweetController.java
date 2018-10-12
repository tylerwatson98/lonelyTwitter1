package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;

public class ElasticSearchTweetController {

    static JestDroidClient client=null;


    public static void setClient(){
        if(client==null){
            DroidClientConfig config = new DroidClientConfig
                    .Builder("http://cmput301.softwareprocess.es.8080/")
                    .build();
            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client=(JestDroidClient) factory.getObject();
        }
    }

    public static class AddTweetTask extends AsyncTask<Tweet, Void, Void>{
        @Override
        protected Void doInBackground(Tweet... params){
            return null;
        }

    }
}
