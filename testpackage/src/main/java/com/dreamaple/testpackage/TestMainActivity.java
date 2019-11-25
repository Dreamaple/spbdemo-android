package com.dreamaple.testpackage;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.dreamaple.baseutils.BaseActivity;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestMainActivity extends BaseActivity {

    private static int threadFactoryNumb;

    private static synchronized int nextThreadNum() {
        return threadFactoryNumb++;
    }

    final static int CORE_POOL_SIZE = 4;
    final static int MAXIMUM_POOL_SIZE = 8;
    final static long KEEP_ALIVE_TIME = 60 * 2;
    BlockingQueue<Runnable> workQueue;


    ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(@NonNull Runnable r) {
            String threadTag = "ThreadFactory";
            if (r instanceof MyRunnable) {
                threadTag = ((MyRunnable) r).name;
            }
            Thread thread = new Thread(r);
            StringBuilder stringBuilder = new StringBuilder(thread.getName());
            thread.setName(stringBuilder.append(threadTag).append(nextThreadNum()).toString());
            return thread;
        }
    };

    //test
//    ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        workQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, workQueue, threadFactory, new ThreadPoolExecutor.AbortPolicy());

        threadPoolExecutor.execute(new MyRunnable("test") {
            @Override
            public void run() {

            }
        });
    }


    class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.name + " is running.");
//                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}