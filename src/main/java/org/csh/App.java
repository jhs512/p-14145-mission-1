package org.csh;

import org.csh.domain.wiseSaying.controller.SystemController;
import org.csh.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);

    // 진입점 시작
    void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController(scanner);

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();
            Rq rq = new Rq(cmd);


            switch (rq.getActionName()) {
                case "종료" -> {
                    systemController.actionExit();
                    return;
                }
                case "등록" -> wiseSayingController.actionWrite();
                case "목록" -> wiseSayingController.actionList();
                case "수정" -> wiseSayingController.actionModify(rq);
                case "삭제" -> wiseSayingController.actionDelete(rq);
            }

        }
    }
}