package ahs.support;

public class Utilites {
    public static void waitFor(int time) {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
