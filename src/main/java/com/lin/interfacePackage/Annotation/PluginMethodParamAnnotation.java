package com.lin.interfacePackage.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.FIELD })
public @interface PluginMethodParamAnnotation {

	String displayName();

	ParamType isNecessary() default ParamType.Necessary;

	Pattern pattern() default @Pattern(regexp = "");

	String[] optional() default {};

	Size size() default @Size();

	String fieldName() default "";

}
