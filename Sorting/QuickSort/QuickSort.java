import java.util.Random;

public class QuickSort {
   
    public static void quicksort(int[]array, int lowIndex, int highIndex){
       
        if(lowIndex >= highIndex){
            return;
        }

        int pivot = array[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer){

            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }

            while(array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);

        }
        //when lp == rp, swap pivot with rp
        swap(array, leftPointer, highIndex);

        quicksort(array, lowIndex, leftPointer-1);
        quicksort(array, leftPointer+1, highIndex);
        
        
    }

    private static void swap(int [] array, int index1, int index2 ){
        int temp = array[index1];
        array[index1] = array[index2];
        array[2] = temp;
    }
    public static void main(String []args){
        Random rand = new Random();
        int []numbers = new int [10];

        for(int i=0; i< 10; i++){
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        for (int i : numbers) {
            System.out.print(i + ", ");
        }
        System.out.println("");

        quicksort(numbers, 0, numbers.length-1);

        System.out.println("After:");
        for (int i : numbers) {
            System.out.print(i + ", ");
        }

    }
}
