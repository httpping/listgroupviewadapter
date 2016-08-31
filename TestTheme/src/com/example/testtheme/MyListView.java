package com.example.testtheme;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class MyListView  extends ListView{

	public MyListView(Context context ) {
		super(context );
		init();
	}

	public MyListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();

	}
	public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}
	
	private void init() {
		
		setOnScrollListener(new AbsListView.OnScrollListener() {
		    @Override
		    public void onScrollStateChanged(AbsListView view, int scrollState) {
		    }
	
		    @Override
		    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		        if (firstVisibleItem == 0) {
		        	 View firstVisibleItemView = getChildAt(0);
		        	    if (firstVisibleItemView != null && firstVisibleItemView.getTop() == 0) {
		        	        Log.d("ListView", "<----滚动到顶部----->");
		        			getParent().requestDisallowInterceptTouchEvent(false);

		        	    }
		        } else if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
		            Log.d("ListView", "#####滚动到底部######");
        			getParent().requestDisallowInterceptTouchEvent(false);

		        }
		    }
		});
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		getParent().requestDisallowInterceptTouchEvent(true);
		return super.onTouchEvent(ev);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		return super.dispatchTouchEvent(ev);
	}
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		//Log.d("list", "oldl:" +l  +" oldt:" +oldt); 
		super.onScrollChanged(l, t, oldl, oldt);
	}
	
	public boolean onTouch(View v, MotionEvent event) {  
		Log.d("list", "oldl:" +event.getX()  +" oldt:" +event.getY()); 

		   switch (event.getAction()) {  
		   case MotionEvent.ACTION_MOVE:   
		      // getParent().requestDisallowInterceptTouchEvent(true);  
		       break;  
		   case MotionEvent.ACTION_UP:  
		   case MotionEvent.ACTION_CANCEL:  
			  // getParent().requestDisallowInterceptTouchEvent(false);  
		       break;  
		 }
		return super.onTouchEvent(event);
	}
}
