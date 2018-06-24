package ipomoea.jokes_android_library;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        TextView jokeTextView = findViewById(R.id.joke_textView);
        Intent intent = getIntent();
        jokeTextView.setText(intent.getStringExtra("jokeText"));

    }
}