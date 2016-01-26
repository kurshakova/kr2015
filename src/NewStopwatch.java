import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewStopwatch extends JPanel {
    private int min;
    private int sec;
    private int msec;
    private int minLap;
    private int secLap;
    private int msecLap;
    private int lapNumber;
    private boolean isInWork;
    private JLabel minLabel;
    private JLabel secLabel;
    private JLabel msecLabel;
    private JLabel resultLabel;
    private JLabel lapLabel;
    private JLabel minLabel2;
    private JLabel secLabel2;
    private JLabel msecLabel2;
    private JButton startButton;
    private JButton resetButton;
    private JButton lapButton;
    private JLabel stopWatchLabel;
    private JLabel infoLabel;
    private JTextArea lapArea;
    private JScrollPane scrollPane;

    public NewStopwatch() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        this.setBackground(new Color(0x00C6FF));

        Font buttonsFont = new Font("Times New Roman", Font.PLAIN, 30);
        Font labelFont = new Font("Times New Roman", Font.PLAIN, 48);

        stopWatchLabel = new JLabel("Секундомер");
        stopWatchLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        stopWatchLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        stopWatchLabel.setForeground(Color.BLUE);

        minLabel = new JLabel(Integer.toString(min));
        secLabel = new JLabel(Integer.toString(sec));
        msecLabel = new JLabel(Integer.toString(msec));
        minLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        secLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        msecLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        minLabel.setFont(labelFont);
        secLabel.setFont(labelFont);
        msecLabel.setFont(labelFont);

        minLabel.setForeground(Color.BLUE);
        secLabel.setForeground(Color.BLUE);
        msecLabel.setForeground(Color.BLUE);
        minLabel.setBorder(new LineBorder(new Color(0x00C6FF), 2));
        secLabel.setBorder(new LineBorder(new Color(0x00C6FF), 2));
        msecLabel.setBorder(new LineBorder(new Color(0x00C6FF), 2));

        resultLabel = new JLabel("Итого:");
        resultLabel.setForeground(Color.BLUE);
        resultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        minLabel2 = new JLabel(Integer.toString(min));
        secLabel2 = new JLabel(Integer.toString(sec));
        msecLabel2 = new JLabel(Integer.toString(msec));
        minLabel2.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        secLabel2.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        msecLabel2.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        minLabel2.setFont(labelFont);
        secLabel2.setFont(labelFont);
        msecLabel2.setFont(labelFont);

        minLabel2.setForeground(Color.BLUE);
        secLabel2.setForeground(Color.BLUE);
        msecLabel2.setForeground(Color.BLUE);
        minLabel2.setBorder(new LineBorder(new Color(0x00C6FF), 2));
        secLabel2.setBorder(new LineBorder(new Color(0x00C6FF), 2));
        msecLabel2.setBorder(new LineBorder(new Color(0x00C6FF), 2));

        lapLabel = new JLabel("Круг:");
        lapLabel.setForeground(Color.BLUE);
        lapLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        startButton = new JButton("СТАРТ");
        resetButton = new JButton("СБРОС");
        lapButton = new JButton("КРУГ");
        startButton.setFont(buttonsFont);
        resetButton.setFont(buttonsFont);
        lapButton.setFont(buttonsFont);
        startButton.setBackground(new Color(0x00C6FF));
        resetButton.setBackground(new Color(0x00C6FF));
        lapButton.setBackground(new Color(0x00C6FF));
        startButton.setForeground(Color.BLUE);
        resetButton.setForeground(Color.BLUE);
        lapButton.setForeground(Color.BLUE);
        startButton.setBorder(new LineBorder(new Color(0x00C6FF), 2));
        resetButton.setBorder(new LineBorder(new Color(0x00C6FF), 2));
        lapButton.setBorder(new LineBorder(new Color(0x00C6FF), 2));

        lapButton.setEnabled(false);

        infoLabel = new JLabel("Круг №, общее время, время круга");
        infoLabel.setForeground(Color.BLUE);
        infoLabel.setBackground(new Color(0x00C6FF));
        infoLabel.setBorder(new LineBorder(new Color(0x00C6FF), 2));
        infoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        lapArea = new JTextArea();
        lapArea.setEditable(false);
        lapArea.setBackground(new Color(0x9DC4BC));
        lapArea.setForeground(Color.BLUE);
        lapArea.setFont(new Font("Times New Roman", Font.PLAIN, 48));

        scrollPane = new JScrollPane(lapArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(stopWatchLabel, new GridBagConstraints(0, 0, 6, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(resultLabel, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(minLabel, new GridBagConstraints(0, 2, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(secLabel, new GridBagConstraints(2, 2, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(msecLabel, new GridBagConstraints(4, 2, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(lapLabel, new GridBagConstraints(0, 3, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(minLabel2, new GridBagConstraints(0, 4, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(secLabel2, new GridBagConstraints(2, 4, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(msecLabel2, new GridBagConstraints(4, 4, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(infoLabel, new GridBagConstraints(0, 5, 6, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(scrollPane, new GridBagConstraints(0, 6, 6, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(startButton, new GridBagConstraints(0, 7, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(lapButton, new GridBagConstraints(2, 7, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(resetButton, new GridBagConstraints(4, 7, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

        final Timer t = new Timer(100, new Listener());

        startButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isInWork) {
                    t.start();
                    startButton.setText("СТОП");
                    isInWork = true;
                    lapButton.setEnabled(true);
                }
                else{
                    t.stop();
                    startButton.setText("СТАРТ");
                    isInWork = false;
                    lapButton.setEnabled(false);
                }
            }
        });

        resetButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
                min = 0;
                sec = 0;
                msec = 0;
                minLap = 0;
                secLap = 0;
                msecLap = 0;
                minLabel.setText(Integer.toString(min));
                secLabel.setText(Integer.toString(sec));
                msecLabel.setText(Integer.toString(msec));
                minLabel2.setText(Integer.toString(minLap));
                secLabel2.setText(Integer.toString(secLap));
                msecLabel2.setText(Integer.toString(msecLap));
                lapButton.setEnabled(false);
                isInWork = false;
                lapNumber = 0;
                lapArea.setText("");
            }
        });

        lapButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lapNumber++;
                lapArea.append("• Круг " + lapNumber + ", " + min + ":" + sec + "." + msec + ", " + minLap + ":" + secLap + "." + msecLap + "\n");
                minLap = 0;
                secLap = 0;
                msecLap = 0;
            }
        });
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public int getMSec() {
        return msec;
    }

    public void setMin(int min) {
        this.min = min;
        minLabel.setText(Integer.toString(min));
    }

    public void setSec(int sec) {
        this.sec = sec;
        secLabel.setText(Integer.toString(sec));
    }

    public void setMSec(int msec) {
        this.msec = msec;
        msecLabel.setText(Integer.toString(msec));
    }

    public int getMinLap() {
        return minLap;
    }

    public int getSecLap() {
        return secLap;
    }

    public int getMSecLap() {
        return msecLap;
    }

    public void setMinLap(int minLap) {
        this.minLap = minLap;
        minLabel2.setText(Integer.toString(minLap));
    }

    public void setSecLap(int secLap) {
        this.secLap = secLap;
        secLabel2.setText(Integer.toString(secLap));
    }

    public void setMSecLap(int msecLap) {
        this.msecLap = msecLap;
        msecLabel2.setText(Integer.toString(msecLap));
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int min = getMin();
            int sec = getSec();
            int msec = getMSec();
            int minLap = getMinLap();
            int secLap = getSecLap();
            int msecLap = getMSecLap();

            msec++;
            msecLap++;

            if (msec == 10) {
                msec = 0;
                sec++;
            }

            if (sec == 60) {
                sec = 0;
                min++;
            }

            if (msecLap == 10) {
                msecLap = 0;
                secLap++;
            }

            if (secLap == 60) {
                secLap = 0;
                minLap++;
            }

            setMin(min);
            setSec(sec);
            setMSec(msec);
            setMinLap(minLap);
            setSecLap(secLap);
            setMSecLap(msecLap);
        }
    }
}