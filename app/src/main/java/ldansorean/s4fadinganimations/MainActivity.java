package ldansorean.s4fadinganimations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static int ANIMATION_DURATION = 2000;
    private static int ROTATIONS = 360 * 5;
    private float roseAlpha = 1, roseScale = 1;
    private float yellowAlpha = 0, yellowScale = 0;
    private ImageView roseImg, yellowImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roseImg = findViewById(R.id.rose);
        yellowImg = findViewById(R.id.yellow);

        //set initial transparency and size. Rose is full size and visible, yellow is transparent and small.
        roseImg.setAlpha(roseAlpha);
        yellowImg.setAlpha(yellowAlpha);
        yellowImg.setScaleX(yellowScale);
        yellowImg.setScaleY(yellowScale);
    }

    /**
     * Swap image in focus using animations.
     */
    public void animate(View view) {
        Log.i("animate", getResources().getResourceEntryName(view.getId()) + " was clicked.");

        //flip sizes and alpha
        roseAlpha = 1 - roseAlpha;
        roseScale = 1 - roseScale;
        yellowAlpha = 1 - yellowAlpha;
        yellowScale = 1 - yellowScale;

        Log.i("animate", String.format("Rose: alpha = %.2f, scale = %.2f", roseAlpha, roseScale));
        Log.i("animate", String.format("Yellow: alpha = %.2f, scale = %.2f", yellowAlpha, yellowScale));

        //animate new size and alpha
        roseImg.animate().alpha(roseAlpha).scaleX(roseScale).scaleY(roseScale).rotationBy(ROTATIONS).setDuration(ANIMATION_DURATION);
        yellowImg.animate().alpha(yellowAlpha).scaleX(yellowScale).scaleY(yellowScale).rotationBy(ROTATIONS).setDuration(ANIMATION_DURATION);
    }
}
