package com.array;

public class OrderArray {
	private int[] intArray;
	private int length = 0;// 数组元素个数
	// 初始化数组最大容量

	public OrderArray(int MAX_SIZE) {
		// TODO Auto-generated constructor stub
		intArray = new int[MAX_SIZE];
	}

	public int find(int target) {
		int lowerBound = 0;
		int upperBound = length - 1;
		int midBound;
		while (lowerBound <= upperBound) {
			midBound = (lowerBound + upperBound) / 2;
			if (intArray[midBound] == target) {
				return midBound;
			} else if (intArray[midBound] > target) {
				upperBound = midBound - 1;
			} else {
				lowerBound = midBound + 1;
			}
		}
		return -1;// 不存在则返回-1
	}

	public void insert(int target) {

		if (length == 0) {// 数组为空
			intArray[length] = target;
			length++;
		} else {
			int location = 0;
			while (intArray[location] < target&&location<length) {
				location++;
			}
			for (int i = length - 1; i >= location; i--) {
				intArray[i + 1] = intArray[i];
			}
			intArray[location] = target;
			length++;
		}
	}

	public boolean delete(int target) {
		if (find(target) == -1) {
			return false;
		} else {
			int index = find(target);
			for (int i = index + 1; i < length; i++) {
				intArray[i - 1] = intArray[i];
			}
			length--;
			return true;
		}
	}

	public void print() {
		System.out.print("[");
		for (int i = 0; i < length - 1; i++) {
			System.out.print(intArray[i] + ",");
		}
		System.out.print(intArray[length - 1]);
		System.out.print("]");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderArray orderArray = new OrderArray(10);

		orderArray.insert(3);
		orderArray.insert(4);
		orderArray.insert(6);
		orderArray.insert(8);
		orderArray.insert(7);
		orderArray.print();
	}

}
