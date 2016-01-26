import javax.swing.*;
import java.awt.*;

public class Main {
    public static Main window;
    private JFrame mainFrame;
    private JPanel mainPanel;
    private NewStopwatch stopwatch = new NewStopwatch();
    private NewTimer timer = new NewTimer();
    private NewWorldClock clock = new NewWorldClock();

    public Main() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setTitle("Курсовая Куршаковой");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        mainFrame.setBounds((screenWidth - screenWidth / 2) / 2, 0, screenWidth / 2, screenHeight - 50);

        GridBagLayout layout = new GridBagLayout();
        mainPanel = new JPanel(layout);

        mainPanel.add(clock, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        mainPanel.add(timer, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        mainPanel.add(stopwatch, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

        mainPanel.setBackground(Color.GRAY);

        mainFrame.add(mainPanel);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window = new Main();
                    window.mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}