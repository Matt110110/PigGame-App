package matruprasadchand.github.matt110110.piggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTextViewPlayer1;
    TextView mTextViewPlayer2;
    ImageView mImageViewPlayer1;
    ImageView mImageViewPlayer2;
    Button rollButton;
    Button holdButton;
    TextView mTextViewTemp1;
    TextView mTextViewTemp2;
    int activePlayer = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewPlayer1 = findViewById(R.id.txt_player1);
        mTextViewPlayer2 = findViewById(R.id.txt_player2);
        mImageViewPlayer2 = findViewById(R.id.player2);
        mImageViewPlayer1 = findViewById(R.id.player1);
        mTextViewTemp1 = findViewById(R.id.temp_player1);
        mTextViewTemp2 = findViewById(R.id.temp_player2);
        rollButton = findViewById(R.id.roll);
        holdButton = findViewById(R.id.hold);
        final int[] diceImage = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4,
                R.drawable.dice5, R.drawable.dice6};
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d("pig", "The button has been pressed.");
//                Random randomNuGenerator = new Random();
//                int num = randomNuGenerator.nextInt(6);
//                Log.d("pig", "Random number is: " + num );
//                mImageViewPlayer1.setImageResource(diceImage[num]);
//                num = randomNuGenerator.nextInt(6);
//                mImageViewPlayer2.setImageResource(diceImage[num]);
                Random dice_roll = new Random();
                int output = dice_roll.nextInt(6);
                if (activePlayer == 1) {
                    mImageViewPlayer1.setImageResource(diceImage[output]);
                    if (output == 5) {
                        mTextViewTemp1.setText(R.string.init_score);
                        Toast.makeText(getApplicationContext(), "Player 2's turn", Toast.LENGTH_SHORT).show();
                        activePlayer = 2;
                    }
                    else {
                        int temp = Integer.parseInt(mTextViewTemp1.getText().toString());
                        temp += (output + 1);
                        mTextViewTemp1.setText(Integer.toString(temp));
                    }
                }
                else {
                    mImageViewPlayer2.setImageResource(diceImage[output]);
                    if (output == 5) {
                        mTextViewTemp2.setText(R.string.init_score);
                        Toast.makeText(getApplicationContext(), "Player 1's turn", Toast.LENGTH_SHORT).show();
                        activePlayer = 1;
                    }
                    else {
                        int temp = Integer.parseInt(mTextViewTemp2.getText().toString());
                        temp += (output + 1);
                        mTextViewTemp2.setText(Integer.toString(temp));
                    }
                }
            }
        });
        holdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activePlayer == 1) {
                    int temp_score = Integer.parseInt(mTextViewTemp1.getText().toString());
                    int perma_score = Integer.parseInt(mTextViewPlayer1.getText().toString());
                    perma_score += temp_score;
                    mTextViewPlayer1.setText(Integer.toString(perma_score));
                    mTextViewTemp1.setText(R.string.init_score);
                    activePlayer = 2;
                }
                else {
                    int temp_score = Integer.parseInt(mTextViewTemp2.getText().toString());
                    int perma_score = Integer.parseInt(mTextViewPlayer2.getText().toString());
                    perma_score += temp_score;
                    mTextViewPlayer2.setText(Integer.toString(perma_score));
                    mTextViewTemp2.setText(R.string.init_score);
                    activePlayer = 1;
                }
            }
        });
    }
}
