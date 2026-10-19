import java.util.Scanner;

public class App {
    void run(){
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);
        WiseSaying[] wiseSayings = new WiseSaying[100];
        int wiseSayingLastIndex = 0;

        while(true){
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if(cmd.equals("종료")){
                break;
            }

            else if(cmd.equals("등록")){
                wiseSayings[wiseSayingLastIndex] = new WiseSaying();
                System.out.print("명언 : ");
                wiseSayings[wiseSayingLastIndex].content = scanner.nextLine().trim();
                System.out.print("작가 : ");
                wiseSayings[wiseSayingLastIndex].author = scanner.nextLine().trim();
                wiseSayings[wiseSayingLastIndex].id = wiseSayingLastIndex+1;
                wiseSayingLastIndex++;
                System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSayingLastIndex));
            }

            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------");

                for(int i = wiseSayingLastIndex-1 ; i >= 0; i--){
                    if(wiseSayings[i].id!=0)
                        System.out.println("%d / %s / %s".formatted(wiseSayings[i].id, wiseSayings[i].author, wiseSayings[i].content));


                }
            }

            else if(cmd.equals("삭제")){
                System.out.print("?id=");
                int deleteId = Integer.parseInt(scanner.nextLine().trim());
                if(deleteId-1 >= wiseSayingLastIndex || wiseSayings[deleteId-1].id == 0){
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(deleteId));
                }
                else{
                    wiseSayings[deleteId-1].id=0;
                    wiseSayings[deleteId-1].author = null;
                    wiseSayings[deleteId-1].content = null;
                    System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteId));
                }
            }

            else if(cmd.equals("수정")){
                System.out.print("?id=");
                int modifyId=Integer.parseInt(scanner.nextLine().trim());
                if(modifyId-1 >= wiseSayingLastIndex || wiseSayings[modifyId-1].id == 0){
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(modifyId));
                }

                else{
                    System.out.println("명언(기존) %s".formatted(wiseSayings[modifyId-1].content));
                    System.out.print("명언 : ");
                    wiseSayings[modifyId-1].content = scanner.nextLine().trim();

                    System.out.println("작가(기존) : %s".formatted(wiseSayings[modifyId-1].author));
                    System.out.print("작가 : ");
                    wiseSayings[modifyId-1].author = scanner.nextLine().trim();
                }

            }
        }

        scanner.close();
    }
}
