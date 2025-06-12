package com.quality.collab.poc.authorizations.aspects;

import com.quality.collab.poc.authorizations.annotations.AuthCheck;
import com.quality.collab.poc.authorizations.services.AuthorizationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizationAspect {

    @Autowired
    private AuthorizationService authorizationService; // your custom logic class

    @Around("@annotation(authCheck)")
    public Object checkAuthorization(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        String controller = authCheck.controller();
        String action = authCheck.action();

        // Custom logic to check if the current user is authorized
        boolean authorized = authorizationService.isAuthorized(controller, action);

        if (!authorized) {
            throw new AccessDeniedException("Access denied for action: " + action + " on: " + controller);
        }

        // Continue to the actual controller method
        return joinPoint.proceed();
    }
}

