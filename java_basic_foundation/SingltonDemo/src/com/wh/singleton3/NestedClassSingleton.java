package com.wh.singleton3;

public class NestedClassSingleton {

	private NestedClassSingleton() {

	}

	private static class SingletonHolder {
		private static final NestedClassSingleton nestedClassSingleton = new NestedClassSingleton();
	}

	public static NestedClassSingleton getNestedClassSingleton() {
		return SingletonHolder.nestedClassSingleton;
	}

}
