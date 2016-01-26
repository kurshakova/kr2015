import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class NewTimer extends JPanel {
    private int hour;
    private int min;
    private int sec;
    private JLabel timerLabel;
    private JLabel hourLabel;
    private JLabel minLabel;
    private JLabel secLabel;
    private JLabel hourLabelInfo;
    private JLabel minLabelInfo;
    private JLabel secLabelInfo;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JComboBox hoursComboBox;
    private JComboBox minsComboBox;
    private JComboBox secsComboBox;
    private boolean isInWork;
    final Timer t = new Timer(1000, new Listener());
    Thread thread;

    public NewTimer() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        this.setBackground(new Color(0x00C6FF));

        Font buttonsFont = new Font("Times New Roman", Font.PLAIN, 30);
        Font labelFont = new Font("Times New Roman", Font.PLAIN, 48);

        timerLabel = new JLabel("Таймер");
        timerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        timerLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        timerLabel.setForeground(Color.BLUE);

        String masHours[] = new String[24];
        for (int y = 0; y < 24; y++) {
            int i = y++;
            y--;
            masHours[y] = Integer.toString(i);
        }

        String masMins[] = new String[60];
        for (int y = 0; y < 60; y++) {
            int i = y++;
            y--;
            masMins[y] = Integer.toString(i);
        }

        String masSec[] = new String[60];
        for (int y = 0; y < 60; y++) {
            int i = y++;
            y--;
            masSec[y] = Integer.toString(i);
        }

        hoursComboBox = new JComboBox(masHours);
        minsComboBox = new JComboBox(masMins);
        secsComboBox = new JComboBox(masSec);

        hourLabel = new JLabel(Integer.toString(hour));
        minLabel = new JLabel(Integer.toString(min));
        secLabel = new JLabel(Integer.toString(sec));
        hourLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        minLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        secLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        hourLabelInfo = new JLabel("Час");
        minLabelInfo = new JLabel("Мин");
        secLabelInfo = new JLabel("Сек");
        hourLabelInfo.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        minLabelInfo.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        secLabelInfo.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        hourLabelInfo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        minLabelInfo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        secLabelInfo.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        hourLabel.setFont(labelFont);
        minLabel.setFont(labelFont);
        secLabel.setFont(labelFont);

        hourLabel.setForeground(Color.BLUE);
        minLabel.setForeground(Color.BLUE);
        secLabel.setForeground(Color.BLUE);
        hourLabelInfo.setForeground(Color.BLUE);
        minLabelInfo.setForeground(Color.BLUE);
        secLabelInfo.setForeground(Color.BLUE);
        hourLabel.setBorder(new LineBorder(Color.GRAY, 2));
        minLabel.setBorder(new LineBorder(Color.GRAY, 2));
        secLabel.setBorder(new LineBorder(Color.GRAY, 2));

        startButton = new JButton("СТАРТ");
        stopButton = new JButton("СТОП");
        resetButton = new JButton("СБРОС");
        startButton.setFont(buttonsFont);
        stopButton.setFont(buttonsFont);
        resetButton.setFont(buttonsFont);
        startButton.setBackground(new Color(0x00C6FF));
        stopButton.setBackground(new Color(0x00C6FF));
        resetButton.setBackground(new Color(0x00C6FF));
        startButton.setForeground(Color.BLUE);
        stopButton.setForeground(Color.BLUE);
        resetButton.setForeground(Color.BLUE);
        stopButton.setEnabled(false);

        this.add(timerLabel, new GridBagConstraints(0, 0, 6, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(hourLabelInfo, new GridBagConstraints(0, 1, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(minLabelInfo, new GridBagConstraints(2, 1, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(secLabelInfo, new GridBagConstraints(4, 1, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(hourLabel, new GridBagConstraints(0, 2, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(minLabel, new GridBagConstraints(2, 2, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(secLabel, new GridBagConstraints(4, 2, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(hoursComboBox, new GridBagConstraints(0, 3, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(minsComboBox, new GridBagConstraints(2, 3, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(secsComboBox, new GridBagConstraints(4, 3, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(startButton, new GridBagConstraints(0, 4, 6, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(stopButton, new GridBagConstraints(0, 5, 6, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(resetButton, new GridBagConstraints(0, 6, 6, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

        startButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isInWork) {
                    Object object = hoursComboBox.getItemAt(hoursComboBox.getSelectedIndex());
                    hour = Integer.parseInt(object.toString());
                    object = minsComboBox.getItemAt(minsComboBox.getSelectedIndex());
                    min = Integer.parseInt(object.toString());
                    object = secsComboBox.getItemAt(secsComboBox.getSelectedIndex());
                    sec = Integer.parseInt(object.toString());
                }
                if ((sec == 0) && (hour == 0) && (min == 0)) {
                    JOptionPane.showMessageDialog(null, "Задайте время!");
                } else {
                    hourLabel.setText(Integer.toString(hour));
                    minLabel.setText(Integer.toString(min));
                    secLabel.setText(Integer.toString(sec));
                    stopButton.setEnabled(true);
                    t.start();
                }
            }
        });

        stopButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((isInWork) && (sec == 0) && (hour == 0) && (min == 0)) {
                } else {
                    t.stop();
                    stopButton.setEnabled(false);
                    isInWork = true;
                }
            }
        });

        resetButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
                hour = 0;
                min = 0;
                sec = 0;
                hourLabel.setText(Integer.toString(hour));
                minLabel.setText(Integer.toString(min));
                secLabel.setText(Integer.toString(sec));
                isInWork = false;
            }
        });
    }

    public void StopTimer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File f = new File("signal.wav");
        thread = new Thread(new Sound(f));
        thread.start();
        t.stop();
        isInWork = false;
        secLabel.setText("0");
        sec = 0;
        stopButton.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Время истекло!");
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public void setHour(int hour) {
        this.hour = hour;
        hourLabel.setText(Integer.toString(hour));
    }

    public void setMin(int min) {
        this.min = min;
        minLabel.setText(Integer.toString(min));
    }

    public void setSec(int sec) {
        this.sec = sec;
        secLabel.setText(Integer.toString(sec));
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int hour = getHour();
            int min = getMin();
            int sec = getSec();

            sec--;

            if ((sec == 0) && (hour == 0) && (min == 0)) {
                try {
                    StopTimer();
                } catch (UnsupportedAudioFileException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (LineUnavailableException e1) {
                    e1.printStackTrace();
                }
            } else {
                if (sec == -1) {
                    sec = 59;
                    min--;
                }

                if (min == -1) {
                    min = 59;
                    hour--;
                }
                setHour(hour);
                setMin(min);
                setSec(sec);
            }
        }
    }
}