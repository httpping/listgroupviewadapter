package com.example.testtheme.bean;

import java.util.List;

public class OrderBean {
	
	public String storeName ;
	public String orderId ;
	public List<GoodsBean> goodsBeans;
	
	public boolean isShowAll;

	
	public static class GoodsBean{
		public String goodsName ;
		public String goodsPrice ;
	}

}
