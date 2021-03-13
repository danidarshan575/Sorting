import javax.swing.*;
import java.util.Arrays;

public class Sorts {

    //************************************************ Merge Sort ******************************************************
    
    public void mergeSort(int[] a, int n) {
        Data d2 = new Data();
        String s = d2.getSort();
        long startTime;
        long elapsedTime;
        startTime = System.nanoTime();
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);

        elapsedTime = System.nanoTime() - startTime;
        d2.setTimeofExecution(elapsedTime);
        d2.setOutput(a);
        WriteOutput(a, elapsedTime);
    }

    public void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {

            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    // *********************************************** Merge Sort ends *************************************************


    //********************************************* Heap Sort **********************************************************

    public void heapSort(int inputArray[]) {
        Data d2 = new Data();
        String s = d2.getSort();
        long startTime;
        long elapsedTime;
        startTime = System.nanoTime();
        /* Build max heap. */
        // Doing it for half the array is sufficient as the rest of array are going the children nodes.
        for (int i = inputArray.length / 2 - 1; i >= 0; i--) {
            heapify(inputArray, inputArray.length, i);
        }
        /* Extract the biggest element (top of heap) one by one and move to the end */
        for (int i = inputArray.length - 1; i >= 0; i--) {
            // Move current root to end
            int temp = inputArray[0];
            inputArray[0] = inputArray[i];
            inputArray[i] = temp;
            // Call max heapify on the reduced heap.
            heapify(inputArray, i, 0);

            elapsedTime = System.nanoTime() - startTime;
            d2.setTimeofExecution(elapsedTime);
            d2.setOutput(inputArray);
            WriteOutput(inputArray, elapsedTime);

        }
    }

    void heapify(int arr[], int arrayLength, int rootElementIndex) {

        int leftIndex = 2 * rootElementIndex + 1;  // left = 2*i + 1
        int rightIndex = 2 * rootElementIndex + 2;  // right = 2*i + 2

        int largest = rootElementIndex;

        if (leftIndex < arrayLength && arr[leftIndex] > arr[largest])
            largest = leftIndex;

        if (rightIndex < arrayLength && arr[rightIndex] > arr[largest])
            largest = rightIndex;

        if (largest != rootElementIndex) {

            int swap = arr[rootElementIndex];
            arr[rootElementIndex] = arr[largest];
            arr[largest] = swap;
            heapify(arr, arrayLength, largest);
        }
    }
    // ************************************* Heap Sort ends here ******************************************************


    //************************************************* Quick Sort ****************************************************
    public void quickSort(int arr[], int begin, int end) {

        Data d2 = new Data();
        String s = d2.getSort();
        long startTime;
        long elapsedTime;
        startTime = System.nanoTime();

        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }

        elapsedTime = System.nanoTime() - startTime;
        d2.setTimeofExecution(elapsedTime);
        d2.setOutput(arr);
        WriteOutput(arr, elapsedTime);
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
    //******************************************* Quick sort ends here *************************************************

    //******************************************* Quick Sort using 3 medians *******************************************

    public  void quickSort3med(int[] intArray) {
        Data d2 = new Data();
        String s = d2.getSort();
        long startTime;
        long elapsedTime;
        startTime = System.nanoTime();

        recQuickSort(intArray, 0, intArray.length - 1);

        elapsedTime = System.nanoTime() - startTime;
        d2.setTimeofExecution(elapsedTime);
        d2.setOutput(intArray);
        WriteOutput(intArray,elapsedTime);

    }

    public  void recQuickSort(int[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(intArray, left, right);
        else {
            double median = medianOf3(intArray, left, right);
            int partition = partitionIt(intArray, left, right, median);
            recQuickSort(intArray, left, partition - 1);
            recQuickSort(intArray, partition + 1, right);
        }
    }

    public  int medianOf3(int[] intArray, int left, int right) {
        int center = (left + right) / 2;

        if (intArray[left] > intArray[center])
            swap(intArray, left, center);

        if (intArray[left] > intArray[right])
            swap(intArray, left, right);

        if (intArray[center] > intArray[right])
            swap(intArray, center, right);

        swap(intArray, center, right - 1);
        return intArray[right - 1];
    }

    public  void swap(int[] intArray, int dex1, int dex2) {
        int temp = intArray[dex1];
        intArray[dex1] = intArray[dex2];
        intArray[dex2] = temp;
    }

    public  int partitionIt(int[] intArray, int left, int right, double pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (intArray[++leftPtr] < pivot)
                ;
            while (intArray[--rightPtr] > pivot)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(intArray, leftPtr, rightPtr);
        }
        swap(intArray, leftPtr, right - 1);
        return leftPtr;
    }

    public  void manualSort(int[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (intArray[left] > intArray[right])
                swap(intArray, left, right);
            return;
        } else {
            if (intArray[left] > intArray[right - 1])
                swap(intArray, left, right - 1);
            if (intArray[left] > intArray[right])
                swap(intArray, left, right);
            if (intArray[right - 1] > intArray[right])
                swap(intArray, right - 1, right);
        }
    }

    //************************************ Quick Sort Using 3 Medians ends here ****************************************


    //***************************************** Insertion Sort *********************************************************

    public void insertionSort(int array[]) {
        Data d2 = new Data();
        String s = d2.getSort();
        long startTime;
        long elapsedTime;
        startTime = System.nanoTime();

        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }

        elapsedTime = System.nanoTime() - startTime;
        d2.setTimeofExecution(elapsedTime);
        d2.setOutput(array);
        WriteOutput(array, elapsedTime);
    }
    //********************************* Insertion Sort Ends here *******************************************************

    // ****************************************** Selection Sort *******************************************************

    public void selectionSort(int[] arr) {
        Data d2 = new Data();
        String s = d2.getSort();
        long startTime;
        long elapsedTime;
        startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;

            elapsedTime = System.nanoTime() - startTime;
            d2.setTimeofExecution(elapsedTime);
            d2.setOutput(arr);
            WriteOutput(arr, elapsedTime);
        }
    }
    // ************************************** Selection Sort ends here *************************************************

    // ********************************************* Bubble Sort *******************************************************

    public void bubbleSort(int[] a) {

        Data d2 = new Data();
        String s = d2.getSort();
        long startTime;
        long elapsedTime;
        startTime = System.nanoTime();

        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        elapsedTime = System.nanoTime() - startTime;
        d2.setTimeofExecution(elapsedTime);
        d2.setOutput(a);
        WriteOutput(a, elapsedTime);
    }

    // *************************************** Bubble Sort ends here ***************************************************


    public void WriteOutput(int[] a, long ExecTime) {
        Output op = new Output();
        op.jTextAreaOutput.setText(Arrays.toString(a));
        op.jLabelExecutionTime.setText(Long.toString(ExecTime));
        op.setVisible(true);
        op.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
