package jp.naklab.assu.android.android_max_count;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private final String PREF_KEY = "pref_key";
    private final String PREF_SCORE_KEY = "highscore_key";
    SharedPreferences pref;
    int highScore;

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        highScore = loadHightScore();


        int currentScore = loadCurrentScore();


        if (currentScore > highScore) {
            highScore = currentScore;
        }

        textViewResult = findViewById(R.id.textview_result);
        textViewResult.setText("" + highScore);

        saveHighScore();
    }

    private int loadCurrentScore() {
        Intent intent = getIntent();
        return intent.getIntExtra(MainActivity.INTENT_KEY, 0);
    }

    private int loadHightScore() {
        pref = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        SharedPreferences.Editor e = pref.edit();
        return pref.getInt(PREF_SCORE_KEY, 15);
    }

    private void saveHighScore() {
        pref = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        SharedPreferences.Editor e = pref.edit();
        e.putInt(PREF_SCORE_KEY, highScore).commit();
    }


    public void back(View v) {
        finish();
    }


}
