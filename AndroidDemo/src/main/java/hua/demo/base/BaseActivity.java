package hua.demo.base;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        setListener();
    }

    public abstract void initView();
    public abstract void initData();
    public abstract void setListener();

}
