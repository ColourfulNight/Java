package study;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Edgar on 2017-12-25.
 */
public class MoveMouse {
    private static Robot myRobot;

    static {
        try {
            myRobot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        int a  = 10;
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ScheduledExecutorService stpe = new ScheduledThreadPoolExecutor(1, namedThreadFactory);
        Random random = new Random(System.currentTimeMillis());

        stpe.scheduleWithFixedDelay(() -> {
            random.setSeed(System.currentTimeMillis());
            int x = random.ints(1, 200, 1400).toArray()[0];
            int y = random.ints(1, 350, 860).toArray()[0];
            myRobot.mouseMove(x, y);
        }, 5, 300, TimeUnit.SECONDS);
    }

}


