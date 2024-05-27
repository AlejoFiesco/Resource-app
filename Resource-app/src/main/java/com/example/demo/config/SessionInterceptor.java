package com.example.demo.config;

import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.database.factory.Factory;
import com.example.demo.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Aspect
@Component
public class SessionInterceptor {

	@Autowired
	Factory factory;

	@Before("@annotation(com.example.demo.config.AuthenticatorAnnotation)")
	public void beforeServiceCall(JoinPoint joinPoint) throws UnauthorizedException {
	    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	    if (attributes != null) {
	        HttpServletRequest request = attributes.getRequest();
	        if (request != null) {
	            String idUser = request.getHeader("idUser");
	            try {
	            	User user = factory.getById(User.class, idUser);
	                if (Objects.isNull(user)) {
	                    throw new UnauthorizedException("User with id " + idUser + " not found!");
	                }
	            } catch (UnauthorizedException e) {
	                // Handle UnauthorizedException
	                HttpServletResponse response = attributes.getResponse();
	                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Set 401 status code
	                throw e; // Re-throw the exception to prevent further method execution
	            } catch (Exception e) {
	                // Handle other exceptions (optional)
	                e.printStackTrace();
	                // Consider returning a different error code for unexpected exceptions
	            }
	        }
	    }
	}

}
