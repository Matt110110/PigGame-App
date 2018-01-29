package matruprasadchand.github.matt110110.piggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTextViewPlayer1;
    TextView mTextViewPlayer2;
    ImageView mImageViewPlayer1;
    ImageView mImageViewPlayer2;
    Button rollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewPlayer1 = findViewById(R.id.txt_player1);
        mTextViewPlayer1.setText(R.string.init_score);
        mTextViewPlayer2 = findViewById(R.id.txt_player2);
        mTextViewPlayer2.setText(R.string.init_score);
        mImageViewPlayer2 = findViewById(R.id.player2);
        mImageViewPlayer1 = findViewById(R.id.player1);
        rollButton = findViewById(R.id.roll);
        final int[] diceImage = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4,
                R.drawable.dice5, R.drawable.dice6};
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("pig", "The button has been pressed.");
                Random randomNuGenerator = new Random();
                int num = randomNuGenerator.nextInt(6);
                Log.d("pig", "Random number is: " + num );
                mImageViewPlayer1.setImageResource(diceImage[num]);
                num = randomNuGenerator.nextInt(6);
                mImageViewPlayer2.setImageResource(diceImage[num]);
            }
        });
    }
}
