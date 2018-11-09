package com;

public class QuickSort {
	private int[] intArray;
	public QuickSort(int[] intArray) {
		// TODO Auto-generated constructor stub
		this.intArray=intArray;
	}
	public void print() {
		System.out.print("[");
		for (int i = 0; i < intArray.length - 1; i++) {
			System.out.print(intArray[i] + ",");
		}
		System.out.print(intArray[intArray.length - 1]);
		System.out.print("]");
		System.out.println();
	}
	/**
	 * 
	 * @param low 数组最小下标
	 * @param high 数组最大下标
	 */
	public void quickSort(int low,int high){
		if(low<high){
			int pivot=intArray[low];//以第一个元素为基准
			int partition=partition(low, high, pivot);//对数组进行划分
			print();
			quickSort(low, partition-1); //递归对划分后的低位段进行快速排序
			quickSort(partition+1, high);//递归对划分后的高位段进行快速排序
		}else{
			return;
		}
	}
	/**
	 * 以pivot为基准对下标low~high的数据进行划分(只在类内部调用 无需暴露)
	 * @param low 数据段的最小下标
	 * @param high 数据段的最大下标
	 * @param pivot 划分的基准元素对应的下标
	 * @return 划分结束后返回基准元素所在位置的下标
	 */
	private int partition(int low,int high,int pivot){
		while(low<high){
			//从high端往前找，寻找比基准元素小的记录 
			while(low<high&&intArray[high]>=pivot){
				high--;
			}
			swap(low, high);
			//从low端往后找，寻找比基准元素大的记录
			while(low<high&&intArray[low]<=pivot){
				low++;
			}
			swap(low,high);
		}
		return low;
	}
	/**
	 * 交换数组中两个元素的数据(只在类内部调用 无需暴露)
	 * @param low 待交换数据的低位下标
	 * @param high 待交换数据的高位下标
	 */
	private void swap(int low,int high){
		int temp=intArray[low];
		intArray[low]=intArray[high];
		intArray[high]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 20, 40, 30, 10, 60, 50};
		QuickSort quickSort=new QuickSort(array);
		System.out.print("未排序时的结果：");
		quickSort.print();
		quickSort.quickSort(0, array.length-1);
	}

}
