package com;

public class SelectionSort {
	private int[] intArray;

	public SelectionSort(int[] intArray) {
		this.intArray = intArray;
	}

	// 打印数组
	public void print() {
		System.out.print("[");
		for (int i = 0; i < intArray.length - 1; i++) {
			System.out.print(intArray[i] + ",");
		}
		System.out.print(intArray[intArray.length - 1]);
		System.out.print("]");
		System.out.println();
	}

	// 选择排序
	public void selectionSort() {
		for (int i = 0; i < intArray.length - 1; i++) {
			int min = i;// 标记最小值对应的下标
			for (int j = i + 1; j < intArray.length; j++) {
				if (intArray[min] > intArray[j]) {
					min = j;
				}
			}
			if (i != min) {
				int temp = intArray[min];
				intArray[min] = intArray[i];
				intArray[i] = temp;
			}
			System.out.print("第" + (i + 1) + "趟排序");
			print();
		}
	}
	// 选择排序 改进一
		public void selectionSort_improvement_1() {
			for (int i = 0; i < intArray.length/2; i++) {
				int min=i;//最小值下标 
				int max=i;//最大值下标
				for (int j = i+1; j < intArray.length-i; j++) {
					if(intArray[min]>intArray[j]){
						min=j;//最小值下标对应改变
					}
					if(intArray[max]<intArray[j]){
						max=j;//最大值下标对应改变
					}
				}
				if(min!=i){//最小值 不在初始位置  需要交换
					int temp=intArray[min];
					intArray[min]=intArray[i];
					intArray[i]=temp;
				}
				if(max!=intArray.length-1-i){//最大值 不在初始位置  需要交换
					int temp=intArray[max];
					intArray[max]=intArray[intArray.length-1-i];
					intArray[intArray.length-1-i]=temp;
				}
				System.out.print("第" + (i + 1) + "趟排序");
				print();
			}
		}
	public static void main(String[] args) {
		int[] intArray = { 20, 40, 30, 10, 60, 50 };
		SelectionSort selectionSort = new SelectionSort(intArray);
		System.out.print("未排序时的结果：");
		selectionSort.print();
//		selectionSort.selectionSort();
		selectionSort.selectionSort_improvement_1();
	}
}
