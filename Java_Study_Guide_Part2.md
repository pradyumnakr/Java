# Java Study Guide — Part 2

> **Continuation of** `Java_Study_Guide.md`
> Covers: OOP Concepts, Inheritance, Polymorphism, Abstraction, Encapsulation, and more.

---

## `this()` — Constructor Chaining
`this()` is used to call **another constructor within the same class**. It is used for **constructor chaining** inside the same class.

### 📌 Example
```java
class Student {
    String name;
    int age;

    Student(String name) {
        this(name, 18);   // calls the 2-arg constructor
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Student s = new Student("Pradyumna");
```

**Flow:**
1. First constructor `Student(String name)` runs.
2. `this(name, 18)` → delegates to the second constructor.
3. `Student(String name, int age)` executes.

> 🚨 **Important Rule:** `this()` **must** be the **first statement** inside the constructor.

---

## `super()` — Parent Constructor Call
`super()` is used to call the **parent class constructor**. It is primarily used in inheritance.

### 📌 Example
```java
class Person {
    Person(String name) {
        System.out.println("Person constructor");
    }
}

class Student extends Person {
    Student(String name) {
        super(name);   // calls parent constructor
        System.out.println("Student constructor");
    }
}

Student s = new Student("Pradyumna");
```

**Flow:**
1. `super(name)` runs → **Parent** (`Person`) constructor executes first.
2. Then the **Student** constructor continues.

### 🚨 Important Rules
1. **Auto-added by Java:** If you don't write `super()`, Java automatically adds a no-arg `super()` call — but **only if the parent has a no-arg constructor**.
   ```java
   class Student extends Person {
       Student() {
           // super() added automatically
       }
   }
   ```
2. `super()` must also be the **first statement** in the constructor.

### 🆚 `this()` vs `super()`
| Feature | `this()` | `super()` |
| --- | --- | --- |
| **Calls** | Same class constructor | Parent class constructor |
| **Used for** | Constructor chaining | Inheritance |
| **Refers to** | Current class | Parent class |
| **Together?** | ❌ Cannot be used together | ❌ Cannot be used together |
| **Position** | Must be first statement | Must be first statement |

---

## Why Static Methods Can't Access Non-Static Members
Static methods belong to the **class**. Non-static members belong to an **object**. A static method can run without any object ever being created.

### 🧠 Think About Memory
When a class is loaded by the JVM:
- **Static members** → stored **once** at the class level.
- **Non-static members** → created **only when** an object is instantiated.

### 📌 Example
```java
class Student {
    int age = 20;              // non-static (belongs to object)
    static String school = "VT"; // static (belongs to class)

    static void show() {
        System.out.println(age);   // ❌ Compile Error!
    }
}
```

**Why the error?**
- `age` belongs to a specific **object**.
- `show()` is **class-level** — no object reference exists inside it.
- Java has no way to know *which* object's `age` to use!

### ✅ How To Access Non-Static Inside a Static Method?
You must **create an object** first — then JVM knows exactly which object's fields to use:
```java
static void show() {
    Student s = new Student();
    System.out.println(s.age);  // ✅ OK — explicit object reference
}
```

### ✅ Why Can Static Access Static?
Because static members belong to the class — there is **only one copy** and **no ambiguity**.
```java
static void show() {
    System.out.println(school);  // ✅ OK — school is also class-level
}
```

### 🎯 Quick Summary: Static vs Non-Static
| Feature | Static | Non-Static |
| --- | --- | --- |
| **Belongs to** | Class | Object |
| **`this` reference** | ❌ No | ✅ Yes |
| **Copies** | One shared copy | One per object |
| **Instance access** | ❌ Can't access directly | ✅ Can access static |

---

## Non-Static Inner Class
A non-static inner class is **tied to an instance of the outer class**. It cannot exist independently — it needs an `Outer` object.

```java
class Outer {
    int x = 10;

    class Inner {
        void show() {
            System.out.println(x);  // can access Outer's members
        }
    }
}
```

### ✅ Correct Way to Instantiate
```java
Outer outer = new Outer();
Outer.Inner obj = outer.new Inner();
```
This creates an `Inner` object **associated with a specific `outer` object**.

### ❌ Why Not Just `new Inner()`?
```java
Outer.Inner obj = new Inner(); // ❌ Compile Error
```
Because the JVM asks: *"Which `Outer` instance should this `Inner` belong to?"* There may be multiple `Outer` objects — it's ambiguous without a reference.

---

## Variables in Java
A **variable** is a container that stores data. Every variable in Java has:
- **Type** — what kind of data it holds
- **Name** — the identifier
- **Scope** — where it is accessible
- **Lifetime** — how long it exists

**Scope** is the region of the program where a variable is accessible, and it depends on *where* the variable is declared.

---

## 1️⃣ Local Variables
A local variable is declared **inside a method, constructor, or block `{}`**.

```java
class Student {
    void show() {
        int age = 20;   // local variable
        System.out.println(age);
    }
}
```

### Properties of Local Variables
- Stored in **Stack** memory
- Exists **only while the method is running**
- **Must be initialized before use** (no default value)
- Not accessible outside the method

---

## 2️⃣ Instance Variables
Instance variables are declared inside the class but **outside methods**, and are **non-static**.

```java
class Student {
    String name;  // instance variable
    int age;

    void show() {
        System.out.println(name);
    }
}
```

### Properties of Instance Variables
- Stored in **Heap** memory
- Each object has its **own copy**
- Gets **default values** automatically

| Type | Default Value |
| --- | --- |
| `int` | `0` |
| `boolean` | `false` |
| `Object` | `null` |

```java
Student s1 = new Student();
Student s2 = new Student();
// s1.name and s2.name are completely separate copies
```

---

## 3️⃣ Static Variables
Static variables are declared using `static` and **belong to the class**, not any individual object.

```java
class Student {
    static String school = "VT";  // static variable
}
```

### Properties of Static Variables
- Stored in the **Method Area** (class area)
- **Only one copy** exists, shared among all objects
- Loaded when the class is first loaded by the JVM

```java
Student s1 = new Student();
Student s2 = new Student();

System.out.println(Student.school); // Both share the same `school`
```

### 🆚 Variable Types Quick Summary
| Feature | Local | Instance | Static |
| --- | --- | --- | --- |
| **Declared in** | Method/block | Class body | Class body |
| **Memory** | Stack | Heap | Method Area |
| **Default value** | ❌ None | ✅ Yes | ✅ Yes |
| **Copies** | Per call | Per object | One for all |

---

## 🧠 Memory Visualization Concept
| When | What gets created |
| --- | --- |
| **Class loads** | Static variables |
| **Object created** | Instance variables |
| **Method runs** | Local variables |

```java
class Student {
    static String school = "VT";  // created when class loads
    String name;                  // created when object is created

    void show() {
        int age = 20;             // created when method runs
        System.out.println(name + " " + school + " " + age);
    }
}
```

---

## Arithmetic Operators
Used for mathematical operations.

| Operator | Meaning |
| --- | --- |
| `+` | Addition |
| `-` | Subtraction |
| `*` | Multiplication |
| `/` | Division |
| `%` | Modulus (remainder) |

```java
int a = 10;
int b = 3;

System.out.println(a + b); // 13
System.out.println(a - b); // 7
System.out.println(a * b); // 30
System.out.println(a / b); // 3  (integer division — no decimal)
System.out.println(a % b); // 1  (remainder of 10 ÷ 3)
```

---

## Relational Operators
Used to **compare values**. Always return a `boolean` (`true` or `false`).

| Operator | Meaning |
| --- | --- |
| `>` | Greater than |
| `<` | Less than |
| `>=` | Greater than or equal to |
| `<=` | Less than or equal to |
| `==` | Equal to |
| `!=` | Not equal to |

```java
int x = 5;
int y = 10;

System.out.println(x > y);  // false
System.out.println(x < y);  // true
System.out.println(x == y); // false
```

### ⚠️ `==` vs `.equals()` for Objects
```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);        // false (different memory references)
System.out.println(s1.equals(s2));   // true  (same content)
```

> 🔑 **Key Rule:**
> - `==` compares **references** (memory addresses)
> - `.equals()` compares **values** (actual content)

---

## Logical Operators
Used with **boolean expressions** to combine multiple conditions.

| Operator | Meaning | Returns `true` when... |
| --- | --- | --- |
| `&&` | Logical AND | **Both** conditions are true |
| `\|\|` | Logical OR | **At least one** condition is true |
| `!` | Logical NOT | Condition is **false** (inverts result) |

---

## Assignment Operators

**Basic assignment:**
```java
int a = 10;
```

**Compound assignment** (shorthand for combining an operation with assignment):

| Operator | Equivalent To |
| --- | --- |
| `+=` | `a = a + b` |
| `-=` | `a = a - b` |
| `*=` | `a = a * b` |
| `/=` | `a = a / b` |
| `%=` | `a = a % b` |

---

## Ternary Operator
A compact, single-line shorthand for an `if-else` statement.

**Syntax:**
```java
condition ? value_if_true : value_if_false;
```

**Example:**
```java
int age = 20;
String result = (age >= 18) ? "Adult" : "Minor";
System.out.println(result); // Adult
```

---

## Decision-Making Statements
Used to execute code based on conditions.

### 🔹 1. `if` Statement
```java
int age = 20;

if (age >= 18) {
    System.out.println("Adult");
}
```
- If the condition is `true` → the block runs.
- If the condition is `false` → it is skipped.

### 🔹 2. `if-else` Statement
```java
if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

### 🔹 3. `if-else-if` Ladder
Used to check multiple conditions in sequence.
```java
int marks = 85;

if (marks >= 90) {
    System.out.println("A");
} else if (marks >= 75) {
    System.out.println("B");
} else {
    System.out.println("C");
}
```

### 🔹 4. `switch` Statement
Used when checking a single variable against multiple discrete values.
```java
int day = 2;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Invalid");
}
```

---

## Looping Statements
Used to repeat code multiple times.

### 🔹 1. `for` Loop
Best when the **number of iterations is known**.
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

### 🔹 2. `while` Loop
Runs **while** a condition is `true`. Condition is checked **before** each iteration.
```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```

### 🔹 3. `do-while` Loop
Runs **at least once** — condition is checked **after** each iteration.
```java
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 5);
```

### 🔹 4. Enhanced `for` Loop (For-each)
Used with **arrays or collections** — no index needed.
```java
int[] arr = {1, 2, 3};

for (int num : arr) {
    System.out.println(num);
}
```

---

## Branching Statements
Used to control the flow within loops and methods.

### 🔹 1. `break`
Stops the loop **immediately**.
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
}
```

### 🔹 2. `continue`
Skips the **current iteration** and moves to the next.
```java
for (int i = 0; i < 5; i++) {
    if (i == 2) continue;
    System.out.println(i); // prints 0, 1, 3, 4
}
```

### 🔹 3. `return`
**Exits the method** completely.
```java
void check(int x) {
    if (x < 0) return;
    System.out.println("Positive");
}
```

---

## Encapsulation
Encapsulation means **wrapping data (variables) and methods together into a single unit (class)** and restricting direct access to the data.

> 👉 Hide internal details. Allow controlled access.

### 💊 Real-Life Analogy
Think of a medicine capsule:
- **Inside** → ingredients (hidden)
- **Outside** → protective coating
You cannot directly access what's inside. Same in Java: data is hidden and access is given through methods.

### ✅ How to Achieve Encapsulation
Using **`private` variables** + **`public` getter & setter methods**:

```java
class Student {
    private String name;   // data is hidden
    private int age;

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {     // validation
            this.age = age;
        }
    }
}
```

### 🌟 Benefits of Encapsulation
1. **Data hiding** — internal state is not exposed directly
2. **Better security** — data cannot be tampered with freely
3. **Control over modification** — setters can validate input (e.g., `age > 0`)
4. **Flexibility** — internal implementation can change without affecting calling code
5. **Improved maintainability** — cleaner, well-organized code

### 🆚 Encapsulation vs Abstraction
| Feature | Encapsulation | Abstraction |
| --- | --- | --- |
| **Hides** | Data | Implementation |
| **Achieved using** | Access modifiers (`private`) | Abstract class / Interface |
| **Focus** | Security | Design |

### 💡 Visual Summary
```
Without Encapsulation:  Object → Direct access      → Data corruption possible
With Encapsulation:     Object → Getter/Setter       → Controlled access → Safe
```

---

## Abstraction
Abstraction means **hiding implementation details and showing only essential features**.

> 👉 Show *what* to do. Hide *how* it is done.

### 🚗 Real-Life Analogy
Think of a car: when you press the accelerator, you don't need to know how fuel injection or engine compression works. You just know:
> 👉 Press pedal → car moves.
That is abstraction.

### ✅ How to Achieve Abstraction in Java
- **1️⃣ Interfaces** — define *what* methods must exist, but not *how* they work.
- **2️⃣ Abstract Classes** — can mix abstract (unimplemented) and concrete (implemented) methods.

### 🔹 Abstraction Using Interface
```java
interface Payment {
    void pay();   // abstract method — no implementation
}

class CreditCardPayment implements Payment {
    public void pay() {
        System.out.println("Paid using credit card");
    }
}
```
The interface hides *how* payment works — the user only sees `pay()`.

### 🔹 Abstraction Using Abstract Class
An abstract class can have both **abstract methods** (no body) and **concrete methods** (with body):
```java
abstract class Animal {
    abstract void makeSound();  // must be implemented by subclass

    void sleep() {              // concrete — already implemented
        System.out.println("Sleeping...");
    }
}
```

### 🆚 Encapsulation vs Abstraction
| Feature | Encapsulation | Abstraction |
| --- | --- | --- |
| **Hides** | Data | Implementation |
| **Uses** | `private` variables | Interface / Abstract class |
| **Focus** | Security | Design |

### 💡 Visual Summary
```
Without Abstraction:  User → Sees full implementation → Complex
With Abstraction:     User → Sees simple interface    → Clean design
```

---

## Abstract Methods
An abstract method has a **declaration but NO implementation** (no body). It defines *what* should be done, not *how*.

### 📌 Syntax
```java
abstract void makeSound();
```
Notice:
- No `{ }` curly braces
- No method body
- Ends with `;`

### ❓ Why Use Abstract Methods?
- You want **subclasses to provide their own implementation**.
- You want to **enforce a contract** — every subclass *must* implement it.

```java
class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
}
```
> ⚠️ If `Dog` doesn't implement `makeSound()` → **compilation error!**

---

## Concrete Methods
A concrete method has a **full implementation** (a method body).

### 📌 Example
```java
class Animal {
    void sleep() {
        System.out.println("Sleeping...");
    }
}
```
- `sleep()` has complete logic.
- Subclasses can **inherit and use it directly** without overriding.

### 🤔 Why Mix Both?
Because some behavior is **common** across all subclasses (concrete), and some behavior **differs** per subclass (abstract).

| Behavior | Type | Reason |
| --- | --- | --- |
| All animals sleep | **Concrete** | Same logic for everyone — define once |
| Different animals make sounds | **Abstract** | Each subclass must define its own |

This is the power of an **abstract class** — it is a partial blueprint where common logic is shared and unique behavior is enforced.

### 🆚 Key Differences: Abstract vs Concrete Method
| Feature | Abstract Method | Concrete Method |
| --- | --- | --- |
| **Body** | ❌ No body | ✅ Has body |
| **Must be implemented** | ✅ Yes | ❌ Optional override |
| **Syntax** | Ends with `;` | Uses `{ }` |
| **Purpose** | Abstraction / contract | Actual logic |

### 🚨 Important Rules
1. Abstract method must be inside an **abstract class** or an **interface**.
2. If a class contains an abstract method → the class **must** be declared `abstract`.
   ```java
   abstract class Animal {
       abstract void makeSound();
   }
   ```
3. You **cannot create an object** of an abstract class:
   ```java
   Animal a = new Animal(); // ❌ Compile Error
   ```

---

## Inheritance
Inheritance means a **child class (subclass)** acquires the properties and behaviors of a **parent class (superclass)**.

> 👉 Reusing code. Extending functionality.

### 🐕 Real-Life Example
- **Parent:** `Animal`
- **Child:** `Dog`
- `Dog` *is-a* `Animal` — it inherits common features from `Animal`.

### 🔹 Basic Syntax
```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

Dog d = new Dog();
d.eat();   // ✅ inherited from Animal
d.bark();  // ✅ Dog's own method
```

### 🔹 Key Rules
- The `extends` keyword is used.
- Child class inherits:
  - ✅ `public` members
  - ✅ `protected` members
  - ❌ `private` members (not directly accessible)

### 🔢 Types of Inheritance in Java

**1️⃣ Single Inheritance**
```java
class A {}
class B extends A {}
```

**2️⃣ Multilevel Inheritance**
```java
class A {}
class B extends A {}
class C extends B {}  // C → B → A
```

**3️⃣ Hierarchical Inheritance**
```java
class A {}
class B extends A {}  // B and C both extend A
class C extends A {}
```

**❌ Multiple Inheritance (Not Allowed with Classes)**
```java
class C extends A, B {}  // ❌ Not allowed in Java
```
> Java avoids multiple inheritance with classes to prevent the **Diamond Problem**.
> ✅ However, multiple inheritance **is** allowed through **interfaces**.

---

## `super` Keyword in Inheritance
`super` is used to refer to the **parent class** — its methods and variables.

### 📌 Access Parent Method
```java
class Dog extends Animal {
    void show() {
        super.eat();  // calls Animal's eat() method
    }
}
```

### 📌 Access Parent Variable
```java
class Animal {
    int age = 5;
}

class Dog extends Animal {
    int age = 2;

    void printAge() {
        System.out.println(age);       // 2 — Dog's own age
        System.out.println(super.age); // 5 — Animal's age
    }
}
```

---

## Constructor in Inheritance
When a child object is created, constructors run in **parent → child** order:

```java
class Animal {
    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {
    Dog() {
        System.out.println("Dog constructor");
    }
}
```

**Output:**
```
Animal constructor
Dog constructor
```

> 👉 Java automatically calls `super()` in the child constructor if not explicitly written (as long as the parent has a no-arg constructor).

---

## Method Overriding
*⭐ Very Important*

A child class can **override** a parent class method to provide its own specific implementation.

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```

> 👉 This enables **Runtime Polymorphism** — the JVM decides at runtime which `sound()` to call based on the actual object type.

### 🔑 Access Modifiers in Inheritance
| Modifier | Accessible in Subclass? |
| --- | --- |
| `public` | ✅ Yes |
| `protected` | ✅ Yes |
| `default` (no keyword) | ✅ Only if same package |
| `private` | ❌ No |

---

## Polymorphism in Java
Java supports two types of polymorphism:
- **1️⃣ Compile-Time Polymorphism** (Method Overloading)
- **2️⃣ Runtime Polymorphism** (Method Overriding)

### 1️⃣ Compile-Time Polymorphism (Static Binding)
Achieved using **method overloading** — same method name, different parameters. The correct method is decided at **compile time**.

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

### 2️⃣ Runtime Polymorphism (Dynamic Binding)
Achieved using **method overriding + inheritance**. The method call is resolved at **runtime** based on the actual object type.

```java
class Animal {
    void sound() { System.out.println("Animal sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Bark"); }
}

Animal a = new Dog();
a.sound(); // "Bark" — resolved at runtime
```

### 🔥 Important Concept: Reference Type vs Object Type
```java
Animal a = new Dog();
```
| | Type | Determines |
| --- | --- | --- |
| `a` (variable) | **Reference type** → `Animal` | Which variables are accessed |
| `new Dog()` | **Object type** → `Dog` | Which method runs |

**Example:**
```java
class Animal {
    String type = "Animal";
    void show() { System.out.println("Animal show"); }
}

class Dog extends Animal {
    String type = "Dog";
    void show() { System.out.println("Dog show"); }
}

Animal a = new Dog();
System.out.println(a.type); // "Animal" — reference type wins for variables
a.show();                   // "Dog show" — object type wins for methods
```

### 🆚 Compile-Time vs Runtime Polymorphism
| Feature | Compile-Time | Runtime |
| --- | --- | --- |
| **Achieved by** | Overloading | Overriding |
| **Binding** | Static | Dynamic |
| **Decided at** | Compile time | Runtime |
| **Inheritance required?** | ❌ No | ✅ Yes |

---

## Copy Constructor
A copy constructor creates a **new object by copying the values of another object** of the same class.

> 👉 It makes a copy of an existing object.

### ❌ Does Java Provide One Automatically?
No. Unlike C++, Java does **NOT** provide a built-in copy constructor — you must define it manually.

### 📌 Example
```java
class Student {
    String name;
    int age;

    // Normal constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Student(Student s) {
        this.name = s.name;
        this.age = s.age;
    }
}

Student s1 = new Student("Pradyumna", 24);
Student s2 = new Student(s1);  // copy created
```
> - `s1` and `s2` are **different objects** in memory.
> - But they **contain the same data**.

---

## Static Keyword (Deep Dive)
`static` means **belongs to the class, not to an object**. It is shared across all objects.

### 🔥 1️⃣ Static Variable
```java
class Student {
    static String school = "VT";
}
```
- **Only one copy** exists in memory.
- **Shared by all objects** — changing it in one place changes it everywhere.

### 🔥 2️⃣ Static Method
```java
class MathUtil {
    static int add(int a, int b) {
        return a + b;
    }
}

MathUtil.add(10, 20); // Called without creating an object
```

### 🔥 3️⃣ Static Block
Runs **once** when the class is first loaded by the JVM.
```java
class Test {
    static {
        System.out.println("Class Loaded");
    }
}
```

### 🔥 4️⃣ Static Nested Class
```java
class Outer {
    static class Inner {}
}
```
> Does **not** require an outer class object to instantiate.

---

## `final` Keyword
`final` means **cannot be changed**. Its behaviour depends on where it is used.

### 🔥 1️⃣ Final Variable
Cannot be reassigned after initialization.
```java
final int x = 10;
// x = 20; ❌ Compile Error
```

### 🔥 2️⃣ Final Method
Cannot be **overridden** by a subclass.
```java
class A {
    final void show() {}
}
```
> Used to prevent method overriding and ensure consistent behavior.

### 🔥 3️⃣ Final Class
Cannot be **extended** (subclassed).
```java
final class A {}
// class B extends A {} ❌ Not allowed
```
**Real Example:** `String` is a `final` class — that's why you cannot subclass it.

### 🔥 `static` + `final` Together
The combination is used for **constants** — one copy that can never change.
```java
class Constants {
    static final double PI = 3.14159;
}
```
| Keyword | Meaning |
| --- | --- |
| `static` | One copy per class |
| `final` | Cannot be changed |
| **Combined** | A true constant |

---

## `finally` Block
`finally` is used in exception handling. It defines a block that **always executes**, whether an exception occurs or not.

### 📌 Example
```java
try {
    int x = 10 / 0;
} catch (Exception e) {
    System.out.println("Exception caught");
} finally {
    System.out.println("Finally block executed");
}
```
**Output:**
```
Exception caught
Finally block executed
```

---

## `finalize()` Method
`finalize()` is a method defined in the `Object` class. It is called by the **Garbage Collector** just before an object is destroyed.

### 📌 Example
```java
class Test {
    protected void finalize() {
        System.out.println("Object destroyed");
    }
}
```
> ⚠️ Note: `finalize()` is deprecated since Java 9 and should not be relied upon in modern code.

---

### 🆚 `final` vs `finally` vs `finalize()`
| Feature | `final` | `finally` | `finalize()` |
| --- | --- | --- | --- |
| **Type** | Keyword | Block | Method |
| **Used with** | Variable, Method, Class | `try-catch` | `Object` class |
| **Purpose** | Prevent modification | Cleanup / guaranteed execution | GC cleanup |
| **When executes** | Compile-time rule | Always after `try`/`catch` | Before GC removes object |
