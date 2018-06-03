package Algorithm;

public class InsertSort {
    public static int[] num = {5656,65,31,51,231,5,54,87,98641,654,1,151,5,15,165,15,132,15,4489,456,21};

    public static void main(String args[]) {
        insertSort(num);
        print(num);
    }

    public static void insertSort(int[] sort) {
        for (int i = 1; i < sort.length; i++) {
            int index = sort[i];
            for(int j = 0; j <= i;j++){
                if(sort[0]>index){
                    for (int k = i; k >0 ; k--) {
                        sort[k] = sort[k-1];
                    }
                    sort[0] = index;
                    break;
                }
                else if (j-1>=0 && index > sort[j-1] && index <= sort[j]) {
                    for (int k = i; k >j ; k--) {
                        sort[k] = sort[k-1];
                    }
                    sort[j] = index;
                }
            }
        }
    }

    public static void print(int[] sort) {
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + " ");
        }
    }
}
