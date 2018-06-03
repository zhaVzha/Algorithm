package Algorithm;

public class QuickSort {
    public static int[] num = {56,2,3,2,65,4,21,5,454545,5453153,54,21,54,21,54,864135,4531,345,212,0,154};

    public static void main(String args[]) {
        quickSort(num,0,num.length-1);
        print(num);
    }

    public static void quickSort(int[] sort,int low, int high) {
        if(low < high){
            int l = low;
            int h = high;
            int flag = sort[low];
            while(l < h){
                while (sort[h] > flag && l<h) {
                    h--;
                }
                if(l<h){
                    int change = sort[l];
                    sort[l] = sort[h];
                    sort[h] = change;
                    l++;
                }
                while (sort[l] < flag && l<h) {
                    l++;
                }
                if(l<h){
                    int change = sort[l];
                    sort[l] = sort[h];
                    sort[h] = change;
                    h--;
                }
            }
            if(low<l-1)
                quickSort(sort,low,l-1);
            if(high>h+1)
                quickSort(sort,h+1,high);
        }
    }

    public static void print(int[] sort) {
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i]+" ");
        }
    }
}
