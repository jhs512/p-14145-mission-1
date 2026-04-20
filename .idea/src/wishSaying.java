import java.util.Scanner;

public class wishSaying {

    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);
        String[][] wishSaying = new String[10][2];
        int count = 0;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) break;
            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wish = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                wishSaying[count][0] = wish;
                wishSaying[count][1] = author;
                count++;

                System.out.println(count + "번 명언이 등록되었습니다.");

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = count; i > 0; i--) {
                    if (wishSaying[i-1][0] == null) continue;
                    System.out.println(i + " / " + wishSaying[i-1][1] + " / " + wishSaying[i-1][0]);
                }

            } else if (cmd.startsWith("삭제?id=")) {
                String input = cmd.substring("삭제?id=".length());
                int number = Integer.parseInt(input);

                if (wishSaying[number-1][0] == null) {
                    System.out.println(number + "번 명언은 존재하지 않습니다.");
                } else {
                    wishSaying[number-1][0] = null;
                    wishSaying[number-1][1] = null;
                    System.out.println(number +"번 명언이 삭제되었습니다.");
                }

            } else if (cmd.startsWith("수정?id=")) {
                String input = cmd.substring("수정?id=".length());
                int number = Integer.parseInt(input);

                if (wishSaying[number-1][0] == null) {
                    System.out.println(number + "번 명언은 존재하지 않습니다.");
                } else {
                    System.out.println("명언(기존) : " + wishSaying[number-1][0]);
                    System.out.print("명언 : ");
                    String wishNew = scanner.nextLine();
                    wishSaying[number-1][0] = wishNew;

                    System.out.println("작가(기존) : " + wishSaying[number-1][1]);
                    System.out.print("작가 : ");
                    String authorNew = scanner.nextLine();
                    wishSaying[number-1][1] = authorNew;
                }
            }
        }
    }
}
