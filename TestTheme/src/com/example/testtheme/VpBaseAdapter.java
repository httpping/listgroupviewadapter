package com.example.testtheme;

import java.util.List;

import android.R.integer;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 基础的adapter
 * @author tp
 *
 * @param <T>
 */
public class VpBaseAdapter<T> extends BaseAdapter {
	
	private Context mContext;
	private List<T> mDataList;
	ViewHolder<T> mViewHolder;
	
	public VpBaseAdapter(Context mContext, List<T> mDataList ,ViewHolder<T> viewHolder) {
		super();
		this.mContext = mContext;
		this.mDataList = mDataList;
		mViewHolder = viewHolder;
	}

	
	@Override
	public int getCount() {
		return mDataList == null ? 0: mDataList.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//if (convertView == null) {
			convertView =  mViewHolder.onCreateView(mContext, position);
		//} 
		
		mViewHolder.bindView(convertView,mDataList.get(position),position);
		
		return convertView;
	}
	
	
	/**
	 * view 持有 和 更新
	 * @author tp
	 *
	 * @param <T>
	 */
	public interface   ViewHolder<T> {
		
		/**
		 * 创建view
		 * @param context
		 * @return
		 */
		 public View onCreateView(Context context,int position);
		
		 public void bindView(View v,T t,int position);
	}
	
	

	/*VpBaseAdapter<AddGoodsBean> daAdapter = new VpBaseAdapter<AddGoodsBean>(this, new ArrayList<AddGoodsBean>(),new ViewHolder<AddGoodsBean>() {
		
		
		@Override
		public View onCreateView(Context context, int position) {
			return LayoutInflater.from(context).inflate(R.layout.activity_about,null);
		}

		@Override
		public void bindView(View v, AddGoodsBean t) {
			
			Finder(v);
			imageView.setImageResource(0);
			
		}
		
		ImageView imageView;
		
		public void Finder(View v){
			 imageView = (ImageView) v.findViewById(0);
		}
		
	});*/
	
	
}
