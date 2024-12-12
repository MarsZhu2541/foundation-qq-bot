package com.mars.util;

import java.util.concurrent.ArrayBlockingQueue;

public class RepeatPushHelper {

    private final ArrayBlockingQueue<String> queue;

    public RepeatPushHelper(int queueSize){
        queue = new ArrayBlockingQueue<>(queueSize);
    }

    public void put(String element) throws InterruptedException {
        if (queue.size() == queue.remainingCapacity()) {
            String removed = queue.poll();
            if (removed!= null) {
                System.out.println("队列已满，移除元素: " + removed);
            }
        }
        queue.put(element);
    }

    public boolean isRepeat(String element) {
        return queue.contains(element);
    }
}
