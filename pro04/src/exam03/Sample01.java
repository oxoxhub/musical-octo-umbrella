package exam03;

import java.util.Arrays;
import java.util.Random;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 1. 배열의 크기가 10 인 정수 배열을 2개 생성 후 각 배열에 10 ~ 99 사이의 난수값으로
		 *    초기화 시키고 출력한다.
		 */
		Random rand = new Random();
		
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		
		for(int i = 0; i < arr1.length; i++) {
			int num = rand.nextInt(90) + 10;
			arr1[i] = num;
			
			num = rand.nextInt(90) + 10;
			arr2[i] = num;
		}
		
		System.out.println("1. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr1));
		System.out.println("\t" + Arrays.toString(arr2));
		
		/*
		 * 2. 1번 문제에서 생성한 첫번째 배열과 두번째 배열의 합을 구하여 새로운 세번째 배열을 만들고
		 *    출력한다.
		 */
		int[] arr3 = arr1.clone();
		
		for(int i = 0; i < arr3.length; i++) {
			arr3[i] += arr2[i];
		}
		
		System.out.println("2. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr3));
		
		/*
		 * 3. 2번 문제까지 진행하여 만들어진 3개의 배열을 이용하여 짝수값만 저장되어 있는 배열과 홀수값만 저장
		 *    되어 있는 배열을 만들고 짝수 배열과 홀수 배열을 출력한다.
		 */
		
		// 첫번째 방법
		/*
		int[] arr4 = new int[30];
		int[] arr5 = new int[30];
		int idx1 = 0, idx2 = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] % 2 == 0) {
				arr4[idx1] = arr1[i];
				idx1++;
			} else {
				arr5[idx2] = arr1[i];
				idx2++;
			}
		}
		
		for(int i = 0; i < arr2.length; i++) {
			if(arr2[i] % 2 == 0) {
				arr4[idx1] = arr2[i];
				idx1++;
			} else {
				arr5[idx2] = arr2[i];
				idx2++;
			}
		}
		
		for(int i = 0; i < arr3.length; i++) {
			if(arr3[i] % 2 == 0) {
				arr4[idx1] = arr3[i];
				idx1++;
			} else {
				arr5[idx2] = arr3[i];
				idx2++;
			}
		}
		
		arr4 = Arrays.copyOf(arr4, idx1);
		arr5 = Arrays.copyOf(arr5, idx2);
		*/
		
		// 두번째 방법
		/*
		int[] arr4;
		int[] arr5;
		int cnt1 = 0, cnt2 = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] % 2 == 0) {
				cnt1++;
			} else {
				cnt2++;
			}
			
			if(arr2[i] % 2 == 0) {
				cnt1++;
			} else {
				cnt2++;
			}
			
			if(arr3[i] % 2 == 0) {
				cnt1++;
			} else {
				cnt2++;
			}
		}
		
		arr4 = new int[cnt1];
		arr5 = new int[cnt2];
		int idx1 = 0, idx2 = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] % 2 == 0) {
				arr4[idx1] = arr1[i];
				idx1++;
			} else {
				arr5[idx2] = arr1[i];
				idx2++;
			}
			
			if(arr2[i] % 2 == 0) {
				arr4[idx1] = arr2[i];
				idx1++;
			} else {
				arr5[idx2] = arr2[i];
				idx2++;
			}
			
			if(arr3[i] % 2 == 0) {
				arr4[idx1] = arr3[i];
				idx1++;
			} else {
				arr5[idx2] = arr3[i];
				idx2++;
			}
		}
		*/
		
		// 세번째 방법
		int[] arr4 = new int[0];
		int[] arr5 = new int[0];
		
		for(int i = 0; i < arr1.length; i++) {
			int[] temp;
			
			if(arr1[i] % 2 == 0) {
				temp = new int[arr4.length + 1];
				System.arraycopy(arr4, 0, temp, 0, arr4.length);
				arr4 = temp;
				
				arr4[arr4.length - 1] = arr1[i];
			} else {
				temp = new int[arr5.length + 1];
				System.arraycopy(arr5, 0, temp, 0, arr5.length);
				arr5 = temp;
				
				arr5[arr5.length - 1] = arr1[i];
			}
			
			if(arr2[i] % 2 == 0) {
				temp = new int[arr4.length + 1];
				System.arraycopy(arr4, 0, temp, 0, arr4.length);
				arr4 = temp;
				
				arr4[arr4.length - 1] = arr2[i];
			} else {
				temp = new int[arr5.length + 1];
				System.arraycopy(arr5, 0, temp, 0, arr5.length);
				arr5 = temp;
				
				arr5[arr5.length - 1] = arr2[i];
			}
			
			if(arr3[i] % 2 == 0) {
				temp = new int[arr4.length + 1];
				System.arraycopy(arr4, 0, temp, 0, arr4.length);
				arr4 = temp;
				
				arr4[arr4.length - 1] = arr3[i];
			} else {
				temp = new int[arr5.length + 1];
				System.arraycopy(arr5, 0, temp, 0, arr5.length);
				arr5 = temp;
				
				arr5[arr5.length - 1] = arr3[i];
			}
		}
		
		System.out.println("3. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr4));
		System.out.println("\t" + Arrays.toString(arr5));
		
		/*
		 * 4. 짝수/홀수 배열에 있는 값들중 중복된 값이 있는 경우 하나의 값만 남겨 새로운 배열로 만들고 출력한다.
		 */
		int[] arr6 = new int[0];
		int[] arr7 = new int[1];
		
		for(int i = 0; i < arr4.length - 1; i++) {
			if(arr4[i] != -1) {
				for(int j = i + 1; j < arr4.length; j++) {
					if(arr4[i] == arr4[j]) {
						arr4[j] = -1;
					}
				}
			}
		}
		
		for(int i = 0; i < arr4.length; i++) {
			if(arr4[i] != -1) {
				int[] temp = new int[arr6.length + 1];
				System.arraycopy(arr6, 0, temp, 0, arr6.length);
				arr6 = temp;
				
				arr6[arr6.length - 1] = arr4[i];
			}
		}
		
		arr7[0] = arr5[0];
		for(int i = 1; i < arr5.length; i++) {
			boolean dup = false;
			for(int j = 0; j < arr7.length; j++) {
				if(arr7[j] == arr5[i]) {
					dup = true;
					break;
				}
			}
			if(!dup) {
				arr7 = Arrays.copyOf(arr7, arr7.length + 1);
				arr7[arr7.length - 1] = arr5[i];
			}
		}
		
		System.out.println("4. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr6));
		System.out.println("\t" + Arrays.toString(arr7));
		
		/*
		 * 5. 짝수/홀수 배열에 있는 값을 작은값 부터 큰값 순으로 정렬된 배열을 만들고 출력한다.
		 */
		int[] arr8 = arr6.clone();
		int[] arr9 = arr7.clone();
		
		for(int i = 0; i < arr8.length - 1; i++) {
			for(int j = i + 1; j < arr8.length; j++) {
				if(arr8[i] > arr8[j]) {
					int temp = arr8[j];
					arr8[j] = arr8[i];
					arr8[i] = temp;
				}
			}
		}
		
		for(int i = 0; i < arr9.length - 1; i++) {
			for(int j = i + 1; j < arr9.length; j++) {
				if(arr9[i] > arr9[j]) {
					int temp = arr9[j];
					arr9[j] = arr9[i];
					arr9[i] = temp;
				}
			}
		}
		
		System.out.println("5. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr8));
		System.out.println("\t" + Arrays.toString(arr9));
		
		/*
		 * 6. 짝수/홀수 배열로 나누어져 있는 것을 하나의 배열로 합쳐서 하나의 배열로 만들고 출력한다.
		 */
		int[] arr10 = new int[arr8.length + arr9.length];
		System.arraycopy(arr8, 0, arr10, 0, arr8.length);
		System.arraycopy(arr9, 0, arr10, arr8.length, arr9.length);
		
		System.out.println("6. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr10));
	}

}
