package com.assignment.java.week8;

import java.util.ArrayList;
import java.util.HashMap;

public class Thread1 implements Runnable {

	HashMap<ProjectDetails, ArrayList<Employee>> hMap;
	Thread t;

	Thread1(HashMap<ProjectDetails, ArrayList<Employee>> hMap) {
		this.hMap = hMap;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		synchronized (hMap) {
			System.out.println("Serialize called by Producer");
			System.out.println("Serialized Data :" + hMap);
			System.out.println("DeSerialize Called by Consumer");
			System.out.println("DeSerialized Data" + hMap);
		}
	}
}
