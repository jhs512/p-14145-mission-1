import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();

        int id = 0;

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("등록")) {
                System.out.print("명언 : ");
                String saying = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                id++;
                list.add(new String[]{String.valueOf(id),saying, author});

                System.out.println(id + "번 명언이 등록되었습니다.");
            }

            else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = list.size()-1; i >= 0; i--) {
                    String[] item = list.get(i);
                    System.out.println((item[0] + " / " + item[1] + " / " + item[2]));
                }
            }

            else if (command.equals("종료")) {
                break;
            }

            else if (command.startsWith("삭제?id=")) {
                int removeId = Integer.parseInt(command.split("=")[1]);

                for (int i = 0; i < list.size(); i++) {
                    if (Integer.parseInt(list.get(i)[0]) == removeId) {
                        list.remove(i);
                        System.out.println(removeId + "번 명언이 삭제되었습니다.");
                        break;
                    }

                    if (i == list.size() - 1) {
                        System.out.println(removeId + "번 명언은 존재하지 않습니다.");
                    }
                }
            }
            else if (command.startsWith("수정?id=")) {
                int sayingId = Integer.parseInt(command.split("=")[1]);

                for (int i = 0; i < list.size(); i++) {
                    if (Integer.parseInt(list.get(i)[0]) == sayingId) {
                        System.out.println("명언(기존) : " + list.get(i)[1]);
                        System.out.print("명언 :");
                        String newSaying = scanner.nextLine();

                        System.out.println("작가(기존) : " + list.get(i)[2]);
                        System.out.print("작가 :");
                        String newAuthor = scanner.nextLine();

                        list.get(i)[1] = newSaying;
                        list.get(i)[2] = newAuthor;

                        System.out.println(sayingId + "번 명언이 수정되었습니다.");
                        break;
                    }

                    if (i == list.size() - 1) {
                        System.out.println(sayingId + "번 명언은 존재하지 않습니다.");
                    }
                }
            }
        }
    }
}