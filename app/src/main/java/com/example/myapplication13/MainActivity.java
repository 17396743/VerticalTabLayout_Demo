package com.example.myapplication13;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 *  垂直菜单栏实现的简单案例
 */
public class MainActivity extends AppCompatActivity {

    private VerticalTabLayout vtOne;
    private TextView tvOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        //临时的数据
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("测试" + i);
        }

        //垂直菜单栏的适配器
        vtOne.setTabAdapter(new TabAdapter() {
            //数据的总数
            @Override
            public int getCount() {
                return strings.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }
            // 每条数据显示的图片
            @Override
            public ITabView.TabIcon getIcon(int position) {
                ITabView.TabIcon tabIcon = new ITabView.TabIcon.Builder()
                        .setIcon(R.drawable.man_01_pressed,R.drawable.man_01_none).build();
                return tabIcon;
            }
            // 每条数据显示的内容
            @Override
            public ITabView.TabTitle getTitle(int position) {
                ITabView.TabTitle tabTitle = new ITabView.TabTitle.Builder()
                        .setContent(strings.get(position)).build();
                return tabTitle;
            }

            //点击后显示的颜色
            @Override
            public int getBackground(int position) {
                return Color.BLUE;
            }
        });

        //垂直菜单栏点击监听
        vtOne.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                tvOne.setText(strings.get(position));
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

    }

    private void initView() {
        vtOne = (VerticalTabLayout) findViewById(R.id.vt_one);
        tvOne = (TextView) findViewById(R.id.tv_one);
    }
}