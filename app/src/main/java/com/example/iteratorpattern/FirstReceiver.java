package com.example.iteratorpattern;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FirstReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //添加Intent中附加的限制值
        int limit = intent.getIntExtra("limit",-1001);

        //如果限制值等于1000，则处理。否则继续转发给下一个Receiver
        if (limit == 1000){
            //获取Intent中附加的字符串消息并Toast
            String msg = intent.getStringExtra("msg");
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();

            //终止广播
            abortBroadcast();
        }else {
            //添加信息发送给下一条Receiver
            Bundle b = new Bundle();
            b.putString("new","Message from FirstReceiver");
            setResultExtras(b);
        }
    }
}
