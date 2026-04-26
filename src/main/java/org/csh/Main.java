package org.csh;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
//        testRq();

    }
    private static void testRq() {
        Rq rq = new Rq("어어야야야?id=1&adf=헬로");
        String param = rq.getParam("addf","업음");
        int paramInt = rq.getParamAsInt("idd",-1);
        System.out.println(param);
        System.out.println(paramInt);
    }
}