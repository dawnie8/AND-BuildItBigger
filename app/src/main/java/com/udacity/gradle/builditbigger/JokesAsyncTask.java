package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import ipomoea.jokes_android_library.JokeDisplayActivity;

public class JokesAsyncTask extends AsyncTask<Void, Void, String> {

    private MyApi myApiService = null;

    private Context context;

    JokesAsyncTask (Context context){
        this.context = context.getApplicationContext();
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new com.google.api.client.googleapis.services.GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws java.io.IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            return myApiService.getAJoke().execute().getData();
        } catch (java.io.IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        Intent jokeIntent = new Intent(context, JokeDisplayActivity.class);
        jokeIntent.putExtra("jokeText", joke);
        jokeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(jokeIntent);
    }
}
