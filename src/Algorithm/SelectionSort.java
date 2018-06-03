package Algorithm;

public class SelectionSort {
    public static int[] num = {5,6,1,5,8,9,7,8324,555,56,1231,54,87,512,35,64};
    public static void main(String args[]){
        selectionSort(num);
        print(num);
    }

    public static void selectionSort(int[] sort) {
        int length = sort.length;

        for (int i = 0; i < length; i++) {
            int k = i;
            for (int j = i; j < length; j++) {
                if (sort[i] > sort[j]) {
                    k = j;
                }
            }
            int change = sort[i];
            sort[i] = sort[k];
            sort[k] = change;
        }
    }
    public static void print(int[] sort){
        for(int i = 0;i < sort.length;i++){
            System.out.print(sort[i]+" ");
        }
    }
}
