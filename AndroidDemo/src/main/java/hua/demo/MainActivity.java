package hua.demo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import hua.demo.activity.Demo01Activity;
import hua.demo.activity.Demo02Activity;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btn01;
    private Button btn02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1.去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        assignViews();
        setListener();
    }

    private void setListener() {
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
    }


    private void assignViews() {
        btn01 = (Button) findViewById(R.id.btn_01);
        btn02 = (Button) findViewById(R.id.btn_02);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_01:
                intent = new Intent(this, Demo01Activity.class);
                break;

            case R.id.btn_02:
                intent = new Intent(this, Demo02Activity.class);
                break;
        }
        startActivity(intent);
    }
}
