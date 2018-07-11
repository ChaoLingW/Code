package com.chaoling.sort;

/**
 * 
 * @author chaoling
 * @date 2018年7月9日下午11:31:57
 * @Description
 */
public class Sort {

	public static void main(String[] args) {
		
		int[] arr = new int[] { 4, 1, 3, 6, -1, 5,2};
		
		//System.out.println("冒泡排序");
		
		//new Sort().bubbleSort(arr);
		new Sort().insertionSort(arr);

	}

	public void insertionSort(int[] arr) {
		
		//假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
		//4, 1, 3, 6, 2, 5 
		for(int i = 0; i < arr.length; i++){
			
			//int index = 0;
			int temp;
			if(i == 1){
				if(arr[i] < arr[i-1]){
					
					temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
					
				}
			}
			
			for(int j = i -1; j > 0; j--){
				
				if(arr[i]>arr[j-1] && arr[i] < arr[j]){
					
					temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
					break;
				}
				
			}
			
		}
		
		show(arr);
		
	}

	public void bubbleSort(int[] arr) {
		
		/*
		比较相邻的元素，如果第一个比第二个大，就交换它们两个；
		对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
		最后的元素就会是最大的数。
		针对剩余的元素重复以上的步骤。
		持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
		*/
		
		// n个元素排序，外层小于length-1，内层小于arr.length -i -1
		for (int i = 0; i < arr.length - 1; i++) {// 选出几个最大的 length-1

			for (int j = 0; j < arr.length - i - 1; j++) {// 比较几次：length-i-1
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}

		show(arr);

	}
	
	public void show(int[] arr){
		
		//数组遍历
		for (int i : arr)
			System.out.print(i + " ");
		
		
	}

}
