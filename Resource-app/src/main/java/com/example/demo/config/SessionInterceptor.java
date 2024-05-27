package com.example.demo.config;

import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.database.factory.Factory;
import com.example.demo.model.User;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class SessionInterceptor{
	
	@Autowired
	Factory factory;
	
	@Before("@annotation(com.example.demo.config.AuthenticatorAnnotation)")
	public void beforeServiceCall(JoinPoint joinPoint) throws UnauthorizedException{
		ServletRequestAttributes attibutes = (ServletRequestAttributes) AopContext.currentRequestAttibutes();
		
		if(Objects.isNull(request)) System.out.println("couldnt get request");
		String idUser = request.getHeader("idUser"); // Implement logic to extract email from header
	    
	    try {
			if (idUser != null && Objects.nonNull(factory.getById(User.class, idUser))) {
			  throw new UnauthorizedException("User with email " + idUser + " not found!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
