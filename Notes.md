# Spring AOP

#### Used For
Sprig AOP is provides programming paradigm that allows you to separate cross-cutting concerns from the business logic. 
It is used for logging, transaction management, security, and more.

#### Code samples:
```java
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }
}
```
#### Exception Handling
Spring AOP can be used to handle exceptions in a centralized manner. 
You can define an aspect that intercepts exceptions thrown by methods and handles them appropriately. This can help in maintaining clean and consistent error handling across your application.
##### Coding Example:
```java
@Aspect
@Component
public class ExceptionHandlingAspect {
    @AfterThrowing(pointcut = "execution(* com.example.service.*.*(..))", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Exception ex) {
        System.out.println("Exception in method: " + joinPoint.getSignature().getName());
        System.out.println("Exception message: " + ex.getMessage());
    }
}
```
#### Transaction Management
Spring AOP can be used to manage transactions declaratively.
You can define aspects that handle transaction boundaries, ensuring that methods are executed within a transactional context.
##### Coding Example:
```java
@Aspect
@Component
public class TransactionManagementAspect {
    @Around("execution(* com.example.service.*.*(..))")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        // Start transaction
        System.out.println("Starting transaction for method: " + joinPoint.getSignature().getName());
        try {
            Object result = joinPoint.proceed(); // Proceed with method execution
            // Commit transaction
            System.out.println("Committing transaction for method: " + joinPoint.getSignature().getName());
            return result;
        } catch (Exception ex) {
            // Rollback transaction
            System.out.println("Rolling back transaction for method: " + joinPoint.getSignature().getName());
            throw ex; // Rethrow the exception
        }
    }
}
```
#### Security
Spring AOP can be used to implement security concerns, such as method-level security.
You can define aspects that check user roles or permissions before allowing access to certain methods.
##### Coding Example:
```java
@Aspect
@Component
public class SecurityAspect {
    @Before("execution(* com.example.service.*.*(..)) && @annotation(RequiresRole)")
    public void checkUserRole(JoinPoint joinPoint, RequiresRole requiresRole) {
        String requiredRole = requiresRole.value();
        // Check if the user has the required role
        if (!userHasRole(requiredRole)) {
            throw new SecurityException("User does not have the required role: " + requiredRole);
        }
    }
    private boolean userHasRole(String role) {
        // Implement your logic to check if the user has the specified role
        return true; // Placeholder for actual role checking logic
    }
}
```
How Spring AOP handles, when multiple aspects are applied to the same method, is determined by the order of aspect execution. By default, aspects are executed in the order they are defined. However, you can control the order of aspect execution using the `@Order` annotation or by implementing the `Ordered` interface.

#### Example of controlling aspect order:
```java
@Aspect
@Component
@Order(1) // This aspect will be executed first
public class FirstAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void firstAspectMethod(JoinPoint joinPoint) {
        System.out.println("First aspect executed before method: " + joinPoint.getSignature().getName());
    }
}
```
