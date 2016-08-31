package com.example.testtheme;

import java.util.ArrayList;

import com.example.testtheme.VpBaseAdapter.ViewHolder;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnScrollChangeListener;
import android.widget.ListView;

 

public class IndexFragment extends Fragment {
	
	ListView mListView;
	private ArrayList<ImgData> mDatas;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.index_fragment_list, null);
		mListView = (ListView) view.findViewById(R.id.listView1);
		
		
		  mDatas = new ArrayList<ImgData>();
	        for (int i = 0; i < 100; i++) {
	        	ImgData data = new ImgData();
	        	data.url = "http://d05.res.meilishuo.net/pic/l/f0/da/60f12fb56faf727c9530984b6853_500_331.jpg";
	        	mDatas.add(data);
			}
		
		 VpBaseAdapter<ImgData> adapter = new VpBaseAdapter<ImgData>(getActivity(), mDatas,new ViewHolder<ImgData>() {

				@Override
				public View onCreateView(Context context, int position) {
					Log.d("adapter", "onCreateView" + position);
					/*ImageView imageView = new ImageView(MainActivity.this);
					imageView.setImageResource(R.drawable.home_4gpackage);
					imageView.setBackgroundColor(Color.parseColor("#dddddd"));*/
					View view ;

					view =LayoutInflater.from(getActivity()).inflate(R.layout.item_layout_fragment, null);
					
					return view;
				}

				@Override
				public void bindView(View v, ImgData t,int position) {
					 
				}
			});
	        
	       
	        mListView.setAdapter(adapter);
		
		
		return view;
	}
	
	
	
	
}
