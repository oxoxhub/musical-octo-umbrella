package exam01;

import java.util.Arrays;

public class Sample06 {

	public static void main(String[] args) {
		/*
		 * 배열의 깊은 복사 -> 반복문을 사용하여 값을 하나씩 배열에 저장
		 */
		
		int[] arr1 = new int[] {1,2,3,4,5};
		int[] arr2 = new int[arr1.length]; //인덱스 길이 복사
		
		System.out.println(Arrays.toString(arr1)); // [1, 2, 3, 4, 5] 
		System.out.println(Arrays.toString(arr2)); // [0, 0, 0, 0, 0] arr2에는 arr1의 인덱스 길이 만큼만 복사된다. 값이 복사되는 것은 아니다.
		System.out.println("-----------");
		
		for(int i =0; i < arr1.length; i++) {
			arr2[i] = arr1[i];	// for문을 이용한 깊은 복사 방법. 
			System.out.printf("arr1[%d] -> %d, arr2[%d] -> %d\n", i, arr1[i], i, arr2[i]);
		}
		
		System.out.println("-----------");
		System.out.println(Arrays.toString(arr1)); // [1, 2, 3, 4, 5]
		System.out.println(Arrays.toString(arr2)); // [1, 2, 3, 4, 5]
		System.out.println("-----------");
		
		
		
		//자바의 기본 기능 arraycopy를 이용한 깊은 복사. 
		int[] arr3 = new int[arr1.length]; //인덱스 길이 복사.
		
		//arr1[0]부터 arr1 배열의 길이 만큼(5) 저장된 값을 arr3[0]에 복사하겠다는 뜻이다.
		System.arraycopy(arr1, 0, arr3, 0, arr1.length); 
		
		System.out.println(Arrays.toString(arr3)); // [1, 2, 3, 4, 5]
		System.out.println("-----------");
		
		arr1[0] = 10;
		for(int i =0; i < arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr3[%d] -> %d\n", i, arr1[i], i, arr3[i]);
		}
		
		System.out.println("-----------");
		
		
		
		
		//Arrays 객체를 사용한 깊은 복사
		int[] arr4 = Arrays.copyOf(arr1, arr1.length + 3); //배열의 길이를 늘릴수도 줄일수도 있다. 줄일 때 for문 주의! 작은 값을 기준으로 출력해야한다.
		
		System.out.println(Arrays.toString(arr4)); 
		System.out.println("-----------");
		
		arr1[1] = 20;
		for(int i =0; i < arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr4[%d] -> %d\n", i, arr1[i], i, arr4[i]);
		}
		
		System.out.println("-----------");
		System.out.println("arr4[5] -> " + arr4[5]); //배열의 길이를 늘렸으나 초기화하지 않았으므로 기본값이 출력된다.
		System.out.println("arr4[6] -> " + arr4[6]);
		System.out.println("arr4[7] -> " + arr4[7]);
		System.out.println("-----------");
		
		
		
		
		//.clone() 메서드를 사용한 깊은 복사 
		//값을 그대로 복사한다. 배열의 길이를 늘리거나 줄일수는 없다.
		int[] arr5 = arr1.clone();
		
		arr1[2] = 30;
		for(int i =0; i < arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr5[%d] -> %d\n", i, arr1[i], i, arr5[i]);
		}
	}

}
