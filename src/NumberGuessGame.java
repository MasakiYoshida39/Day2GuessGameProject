import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NumberGuessGame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton guessButton;
    private JLabel messageLabel;
    private int answer;
    private int tries = 0;

    public NumberGuessGame() {
        setTitle("数当てゲーム");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel instructionLabel = new JLabel("1〜300の数字を当ててね！");
        inputField = new JTextField(10);
        guessButton = new JButton("答える");
        messageLabel = new JLabel("数字を入力してボタンを押してね");

        add(instructionLabel);
        add(inputField);
        add(guessButton);
        add(messageLabel);

        guessButton.addActionListener(this);

        Random rand = new Random();
        answer = rand.nextInt(300) + 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(inputField.getText());
            tries++;

            if (guess < 1 || guess > 300) {
                messageLabel.setText("1〜300の間で入力してね！");
            } else if (guess < answer) {
                messageLabel.setText("もっと大きいよ！");
            } else if (guess > answer) {
                messageLabel.setText("もっと小さいよ！");
            } else {
                messageLabel.setText("正解！" + tries + "回で当たったよ🎉");
                guessButton.setEnabled(false); // ボタン無効に
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("数字を入れてね！");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NumberGuessGame().setVisible(true);
        });
    }
}
