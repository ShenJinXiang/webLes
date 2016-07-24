package com.shenjinxiang.annotation;

public @interface MyAnnotation1 {

	String name() default "sjx";
	Gender gender();
	Class clazz() default Object.class;
	String[] ss();
}
