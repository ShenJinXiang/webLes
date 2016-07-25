package com.shenjinxiang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface MyAnnotation1 {
	
	String name();
	int age();
}
