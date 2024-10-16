import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    private final int SCREEN_WIDTH = 700;
    private final int SCREEN_HEIGHT = 600;
    private final int BAR_WIDTH = 16;
    SortingAlgorithm sortAlgo = new SortingAlgorithm();

    static Timer timer;
    private final int DELAY = 100;

    MyPanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setOpaque(true);
        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }

    // draw bars
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 0;
        for (int i = 0; i < sortAlgo.array.length; i++) {
            int barHeight = sortAlgo.array[i] * 10;
            int y = SCREEN_HEIGHT - barHeight;

            if (i == sortAlgo.getCurrentBar1() || i == sortAlgo.getCurrentBar2()) {
                g.setColor(Color.WHITE); // Highlight current bars being processed
            } else {
                g.setColor(Color.GREEN); // Default color
            }
            g.fillRect(x, y, BAR_WIDTH, barHeight);
            x += BAR_WIDTH;
        }
        g.setFont(new Font("Times New Roman",Font.BOLD,24));
        g.setColor(Color.red);
        g.drawString(sortAlgo.isDone ? "sorting done" : "sorting", 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //sortAlgo.bubbleSortStep(); // Change this to call other sorting methods
        sortAlgo.selectionSortStep();
        //sortAlgo.insertionSortStep();
        //sortAlgo.gnomeSortStep();
        // -1 sortAlgo.radixSortStep();
        // -1 sortAlgo.bucketSortStep();
        // -1 sortAlgo.cocktailShakerSortStep();
        // issue -> sortAlgo.heapSortStep();
        // -1 sortAlgo.pigeonholeSortStep();
        // -1 sortAlgo.timSortStep();
        // issue -> sortAlgo.countingSortStep();
        // issue -> sortAlgo.shellSortStep();

        repaint();
    }
}
