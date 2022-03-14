package exam01;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * 배열의 크기가 10인 배열을 선언하고 10 ~ 1 까지의 값으로 초기화 한다.
		 */
		
		int[] arr1 = new int[10];
		int num1 = 10;
		for(int i = 0; i < 10; i++) {
			arr1[i] = num1--;
			System.out.println(arr1[i]);
		}
		
		System.out.println();
		
		
		/*
		 * 배열의 크기가 10인 배열을 선언하고 2부터 시작하여 짝수값에 해당하는 값으로 초기화 한다.
		 */
		
		int[] arr2 = new int[10];
		int num2 = 0;
		for(int i = 0; i < 10; i++) {
			arr2[i] = num2 += 2;
			System.out.println(arr2[i]);
		}
		
		System.out.println();
		
		/*
		 * 배열의 크기가 5인 실수 배열을 선언하고 1 부터 0.5씩 증가된 값으로 초기화 한다.
		 */
		
		double[] arr3 = new double[5];
		double d = 1.0;
		for(int i = 0; i < 5; i++) {
			arr3[i] = d;
			d += 0.5;
			System.out.println(arr3[i]);
		}
		
		System.out.println();
		
		
		/*
		 * 배열의 크기가 5인 문자 배열을 선언하고 'A'~ 'E' 까지의 문자값으로 초기화 한다.
		 */
		
		char[] arr4 = new char[5];
		char c = 'A';
		for(int i = 0; i < 5; i++) {
			arr4[i] = c++;
			System.out.print(arr4[i] + "\t");
		}
		
	}

}
