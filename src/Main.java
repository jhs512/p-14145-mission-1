import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        String[] arr2 = new String[100];
        String[] arr3 = new String[100];

        System.out.println("== 명언 앱 ==");
        while(true){

            System.out.print("명령)");
            String md = sc.nextLine().trim();

            if(md.equals("종료")){
                break;
            } else if (md.equals("등록")) {
                count++;

                System.out.print("명언 : ");
                String md2 = sc.nextLine().trim();
                System.out.print("작가 : ");
                String md3 = sc.nextLine().trim();

                arr2[count-1] = md2; //명언
                arr3[count-1] = md3; //작가

                System.out.println(count+"번 명언이 등록되었습니다.");
            } else if (md.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = 0; i < count; i++) {
                    if(arr3[count-i-1] != null){
                        System.out.println( count-i + "/" + arr3[count-i-1] + "/" + arr2[count-i-1]);
                    }
                }
            } else if (md.equals("삭제")) {
                System.out.print("?id=");
                int md4 = Integer.parseInt(sc.nextLine().trim());

                if(arr2[md4-1] == null){
                    System.out.println(md4+"번 명언은 존재하지 않습니다.");
                }
                else{
                    arr2[md4-1] = null;
                    arr3[md4-1] = null;
                    System.out.println(md4+"번 명언이 삭제되었습니다.");
                }

            } else if (md.equals("수정")) {
                System.out.print("?id=");
                int md4 = Integer.parseInt(sc.nextLine().trim());

                if(arr2[md4-1] == null){
                    System.out.println(md4+"번 명언은 존재하지 않습니다.");
                }  else{
                    System.out.println("명언(기존) : "+arr2[md4-1]);

                    System.out.print("명언 : ");
                    String md5 = sc.nextLine().trim();

                    arr2[md4-1] = md5;

                    System.out.println("작가(기존) : "+arr3[md4-1]);

                    System.out.print("작가 : ");
                    String md6 = sc.nextLine().trim();
                    arr3[md4-1] = md6;
                }

            }else{
                System.out.println("잘못된접근");
            }
        }
    }
}

