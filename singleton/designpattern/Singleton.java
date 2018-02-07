package com.singleton.designpattern;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton implements Serializable, Cloneable {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, IllegalArgumentException, InvocationTargetException {

		/*
		 * Singleton s1 = (Singleton)
		 * Class.forName(Singleton.class.getCanonicalName()).newInstance();
		 * System.out.println(s1); Singleton s = Singleton.getInstance();
		 */
		Class cl = Class.forName("com.singleton.designpattern.Singleton");
		Constructor con[] = cl.getDeclaredConstructors();
		Singleton obj = (Singleton) con[0].newInstance();
		System.out.println("Object:" + obj);
	}

	private static Singleton singleton;
	private boolean flag = false;

	private Singleton() {
		if (Singleton.singleton != null) {
			throw new InstantiationError("Creating of this object is not allowed.");
		}
	}

	public static Singleton getInstance() {

		if (singleton == null) {

			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

	// readResolve method to suppress creating new object during de-serialization
	private Object readResolve() throws ObjectStreamException {
		return getInstance();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// directly throw Clone Not Supported Exception
		throw new CloneNotSupportedException();
	}

	public Object newInstance() {
		throw new InstantiationError("Creating of this object is not allowed.");
	}
}
