package com.array;

import java.util.Iterator;

public class UnorderArray {
	private String[] strArray;
	private int length=0;//数组元素个数
	//初始化数组最大容量
	public UnorderArray(int MAX_SIZE) {
		// TODO Auto-generated constructor stub
		strArray=new String[MAX_SIZE];
	}
	//检测数组是否包含某个元素，如果存在返回其下标，不存在则返回-1
	public int contains(String target){
		for (int i = 0; i < length; i++) {
			if(strArray[i].equals(target)){
				return i;//存在指定的元素则返回对应下标
			}
		}
		return -1;//不存在指定的元素则返回-1
	}
	//将目标元素插入指定下标位置
	public void insert(String target){
		strArray[length]=target;
		length++;
	}
	public boolean delete(String target){
		if(contains(target)==-1){
			return false;
		}else{
			int index=contains(target);
			for (int i = index; i <length-1; i++) {
				strArray[i]=strArray[i+1];
			}
			length--;
			return true;
		}
	}
	public void print(){
		System.out.print("[");
		for (int i = 0; i < length-1; i++) {
			System.out.print(strArray[i]+",");
		}
		System.out.print(strArray[length-1]);
		System.out.print("]");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnorderArray unorderArray=new UnorderArray(10);
		unorderArray.insert("1");
		unorderArray.insert("2");
		unorderArray.insert("3");
		unorderArray.insert("3");
		unorderArray.insert("5");
		unorderArray.delete("3");
		unorderArray.print();
	}

}
