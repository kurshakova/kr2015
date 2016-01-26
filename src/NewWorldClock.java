import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.TimeZone;

public class NewWorldClock extends JPanel {
    private String choice = "GMT+02:00";
    private JTextField timeField;
    private JTextField dateField;
    private JComboBox timeZones;
    private final JLabel photo;
    private JLabel worldClockLabel;

    public void ChangeIcon(int hour){
        switch (hour) {
            case 22:
            case 23:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                photo.setIcon(new ImageIcon("1.jpg"));
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                photo.setIcon(new ImageIcon("2.jpg"));
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                photo.setIcon(new ImageIcon("3.jpg"));
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                photo.setIcon(new ImageIcon("4.jpg"));
                break;
        }
    }

    public NewWorldClock() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(new Color(0x00C6FF));

        worldClockLabel = new JLabel("Мировое время");
        worldClockLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        worldClockLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        worldClockLabel.setForeground(Color.BLUE);

        String[] timeZonesMas = {
                "GMT-12:00 Линия перемены даты",
                "GMT-11:00 Время в формате GMT-11:00",
                "GMT-10:00 Гавайи",
                "GMT-09:00 Аляска",
                "GMT-08:00 Тихоокеанское время (США и Канада",
                "GMT-07:00 Мексика",
                "GMT-06:00 Центральное время (США и Канада",
                "GMT-05:00 Североамериканское восточное время (США и Канада)",
                "GMT-04:00 Канада",
                "GMT-03:00 Бразилиа",
                "GMT-02:00 Среднеатлантическое время",
                "GMT-01:00 Азорские острова",
                "GMT+00:00 Дублин, Эдинбург, Лиссабон, Лондон",
                "GMT+01:00 Берлин, Париж, Мадрид, Рим, Варшава",
                "GMT+02:00 Египет, Израиль, Ливан, Ливия, Турция, ЮАР, Киев",
                "GMT+03:00 Москва, Минск, Ирак",
                "GMT+04:00 Объединённые Арабские Эмираты",
                "GMT+05:00 Казахстан, Пакистан, Таджикистан, Туркмения, Узбекистан",
                "GMT+06:00 Казахстана, Киргизия, Бангладеш, Бутанское время",
                "GMT+07:00 Красноярское время, Кемерово, Юго-Восточная Азия (Бангкок, Джакарта, Ханой)",
                "GMT+08:00 Иркутское время, Улан-Батор, Куала-Лумпур, Гонконг, Китай, Сингапур, Тайвань",
                "GMT+09:00 Якутское время, Республика Корея, Япония",
                "GMT+10:00 Владивостокское время, Восточноавстралийское время (Брисбен, Канберра, Мельбурн, Сидней), Тасмания, Западно-тихоокеанское время (Гуам, Порт-Морсби",
                "GMT+11:00 Соломоновы Острова, Новая Каледония",
                "GMT+12:00 Камчатское время, Маршалловы Острова, Фиджи, Новая Зеландия",
                "GMT+13:00 Самоа, Тонга",
                "GMT+14:00 Острова Лайн (Кирибати)"
        };

        timeZones = new JComboBox(timeZonesMas);
        timeZones.setSelectedIndex(14);

        timeField = new JTextField();

        timeField.setEditable(false);
        timeField.setForeground(Color.BLUE);
        timeField.setBackground(Color.BLACK);
        timeField.setFont(new Font("Times New Roman", Font.PLAIN, 48));
        timeField.setBorder(new LineBorder(new Color(0x00C6FF), 1));

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox) e.getSource();
                String item = (String) box.getSelectedItem();
                item = item.substring(0, 9);
                choice = item;
            }
        };

        timeZones.addActionListener(actionListener);

        dateField = new JTextField();

        dateField.setEditable(false);
        dateField.setForeground(Color.BLUE);
        dateField.setBackground(Color.BLACK);
        dateField.setFont(new Font("Times New Roman", Font.PLAIN, 48));
        dateField.setBorder(new LineBorder(new Color(0x00C6FF), 1));

        timeField.setBackground(new Color(0x00C6FF));
        dateField.setBackground(new Color(0x00C6FF));

        photo = new JLabel();
        Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone(choice));
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        photo.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        ChangeIcon(hour);

        this.add(worldClockLabel, new GridBagConstraints(0, 0, 3, 1, 1, 0.1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(timeZones, new GridBagConstraints(0, 1, 3, 1, 1, 0.1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(photo, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(timeField, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(dateField, new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

        Timer t = new Timer(1000, new Listener());
        t.start();
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone(choice));
            int hour = currentTime.get(Calendar.HOUR_OF_DAY);
            int min = currentTime.get(Calendar.MINUTE);
            int sec = currentTime.get(Calendar.SECOND);

            int year = currentTime.get(Calendar.YEAR);
            int month = currentTime.get(Calendar.MONTH) + 1;
            int day = currentTime.get(Calendar.DAY_OF_MONTH);

            ChangeIcon(hour);

            dateField.setText(day + "/" + month + "/" + year);
            timeField.setText(hour + ":" + min + ":" + sec);
        }
    }
}