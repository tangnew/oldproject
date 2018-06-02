package com.deadthread;

/**
 * 
 * 死锁简单示例 死锁的原因是由于两个线程相互等待 对方已被锁定的资源
 * 
 * @author Administrator
 * 
 */
public class Main {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj1 = new Object();
		DeadLockThread diedLock = new DeadLockThread(obj, obj1);
		DeadLockThread1 diedLock1 = new DeadLockThread1(obj, obj1);
		diedLock.start();
		diedLock1.start();
	}
}

class DeadLockThread extends Thread {
	private Object obj;
	private Object obj1;

	public DeadLockThread(Object obj, Object obj1) {
		this.obj = obj;
		this.obj1 = obj1;
	}

	@Override
	public void run() {
		synchronized (obj) {
			System.out.println("obj0");
			try {
				Thread.sleep(1000);
				System.out.println("obj1");
				synchronized (obj1) {
					System.out.println(obj1.getClass());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class DeadLockThread1 extends Thread {
	private Object obj;
	private Object obj1;

	public DeadLockThread1(Object obj, Object obj1) {
		this.obj = obj;
		this.obj1 = obj1;
	}

	@Override
	public void run() {
		synchronized (obj1) {
			System.out.println("obj10");
			try {
				Thread.sleep(100);
				System.out.println("obj11");
				synchronized (obj) {
					System.out.println(obj.getClass());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}