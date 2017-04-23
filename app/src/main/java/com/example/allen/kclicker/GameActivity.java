package com.example.allen.kclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final KClicker kclicker = new KClicker(10);
        TextView countText = (TextView)findViewById(R.id.count);
        countText.setText("あと" + kclicker.getCount() + "回");

        findViewById(R.id.clickButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                kclicker.click();
                TextView countText = (TextView) findViewById(R.id.count);

                if(kclicker.isEnd()) {
                    countText.setText("クリア！");
                } else {
                    countText.setText("あと" + kclicker.getCount() + "回");
                }
            }
        });

        findViewById(R.id.prevButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}


class KClicker {
    private int clickCount;

    KClicker(int count){
        setCount(count);
    }

    void setCount(int count) { clickCount = count; }
    int  getCount() { return clickCount; }
    void click() { clickCount -= 1; }
    boolean isEnd() { return clickCount <= 0; }
}