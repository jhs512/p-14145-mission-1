import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);
        int mapIdx = 1;
        String[][] map = new String[100][2];

        while(true) {
            System.out.print("명령) ");

            String cmd = sc.nextLine().trim();

            if(cmd.equals("종료")) break;
            else if(cmd.equals("등록")) {
                System.out.print("명언 : ");
                String saying = sc.nextLine().trim();
                System.out.print("작가 : ");
                String writer = sc.nextLine().trim();
                map[mapIdx++] = new String[]{saying, writer};
                System.out.println((mapIdx - 1) + "번 명언이 등록되었습니다.");
            } else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i = mapIdx-1 ; i > 0; i--) {
                    if(map[i] != null){
                        String [] cur = map[i];
                        System.out.println(i + " / " + cur[1] + " / " + cur[0]);
                    }
                }
            } else {
                int delIdx = cmd.indexOf("?");
                String tmp = "";
                if(delIdx != -1)
                    tmp = cmd.substring(0, delIdx);

                if(!cmd.contains("=")) continue;
                int idx = Integer.parseInt(cmd.substring(cmd.indexOf("=")+1));

                if(tmp.equals("삭제")){
                    if(map[idx] == null){
                        System.out.println(idx + "번 명언은 존재하지 않습니다.");
                    } else {
                        map[idx] = null;
                        System.out.println(idx + "번 명언이 삭제되었습니다.");
                    }
                } else if(tmp.equals("수정")){
                    if(map[idx] == null){
                        System.out.println(idx + "번 명언은 존재하지 않습니다.");
                    } else {
                        String[] cur = map[idx];
                        String[] newStr = new String[2];
                        System.out.println("명언(기존) : " + cur[0]);
                        System.out.print("명언 : ");
                        newStr[0] = sc.nextLine().trim();
                        System.out.println("작가(기존) : " + cur[1]);
                        System.out.print("작가 : ");
                        newStr[1] = sc.nextLine().trim();

                        map[idx] = newStr;
                    }
                }
            }
        }
    }
}