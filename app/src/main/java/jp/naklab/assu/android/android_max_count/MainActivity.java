package jp.naklab.assu.android.android_max_count;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String INTENT_KEY = "maxScore_key";
    int count;
    int maxCount;

    TextView textViewCount;
    TextView textViewMaxCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        textViewCount = findViewById(R.id.textview_count);
        textViewMaxCount = findViewById(R.id.textview_max);


        count = 0;
        maxCount = 0;
    }


    public void result(View v) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(INTENT_KEY, maxCount);
        startActivity(intent);
    }

    public void reset(View v) {
        count = 0;
        textViewCount.setText("" + count);
    }

    public void add(View v) {
        count++;
        textViewCount.setText("" + count);

        if (count > maxCount) {
            maxCount = count;
            textViewMaxCount.setText("" + maxCount);
        }
    }
}
