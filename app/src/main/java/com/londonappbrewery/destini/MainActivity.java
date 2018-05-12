package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView storyText;
    Button topButton;
    Button bottomButton;
    int storyIndex = 1;
    private int[] stories = {R.string.T1_Story, R.string.T2_Story, R.string.T3_Story,
            R.string.T4_End, R.string.T5_End, R.string.T6_End};
    private int[] topText = {R.string.T1_Ans1, R.string.T2_Ans1, R.string.T3_Ans1};
    private int[] bottomText = {R.string.T1_Ans2, R.string.T2_Ans2, R.string.T3_Ans2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyText = (TextView) findViewById(R.id.storyTextView);
        topButton = (Button) findViewById(R.id.buttonTop);
        bottomButton = (Button) findViewById(R.id.buttonBottom);

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positivePath();
                display();
            }
        });

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negativePath();
                display();
            }
        });

    }

    void positivePath(){
        if(storyIndex == 1)
            storyIndex += 2;
        else if(storyIndex == 2)
            storyIndex += 4;
        else if(storyIndex == 3)
            storyIndex += 3;
    }

    void negativePath(){
        if(storyIndex == 1)
            storyIndex++;
        else if(storyIndex == 2)
            storyIndex += 2;
        else if(storyIndex == 3)
            storyIndex += 2;
    }

    void display(){
        storyText.setText(stories[storyIndex-1]);
        if(storyIndex < 4)
        {
            topButton.setText(topText[storyIndex-1]);
            bottomButton.setText(bottomText[storyIndex-1]);
        }
        else
        {
            topButton.setVisibility(View.GONE);
            bottomButton.setVisibility(View.GONE);
        }
    }
}
