package Algorithm;

public class BubbleSort {
    public static int[] num = {45,5,1,0,2,5,65,15,13,54,8,9,54,31,54,21,5};
    public static void main(String args[]) {
        bubbleSort(num);
        print(num);
    }

    public static void bubbleSort(int[] sort) {
        int length = sort.length;
        for (int i = 0; i < length; i++) {
            for (int j = length-1; j >=i; j--) {
                if (sort[i] > sort[j]) {
                    int change = sort[i];
                    sort[i] = sort[j];
                    sort[j] = change;
                }
            }
        }
    }

    public static void print(int[] sort){
        for(int i = 0;i<sort.length;i++){
            System.out.print(sort[i]+" ");
        }
    }
}
