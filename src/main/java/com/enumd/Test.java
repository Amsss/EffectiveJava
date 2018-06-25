package com.enumd;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Test {
	public static void main(String[] args) {
		System.out.println(Planet.MERCURY.surfaceGravity());
		System.out.printf("Weight on %s is %f%n",Planet.MERCURY,Planet.MERCURY.surfaceGravity());
		System.out.println(Planet.MERCURY.name());
		Map map = new Hashtable();
		Map mapa = new HashMap();
		Map mapc = new ConcurrentHashMap();
	}
}
