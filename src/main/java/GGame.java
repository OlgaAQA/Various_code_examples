
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GGame extends JFrame {
    private JTextField textGuess;
    private JLabel lblOutput;
    private int number;
    public void checkGame() {
        String guessTxt = textGuess.getText();
        String messege = "";
        int ggg = Integer.parseInt(guessTxt);
        if (ggg > number)
            messege = "Загаданное число меньше,чем" + " " + ggg + " !" + " Попробуй снова)";

        else if (ggg < number)
            messege = "Загаданное число больше,чем" + " " + ggg + " !" + " Попробуй снова)";
        else
            messege = "Ты отгадал!!! Поздравляю! У тебя отличная интуиция!";
        lblOutput.setText(messege);

    }
    public void newGame() {
        number = (int) (Math.random() * 100 + 1);
    }
    public GGame() {
        getContentPane().setForeground(new Color(170, 170, 170));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\olgad\\Desktop\\JOB\\2791675895_naklejka-stiker-na.bmp"));
        setTitle("Проверь интуицию!");
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 434, 19);
        getContentPane().add(panel);

        JLabel lblNewLabel = new JLabel("Добро пожаловать в игру Тренировка Интуиции!!!");
        lblNewLabel.setForeground(new Color(206, 137, 34));
        lblNewLabel.setBackground(new Color(240, 240, 240));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(26, 30, 387, 19);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Отгадай какое число от 1 до 100 загаданно:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setBounds(82, 60, 297, 19);
        getContentPane().add(lblNewLabel_1);

        textGuess = new JTextField();
        textGuess.setBackground(new Color(255, 255, 255));
        textGuess.setHorizontalAlignment(SwingConstants.CENTER);
        textGuess.setBounds(157, 125, 124, 20);
        getContentPane().add(textGuess);
        textGuess.setColumns(10);

        JButton btnButton = new JButton("Отгадать!");
        btnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGame();
            }
        });
        btnButton.setBounds(157, 156, 125, 23);
        getContentPane().add(btnButton);

        JLabel lblNewLabel_2 = new JLabel("* Введи число и нажми кнопку!");
        lblNewLabel_2.setForeground(new Color(128, 128, 128));
        lblNewLabel_2.setBounds(26, 236, 278, 14);
        getContentPane().add(lblNewLabel_2);

        lblOutput = new JLabel();
        lblOutput.setBounds(61, 90, 383, 24);
        getContentPane().add(lblOutput);
    }
    public static void main(String[] args) {
        GGame theGame = new GGame();
        theGame.newGame();
        theGame.setSize(new Dimension(450,300));
        theGame.setVisible(true);

    }
}