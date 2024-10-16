import java.util.Arrays;

public class SortingAlgorithm {
    public final int[] array = {
            42, 5, 33, 10, 26, 48, 19, 55, 31, 3,
            20, 7, 45, 60, 38, 22, 13, 59, 51, 30,
            28, 6, 15, 58, 24, 18, 9, 36, 54, 14,
            40, 21, 34, 4, 11, 32, 12, 63, 2, 50
    };

    private int i = 0, j = 0, minIndex = 0;
    private int currentBar1 = -1;
    private int currentBar2 = -1;
    boolean isDone = false;
    private void reset() {
        i = 0;
        j = 0;
        currentBar1 = -1;
        currentBar2 = -1;
    }

    // Getter and Setter for current bars
    int getCurrentBar1() {
        return currentBar1;
    }

    void setCurrentBar1(int x) {
        this.currentBar1 = x;
    }

    int getCurrentBar2() {
        return currentBar2;
    }

    void setCurrentBar2(int x) {
        this.currentBar2 = x;
    }

    // Bubble Sort Step
    public void bubbleSortStep() {
        if (i < array.length - 1) {
            if (j < array.length - i - 1) {
                currentBar1 = j;
                currentBar2 = j + 1;

                if (array[j] > array[j + 1]) {
                    // Swap the bars
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                j++;
            } else {
                j = 0;
                i++;
            }
        } else {
            reset();
            isDone = true;
            MyPanel.timer.stop();
        }
    }

    // Selection Sort Step
    public void selectionSortStep() {
        if (i < array.length - 1) {
            minIndex = i;
            for (j = i + 1; j < array.length; j++) {
                currentBar1 = minIndex;
                currentBar2 = j;

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }


            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
            i++;
        } else {
            reset();
            isDone = true;
            MyPanel.timer.stop();

        }
    }

    // Insertion Sort Step
    public void insertionSortStep() {
        if (i < array.length) {
            int key = array[i];
            j = i - 1;
            currentBar1 = i;

            while (j >= 0 && array[j] > key) {
                currentBar2 = j;
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            i++;
        } else {
           reset();
            isDone = true;
            MyPanel.timer.stop(); // Sorting completed
        }
    }

    // Gnome Sort Step
    public void gnomeSortStep() {
        if (i < array.length) {
            currentBar1 = array[j];
            currentBar2 = (j > 0) ? array[j - 1] : -1;

            if (j > 0 && array[j] < array[j - 1]) {
                // Swap
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;

                // After swap, set the current bars to show the swapped values
                currentBar1 = array[j - 1]; // Updated value after the swap
                currentBar2 = array[j]; // Updated value after the swap

                j--; // Move left in the array
            } else {
                j++; // Move right in the array
                if (j == array.length) {
                    i++; // Move to the next position
                    j = i; // Reset j to the current position
                }
            }
        } else {
            isDone = true;
            MyPanel.timer.stop();
            reset();
        }
    }


    /****************************
     *
     * OTHER SORT TO BE DONE SOON
     * ***************/

//    // Shell Sort Step
//    public void shellSortStep() {
//        if (i == 0) {
//            i = array.length / 2; // Initialize gap
//        }
//        if (i > 0) {
//            j = 0; // Reset j for the inner loop
//            while (j + i < array.length) {
//                currentBar1 = j; // Highlight the first bar
//                currentBar2 = j + i; // Highlight the bar i positions away
//                if (array[j] > array[j + i]) {
//                    // Swap
//                    int temp = array[j];
//                    array[j] = array[j + i];
//                    array[j + i] = temp;
//                }
//                j++;
//            }
//            i--;
//        } else {
//            currentBar1 = -1; // Reset after sorting is finished
//            currentBar2 = -1;
//            MyPanel.timer.stop(); // Sorting completed
//        }
//    }
//
//    // Heap Sort Step
//    public void heapSortStep() {
//        // Create a max heap
//        if (i < array.length) {
//            currentBar1 = i; // Current index being processed
//            buildMaxHeap(array.length - i);
//            i++;
//        } else {
//            currentBar1 = -1; // Reset after sorting is finished
//            currentBar2 = -1;
//            MyPanel.timer.stop(); // Sorting completed
//        }
//    }
//
//    private void buildMaxHeap(int length) {
//        for (int k = length / 2 - 1; k >= 0; k--) {
//            maxHeapify(length, k);
//        }
//    }
//
//    private void maxHeapify(int length, int index) {
//        int largest = index;
//        int left = 2 * index + 1;
//        int right = 2 * index + 2;
//
//        if (left < length && array[left] > array[largest]) {
//            largest = left;
//        }
//        if (right < length && array[right] > array[largest]) {
//            largest = right;
//        }
//        if (largest != index) {
//            int temp = array[index];
//            array[index] = array[largest];
//            array[largest] = temp;
//
//            currentBar1 = index; // Highlight the index being swapped
//            currentBar2 = largest; // Highlight the largest index
//            maxHeapify(length, largest);
//        }
//    }
//
//    // Counting Sort Step
//    public void countingSortStep() {
//        int max = Arrays.stream(array).max().getAsInt();
//        int[] count = new int[max + 1];
//        int[] output = new int[array.length];
//
//        for (int num : array) {
//            count[num]++;
//        }
//
//        for (int i = 1; i <= max; i++) {
//            count[i] += count[i - 1];
//        }
//
//        for (int i = array.length - 1; i >= 0; i--) {
//            output[count[array[i]] - 1] = array[i];
//            count[array[i]]--;
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = output[i];
//        }
//
//        currentBar1 = -1; // Reset after sorting is finished
//        currentBar2 = -1;
//        MyPanel.timer.stop(); // Sorting completed
//    }
//
//    // Radix Sort Step
//    public void radixSortStep() {
//        int max = Arrays.stream(array).max().getAsInt();
//        for (int exp = 1; max / exp > 0; exp *= 10) {
//            countingSortByDigit(exp);
//        }
//
//        currentBar1 = -1; // Reset after sorting is finished
//        currentBar2 = -1;
//        MyPanel.timer.stop(); // Sorting completed
//    }
//
//    private void countingSortByDigit(int exp) {
//        int n = array.length;
//        int[] output = new int[n];
//        int[] count = new int[10];
//
//        for (int i = 0; i < n; i++) {
//            count[(array[i] / exp) % 10]++;
//        }
//
//        for (int i = 1; i < 10; i++) {
//            count[i] += count[i - 1];
//        }
//
//        for (int i = n - 1; i >= 0; i--) {
//            output[count[(array[i] / exp) % 10] - 1] = array[i];
//            count[(array[i] / exp) % 10]--;
//        }
//
//        System.arraycopy(output, 0, array, 0, n);
//    }
//
//    // Bucket Sort Step
//    public void bucketSortStep() {
//        int max = Arrays.stream(array).max().getAsInt();
//        int bucketCount = (max / 10) + 1;
//        int[][] buckets = new int[bucketCount][0];
//
//        // Place elements in buckets
//        for (int value : array) {
//            int bucketIndex = value / 10;
//            buckets[bucketIndex] = append(buckets[bucketIndex], value);
//        }
//
//        int index = 0;
//        for (int[] bucket : buckets) {
//            Arrays.sort(bucket);
//            for (int value : bucket) {
//                array[index++] = value;
//            }
//        }
//
//        currentBar1 = -1; // Reset after sorting is finished
//        currentBar2 = -1;
//        MyPanel.timer.stop(); // Sorting completed
//    }
//
//    private int[] append(int[] bucket, int value) {
//        int[] newBucket = new int[bucket.length + 1];
//        System.arraycopy(bucket, 0, newBucket, 0, bucket.length);
//        newBucket[bucket.length] = value;
//        return newBucket;
//    }
//
//    // Tim Sort Step
//    public void timSortStep() {
//        // Implementation of Tim Sort algorithm
//        // Create a temporary array to hold the sorted values
//        int[] temp = new int[array.length];
//        int run = 32; // Use a run size of 32
//
//        for (int start = 0; start < array.length; start += run) {
//            int end = Math.min(start + run - 1, array.length - 1);
//            insertionSort(start, end);
//        }
//
//        // Merge sorted runs
//        for (int size = run; size < array.length; size *= 2) {
//            for (int left = 0; left < array.length; left += 2 * size) {
//                int mid = left + size - 1;
//                int right = Math.min((left + 2 * size - 1), (array.length - 1));
//                if (mid < right) {
//                    merge(left, mid, right);
//                }
//            }
//        }
//
//        currentBar1 = -1; // Reset after sorting is finished
//        currentBar2 = -1;
//        MyPanel.timer.stop(); // Sorting completed
//    }
//
//    private void insertionSort(int left, int right) {
//        for (int i = left + 1; i <= right; i++) {
//            int key = array[i];
//            int j = i - 1;
//            while (j >= left && array[j] > key) {
//                array[j + 1] = array[j];
//                j--;
//            }
//            array[j + 1] = key;
//        }
//    }
//
//    private void merge(int left, int mid, int right) {
//        // Merge two sorted halves
//        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
//        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);
//
//        int i = 0, j = 0, k = left;
//
//        while (i < leftArray.length && j < rightArray.length) {
//            currentBar1 = i; // Index of left array
//            currentBar2 = j; // Index of right array
//            if (leftArray[i] <= rightArray[j]) {
//                array[k++] = leftArray[i++];
//            } else {
//                array[k++] = rightArray[j++];
//            }
//        }
//
//        while (i < leftArray.length) {
//            array[k++] = leftArray[i++];
//        }
//
//        while (j < rightArray.length) {
//            array[k++] = rightArray[j++];
//        }
//    }
//
//    // Cocktail Shaker Sort Step
//    public void cocktailShakerSortStep() {
//        if (i == 0) {
//            j = 0; // Initialize j
//        }
//        if (i < array.length / 2) {
//            currentBar1 = j; // Highlight the left side
//            currentBar2 = j + 1; // Highlight the right side
//            if (j < array.length - i - 1) {
//                if (array[j] > array[j + 1]) {
//                    // Swap
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//                j++;
//            } else {
//                // Reverse direction
//                for (j = array.length - i - 2; j >= i; j--) {
//                    currentBar1 = j; // Highlight the right side
//                    currentBar2 = j + 1; // Highlight the left side
//                    if (array[j] > array[j + 1]) {
//                        // Swap
//                        int temp = array[j];
//                        array[j] = array[j + 1];
//                        array[j + 1] = temp;
//                    }
//                }
//                i++; // Move i up for the next iteration
//            }
//        } else {
//            currentBar1 = -1; // Reset after sorting is finished
//            currentBar2 = -1;
//            MyPanel.timer.stop(); // Sorting completed
//        }
//    }
//
//    // Pigeonhole Sort Step
//    public void pigeonholeSortStep() {
//        int min = Arrays.stream(array).min().getAsInt();
//        int max = Arrays.stream(array).max().getAsInt();
//        int range = max - min + 1;
//
//        int[] holes = new int[range];
//
//        for (int value : array) {
//            holes[value - min]++;
//        }
//
//        int index = 0;
//        for (int i = 0; i < holes.length; i++) {
//            while (holes[i] > 0) {
//                array[index++] = i + min;
//                holes[i]--;
//            }
//        }
//
//        currentBar1 = -1; // Reset after sorting is finished
//        currentBar2 = -1;
//        MyPanel.timer.stop(); // Sorting completed
//    }
}
