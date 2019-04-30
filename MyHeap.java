public class MyHeap{
  private int[] heap;
  private static void pushDown(int[] data, int size, int index){
    //when there only exists one leaf
    if(index * 2 + 1 < size){
      // there is only a left leaf
      if (data[index] < data[index * 2 + 1]){
        int temp = data[index];
        data[index] = data[index * 2 + 1];
        data[index * 2 + 1] = temp;
        pushDown(data, size, index * 2 + 1);
      }
    }
    //when there exist two leaves
    else if (index * 2 + 2 < size){
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
    return;
  }

  private static void pushUp(int[] data, int index){
    if ((index - 1) / 2 > 0) {
      if (data[index] > data[(index - 1) / 2]){
        int temp = data[index];
        data[index] = data[(index - 1) / 2];
        data[(index - 1) / 2] = temp;
        pushUp(data, (index - 1) / 2);
      }
    }
  }

  public static void heapify(int[] data){
    // for(int i = data.length / 2=; i >= 0;      ----j <- 9){
    //   pushDown(data,index)
    }
  }

  public static void heapsort(int[] data){
    heapify(data);
    for (int i = 0; i < data.length; i = i * 2 + 1){
      pushDown(data, size, i);
    }
    for (int i = data.length; i > 0; i = (i - 1) / 2){
      pushUp(data, i);
    }

  }





}
