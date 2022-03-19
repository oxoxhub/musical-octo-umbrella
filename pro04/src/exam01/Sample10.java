package exam01;

import java.util.Arrays;

public class Sample10 {

	public static void main(String[] args) {
		/*
		 * 동적 배열
		 * 		-기존 배열의 크기보다 크거나 작은 새로운 배열을 만들어서 사용하는 형태
		 */

		int[] arr1 =new int[] {1,2,3};
		
		System.out.println(Arrays.toString(arr1));
		
//		for(int i = 0; i < arr1.length; i++) {
//			System.out.print(arr1[i]+"\t");
//		}
//		System.out.println();
		
		//동적 배열을 만들기 위해 임시 배열 저장 공간 생성
		int[] temp = new int[arr1.length + 1]; //temp 배열의 길이는 4가 된다.
		
		for(int i = 0; i < arr1.length; i++) {
			temp[i] = arr1[i]; //깊은 복사
		}
		
		System.out.println("arr1: " + arr1); // arr1: [I@4926097b
		System.out.println("temp: " + temp); // temp: [I@762efe5d
		
		arr1 = temp; //얕은 복사
		
		System.out.println("arr1: " + arr1);  // arr1: [I@762efe5d arr1의 참조값이 바뀌었다. 얕은 복사로 temp의 배열을 참조하기때문에.
		
		arr1[3] = 7;
		
		System.out.println(Arrays.toString(arr1)); //arr1은 얕은 복사를 했기에 temp의 배열을 그대로 출력한다.
		System.out.println(Arrays.toString(temp)); //[1, 2, 3, 7] 
		//arr1[3]에 7을 할당했는데 temp[3]의 값도 같이 7로 바뀐 이유는 arr1과 temp가 같은 배열을 참조하고있기 때문이다.
		System.out.println("---------------");
		
		
		//Arrays.copyOf(깊은 복사)를 사용한 동적 배열
		temp = Arrays.copyOf(arr1, arr1.length + 1); //(복사할(값) 배열, 복사할 배열의 길이(인덱스) + n(동적배열의 수))
		System.out.println("temp: " + temp); // [I@5d22bbb7 새로운 배열 객체 생성된다.
		System.out.println("arr1: " + arr1); // arr1: [I@762efe5d
		arr1 = temp; // arr1: [I@5d22bbb7 얕은 복사로 새로운 temp의 배열을 참조한다.
		
		System.out.println(Arrays.toString(arr1)); //[1, 2, 3, 7, 0] 배열의 길이를 늘렸고 기본값이 출력된다.
		System.out.println("arr1: " + arr1); // arr1: [I@5d22bbb7 
		System.out.println("---------------");
		
		
		
		//System.arraycopy 를 사용한 동적 배열
		temp = new int[arr1.length + 1];
		System.out.println("temp: " + temp); // [I@41a4555e 새로운 배열 객체 생성으로 참조값 바뀜.
		
		arr1[4] = 9;
		System.arraycopy(arr1, 0, temp, 0, arr1.length);
		arr1 = temp;
		
		System.out.println(Arrays.toString(arr1)); //[1, 2, 3, 7, 9, 0]
		System.out.println("arr1: " + arr1); // [I@41a4555e
		System.out.println("---------------");
		
		temp = new int[arr1.length + 1]; 
		System.out.println("temp: " + temp); // temp: [I@3830f1c0
		System.out.println(Arrays.toString(temp)); // [0, 0, 0, 0, 0, 0, 0]
		
		System.arraycopy(arr1, 0, temp, 0, arr1.length);
		System.out.println(Arrays.toString(temp)); // [1, 2, 3, 7, 9, 0, 0]
		
		System.arraycopy(arr1, 0, temp, 1, arr1.length); //복사할 인덱스의 시작을 정할 수 있다.
		System.out.println(Arrays.toString(temp)); // [1, 1, 2, 3, 7, 9, 0] 인덱스를 늘리지 않으면 에러. Array Index Out Of Bounds Exception
		System.out.println(Arrays.toString(arr1)); // [1, 2, 3, 7, 9, 0]
		
		arr1 = temp;
		
		System.out.println(Arrays.toString(arr1)); // [1, 1, 2, 3, 7, 9, 0]
	}

}
