import java.util.Arrays;

public class KthSmallest {
	static int size = 0;
	
	public static void main(String[] args) {
		System.out.println(kthSmallest(new int[]{7, 10, 4 ,20, 15},0,4,3));
		
	}
	
	public static int kthSmallest(int[] arr, int start, int end, int k) 
    { 
		// Build min heap i:e every parent node will be
	    // smaller than their left and right node
		size = end + 1;
        for(int i=((size/2) - 1); i>=0; i--){
        	
        	arr = heapify(arr, size, i);
        	
        }
		
        // call k times extractMin()
     	// which will make sure after: 
     	// After 1st iteration smallest element will be root
     	// After 2nd iteration 2nd smallest element will be root
     	// and so on 
     	// Similarly after kth iteration kth smallest element will be root i:e at arr[0] position
		for(int i=0; i<k - 1; i++){
            
            arr = extractMin(arr);
            
        }
        return arr[0];
    }
	
	// This method will make sure, root is smaller element
	public static int[] extractMin(int[] arr){
        size--;
		arr[0] = arr[size];
        return heapify(arr,size,0);
        
    }
    

	private static void printArr(int[] arr) {
		// TODO Auto-generated method stub
    	Arrays.stream(arr).forEach(System.out::println);
    	System.out.println("----");
	}

	// This method will make sure given indices is the smaller than left and right node
    // Also after every swap recursive call will be performed to check
    // swapped element is smaller than their child nodes and so on.
	public static int[] heapify(int[] newArr, int n, int root ){
        
        int leftChild = ((root*2) + 1);
        int rightChild = ((root*2) + 2);
        int min = root;
        
        if((leftChild < n) && newArr[min] > newArr[leftChild])
                min = leftChild;
                
        if((rightChild < n) && newArr[min] > newArr[rightChild])
                min = rightChild;
        
        if(min != root){
            int temp = newArr[min];
            newArr[min] =  newArr[root];
            newArr[root] = temp;
            heapify(newArr,n,min);
        }
        
        return newArr;
                
    }

}
