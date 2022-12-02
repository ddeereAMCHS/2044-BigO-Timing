public class Util {
  public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) { return i; }
    }
    return -1;
  }

  // pre-condition: arr is sorted
  public static int binarySearch(int[] arr, int left, int right, int target) {
    if (right < left) { return -1; }

    int mid = (left + right) / 2;
    if (arr[mid] == target) { return mid; }
    else if (arr[mid] < target) { return binarySearch(arr, mid+1, right, target); }
    else { return binarySearch(arr, left, mid-1, target); }
  }

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length-1; i++) {
      for (int j = 0; j < arr.length-i-1; j++) {
        if (arr[j] > arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
  }

  public static void selectionSort(int arr[]) {
    for (int i = 0; i < arr.length-1; i++) {
      int min_idx = i;
      for (int j = i+1; j < arr.length; j++) {
        if (arr[j] < arr[min_idx]) { min_idx = j; }
      }
      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }

  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; ++i) {
      int key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  public static void mergeSort(int[] arr, int left, int right) {
    if (left >= right) { return; }
    int mid = (left + right) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid+1, right);
    merge(arr, left, right);
  }

  public static void merge(int[] arr, int left, int right) {
    int mid = (left + right) / 2;
    int size1 = mid - left + 1;
    int size2 = right - mid;
    int[] arrLeft = new int[size1];
    int[] arrRight = new int[size2];

    for (int i = 0; i < arrLeft.length; ++i) {
      arrLeft[i] = arr[left + i];
    }
    for (int j = 0; j < arrRight.length; ++j) {
      arrRight[j] = arr[mid + 1 + j];
    }

    int i = 0;
    int j = 0;
    int k = left;

    while (i < arrLeft.length && j < arrRight.length) {
      if (arrLeft[i] <= arrRight[j]) {
        arr[k] = arrLeft[i];
        i++;
      }
      else {
        arr[k] = arrRight[j];
        j++;
      }
      k++;
    }

    while (i < arrLeft.length) {
      arr[k] = arrLeft[i];
      i++;
      k++;
    }

    while (j < arrRight.length) {
      arr[k] = arrRight[j];
      j++;
      k++;
    }
  }
  
  public static void quickSort(int[] arr, int left, int right) {
    if (left >= right) { return; }

    int idxPart = partition(arr, left, right);
    quickSort(arr, left, idxPart - 1);
    quickSort(arr, idxPart + 1, right);
  }

  public static int partition(int[] arr, int left, int right) {
    int pivot = arr[right]; // select last element as pivot value

    int i = left;
    for (int j = left; j < right; j++) {
      if (arr[j] < pivot) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
      }
    }
    int temp = arr[i];
    arr[i] = arr[right];
    arr[right] = temp;
    return i;
  }
}
