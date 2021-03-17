package com.zhl.test.util.sort;

import com.zhl.test.util.Utils;

/**
 * 快速排序
 * @author zhanghanlin
 *
 */
public class QuickSort {
	public static Integer[] src = new Integer[16];
	
	/**
	 * 快速排序
	 * @param src	需要排序的数组
	 * @param p	排序开始位置
	 * @param r	排序结束位置
	 */
	public static void sort(int p,int r){
		if (p < r) {
			int q = partition(p, r);
			sort(p, q - 1);
			sort(q + 1, r);
		}
	}
	
	/**
	 * 返回数组分割下标位置
	 * @param p	排序开始位置
	 * @param r	排序结束位置
	 * @return
	 */
	public static int partition(int p, int r){
		int x = src[r];	//主元,围绕该Val进行划分字数组
		int i = p;	//排序开始比较的位置
		for (int j = p; j < r; j++) {
			if (src[j] <= x) {
				Utils.swap(src,i, j);	//交换
				i++;
			}
		}
		Utils.swap(src,i, r);
		return i;
	}
	
	public static void main(String[] args) {
		src = Utils.random(10, 100, 10);
		Utils.print(src,"排序前");
		int p = 0;	//起始索引,默认第一个0
		int r = src.length - 1;	//最末索引,数组长度减一
		sort(p, r);	//开始排序
		Utils.print(src,"排序后");
	}
}
