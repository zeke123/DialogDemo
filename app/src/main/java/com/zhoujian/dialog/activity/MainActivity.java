package com.zhoujian.dialog.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.zhoujian.dialog.R;
import com.zhoujian.dialog.customview.CustomDialog;
import com.zhoujian.dialog.customview.DialogInterface;
import java.util.ArrayList;

public class MainActivity extends Activity
{

    private  Button button;
    private  ArrayList<String> datas;
    private String mString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDatas();
        clickEvent();
    }

    private void initDatas()
    {
        datas = new ArrayList<String>();
        datas.add("男");
        datas.add("女");

        datas.clear();

        datas.add("计算机网络");
        datas.add("计算机图形学");
        datas.add("软件工程");


    }

    private void initView()
    {
        button = (Button)findViewById(R.id.button);
    }
    private void clickEvent()
    {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomDialog.Builder(MainActivity.this).setlTitleVisible(true)//设置是否显示标题
                        .setTitleHeight(65)   //设置标题高度
                        .setTitleText("选择选修的课程")  //设置标题提示文本
                        .setTitleTextSize(16) //设置标题字体大小 sp
                        .setTitleTextColor(R.color.colorPrimary) //设置标题文本颜色
                        .setItemHeight(45)  //设置item的高度
                        .setItemWidth(0.9f)  //屏幕宽度*0.9
                        .setItemTextColor(R.color.colorPrimaryDark)  //设置item字体颜色
                        .setItemTextSize(14)  //设置item字体大小
                        .setCancleButtonText("取消")  //设置最底部“取消”按钮文本
                        .setOnItemListener(new DialogInterface.OnItemClickListener<CustomDialog>() {
                            @Override
                            public void onItemClick(CustomDialog dialog, View button, int position) {
                                mString = datas.get(position);
                                Toast.makeText(MainActivity.this, mString, Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .setCanceledOnTouchOutside(true)  //设置是否可点击其他地方取消dialog
                        .build()
                        .setDatas(datas)
                        .show();
            }
        });
    }
}
