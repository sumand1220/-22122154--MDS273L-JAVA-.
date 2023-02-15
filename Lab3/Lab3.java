import java.util.Arrays;
import java.util.Scanner;

public class Lab3 {
    static float mean(int arr[], int temp, int n){
        for(int i=0; i<arr.length; i++){
            temp = temp + arr[i];
        }
        float avg= temp/arr.length;
        System.out.println("MEAN OF THE ARRAY IS: "+avg);
        return avg; 
    }
    static double median(int arr[]){
        double med=0;
        //Arrays.sort(arr);
        if(arr.length/2!=0){
            med=arr[arr.length / 2];
        }
        else{
            med=(arr[(arr.length - 1) / 2] + arr[arr.length / 2]) / 2.0;
        }
        System.out.println("MEDIAN OF THE ARRAY IS: "+med);
        return med;
    }
    static float mode(int arr[], float temp){
        int mod = 0;
        for (int i = 0; i < arr.length; ++i) {
           int count = 0;
           for (int j = 0; j < arr.length; ++j) {
              if (arr[j] == arr[i])
              ++count;
           }
  
           if (count > temp) {
              temp = count;
              mod = arr[i];
           }
        }
        System.out.println("MODE OF THE ARRAY IS: "+mod);
        return mod;
    }
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter the Limit for the Array");
        int n=obj.nextInt();
        int temp=0;
        int[] arr=new int[n];
        System.out.println("Enter the Elements");
        for (int i=0; i<n; i++){
            arr[i]=obj.nextInt();
        }
        System.out.println("1.MEAN 2.MEDIAN 3.MODE");
        System.out.println("\n\t ENTER YOUR CHOICE");
        int ch = obj.nextInt();
        switch(ch){
            case 1:
            mean(arr, temp, n);
            break;
            case 2:
            median(arr);
            break;
            case 3:
            mode(arr,temp);
            break;
            }
    }
    
}
