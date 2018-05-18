package com.zhuzz.singleton;

import java.io.Serializable;

public class Elvis implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Elvis INSTANCE = new Elvis();
	private Elvis() {
		
	}
	public static Elvis getInstance() {
		return INSTANCE;
	}
	
	public Object readResolve() {
		return INSTANCE;
	}
	
}
