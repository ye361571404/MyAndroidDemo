package hua.demo.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import hua.demo.R;
import hua.demo.base.BaseActivity;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Demo02Activity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_demo02);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        btn01 = (Button) findViewById(R.id.btn_01);
        btn02 = (Button) findViewById(R.id.btn_02);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);

    }


    private Button btn01;
    private Button btn02;



    @Override
    public void onClick(View v) {
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        switch (v.getId()) {
            case R.id.btn_01:
                // 显示通知
                /*Notification notify = new Notification();     // 创建一个通知对象
                notify.icon = R.mipmap.advise1;               // 设置通知图片
                notify.tickerText = "显示第一个通知";
                notify.when = System.currentTimeMillis();
                notify.defaults = Notification.DEFAULT_ALL;
                notify.setLatestEventInfo(this, "无题", "每天进步一点点",null);//设置事件信息*/

                Notification.Builder notifyBuilder = new Notification.Builder(this);
                notifyBuilder.setSmallIcon(R.mipmap.advise1);
                notifyBuilder.setTicker("显示第一个通知");
                notifyBuilder.setWhen(System.currentTimeMillis());
                notifyBuilder.setDefaults(Notification.DEFAULT_ALL);
                notifyBuilder.setContentTitle("第一个通知");
                notifyBuilder.setContentText("每天进步一点点");
                Notification notification = notifyBuilder.build();
                notificationManager.notify(123,notification);

                Notification.Builder notifyBuilder02 = new Notification.Builder(this);
                notifyBuilder02.setSmallIcon(R.mipmap.advise2);
                notifyBuilder02.setTicker("显示第二个通知");
                notifyBuilder02.setWhen(System.currentTimeMillis());
                notifyBuilder02.setDefaults(Notification.DEFAULT_ALL);
                notifyBuilder02.setContentTitle("显示第二个通知");
                notifyBuilder02.setContentText("点击查看详细内容");
                notifyBuilder02.setAutoCancel(true);
                Intent intent = new Intent(this,ContentActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                notifyBuilder02.setContentIntent(pendingIntent);
                Notification notification2 = notifyBuilder02.build();
                notificationManager.notify(124,notification2);

                break;
            case R.id.btn_02:
                // 删除通知
                // notificationManager.cancel(123);
                notificationManager.cancelAll();

                break;
        }
    }
}
