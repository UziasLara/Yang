import java.util.Random;

public class array {
	public static void main(String[] args) {
		Random r = new Random();
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		// int r = (random.nextInt());
		int count = 0;

		for (int i = 0; i <arr1.length; i++) {
			arr1[i] = r.nextInt(10) + 1;
			System.out.print(arr1[i]+" ");
		}
		
		System.out.println();
		
		arr2[0] = arr1[0];
		System.out.print(arr2[0]);
		
		
		for (int j= 1;j<arr1.length;j++) {
			arr2[j] = arr1[j] + arr1[j-1];
			System.out.print(" "+ arr2[j]+" ");
		}
	}
	// for(int j = 0; j<arr2.length;j++){
	// System.out.println(arr2[j]);
	// }

}
