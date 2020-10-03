package s.l.q.m.kkk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BrokerAspect {

    private static final Logger logger = LoggerFactory.getLogger(BrokerAspect.class);

    @Pointcut("execution(public * s.l.q.m.kkk.bean.*.*(..))")
    public void writeLog() {}

    @Before("writeLog()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("into doBefore method");
    }

    @AfterReturning(returning = "ret",pointcut = "writeLog()")
    public void doAfterReturning(Object ret) {
        logger.info("into doAfterReturning method");
    }

    @AfterThrowing(pointcut = "writeLog()", throwing = "ex")
    public void doAfterThrowing(Exception ex) {
        logger.info("into AfterThrowing method");
    }

    @After(value = "writeLog()")
    public void doAfter() {
        logger.info("into doAfter method");
    }

    @Around(value = "writeLog()")
    public void doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("into before doAround");
        proceedingJoinPoint.proceed();
        logger.info("into behind doAround");
    }
}
