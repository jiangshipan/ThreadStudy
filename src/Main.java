import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        int[] array = new int[] {3,5,1,2,7,6};
        new Main().sort(array,0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    public void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partSort(array,start,end);
        sort(array,start,pivot - 1);
        sort(array,pivot + 1, end);
    }
    public int partSort(int[] array, int start, int end) {
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left != right) {
            while (left < right && array[right] > pivot) {
                right--;
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        array[start] = array[left];
        array[left] = pivot;
        return left;
    }

}
