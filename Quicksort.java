
public class Quicksort {
	private int[] numbers;
	private int number;

	public void sort(int[] inputArr) {
		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.numbers = inputArr;
		number = inputArr.length;
		quickSort(0, number - 1);
	}

	public void quickSort(int low, int high){
		int i = low, j = high, pivot = numbers[low+(high-low)/2];
		while(i<=j){
			while(numbers[i]<pivot){
				i++;
			}
			while(numbers[j]>pivot){
				j--;
			}
			if (i <= j) {
				int temp = numbers[i];
		        numbers[i] = numbers[j];
		        numbers[j] = temp;
                i++;
                j--;
            }
		}
		if (low < j){
			quickSort(low, j);
		}
		if (i < high){
			quickSort(i, high);
		}
	}

	public static void main(String[] args) {
		Quicksort sorter = new Quicksort();
		int[] array = { 3, 7, 8, 5, 2, 1, 9, 5, 4 };
		sorter.sort(array);
		for(int i:array){
            System.out.print(i);
            System.out.print(" ");
        }
	}
}
