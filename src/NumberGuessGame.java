import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int answer = rand.nextInt(100) + 1;  // 1〜100の数字をつくる
        int guess = 0;
        int tries = 0;

        System.out.println("★ 数当てゲーム ★");
        System.out.println("1〜100の数字を当ててね！");

        while (guess != answer) {
            System.out.print("数字を入れてね: ");
            guess = input.nextInt();
            tries++;

            if (guess < answer) {
                System.out.println("もっと大きいよ！");
            } else if (guess > answer) {
                System.out.println("もっと小さいよ！");
            } else {
                System.out.println("正解！" + tries + "回で当たったよ！");
            }
        }

        input.close();
    }
}
