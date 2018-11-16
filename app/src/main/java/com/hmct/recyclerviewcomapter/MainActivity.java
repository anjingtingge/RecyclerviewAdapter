package com.hmct.recyclerviewcomapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    public CommonAdapter commonAdapter;
    public List<ItemBean> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView)findViewById(R.id.rcv1);

        mDatas = new ArrayList<ItemBean>();

        for (int i = 0; i <= 10; i++)
        {
//            mDatas.add((char) i + "");
            mDatas.add(new ItemBean(String.valueOf(i), String.valueOf(i+1)));

        }




        commonAdapter=new CommonAdapter<ItemBean>(this,R.layout.item_step, mDatas)
        {
            @Override
            public void convert(ViewHolder holder, ItemBean s)
            {
                TextView tv = holder.getView(R.id.tex);
                TextView textView = holder.getView(R.id.texq);
                tv.setText(s.getDesc());
                textView.setText(s.getUrl());
            }
        };
        //普通
//        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //网格
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);

        //瀑布流
//        StaggeredGridLayoutManager  layoutManager=new StaggeredGridLayoutManager( 2,StaggeredGridLayoutManager.VERTICAL );
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(commonAdapter);

        commonAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position)
            {
                String aa=mDatas.get(position).getDesc();
                Toast.makeText(MainActivity.this, aa, Toast.LENGTH_SHORT).show();
//                commonAdapter.notifyItemRemoved(position);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position)
            {
                return false;
            }
        });


    }
}
