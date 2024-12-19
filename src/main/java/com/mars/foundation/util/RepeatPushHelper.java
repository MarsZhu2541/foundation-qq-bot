package com.mars.foundation.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;

@Slf4j
public class RepeatPushHelper {

    private final ArrayBlockingQueue<String> queue;

    public RepeatPushHelper(int queueSize){
        queue = new ArrayBlockingQueue<>(queueSize);
    }

    public void put(String element) throws InterruptedException {
        if (queue.size() == queue.remainingCapacity()) {
            String removed = queue.poll();
            if (removed!= null) {
                log.debug("队列已满，移除元素: " + removed);
            }
        }
        queue.put(element);
    }

    public boolean isRepeat(String element) {
        return queue.contains(element);
    }
}
