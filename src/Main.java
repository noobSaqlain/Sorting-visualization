import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        new MyFrame();
    }
}


//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Sorting Algorithms Visualization");
//        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
//        MyPanel panel = new MyPanel(sortingAlgorithm);
//
//        JButton heapSortButton = new JButton("Heap Sort");
//        heapSortButton.addActionListener(e -> {
//            sortingAlgorithm.setSortingAlgorithm("HeapSort");
//            sortingAlgorithm.heapSort();
//        });
//
//        JButton countingSortButton = new JButton("Counting Sort");
//        countingSortButton.addActionListener(e -> {
//            sortingAlgorithm.setSortingAlgorithm("CountingSort");
//            sortingAlgorithm.countingSort();
//        });
//
//        JButton radixSortButton = new JButton("Radix Sort");
//        radixSortButton.addActionListener(e -> {
//            sortingAlgorithm.setSortingAlgorithm("RadixSort");
//            sortingAlgorithm.radixSort();
//        });
//
//        JButton bucketSortButton = new JButton("Bucket Sort");
//        bucketSortButton.addActionListener(e -> {
//            sortingAlgorithm.setSortingAlgorithm("BucketSort");
//            sortingAlgorithm.bucketSort();
//        });
//
//        JButton shellSortButton = new JButton("Shell Sort");
//        shellSortButton.addActionListener(e -> {
//            sortingAlgorithm.setSortingAlgorithm("ShellSort");
//            sortingAlgorithm.shellSort();
//        });
//
//        JButton timSortButton = new JButton("Tim Sort");
//        timSortButton.addActionListener(e -> {
//            sortingAlgorithm.setSortingAlgorithm("TimSort");
//            sortingAlgorithm.timSort();
//        });
//
//        JButton cocktailShakerSortButton = new JButton("Cocktail Shaker Sort");
//        cocktailShakerSortButton.addActionListener(e -> {
//            sortingAlgorithm.setSortingAlgorithm("CocktailShakerSort");
//            sortingAlgorithm.cocktailShakerSort();
//        });
//
//        JButton pigeonholeSortButton = new JButton("Pigeonhole Sort");
//        pigeonholeSortButton.addActionListener(e -> {
//            sortingAlgorithm.setSortingAlgorithm("PigeonholeSort");
//            sortingAlgorithm.pigeonholeSort();
//        });
//
//        JButton gnomeSortButton = new JButton("Gnome Sort");
//        gnomeSortButton.addActionListener(e -> {
//            sortingAlgorithm.setSortingAlgorithm("GnomeSort");
//            sortingAlgorithm.gnomeSort();
//        });
//
//        JButton sleepSortButton = new JButton("Sleep Sort");
//        sleepSortButton.addActionListener(e -> {
//            sortingAlgorithm.setSortingAlgorithm("SleepSort");
//            sortingAlgorithm.sleepSort();
//        });
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(heapSortButton);
//        buttonPanel.add(countingSortButton);
//        buttonPanel.add(radixSortButton);
//        buttonPanel.add(bucketSortButton);
//        buttonPanel.add(shellSortButton);
//        buttonPanel.add(timSortButton);
//        buttonPanel.add(cocktailShakerSortButton);
//        buttonPanel.add(pigeonholeSortButton);
//        buttonPanel.add(gnomeSortButton);
//        buttonPanel.add(sleepSortButton);
//
//        frame.add(panel, BorderLayout.CENTER);
//        frame.add(buttonPanel, BorderLayout.SOUTH);
//        frame.setSize(800, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);