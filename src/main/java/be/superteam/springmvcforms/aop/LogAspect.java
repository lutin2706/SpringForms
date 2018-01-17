package be.superteam.springmvcforms.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;


@Component
@Aspect
public class LogAspect {

    @Autowired
    private HttpSession httpSession;

    private Logger logger = LoggerFactory.getLogger(getClass());

    // @Before = avant la méthode
    // execution = l'exécution de la méthode
    // (* = tous les types de retour
    // be.superteam.springmvcforms.controller.* = toutes les classes du package controller
    // .* = toutes les méthodes
    // (..) = n'importe quel paramètre
    @Around("execution(* be.superteam.springmvcforms.controller.*.*(..))")
    // JoinPoint = tout ce qui est sélectionné ci-dessus
    public Object beforeControllers(ProceedingJoinPoint joinPoint) {
        try {
            logger.info("Before " + joinPoint);
            Object result = joinPoint.proceed(joinPoint.getArgs());
            logger.info("After " + joinPoint);
            return result;
        } catch (Throwable throwable) {
            logger.error("Error " + joinPoint);
            return null;
        }
    }

    @Around("execution(* be.superteam.springmvcforms.service.*.*(..))")
    // JoinPoint = tout ce qui est sélectionné ci-dessus
    public Object aroundServices(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint + " called by " + httpSession.getId());
        Object result = joinPoint.proceed();
        logger.info(joinPoint + " executed");
        return result;
    }


}
