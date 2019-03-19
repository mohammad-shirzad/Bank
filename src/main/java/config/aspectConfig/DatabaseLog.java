package config.aspectConfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;

public class DatabaseLog {

    public Object ioLog(ProceedingJoinPoint joinPoint) {
        Object obj = new Object();
        try {
            CodeSignature signature = (CodeSignature) joinPoint.getSignature();
            System.out.println("method: " + signature.getName() + " started");
            obj = joinPoint.proceed();
            System.out.println("method: " + signature.getName() + " finished");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            return obj;
        }
    }

    public void diffLog(JoinPoint joinPoint) {
        try {


        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
