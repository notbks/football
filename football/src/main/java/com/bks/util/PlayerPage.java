package com.bks.util;

public class PlayerPage {
	int start =0;
	int count =5;
	int last =0;
	//获取最后一页的开始
	public void caculateLast(int total) {
		//如果是50 就是45开始
		if(0==total%count) {
			last =total -count;
		}else {
			//如果是51 就从51-1=50开始
			last =total -total%count;
		}
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLast() {
		return last;
	}
//
//	public void setLast(int last) {
//		this.last = last;
//	}
//	
}
