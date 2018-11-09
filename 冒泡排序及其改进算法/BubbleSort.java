package com;

public class BubbleSort {
	private int[] intArray;

	public BubbleSort(int[] intArray) {
		// TODO Auto-generated constructor stub
		this.intArray = intArray;
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

	public void bubbleSort() {
		for (int i = 0; i < intArray.length - 1; i++) {// 排序趟数（数组长度减一）
			for (int j = 0; j < intArray.length - i - 1; j++) { // 每一趟将最大的数沉淀到相对应的末尾
				if (intArray[j] > intArray[j + 1]) {// 前一位数大于后一位数 即进行交换
					int temp = intArray[j];
					intArray[j] = intArray[j + 1];
					intArray[j + 1] = temp;
				}
			}
			System.out.print("第" + (i + 1) + "轮排序结果：");
			print();
		}
	}

	// 冒泡排序改进1
	public void bubbleSort_improvement_1() {
		for (int i = 0; i < intArray.length - 1; i++) {// 排序趟数（数组长度减一）
			boolean exchange = false;// 用于标记每一趟是否进行了数据交换 默认没有交换false
			for (int j = 0; j < intArray.length - i - 1; j++) { // 每一趟将最大的数沉淀到相对应的末尾
				if (intArray[j] > intArray[j + 1]) {// 前一位数大于后一位数 即进行交换
					int temp = intArray[j];
					intArray[j] = intArray[j + 1];
					intArray[j + 1] = temp;
					exchange = true;//发生数据交换
				}
			}
			System.out.print("第" + (i + 1) + "轮排序结果：");
			print();
			if (!exchange) {// 如果某一趟未进行数据交换 证明数组已经排序好了 可立即结束排序
				break;
			}
		}
	}

	// 冒泡排序改进2
	public void bubbleSort_improvement_2() {
		int index=0;;
		int endPoint=intArray.length-1;//endPoint代表最后一个需要比较元素的下标
		while(endPoint>0){
			int pos=0;
			for (int i = 1; i < endPoint; i++) {
				if(intArray[i-1]>intArray[i]){
					int temp=intArray[i-1];
					intArray[i-1]=intArray[i];
					intArray[i]=temp;
					pos=i-1;
					System.out.print(pos+"\t");
				}
			}
			endPoint=pos;//下一轮排序时只对下标小于pos的元素排序， 下标大于等于pos的元素已经排好
			index++;
			System.out.print("第" + index + "轮排序结果：");
			print();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 5, 4, 11, 2, 20, 18 };
		BubbleSort bubbleSort = new BubbleSort(array);
		System.out.print("未排序时的结果：");
		bubbleSort.print();
//		bubbleSort.bubbleSort();
//		bubbleSort.bubbleSort_improvement_1();
		bubbleSort.bubbleSort_improvement_2();
	}

}
