import java.util.Scanner;
//Git pull 연습
//new branch 연습
public class Main {
    public static void main(String[] args) {
        // 연습할 가사 여러 줄 - 원하는 가사로 순서대로 넣으세요
        String[] lyrics = {
                "안녕하세요",
                "저는 백수현입니다.",
                "당신의 이름은 무엇인가요"
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 타자 연습 프로그램 ===");
        System.out.println();

        double totalAccuracy = 0;
        double totalCharsPerMinute = 0;

        for (int i = 0; i < lyrics.length; i++) {
            String targetText = lyrics[i];

            System.out.println("[" + (i + 1) + " / " + lyrics.length + "]");
            System.out.println("다음 문장을 입력하세요:");
            System.out.println(targetText);

            long startTime = System.currentTimeMillis();
            System.out.print("입력: ");
            String userInput = scanner.nextLine();
            long endTime = System.currentTimeMillis();

            double elapsedSeconds = (endTime - startTime) / 1000.0;

            int correctChars = 0;
            int minLength = Math.min(targetText.length(), userInput.length());
            for (int j = 0; j < minLength; j++) {
                if (targetText.charAt(j) == userInput.charAt(j)) {
                    correctChars++;
                }
            }
            double accuracy = (double) correctChars / targetText.length() * 100;
            double charsPerMinute = (userInput.length() / elapsedSeconds) * 60;

            totalAccuracy += accuracy;
            totalCharsPerMinute += charsPerMinute;

            System.out.printf("정확도: %.1f%% | 속도: %.0f타/분%n", accuracy, charsPerMinute);
            System.out.println();
        }

        System.out.println("=== 최종 결과 ===");
        System.out.printf("평균 정확도: %.1f%%%n", totalAccuracy / lyrics.length);
        System.out.printf("평균 속도: %.0f타/분%n", totalCharsPerMinute / lyrics.length);
    }
}
