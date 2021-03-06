package com.zhl.test.util.heap;

/**
 * 堆
 * @author zhanghanlin
 *
 */
public class Heap {
	
	public static final int HEAD_MAX = 0;
	public static final int HEAD_MIN = 1;
	
	public static void main(String[] args) {
		int[] A = {49,38,52,44,81,97,76,13,27,65};
		print(A,"原始堆");
		buildHeap(A,HEAD_MAX);
		print(A,"最大堆");
		heapSort(A,HEAD_MAX);
		print(A,"最大堆排序");
		buildHeap(A,HEAD_MIN);
		print(A,"最小堆");
		heapSort(A,HEAD_MIN);
		print(A,"最小堆排序");
	}
	
	/**
	 * 打印元素
	 * @param A
	 * @param s info
	 */
	public static void print(int[] A,String s){
		System.out.print(s + " > ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("");
	}
	
	/**
	 * 堆排序
	 * @param A
	 * @param type
	 */
	public static void heapSort(int[] A,int type){
		buildHeap(A,type);
		int heapSize = A.length - 1;
		for (int i = heapSize; i >= 0; i--) {
			swap(A, 0, i);
			heapify(A, 0, i - 1,type);
		}
	}
	
	/**
	 * 根据type得到最大/最小堆
	 * @param A	堆
	 * @param type	MAX,MIN
	 */
	public static void buildHeap(int[] A,int type){
		int heapSize = A.length - 1;
		for (int i = heapSize / 2; i >= 0;i--) {
			heapify(A, i, heapSize, type);
		}
	}
	
	/**
	 * 最大/最小堆
	 * @param A 堆
	 * @param i	下标
	 * @param heapSize	堆长度
	 * @param type	MAX,MIN
	 */
	public static void heapify(int[] A,int i,int heapSize,int type){
		int l = left(i);	//得到左孩子下标
		int r = right(i);	//得到右孩子下标
		int largest = i;
		if (type == HEAD_MAX) {
			//如果左孩子val比A[i]的val大,则将其下标存储在largest中
			if (l <= heapSize && A[l] > A[i]) {
				largest = l;
			}
			//如果右孩子val比A[i]的val大,则将其下标存储在largest中
			if (r <= heapSize && A[r] > A[largest]) {
				largest = r;
			}
		} else {
			//如果左孩子val比A[i]的val大,则将其下标存储在largest中
			if (l <= heapSize && A[l] < A[i]) {
				largest = l;
			}
			//如果右孩子val比A[i]的val大,则将其下标存储在largest中
			if (r <= heapSize && A[r] < A[largest]) {
				largest = r;
			}
		}
		//如果下标i对应的元素不为最大,则不符合最大堆性质,交换i和largest的元素
		if (largest != i) {
			swap(A, i, largest);
			heapify(A, largest, heapSize,type);
		}
	}
	
	/**
	 * 交换i和largest的元素
	 * @param A
	 * @param i
	 * @param largest
	 */
	public static void swap(int[] A,int i,int largest){
		int temp = A[largest];
		A[largest] = A[i];
		A[i] = temp;
	}
	
	/**
	 * 得到父节点下标
	 * @param i
	 * @return
	 */
	public static int parent(int i){
		return i/2;
	}
	
	/**
	 * 得到左孩子下标
	 * @param i
	 * @return
	 */
	public static int left(int i){
		return 2 * i;
	}
	
	/**
	 * 得到右孩子下标
	 * @param i
	 * @return
	 */
	public static int right(int i){
		return 2 * i + 1;
	}
}
