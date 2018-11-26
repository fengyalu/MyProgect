package com.lulu.demo11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lulu.demo11.dialog.MyDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyDialog myDialog;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        myDialog = new MyDialog(this);
        showDialog = (Button) findViewById(R.id.show_dialog);
        showDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_dialog:
                myDialog.setTxtTitle("我的标题")
                        .setTxtContent("这里写需要展示的内容！")
                        .setTxtBtnLeft("取消")
                        .setTxtBtnRight("确定")
                        .setTxtBtnCenter("详情")
                        .setCancelable(true)
                        .show(MyDialog.Type.TYPT_ONE, MyDialog.Gravitys.CENTER)
                        .setOnButtonClickListener(new MyDialog.OnButtonClickListener() {
                            @Override
                            public void onLeftClick() {
                                Toast.makeText(MainActivity.this, "左侧按钮", Toast.LENGTH_SHORT).show();
                                myDialog.dismiss();
                            }

                            @Override
                            public void onCenterClick() {
                                Toast.makeText(MainActivity.this, "按中间钮", Toast.LENGTH_SHORT).show();
                                myDialog.dismiss();
                            }

                            @Override
                            public void onRightClick() {
                                Toast.makeText(MainActivity.this, "右侧按钮", Toast.LENGTH_SHORT).show();
                                myDialog.dismiss();
                            }
                        });

                break;
            default:
                break;
        }
    }
}
