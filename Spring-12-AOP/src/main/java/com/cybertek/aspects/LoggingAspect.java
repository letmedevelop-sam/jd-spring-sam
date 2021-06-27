package com.cybertek.aspects;

import com.cybertek.controller.ProductController;
import com.cybertek.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {

/*
    AOP Use Cases
• Most Common
    - Logging, security
• Audit Logging
    - Who, what, when, where
• Exception Handling
    - Log exception and notify DevOps team via email
• API Management
    - How many times has a method been called user
    - Analytics: what are peak times? What is average load?
*/

/*
    • Aspect      : Module of code for a cross-cutting concern (logging, security)
    • Advice      : What action is taken and when it should be applied
    • Joint Point : It's a particular point during execution of programs like method execution,
    constructor call, or field assignment
    • Pointcut    : A regular expression that matches a joinpoint. (Where to implement the code)
    Each time any join point matches a pointcut, a specified advice associated with that pointcut is executed
    • Weaving – the process of linking aspects with targeted objects to create an advised object
 */

/*
    Advice Types
    • Before advice : run before the method
    • After finally advice : run after the method (finally)
    • After returning advice : run after method (success execution)
    • After throwing advice : run after method (if exception thrown)
 */

/*
    Spring AOP RoadMap
    • Create Aspects
    • Develop Advices
        - Before, After returning, After throwing
        - After finally, Around
    • Create Pointcut expressions
    • Apply it to our application
 */
    //initialize the logger
    Logger logger = LoggerFactory.getLogger(ProductController.class);


    // @Pointcut sets : Where-when-what to implement in the code
    @Pointcut("execution(* com.cybertek.controller.ProductController.*(..))")   //each method - everywhere in the controller
    public void pointcut(){}  //pointcut names must match

    @Before("pointcut()")  //pointcut names must match
    public void log(){
        logger.info("-------LOG INFO first------");
    }

/*
    //Also the previous two parts can be combined as below in one annotation
    @Before("execution(* com.cybertek.controller.ProductController.*(..))")
    public void beforeAdvice(){
        logger.info("-----------");
    }
*/

        //execution is used 99% by everyone - the most famous one

    @Pointcut("execution(* com.cybertek.controller.ProductController.up*(..))")
    private void anyUpdateOperation(){}

    @Pointcut("execution(* com.cybertek.repository.ProductRepository.findById(Long))")
    private void anyProductRepositoryFindById(){}

    @Before("anyProductRepositoryFindById()")
    public void beforeProductRepoAdvice(JoinPoint joinPoint){
        logger.info(" ----LOG INFO LIST ALL--- ");

        logger.info("Before(findById) -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }

    @Before("anyUpdateOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("---LOG INFO  UPDATE---");
        logger.info("Before -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }

    //within
    @Pointcut("within(com.cybertek.controller..*)")
    private void anyControllerOperation(){}

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceAnnotatedOperation(){}

    @Before("anyServiceAnnotatedOperation() || anyControllerOperation() ")
    public void beforeControllerAdvice2(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }

        //annotation
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteProductOperation(){}

    @Before("anyDeleteProductOperation()")
    public void beforeControllerAdvice3(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }

        //after returning
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetProductOperation(){}

    @AfterReturning(pointcut = "anyGetProductOperation()",returning = "results")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Product results){
        logger.info("After Returning(Mono Result) -> Method : {} - results :{}",joinPoint.getSignature().toShortString(),results);
    }

    @AfterReturning(pointcut = "anyGetProductOperation()",returning = "results")
    public void afterReturningControllerAdvice2(JoinPoint joinPoint, List<Product> results){
        logger.info("After Returning(List Result) -> Method : {} - results :{}",joinPoint.getSignature().toShortString(),results);
    }

          //after throwing
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation(){}

    @AfterThrowing(pointcut = "anyGetPutProductOperation()",throwing = "exception")
    public void afterThrowingControllerAdvice(JoinPoint joinPoint,RuntimeException exception){
        logger.info("After Throwing(Send Email to L2 Team) -> Method: {} - Exception : {}",joinPoint.getSignature().toShortString(),exception.getMessage());
    }

        //after
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation2(){}

    @After("anyGetPutProductOperation2()")
    public void afterControllerAdvice(JoinPoint joinPoint){
        logger.info("After finally -> Method : {} - results :{}",joinPoint.getSignature().toShortString());
    }

    @After("anyGetPutProductOperation2()")
    public void afterControllerAdvice2(JoinPoint joinPoint){
        logger.info("After finally -> Method : {} - results :{}",joinPoint.getSignature().toShortString());
    }

//    //around
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
//    private void anyPostProductOperation(){}
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
//    private void anyPutProductOperation(){}
//
//    @Around("anyPostProductOperation()")
//    public Object anyPostControllerAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        logger.info("Before(Method : {} - Parameters : {}",proceedingJoinPoint.getSignature().toShortString(),proceedingJoinPoint.getArgs());
//
//        List<Product> results = new ArrayList<>();
//      //  results =(List<Product>) proceedingJoinPoint.proceed();
//
//        logger.info("After(Method: {} - Results : {}",proceedingJoinPoint.getSignature().toShortString(),results);
//
//        return results;
//    }

}
