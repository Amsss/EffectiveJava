package com.concurrent;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:52
 */
public class LogService {
    private BlockingQueue<String> queue;
    private LoggerThread loggerThread;
    private PrintWriter writer;
    private boolean isShutdown = false;
    private int reservations = 0;

    public void start() {
        loggerThread.start();
    }

    public void stop() {
        synchronized (this) {
            isShutdown = true;
        }
        loggerThread.interrupt();
    }

    public void log(String msg) {
        synchronized (this) {
            if (isShutdown) {
                throw new IllegalStateException("....");
            }
            queue.add(msg);
        }
    }

    private class LoggerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    try {
                        synchronized (LogService.this) {
                            if (isShutdown && reservations == 0) {
                                break;
                            }
                        }
                        String msg = queue.take();
                        synchronized (LogService.this) {
                            --reservations;
                        }
                        writer.print(msg);
                    } catch (InterruptedException e) {
                        /* 重试 */
                    }
                }
            } finally {

            }
        }
    }
}
