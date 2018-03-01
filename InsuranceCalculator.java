package main;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class InsuranceCalculator extends JFrame
{
    static float tb  = 0,
                 kt  = 0,
                 ko  = 0,
                 kvs = 0,
                 km  = 0,
                 kbm = 0;

    public InsuranceCalculator()
    {
        super("Страховой калькулятор");
        Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        setBounds(screenResolution.width/2 - 340, screenResolution.height/2 - 127, 680, 254);
        setResizable(false);

        String[] tbList = {
                "Выберите базовую тарифную ставку",
                "Мотоциклы, мотороллеры (категория А)",
                "Легковые автомобили физических лиц, ИП (категория В)",
                "Легковые автомобили юридических лиц (категория В)",
                "Легковые автомобили - такси (категория В)",
                "Грузовые автомобили с разрешенной максимальной массой 16 тонн и менее (категория C)",
                "Грузовые автомобили с разрешенной максимальной массой более 16 тонн (категория C)",
                "Грузовые автомобили - прицепы к грузовым автомобилям, полуприцепы, прицепы-роспуски (категория C)",
                "Автобусы с числом пассажирских мест до 20 включительно (категория D)",
                "Автобусы, с числом пассажирских мест более 20 (категория D)",
                "Автобусы, используемые в качестве такси (категория D)",
                "Троллейбусы (категория D)",
                "Трамваи (категория D)",
                "Тракторы, самоходные дорожно-строительные и иные машины (категория D)",
                "Прицепы к тракторам, самоходным дорожно-строительным и иным машинам (категория D)"
        };
        JComboBox tbComboBox = new JComboBox(tbList);

        String[] ktList = {
                "Выберите коэффициент территории",
                "Благовещенск",
                "Октябрьский",
                "Ишимбай",
                "Кумертау",
                "Салават",
                "Стерлитамак",
                "Туймазы",
                "Уфа",
                "Прочие города"
        };
        JComboBox ktComboBox = new JComboBox(ktList);

        String[] koList = {
                "Выберите коэффициент колличества водителей",
                "Количество водителей ограничено",
                "Ограничения по количеству водителей нет"
        };
        JComboBox koComboBox = new JComboBox(koList);

        String[] kvsList = {
                "Выберите коэффициент возраста и стажа водителей",
                "Возраст водителя до 22 лет включительно, стаж до 3 лет включительно",
                "Возраст до 22 лет включительно, стаж свыше 3 лет",
                "Возраст старше 22 лет стаж до 3 лет включительно",
                "Возраст старше 22 лет стаж свыше 3 лет"
        };
        JComboBox kvsComboBox = new JComboBox(kvsList);

        String[] kmList = {
                "Выберите коэффициент мощности двигателя",
                "до 50 л.с. включительно",
                "от 51 до 70 л.с. включительно",
                "от 71 до 100 л.с. включительно",
                "от 101 до 120 л.с. включительно",
                "от 121 до 150 л.с. включительно",
                "от 151 л.с."
        };
        JComboBox kmComboBox = new JComboBox(kmList);

        String[] kbmList = {
                "Выберите коэффициент наличия выплат",
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13"
        };
        JComboBox kbmComboBox = new JComboBox(kbmList);

        tbComboBox.setToolTipText("Базовая тарифная стоимость (Тб)");
        ktComboBox.setToolTipText("Коэффициент территории (Кт)");
        koComboBox.setToolTipText("Коэффициент количества водителей (Ко)");
        kvsComboBox.setToolTipText("Коэффициент возраста и стажа водителей (Квс)");
        kmComboBox.setToolTipText("Коэффициент мощности двигателся (Км)");
        kbmComboBox.setToolTipText("Коэффициент наличия выплат (Кбм)");

        tbComboBox.setPreferredSize(new Dimension(651, 25));
        ktComboBox.setPreferredSize(new Dimension(651, 25));
        koComboBox.setPreferredSize(new Dimension(651, 25));
        kvsComboBox.setPreferredSize(new Dimension(651, 25));
        kmComboBox.setPreferredSize(new Dimension(651, 25));
        kbmComboBox.setPreferredSize(new Dimension(651, 25));

        getContentPane().add(tbComboBox);
        getContentPane().add(ktComboBox);
        getContentPane().add(koComboBox);
        getContentPane().add(kvsComboBox);
        getContentPane().add(kmComboBox);
        getContentPane().add(kbmComboBox);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField tbTextField = new JTextField("0");
        JTextField ktTextField = new JTextField("0");
        JTextField koTextField = new JTextField("0");
        JTextField kvsTextField = new JTextField("0");
        JTextField kmTextField = new JTextField("0");
        JTextField kbmTextField = new JTextField("0");
        JTextField resultTextField = new JTextField("0,00 руб.");

        tbTextField.setToolTipText("Тб");
        ktTextField.setToolTipText("Кт");
        koTextField.setToolTipText("Ко");
        kvsTextField.setToolTipText("Квс");
        kmTextField.setToolTipText("Км");
        kbmTextField.setToolTipText("Кбм");
        resultTextField.setToolTipText("Стоимость страхования");

        tbTextField.setEditable(false);
        ktTextField.setEditable(false);
        koTextField.setEditable(false);
        kvsTextField.setEditable(false);
        kmTextField.setEditable(false);
        kbmTextField.setEditable(false);
        resultTextField.setEditable(false);

        tbTextField.setPreferredSize(new Dimension(50, 25));
        ktTextField.setPreferredSize(new Dimension(50,25));
        koTextField.setPreferredSize(new Dimension(50,25));
        kvsTextField.setPreferredSize(new Dimension(50,25));
        kmTextField.setPreferredSize(new Dimension(50,25));
        kbmTextField.setPreferredSize(new Dimension(50,25));
        resultTextField.setPreferredSize(new Dimension(100,25));

        tbTextField.setHorizontalAlignment(SwingConstants.CENTER);
        ktTextField.setHorizontalAlignment(SwingConstants.CENTER);
        koTextField.setHorizontalAlignment(SwingConstants.CENTER);
        kvsTextField.setHorizontalAlignment(SwingConstants.CENTER);
        kmTextField.setHorizontalAlignment(SwingConstants.CENTER);
        kbmTextField.setHorizontalAlignment(SwingConstants.CENTER);
        resultTextField.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(tbTextField);
        panel.add(new JLabel("  ×  "));
        panel.add(ktTextField);
        panel.add(new JLabel("  ×  "));
        panel.add(koTextField);
        panel.add(new JLabel("  ×  "));
        panel.add(kvsTextField);
        panel.add(new JLabel("  ×  "));
        panel.add(kmTextField);
        panel.add(new JLabel("  ×  "));
        panel.add(kbmTextField);
        panel.add(new JLabel("  =  "));
        panel.add(resultTextField);
        getContentPane().add(panel);

        tbComboBox.addItemListener(event ->
                                   {
                                       switch(tbComboBox.getSelectedIndex())
                                       {
                                           case 0:
                                               tbTextField.setText("0");
                                               break;
                                           case 1:
                                               tbTextField.setText("1215");
                                               break;
                                           case 2:
                                               tbTextField.setText("1980");
                                               break;
                                           case 3:
                                               tbTextField.setText("2375");
                                               break;
                                           case 4:
                                               tbTextField.setText("2965");
                                               break;
                                           case 5:
                                               tbTextField.setText("2025");
                                               break;
                                           case 6:
                                               tbTextField.setText("3240");
                                               break;
                                           case 7:
                                               tbTextField.setText("810");
                                               break;
                                           case 8:
                                               tbTextField.setText("1620");
                                               break;
                                           case 9:
                                               tbTextField.setText("2025");
                                               break;
                                           case 10:
                                               tbTextField.setText("2965");
                                               break;
                                           case 11:
                                               tbTextField.setText("1620");
                                               break;
                                           case 12:
                                               tbTextField.setText("1010");
                                               break;
                                           case 13:
                                               tbTextField.setText("1215");
                                               break;
                                           case 14:
                                               tbTextField.setText("305");
                                               break;

                                       }
                                       tb = Float.valueOf(tbTextField.getText());
                                       resultTextField.setText(getResult());
                                   });

        ktComboBox.addItemListener(event ->
                                   {
                                       switch(ktComboBox.getSelectedIndex())
                                       {
                                           case 0:
                                               ktTextField.setText("0");
                                               break;
                                           case 1:
                                               ktTextField.setText("1.2");
                                               break;
                                           case 2:
                                               ktTextField.setText("1.2");
                                               break;
                                           case 3:
                                               ktTextField.setText("1.1");
                                               break;
                                           case 4:
                                               ktTextField.setText("1.1");
                                               break;
                                           case 5:
                                               ktTextField.setText("1.1");
                                               break;
                                           case 6:
                                               ktTextField.setText("1.3");
                                               break;
                                           case 7:
                                               ktTextField.setText("1.3");
                                               break;
                                           case 8:
                                               ktTextField.setText("1.8");
                                               break;
                                           case 9:
                                               ktTextField.setText("1.0");
                                               break;
                                       }
                                       kt = Float.valueOf(ktTextField.getText());
                                       resultTextField.setText(getResult());
                                   }
                                  );

        koComboBox.addItemListener(event ->
                                   {
                                       switch(koComboBox.getSelectedIndex())
                                       {
                                           case 0:
                                               koTextField.setText("0");
                                               break;
                                           case 1:
                                               koTextField.setText("1.0");
                                               break;
                                           case 2:
                                               koTextField.setText("1.8");
                                               break;
                                       }
                                       ko = Float.valueOf(koTextField.getText());
                                       resultTextField.setText(getResult());
                                   }
                                  );

        kvsComboBox.addItemListener(event ->
                                   {
                                       switch(kvsComboBox.getSelectedIndex())
                                       {
                                           case 0:
                                               kvsTextField.setText("0");
                                               break;
                                           case 1:
                                               kvsTextField.setText("1.8");
                                               break;
                                           case 2:
                                               kvsTextField.setText("1.6");
                                               break;
                                           case 3:
                                               kvsTextField.setText("1.7");
                                               break;
                                           case 4:
                                               kvsTextField.setText("1.0");
                                               break;
                                       }
                                       kvs = Float.valueOf(kvsTextField.getText());
                                       resultTextField.setText(getResult());
                                   }
                                  );

        kmComboBox.addItemListener(event ->
                                   {
                                       switch(kmComboBox.getSelectedIndex())
                                       {
                                           case 0:
                                               kmTextField.setText("0");
                                               break;
                                           case 1:
                                               kmTextField.setText("0.6");
                                               break;
                                           case 2:
                                               kmTextField.setText("1.0");
                                               break;
                                           case 3:
                                               kmTextField.setText("1.1");
                                               break;
                                           case 4:
                                               kmTextField.setText("1.2");
                                               break;
                                           case 5:
                                               kmTextField.setText("1.4");
                                               break;
                                           case 6:
                                               kmTextField.setText("1.6");
                                               break;
                                       }
                                       km = Float.valueOf(kmTextField.getText());
                                       resultTextField.setText(getResult());
                                   }
                                  );

        kbmComboBox.addItemListener(event ->
                                   {
                                       switch(kbmComboBox.getSelectedIndex())
                                       {
                                           case 0:
                                               kbmTextField.setText("0");
                                               break;
                                           case 1:
                                               kbmTextField.setText("2.3");
                                               break;
                                           case 2:
                                               kbmTextField.setText("1.55");
                                               break;
                                           case 3:
                                               kbmTextField.setText("1.4");
                                               break;
                                           case 4:
                                               kbmTextField.setText("1.0");
                                               break;
                                           case 5:
                                               kbmTextField.setText("0.95");
                                               break;
                                           case 6:
                                               kbmTextField.setText("0.9");
                                               break;
                                           case 7:
                                               kbmTextField.setText("0.85");
                                               break;
                                           case 8:
                                               kbmTextField.setText("0.8");
                                               break;
                                           case 9:
                                               kbmTextField.setText("0.75");
                                               break;
                                           case 10:
                                               kbmTextField.setText("0.7");
                                               break;
                                           case 11:
                                               kbmTextField.setText("0.65");
                                               break;
                                           case 12:
                                               kbmTextField.setText("0.6");
                                               break;
                                           case 13:
                                               kbmTextField.setText("0.55");
                                               break;
                                           case 14:
                                               kbmTextField.setText("0.5");
                                               break;
                                       }
                                       kbm = Float.valueOf(kbmTextField.getText());
                                       resultTextField.setText(getResult());
                                   });
    }

    public static String getResult()
    {
        return String.format(new Locale("ru"), "%(.2f", (tb * kt * ko * kvs * km * kbm)) + " руб.";
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(() ->
                                   {
                                       InsuranceCalculator insuranceCalculator = new InsuranceCalculator();
                                       insuranceCalculator.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                       insuranceCalculator.setVisible(true);
                                   });
    }
}