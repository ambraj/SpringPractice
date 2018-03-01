package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {		
		System.out.println("\n=====>>> Executing @Before advice on method");

		// getting method signature
		MethodSignature mSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println("Method: "+mSignature);
		
		// getting argument list
		Object[] args = joinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println(tempArg);
			if(tempArg instanceof Account) {
				System.out.println(((Account) tempArg).getName());
				System.out.println(((Account) tempArg).getLevel());
			}
		}
		
	}
	
}










