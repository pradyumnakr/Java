# Spring Framework Annotations

This guide provides an overview of essential Spring annotations used for Dependency Injection and Bean management.

## `@Component`
Tells Spring to manage the annotated class as a Spring Bean. During startup, Spring scans your project for classes annotated with `@Component` (or its derivatives like `@Service`, `@Repository`, `@Controller`), creates a single instance of them, and places them in its Application Context.

**Example:**
```java
@Component
public class Laptop implements Computer { ... }
```

## `@Autowired`
Used to automatically inject dependencies (Beans) into a class. Spring resolves the dependency by looking for a matching Bean in the Application Context. It can be applied to constructors, fields, or setter methods. **Constructor injection** is the recommended best practice.

**Example (Field Injection):**
```java
@Autowired
private Computer computer;
```

**Example (Constructor Injection):**
```java
@Autowired
public Alien(Computer computer) {
    this.computer = computer;
}
```

## `@Primary`
When multiple Beans of the same type exist in the Application Context (e.g., both `Laptop` and `Desktop` implement `Computer`), Spring doesn't know which one to inject. The `@Primary` annotation tells Spring to prefer a specific Bean when resolving the ambiguous dependency.

**Example:**
```java
@Component
@Primary
public class Laptop implements Computer { ... }
// Whenever a `Computer` is required, the `Laptop` bean will be used.
```

## `@Qualifier`
Provides explicit control over which specific Bean is injected when multiple Beans of the same type exist. By providing the Bean's name (the class name in lowercase, typically), you select exactly which Bean to wire, overriding both default resolution and any `@Primary` annotations.

**Example:**
```java
@Autowired
@Qualifier("laptop")
private Computer computer; // Guarantees the Laptop bean is injected
```

## `@Scope`
Defines the lifecycle pattern of a Spring Bean. 
- `"singleton"` **(Default)**: Only one instance of the Bean is created for the entire application. Every time the Bean is requested, the exact same object reference is returned.
- `"prototype"`: A brand new instance of the Bean is created every single time it is requested.

**Example:**
```java
@Component
@Scope("singleton") // Optional since singleton is the default
public class Alien { ... }
```

## `@Value`
Tells Spring to inject a primitive value or String into a field or constructor parameter. It can be a hardcoded static value, or more powerfully, a property read dynamically from your `application.properties` configuration file using the syntax `@Value("${property.name}")`.

**Example:**
```java
@Value("28") // Hardcoded injection
private int age;

@Value("${alien.default.age}") // Dynamic injection from application.properties
private int configuredAge;
```
