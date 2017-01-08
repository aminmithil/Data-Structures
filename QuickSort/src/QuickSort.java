
public class QuickSort {

	int partation(int arr[], int low, int high){
		int i = low-1;
		int pivot = arr[high];
		for(int j=low; j<high; j++){
			if(arr[j] <= pivot){
				i++;
				
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		int temp = arr[high];
		arr[high] = arr[i+1];
		arr[i+1] = temp;
		
		return i+1;
	}
	
	public void quickSort(int arr[], int low, int high){
		if(low < high){
			int pi = partation(arr, low, high);
			
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
	}
	public static void printArray(int arr[]){
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
	
	public static void main(String args[]){
		int arr[] = {38, 27, 43, 3, 9, 82, 10};
		 
        System.out.println("Given Array");
        printArray(arr);
 
        QuickSort ob = new QuickSort();
        ob.quickSort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
	}
}
