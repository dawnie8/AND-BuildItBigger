package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class JokesAsyncTaskTest extends AndroidTestCase {

    private Context context = InstrumentationRegistry.getTargetContext();

    public void testJokeReceived() {

        JokesAsyncTask task = new JokesAsyncTask(context);
        task.execute();

        try {
            String joke = task.get();
            assertNotNull(joke);
            assertTrue(joke.length() > 0);

        } catch (InterruptedException | ExecutionException e) {
            Log.e("JokesAsyncTaskTest", Log.getStackTraceString(e));
        }
    }


}
