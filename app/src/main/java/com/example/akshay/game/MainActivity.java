package com.example.akshay.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    Boolean playing = true;
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    // 0 is 0, 1 is X
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn (View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && playing) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.o);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.x);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            for (int[] winningPosition : winningPositions){
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] !=2 && playing == true){

                    playing = false;
                    String winner = "";
                    if (gameState[winningPosition[0]] == 0){
                        winner = "O has won";
                    } else if (gameState[winningPosition[0]] == 1){
                        winner = "X has won";
                    }


                    TextView tvWinner = (TextView) findViewById(R.id.tvWinner);
                    tvWinner.setText(winner);

                }
            }
        }
    }

    public void playAgain(View view) {
        playing = true;
        activePlayer = 0;
        for (int i = 0;i<gameState.length;i++){
            gameState[i] = 2;

        }
        TextView tvWinner = (TextView) findViewById(R.id.tvWinner);
        tvWinner.setText("");
        ImageView im1 = (ImageView) findViewById(R.id.imX1);
        ImageView im2 = (ImageView) findViewById(R.id.imX2);
        ImageView im3 = (ImageView) findViewById(R.id.imX3);
        ImageView im4 = (ImageView) findViewById(R.id.imX4);
        ImageView im5 = (ImageView) findViewById(R.id.imX5);
        ImageView im6 = (ImageView) findViewById(R.id.imX6);
        ImageView im7 = (ImageView) findViewById(R.id.imX7);
        ImageView im8 = (ImageView) findViewById(R.id.imX8);
        ImageView im9 = (ImageView) findViewById(R.id.imX9);

        im1.setImageResource(R.drawable.empty);
        im2.setImageResource(R.drawable.empty);
        im3.setImageResource(R.drawable.empty);
        im4.setImageResource(R.drawable.empty);
        im5.setImageResource(R.drawable.empty);
        im6.setImageResource(R.drawable.empty);
        im7.setImageResource(R.drawable.empty);
        im8.setImageResource(R.drawable.empty);
        im9.setImageResource(R.drawable.empty);
    }
}
