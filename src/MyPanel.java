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
    JButton selection, insertion, gnome, home, bubble;
    private String selectedSortAlgo = "insertion"; // default
    private final int DELAY = 100;
     private boolean atHomepaage = true;
     private final int BUTTON_WIDTH = 100, BUTTON_HEIGHT = 40;
     private final int BUTTON_x = SCREEN_WIDTH / 2 + (BUTTON_WIDTH / 2);
     private final int BUTTON_y = 300;
     private final int vertIncre = BUTTON_HEIGHT + 50;
    MyPanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setOpaque(true);
        this.timer = new Timer(DELAY, this);
        initButtons();
        this.timer.start();
    }

    //init buttons
    void initButtons(){
        /******HOME*****/
        home = new JButton("HOME");
        home.setBackground(Color.WHITE);
        home.setPreferredSize(new Dimension(60,30));
        home.setFocusable(false);
        home.setVisible(false);
        this.add(home);

        /********Bubble******/
        bubble = new JButton("BUBBLE SORT");
        bubble.setBackground(Color.WHITE);
        bubble.setFocusable(false);
        bubble.setVisible(true);
        bubble.setLayout(null);
        bubble.setBounds(BUTTON_x,BUTTON_y,BUTTON_WIDTH,BUTTON_HEIGHT);
        this.add(bubble);

        /********SELECTION******/
        selection = new JButton("SELECTION SORT");
        selection.setBackground(Color.WHITE);
        selection.setFocusable(false);
        selection.setVisible(true);
        selection.setLayout(null);
        selection.setBounds(BUTTON_x,BUTTON_y + 1 * vertIncre ,BUTTON_WIDTH,BUTTON_HEIGHT);
        this.add(selection);

        /********insertion******/
        insertion = new JButton("INSERTION SORT");
        insertion.setBackground(Color.WHITE);
        insertion.setFocusable(false);
        insertion.setVisible(true);
        insertion.setLayout(null);
        insertion.setBounds(BUTTON_x,BUTTON_y + 2 * vertIncre,BUTTON_WIDTH,BUTTON_HEIGHT);
        this.add(insertion);

        /********gnome******/
        gnome = new JButton("GNOME SORT");
        gnome.setBackground(Color.WHITE);
        gnome.setFocusable(false);
        gnome.setVisible(true);
        gnome.setLayout(null);
        gnome.setBounds(BUTTON_x,BUTTON_y + 3 * vertIncre,BUTTON_WIDTH,BUTTON_HEIGHT);
        this.add(gnome);
    }
    void setAllButtonFalse(){
        bubble.setVisible(false);
        selection.setVisible(false);
        insertion.setVisible(false);
        gnome.setVisible(false);
        atHomepaage = false;
    }
    void setAllButtonTrue(){
        bubble.setVisible(true);
        selection.setVisible(true);
        insertion.setVisible(true);
        gnome.setVisible(true);
        atHomepaage = true;

    }

    // draw bars
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 0;
        if(atHomepaage){

            sortAlgo.shuffleArray(sortAlgo.array);
            bubble.addActionListener(e ->{
                selectedSortAlgo = "BUBBLE";
                setAllButtonFalse();
            });
            selection.addActionListener(e ->{
                selectedSortAlgo = "SELECTION";
                setAllButtonFalse();
            });
            insertion.addActionListener(e ->{
                selectedSortAlgo = "INSERTION";
                setAllButtonFalse();
            });

            gnome.addActionListener(e ->{
                selectedSortAlgo = "GNOME";
                setAllButtonFalse();
            });
        }else {
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
            g.setFont(new Font("Times New Roman", Font.BOLD, 24));
            g.setColor(Color.red);
            g.drawString(sortAlgo.isDone ? "sorting done" : "sorting", 10, 20);
            if (sortAlgo.isDone) {
                home.setVisible(true);
                home.addActionListener(e ->{
                    home.setVisible(false);
                    setAllButtonTrue();
                });
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //sortAlgo.bubbleSortStep(); // Change this to call other sorting methods
        //sortAlgo.selectionSortStep();
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
        sortAlgo.setSortingAlgo(selectedSortAlgo);
        repaint();
    }
}
