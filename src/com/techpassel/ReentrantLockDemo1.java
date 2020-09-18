package com.techpassel;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {
    public static void main(String[] args) {
        ReentrantLock l = new ReentrantLock(true);
        l.lock();
        l.lock();
        System.out.println("IsLocked : "+l.isLocked());
        System.out.println("IsFair : "+l.isFair());
        System.out.println("IsHeldByCurrentThread : "+l.isHeldByCurrentThread());
        System.out.println("GetHoldCount : "+l.getHoldCount());
        System.out.println("GetQueueLength : "+l.getQueueLength());
        l.unlock();
        System.out.println("IsLocked : "+l.isLocked());
        System.out.println("GetHoldCount after 1 unlock : "+l.getHoldCount());
        l.unlock();
        System.out.println("IsLocked : "+l.isLocked());
        System.out.println("GetHoldCount after 2 unlocks : "+l.getHoldCount());
    }
}
