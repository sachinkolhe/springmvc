package com.newgen.main.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	/*
	 
		@Aspect: Declares a class as an aspect.
		@Before: Executes code before a method.
		@After: Executes code after a method.
		@AfterReturning: Executes code after a method returns successfully.
		@AfterThrowing: Executes code when a method throws an exception.
		@Pointcut: Defines a reusable pointcut expression.
		@Around: Wraps method execution, allowing for pre- and post-execution logic.

*/

    
	@Before("execution(* com.newgen.main.service.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
	    System.out.println("Before executing: " + joinPoint.getSignature().getName());
	}

	
    @After("execution(* com.newgen.main.service..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Method executed: " + joinPoint.getSignature().getName());
    }
    
    
    @AfterReturning(pointcut = "execution(* com.newgen.main.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method returned: " + result);
    }

    
    @AfterThrowing(pointcut = "execution(* com.newgen.main.service.*.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.err.println("Method " + joinPoint.getSignature().getName() + " threw an exception: " + error);
    }

    
    @Around("execution(* com.newgen.main.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before executing: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed(); // Proceed to the method execution
        System.out.println("After executing: " + joinPoint.getSignature().getName());
        return result;
    }

    
}

