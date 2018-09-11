package net.certiv.fluentmark.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {

	public static final Class<?>[] NoParams = (Class[]) null;
	public static final Object[] NoArgs = (Object[]) null;

	private Reflect() {}

	public static void set(Object target, String fieldName, Object value) {
		try {
			Field f = target.getClass().getDeclaredField(fieldName);
			f.setAccessible(true);
			f.set(target, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}

	public static void setSuper(Object target, String fieldName, Object value) {
		try {
			Field f = target.getClass().getSuperclass().getDeclaredField(fieldName);
			f.setAccessible(true);
			f.set(target, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean hasField(Object target, String fieldName) {
		try {
			target.getClass().getDeclaredField(fieldName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Object get(Object target, String fieldName) {
		return get(target, fieldName, false);
	}

	public static Object get(Object target, String fieldName, boolean quiet) {
		try {
			Field f = target.getClass().getDeclaredField(fieldName);
			f.setAccessible(true);
			return f.get(target);
		} catch (Exception e) {
			if (!quiet) e.printStackTrace();
		}
		return null;
	}

	public static Object getSuper(Object target, String fieldName) {
		try {
			Field f = target.getClass().getSuperclass().getDeclaredField(fieldName);
			f.setAccessible(true);
			return f.get(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object getSuper2(Object target, String fieldName) {
		try {
			Field f = target.getClass().getSuperclass().getSuperclass().getDeclaredField(fieldName);
			f.setAccessible(true);
			return f.get(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean hasMethod(Object target, String methodName, Class<?>[] params) {
		if (params == null) params = NoParams;
		try {
			Method m = target.getClass().getMethod(methodName, params);
			if (m != null) return true;
		} catch (Exception e) {}
		return false;
	}

	public static Object invoke(Object target, String methodName) {
		return invoke(target, methodName, NoParams, NoArgs);
	}

	public static Object invoke(Object target, String methodName, Class<?>[] params, Object[] args) {
		try {
			Method m = target.getClass().getMethod(methodName, params);
			m.setAccessible(true);
			return m.invoke(target, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object invokeSuperDeclared(Object target, String methodName, Class<?>[] params, Object[] args) {

		try {
			Method m = target.getClass().getSuperclass().getDeclaredMethod(methodName, params);
			m.setAccessible(true);
			return m.invoke(target, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object make(ClassLoader loader, String className, Object[] args) {
		Object obj = null;
		try {
			Class<?> classNameClass = Class.forName(className, true, loader);
			obj = make(classNameClass, args);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static Object make(Class<?> clazz, Object[] args) {
		Constructor<?> c = clazz.getDeclaredConstructors()[0];
		c.setAccessible(true);
		Object object = null;
		try {
			object = c.newInstance(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}
