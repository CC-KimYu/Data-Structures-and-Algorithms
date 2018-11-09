package com;

public class InsertSort {
	private int[] intArray;
	public InsertSort(int[] intArray) {
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
	//插入排序
	public void insertionSort(){
		for (int i = 1; i < intArray.length; i++) {
			int temp=intArray[i];//设置监视哨（待排序元素   一次排一个）
			int insertPoint=i-1;//待比较元素的下标
			//循环从 准备比较元素后往前比较 找出第一个小于监视哨的元素下标
			while(intArray[insertPoint]>temp&&insertPoint>=0){
				intArray[insertPoint+1]=intArray[insertPoint]; //监视哨小于待比较元素 待比较元素后移
				insertPoint--;
			}
			intArray[insertPoint+1]=temp;//插在第一个小于监视哨的下标位置
			System.out.print("第" + i + "轮排序结果：");
			print();
		}
	}
	//插入排序改进1
	public void insertionSort_improvement_1(){
		for (int i = 1; i < intArray.length; i++) {
			int temp=intArray[i];//设置监视哨（待排序元素   一次排一个）
			if(intArray[i-1]>temp&&intArray[0]<temp){//保证查找的数在区间内
				int insertPoint=binarySearch(0, i-1, temp);
				for(int j=i;j>insertPoint;j--){
					intArray[j]=intArray[j-1];
				}
				intArray[insertPoint]=temp;//插在第一个小于监视哨的下标位置
			}
			else if(intArray[0]>temp){
				for(int j=i;j>0;j--){
					intArray[j]=intArray[j-1];
				}
				intArray[0]=temp;
			}
			System.out.print("第" + i + "轮排序结果：");
			print();
		}
	}
	//二分查找
	public int binarySearch(int low,int high,int target){
		while(low<high){//
			int mid=(low+high)/2;
			if(mid>target){
				high=mid-1;
			}else{//mid<target
				low=mid+1;
			}
		}
		return low;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {  5, 4, 11, 2, 20, 18,1 };
		InsertSort insertSort=new InsertSort(array);
		System.out.print("未排序时的结果：");
		insertSort.print();
		//insertSort.insertionSort();
		insertSort.insertionSort_improvement_1();
	}

}
