import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Quote {
    int id;
    String txt;
    String auth;

    public Quote(int id, String txt, String auth) {
        this.id = id;
        this.txt = txt;
        this.auth = auth;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);

        List<Quote> quotes = new ArrayList<>();
        int seq = 0;

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                break;

            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String txt = sc.nextLine();
                System.out.print("작가 : ");
                String auth = sc.nextLine();

                int id = ++seq;
                quotes.add(new Quote(id, txt, auth));

                System.out.println(id + "번 명언이 등록되었습니다.");

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = quotes.size() - 1; i >= 0; i--) {
                    Quote q = quotes.get(i);
                    System.out.println(q.id + " / " + q.auth + " / " + q.txt);
                }

            } else if (cmd.startsWith("삭제?id=")) {
                int tId = Integer.parseInt(cmd.split("=")[1]);
                boolean ok = false;

                for (int i = 0; i < quotes.size(); i++) {
                    if (quotes.get(i).id == tId) {
                        quotes.remove(i);
                        ok = true;
                        System.out.println(tId + "번 명언이 삭제되었습니다.");
                        break;
                    }
                }

                if (!ok) {
                    System.out.println(tId + "번 명언은 존재하지 않습니다.");
                }

            } else if (cmd.startsWith("수정?id=")) {
                int tId = Integer.parseInt(cmd.split("=")[1]);
                boolean ok = false;

                for (int i = 0; i < quotes.size(); i++) {
                    if (quotes.get(i).id == tId) {
                        Quote q = quotes.get(i);

                        System.out.println("명언(기존) : " + q.txt);
                        System.out.print("명언 : ");
                        q.txt = sc.nextLine();

                        System.out.println("작가(기존) : " + q.auth);
                        System.out.print("작가 : ");
                        q.auth = sc.nextLine();

                        ok = true;
                        break;
                    }
                }

                if (!ok) {
                    System.out.println(tId + "번 명언은 존재하지 않습니다.");
                }
            }
        }
        sc.close();
    }
}