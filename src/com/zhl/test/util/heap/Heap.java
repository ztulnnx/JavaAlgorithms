package com.zhl.test.util.heap;

import com.zhl.test.util.Utils;

/**
 * 堆
 * @author zhanghanlin
 *
 */
public class Heap {	
	public static final int HEAD_MAX = 0;	//最大堆标识
	public static final int HEAD_MIN = 1;	//最小堆标识
	private final int DEFAULT_CAPATITY_SIZE = 16;	//默认堆大小为16
	
	private Integer[] src;	//堆
	private int size = 0;	//堆中的元素个数
	
	public Heap() {
		src = new Integer[DEFAULT_CAPATITY_SIZE];
	}
	
	public Heap(int size){
		src = new Integer[size];
	}
	
	/**
	 * insert value
	 * @param value
	 */
	public void insert(int value){
		src[size] = value;
		size++;
	}
	
	/**
	 * 堆排序
	 * @param type
	 */
	public void heapSort(int type){
		buildHeap(type);
		for (int i = size - 1; i >= 0; i--) {
			Utils.swap(src,0, i);
			heapify(0, i - 1,type);
		}
	}
	
	/**
	 * 根据type得到最大/最小堆
	 * @param type	MAX,MIN
	 */
	public void buildHeap(int type){
		int heapSize = size - 1;
		for (int i = heapSize / 2; i >= 0;i--) {
			heapify(i, heapSize, type);
		}
	}
	
	/**
	 * 最大/最小堆
	 * @param i	下标
	 * @param heapSize	堆长度
	 * @param type	MAX,MIN
	 */
	public void heapify(int i,int heapSize,int type){
		int l = Utils.left(i);	//得到左孩子下标
		int r = Utils.right(i);	//得到右孩子下标
		int largest = i;
		if (type == HEAD_MAX) {
			//如果左孩子val比src[i]的val大,则将其下标存储在largest中
			if (l <= heapSize && src[l] > src[i]) {
				largest = l;
			}
			//如果右孩子val比src[i]的val大,则将其下标存储在largest中
			if (r <= heapSize && src[r] > src[largest]) {
				largest = r;
			}
		} else {
			//如果左孩子val比src[i]的val大,则将其下标存储在largest中
			if (l <= heapSize && src[l] < src[i]) {
				largest = l;
			}
			//如果右孩子val比src[i]的val大,则将其下标存储在largest中
			if (r <= heapSize && src[r] < src[largest]) {
				largest = r;
			}
		}
		//如果下标i对应的元素不为最大,则不符合最大堆性质,交换i和largest的元素
		if (largest != i) {
			Utils.swap(src,i, largest);
			heapify(largest, heapSize,type);
		}
	}
	
	public static void main(String[] args) {
		int[] src = {49,38,52,44,81,97,76,13,27,65};
		Heap heap = new Heap(10);
		for (int i = 0; i < src.length; i++) {
			heap.insert(src[i]);
		}
		Utils.print(heap.src,"原始堆");
		heap.buildHeap(HEAD_MAX);
		Utils.print(heap.src,"最大堆");
		heap.heapSort(HEAD_MAX);
		Utils.print(heap.src,"最大堆排序");
		heap.buildHeap(HEAD_MIN);
		Utils.print(heap.src,"最小堆");
		heap.heapSort(HEAD_MIN);
		Utils.print(heap.src,"最小堆排序");
	}
}