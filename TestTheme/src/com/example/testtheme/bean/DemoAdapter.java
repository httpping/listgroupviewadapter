package com.example.testtheme.bean;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.testtheme.R;
import com.example.testtheme.listview.ListGroupAdapter;

public class DemoAdapter  extends ListGroupAdapter implements OnClickListener{

	public List<OrderBean> orderBeans;
	
	LayoutInflater mInflater;
	
	public DemoAdapter( List<OrderBean> orderBeans, Context context ){
		mContext = context;
		mInflater = LayoutInflater.from(context);
		
		this.orderBeans = orderBeans;
		
	}
	
	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSection() {
		return orderBeans.size();
	}
	
	@Override
	public int getRow(int section) {
		OrderBean bean = orderBeans.get(section);
		if (bean.isShowAll) {
			return bean.goodsBeans.size();
		}else {
			return bean.goodsBeans.size()>2?2:bean.goodsBeans.size();
		}
	}

	@Override
	public View getView(int position, IndexPath indexPath, View convertView,
			ViewGroup parent) {
		View view = null;
		if (convertView!=null) {
			view = convertView;
		}else{
			view = mInflater.inflate(R.layout.goods_item_layout, null);
		}
		TextView goodsView = (TextView) view.findViewById(R.id.goods_name);
		goodsView.setText(orderBeans.get(indexPath.section).goodsBeans.get(indexPath.row).goodsName);
		return view;
	}

	@Override
	public boolean isGroupHeaderForSection(int section) {
//		if (section%2==0) {
//			return false;
//		}
		return true;
	}
	@Override
	public boolean isGroupFooterForSection(int section) {
		if (orderBeans.get(section).goodsBeans.size()<=2) {
			return false ;
		}
		return true;
	}
	@Override
	public View getFooterView(int position, int section, View conView,
			ViewGroup parent) {
		View view = null;
		if (conView!=null) {
			view = conView ;
		}else{
			view = mInflater.inflate(R.layout.footer_item_layout, null);
		}
		
		Button button = (Button) view.findViewById(R.id.button1);
		button.setTag(section);
		OrderBean bean = orderBeans.get(section);
		if (bean.isShowAll) {
			button.setText("关闭 - " + bean.goodsBeans.size());	
		}else {
			button.setText("打开 - "+bean.goodsBeans.size());
		}
		
		button.setOnClickListener(this);
		
		return view;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.button1:
			int section = (Integer) v.getTag();
			OrderBean bean = orderBeans.get(section);
			bean.isShowAll = !bean.isShowAll;
			notifyDataSetChanged();
			break;
		default:
			break;
		}
	}
}
