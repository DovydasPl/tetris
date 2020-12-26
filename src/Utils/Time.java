package Utils;

public class Time {
    private static long time;
    private static long lastTime = System.currentTimeMillis();

    public static void updateTime(){
        time = System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
    }

    public static long getTickTime(){
        return time;
    }
}
