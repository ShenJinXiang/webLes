package com.shenjinxiang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface TestAnnotation {

	String name();
	int age();
}
