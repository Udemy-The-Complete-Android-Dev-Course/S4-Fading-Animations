package ldansorean.s4fadinganimations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static int ANIMATION_DURATION = 2000;
    private float roseAlpha = 1;
    private ImageView roseImg, yellowImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roseImg = findViewById(R.id.rose);
        yellowImg = findViewById(R.id.yellow);

        //set initial transparency
        roseImg.setAlpha(roseAlpha);
        yellowImg.setAlpha(1-roseAlpha);
    }

    /**
     * Swap transparency between images using animation.
     * When one image is visible the other is transparent.
     */
    public void animate(View view) {
        Log.i("animate", getResources().getResourceEntryName(view.getId()) + " was clicked.");

        roseAlpha = 1 - roseAlpha;
        roseImg.animate().alpha(roseAlpha).setDuration(ANIMATION_DURATION);
        yellowImg.animate().alpha(1 - roseAlpha).setDuration(ANIMATION_DURATION);
    }
}
