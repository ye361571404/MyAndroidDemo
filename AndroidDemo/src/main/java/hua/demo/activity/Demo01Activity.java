package hua.demo.activity;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import hua.demo.R;
import hua.demo.base.BaseActivity;

public class Demo01Activity extends BaseActivity implements View.OnClickListener {


    private Button btn01;
    private Button btn02;
    private Button btn03;
    private Button btn04;
    private ImageView ivCat;
    private ImageView iv_fairy;
    private ImageView iv_pig;

    private Animation anim_alpha;
    private Animation anim_rotate;
    private Animation anim_scale;
    private Animation anim_translate;
    private AnimationDrawable anim_fairy;
    private boolean flag = true;
    private AnimationDrawable anim_pig;
    private Animation pig_translate_left;
    private Animation pig_translate_right;
    private RelativeLayout rl_pig;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_demo01);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        btn01 = (Button) findViewById(R.id.btn_01);
        btn02 = (Button) findViewById(R.id.btn_02);
        btn03 = (Button) findViewById(R.id.btn_03);
        btn04 = (Button) findViewById(R.id.btn_04);
        ivCat = (ImageView) findViewById(R.id.iv_cat);
        iv_fairy = (ImageView) findViewById(R.id.iv_fairy);
        iv_pig = (ImageView) findViewById(R.id.iv_pig);
        rl_pig = (RelativeLayout) findViewById(R.id.rl_pig);

        anim_alpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        anim_rotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        anim_scale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        anim_translate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        pig_translate_left = AnimationUtils.loadAnimation(this, R.anim.pig_translate_left);
        pig_translate_right = AnimationUtils.loadAnimation(this, R.anim.pig_translate_right);


        anim_fairy = (AnimationDrawable)iv_fairy.getBackground();
        anim_pig = (AnimationDrawable)iv_pig.getBackground();

    }

    @Override
    public void initData() {

    }


    @Override
    public void setListener() {
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
        iv_fairy.setOnClickListener(this);

        rl_pig.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                anim_pig.start();
                iv_pig.startAnimation(pig_translate_right);
                return false;
            }
        });

        pig_translate_left.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                iv_pig.setBackgroundResource(R.drawable.motionright);
                anim_pig = (AnimationDrawable)iv_pig.getBackground();
                anim_pig.start();
                iv_pig.startAnimation(pig_translate_right);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        pig_translate_right.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                iv_pig.setBackgroundResource(R.drawable.motionleft);
                anim_pig = (AnimationDrawable)iv_pig.getBackground();
                anim_pig.start();
                iv_pig.startAnimation(pig_translate_left);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn_01:
                ivCat.startAnimation(anim_alpha);
                break;
            case R.id.btn_02:
                ivCat.startAnimation(anim_rotate);
                break;
            case R.id.btn_03:
                ivCat.startAnimation(anim_translate);
                break;
            case R.id.btn_04:
                ivCat.startAnimation(anim_scale);
                break;
            case R.id.iv_fairy:
                if(flag){
                    anim_fairy.start();
                    flag = false;
                }else{
                    anim_fairy.stop();
                    flag = true;
                }
                break;
        }

    }
}
