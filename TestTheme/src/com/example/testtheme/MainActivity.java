package com.example.testtheme;

import java.util.LinkedList;
import java.util.List;

import com.example.testtheme.bean.DemoAdapter;
import com.example.testtheme.bean.OrderBean;
import com.example.testtheme.bean.OrderBean.GoodsBean;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


@SuppressLint("NewApi") public class MainActivity extends FragmentActivity {

    private TextView titleView;

	LinearLayout mLayout;
	Toolbar mToolbar;
	ImageView mImageView;
	ListView mListView;
	List<ImgData> mDatas;

	private Animation animation;

	private LayoutAnimationController controller;
	
	boolean isDown = true;
	boolean isRunAnim = true;
	
	DemoAdapter adapter;
	List<OrderBean> orderBeans;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mListView =(ListView) findViewById(R.id.listView1);
        
        orderBeans = new LinkedList<OrderBean>();
        for (int i = 0; i < 20; i++) {
			OrderBean bean = new OrderBean();
			orderBeans.add(bean);
			bean.goodsBeans = new LinkedList<OrderBean.GoodsBean>();
			for (int j = 0; j < Math.random()*12; j++) {
				GoodsBean goodsBean = new GoodsBean();
				goodsBean.goodsName = "i-"+i +"-j-"+j;
				bean.goodsBeans.add(goodsBean);
			}
		}
        
        adapter = new DemoAdapter(orderBeans, this);
        mListView.setAdapter(adapter);
        
        int s = adapter.getSection();
        int count = adapter.getCount();
        
        TextView headTextView = new TextView(this);
        headTextView.setText("list heeee");
        mListView.addHeaderView(headTextView);
        
         Log.d("demo", "s:"+s +" c:" +count +" types =" + adapter.getViewTypeCount());
        
    }
}
