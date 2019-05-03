import java.util.*;
public class MyHeap{
  private int[] heap;
  private static void pushDown(int[] data, int size, int index){
   if (index * 2 + 2 < size){
      if (data[index * 2 + 1] > data[index * 2 + 2]){
        //fompare with the left leaf
        if (data[index] < data[index * 2 + 1]){
          int temp = data[index];
          data[index] = data[index * 2 + 1];
          data[index * 2 + 1] = temp;
          pushDown(data, size, index * 2 + 2);
        }
      }
      else{
        //compare with the right left
        if (data[index] < data[index * 2 + 2]){
          int temp = data[index];
          data[index] = data[index * 2 + 2];
          data[index * 2 + 2] = temp;
          pushDown(data, size, index * 2 + 2);
        }
      }
    }
    //when there only exists one leaf
    else if(index * 2 + 1 < size){
      // there is only a left leaf
      if (data[index] < data[index * 2 + 1]){
        int temp = data[index];
        data[index] = data[index * 2 + 1];
        data[index * 2 + 1] = temp;
        pushDown(data, size, index * 2 + 1);
      }
    }

    return;
  }

  private static void pushUp(int[] data, int index){
    if (index != 0 && data[(index - 1)/2] < data[index]) {
      if (data[index] > data[(index - 1) / 2]){
        int temp = data[index];
        data[index] = data[(index - 1) / 2];
        data[(index - 1) / 2] = temp;
        pushUp(data, (index - 1) / 2);
      }
    }
  }

  public static void heapify(int[] data){
    for(int i = data.length - 1 ; i >= 0; i--){
      pushDown(data,data.length, i);
    }
  }

  public static void heapsort(int[] data){
    heapify(data);
    System.out.println(Arrays.toString(data));
    for (int i = data.length - 1; i > 0; i--){
      int temp = data[i];
      data[i] = data[0];
      data[0] = temp;
      pushDown(data, i, 0);
    }
  }

  public static void main(String[] args) {
   int[] ary = new int[] {34,52,12,43,78,90,2,31};
   heapify(ary);
   System.out.println(Arrays.toString(ary));
   heapsort(ary);
   System.out.println(Arrays.toString(ary));
 }

}
