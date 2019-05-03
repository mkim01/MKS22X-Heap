import java.util.*;
public class MyHeap{
  private int[] heap;
  private static void pushDown(int[] data, int size, int index){
  //when there exists two leaves
   if (index * 2 + 2 < size){
     // when left leaf is greater than the right
      if (data[index * 2 + 1] > data[index] && data[index * 2 + 1] > data[index * 2 + 2]){
          int temp = data[index];
          data[index] = data[index * 2 + 1];
          data[index * 2 + 1] = temp;
          pushDown(data, size, index * 2 + 1);
      }
      //when right leaf is greater than the left
      else if (data[index * 2 + 2] > data[index]){
        //compare with the right left
        // if (data[index] < data[index * 2 + 2]){
          int temp = data[index];
          data[index] = data[index * 2 + 2];
          data[index * 2 + 2] = temp;
          pushDown(data, size, index * 2 + 2);
        }
      }
    //when there only exists one leaf
    else if(index * 2 + 1 < size){
      //only check if the left is greater
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
    if (index != 0 && data[(index - 1)/2] < data[index]){
        int temp = data[index];
        data[index] = data[(index - 1) / 2];
        data[(index - 1) / 2] = temp;
        pushUp(data, (index - 1) / 2);
      }
  }

  public static void heapify(int[] data){
    for(int i = data.length / 2 ; i >= 0; i--){
      //check by every level, not by each node
      pushDown(data,data.length, i);
    }
  }

  public static void heapsort(int[] data){
    int n = data.length;
    heapify(data);
    // System.out.println(Arrays.toString(data));
    //
    while (n > 0){
    // for (int i = data.length - 1; i >= 0; i--){
      int temp = data[0];
      data[0] = data[n - 1];
      data[n - 1] = temp;
      n--;
      pushDown(data, n, 0);
    }
  }

  public static void main(String[]args){
     System.out.println("Size\t\tMax Value\theapsort/builtin ratio ");
     int[]MAX_LIST = {1000000000,500,10};
     for(int MAX : MAX_LIST){
       for(int size = 31250; size < 2000001; size*=2){
         long qtime=0;
         long btime=0;
         //average of 5 sorts.
         for(int trial = 0 ; trial <=5; trial++){
           int []data1 = new int[size];
           int []data2 = new int[size];
           for(int i = 0; i < data1.length; i++){
             data1[i] = (int)(Math.random()*MAX);
             data2[i] = data1[i];
           }
           long t1,t2;
           t1 = System.currentTimeMillis();
           MyHeap.heapsort(data2);
           t2 = System.currentTimeMillis();
           qtime += t2 - t1;
           t1 = System.currentTimeMillis();
           Arrays.sort(data1);
           t2 = System.currentTimeMillis();
           btime+= t2 - t1;
           if(!Arrays.equals(data1,data2)){
             System.out.println("FAIL TO SORT!");
             System.exit(0);
           }
         }
         System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
       }
       System.out.println();
     }
   // int[] ary = new int[] {34,52,12,43,78,90,2,31};
   // heapify(ary);
   // System.out.println(Arrays.toString(ary));
   // HeapPrinter.print(ary);
   // System.out.println(Arrays.toString(ary));

}
}
