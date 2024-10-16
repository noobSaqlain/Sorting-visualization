import javax.swing.*;

public class MyFrame extends JFrame {
MyPanel myPanel;
    MyFrame(){
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        myPanel.timer.start();
    }
}
