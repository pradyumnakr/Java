# Java Study Guide — Part 3

> **Continuation of** `Java_Study_Guide_Part2.md`
> Covers: Exception Handling, Collections, Generics, Threads, Streams, and more.

---

## String
`String` is an **immutable** class in Java. Once created, it cannot be changed.

### 📌 What Happens Internally?
```java
String s = "Hello";
s = s + " World";
```
1. `"Hello"` is created in the String Pool.
2. `"Hello World"` is created as a **new object**.
3. The old `"Hello"` object becomes eligible for Garbage Collection.

### 🔥 String Pool (Very Important)
```java
String s1 = "Java";
String s2 = "Java";
// s1 and s2 refer to the SAME object in the String Pool
```

```java
String s1 = new String("Java");
// Creates a NEW object in heap (outside String Pool)
```

---

## StringBuilder
`StringBuilder` is a **mutable** class used for modifying strings efficiently. No new object is created on modification — the **same object is modified**.

### 📌 Example
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb); // Hello World
```

---

## StringBuffer
`StringBuffer` is a **mutable and thread-safe** version of `StringBuilder`.

### 📌 Example
```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
```

---

## 🆚 String vs StringBuilder vs StringBuffer
| Feature | `String` | `StringBuilder` | `StringBuffer` |
| --- | --- | --- | --- |
| **Mutable** | ❌ No | ✅ Yes | ✅ Yes |
| **Thread-safe** | ✅ Yes | ❌ No | ✅ Yes |
| **Performance** | Slow (for modification) | Fast | Slower than `StringBuilder` |

---

## Java Collections Framework

### 🌳 Collection Interface (Root Interface)
`Collection` is the parent interface of:
- **`List`** — ordered, allows duplicates
- **`Set`** — no duplicates
- **`Queue`** — FIFO structure

> **Note:** `Map` is **NOT** part of the `Collection` interface — it stores key-value pairs separately.

---

### 📋 List (Ordered + Allows Duplicates)
Stores elements in **insertion order**.

**🔥 ArrayList** — Dynamic array; fast random access; slow insertion/deletion in the middle.
```java
List<String> list = new ArrayList<>();
list.add("Java");
list.add("Python");
```

**🔥 LinkedList** — Doubly linked list; fast insertion/deletion; slow random access.
```java
List<String> list = new LinkedList<>();
```

---

### 🔒 Set (No Duplicates)
Does **NOT** allow duplicate elements.

**🔥 HashSet** — No guaranteed order; fast (`O(1)` average).
```java
Set<String> set = new HashSet<>();
set.add("Java");
```

**🔥 LinkedHashSet** — Maintains **insertion order**.

**🔥 TreeSet** — Elements stored in **sorted order**; backed by Red-Black Tree; `O(log n)`.

---

### 🔄 Queue (FIFO Structure)
Used for processing elements in **First-In, First-Out** order.
```java
Queue<Integer> q = new LinkedList<>();
q.add(1);
q.poll(); // removes and returns head
```

---

### 🗺️ Map (Key-Value Pair)
`Map` is **NOT** part of the `Collection` interface. It stores data as **Key → Value** pairs.

**🔥 HashMap** — No guaranteed order; allows one `null` key; fast lookup `O(1)`.
```java
Map<String, Integer> map = new HashMap<>();
map.put("Java", 1);
```

**🔥 LinkedHashMap** — Maintains **insertion order**.

**🔥 TreeMap** — Keys stored in **sorted order**; `O(log n)`.

---

### 🆚 Collections Quick Reference
| Type | Implementation | Order | Duplicates | Speed |
| --- | --- | --- | --- | --- |
| `List` | `ArrayList` | Insertion | ✅ Yes | Fast random access |
| `List` | `LinkedList` | Insertion | ✅ Yes | Fast insert/delete |
| `Set` | `HashSet` | ❌ None | ❌ No | O(1) |
| `Set` | `LinkedHashSet` | Insertion | ❌ No | O(1) |
| `Set` | `TreeSet` | Sorted | ❌ No | O(log n) |
| `Map` | `HashMap` | ❌ None | Keys unique | O(1) |
| `Map` | `LinkedHashMap` | Insertion | Keys unique | O(1) |
| `Map` | `TreeMap` | Sorted keys | Keys unique | O(log n) |

### 🧠 What Actually Happens in Memory?
```java
List<String> list = new ArrayList<>();
```
- The JVM creates an **`ArrayList` object** in the **Heap**.
- The reference variable `list` is of type `List` (the interface).
- `list` can **only access methods defined in the `List` interface** — even though the actual object is an `ArrayList`.

> 💡 This is **Programming to an Interface** in action — you gain flexibility to swap `ArrayList` for `LinkedList` without changing any other code.

### 🔑 Parent Reference → Child Object (Allowed)
```java
List<String> list = new ArrayList<>();  // ✅ Allowed
```

### ❌ Reverse NOT Allowed
```java
ArrayList<String> list = new List<>();  // ❌ Not allowed
```
> Because an **interface cannot be instantiated** — it has no object of its own.

---

## Exception Handling
An **exception** is an event that disrupts the normal flow of a program.
```java
int x = 10 / 0;   // ArithmeticException → program crashes if not handled
```

### ❓ Why Do We Need Exception Handling?
| Without Handling | With Handling |
| --- | --- |
| Program terminates | Program continues |
| No graceful recovery | Errors handled properly |
| Bad user experience | Resources cleaned safely |

### 🌳 Exception Hierarchy
```
Throwable
 ├── Error                    (serious system issues — not meant to be handled)
 └── Exception
      ├── Checked Exception   (compile-time — must be handled)
      └── RuntimeException    (unchecked — occurs at runtime)
```

### 🔢 Types of Exceptions

**1️⃣ Checked Exceptions** — checked at **compile-time**, must be handled.
```java
FileReader file = new FileReader("test.txt");  // ❌ must handle IOException
```
*Examples:* `IOException`, `SQLException`, `FileNotFoundException`

**2️⃣ Unchecked Exceptions (Runtime)** — not checked at compile-time.
```java
String s = null;
s.length();  // NullPointerException at runtime
```
*Examples:* `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`

**3️⃣ Errors** — serious system issues, not meant to be handled.
*Examples:* `OutOfMemoryError`, `StackOverflowError`

---

### 🔑 Exception Handling Keywords
Java provides 5 main keywords: `try`, `catch`, `finally`, `throw`, `throws`

**`try-catch`**
```java
try {
    int x = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

**Multiple `catch` Blocks** — most specific exception must come first.
```java
try {
    // code
} catch (NullPointerException e) {
    // handles null
} catch (ArithmeticException e) {
    // handles arithmetic
}
```

**`finally` Block** — always executes; used for closing files, DB connections, etc.
```java
try {
    int x = 10 / 0;
} catch (Exception e) {
    System.out.println("Error");
} finally {
    System.out.println("Always runs");
}
```

**`throw`** — manually throw an exception.
```java
if (age < 18) {
    throw new IllegalArgumentException("Age must be >= 18");
}
```

**`throws`** — declares that a method may throw an exception (caller must handle it).
```java
void readFile() throws IOException {
    FileReader file = new FileReader("test.txt");
}

### 🔁 Exception Propagation
If an exception is **not handled** in the current method, it moves **up the call stack** until it finds a matching `catch` block or crashes the program.

### 📋 Stack Trace
A stack trace shows the **method call path** where the exception occurred — useful for debugging to trace exactly where things went wrong.

---

## Multithreading
Multithreading means running **multiple threads concurrently** inside a single program.

> A **thread** is the smallest unit of execution inside a process.

### ❓ Why Multithreading?
```
Without: Task1 → completes → Task2 → completes → Task3   (sequential)
With:    Task1 ┐
         Task2 ├── running in parallel
         Task3 ┘
```

**Benefits:**
- Better CPU utilization
- Faster execution
- Responsive applications
- Concurrency handling

### 🆚 Process vs Thread
| Feature | Process | Thread |
| --- | --- | --- |
| **Weight** | Heavyweight | Lightweight |
| **Memory** | Own memory space | Shared memory |
| **Creation** | Slower | Faster |
| **Relationship** | Independent | Runs inside a process |

---

### 🔧 How to Create a Thread in Java
There are 3 main ways:
1. **Extend `Thread` class**
2. **Implement `Runnable`**
3. **Use Executor Framework** *(recommended)*

**1️⃣ Extending `Thread` Class**
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

MyThread t = new MyThread();
t.start(); // ✅ Always call start(), not run() directly!
```
> ⚠️ Calling `run()` directly just executes it as a normal method — it does **NOT** create a new thread.

**2️⃣ Implementing `Runnable` (Better Approach)**
```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Task running");
    }
}

Thread t = new Thread(new MyTask());
t.start();
```
**Why it's better:**
- Java doesn't support multiple class inheritance — implementing `Runnable` keeps the class free to extend another class.
- More flexible and reusable.

**3️⃣ Using Lambda (Modern Way)**
```java
Thread t = new Thread(() -> {
    System.out.println("Running");
});
t.start();
```

---

### 🔄 Thread Lifecycle States
| State | Description |
| --- | --- |
| **1️⃣ New** | Thread object created, not yet started |
| **2️⃣ Runnable** | `start()` called, waiting for CPU |
| **3️⃣ Running** | CPU assigned, `run()` executing |
| **4️⃣ Blocked / Waiting** | Waiting for a resource or another thread |
| **5️⃣ Terminated** | `run()` has completed |

---

## Synchronization
*⭐ Very Important*

**Problem:** Multiple threads sharing memory can cause inconsistent results.

```java
class Counter {
    int count = 0;

    void increment() {
        count++;  // ⚠️ Not atomic — race condition possible
    }
}
```
If two threads call `increment()` at the same time → **race condition**.

**✅ Solution: `synchronized`**
```java
synchronized void increment() {
    count++;
}
```
Now **only one thread** can execute `increment()` at a time — others must wait.

---

### ⚠️ Race Condition
Occurs when **multiple threads modify shared data** without proper synchronization, leading to unpredictable results.

---

### 🔊 `volatile` Keyword
Used to ensure **visibility** of changes across threads. Forces the JVM to read/write the variable directly from/to main memory, bypassing thread-local caches.
```java
volatile boolean flag = true;
```
> Ensures other threads always see the latest value of `flag`.

---

### 🔒 Deadlock
Occurs when **two threads wait for each other forever** — neither can proceed.

```
Thread 1: locks A → waits for B
Thread 2: locks B → waits for A
→ Program freezes 🧊
```

---

## Executor Framework *(Best Practice)*
Instead of manually creating threads, use the **Executor Framework** for thread pooling and efficient resource management.

```java
ExecutorService executor = Executors.newFixedThreadPool(2);

executor.submit(() -> {
    System.out.println("Task running");
});

executor.shutdown(); // always shut down when done
```

**Why it's better than manual threads:**
- **Thread pooling** — reuses a fixed number of threads instead of creating new ones each time
- **Efficient resource management** — avoids overhead of thread creation/destruction
- Cleaner and more scalable code

### 🔊 `volatile` in Action
```java
volatile boolean flag = true;
```
- Thread 1 updates `flag` → value is written **directly to main memory**.
- Thread 2 always reads the **latest value** — no stale cache, no infinite loop.

---

## Lambda Expressions
A lambda expression is a **short way to implement a functional interface** (an interface with exactly one abstract method).

> 👉 It lets you write anonymous functions in Java.

### 📜 Before Java 8 (Verbose)
```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running");
    }
};
```

### ✅ After Java 8 (Lambda)
```java
Runnable r = () -> System.out.println("Running");
```

### 🔢 Types of Lambda Forms
```java
// No parameters
() -> System.out.println("Hi");

// One parameter
x -> x * x

// Multiple parameters
(a, b) -> a + b

// Multiple statements
(a, b) -> {
    int result = a + b;
    return result;
}
```

---

## Functional Interfaces
A **functional interface** has exactly **ONE abstract method**. It can have multiple `default` or `static` methods.

```java
@FunctionalInterface
interface MyInterface {
    void display();
}

MyInterface obj = () -> System.out.println("Hello");
obj.display();
```

---

## Streams API
Streams process **collections in a functional style** — cleaner and more expressive than loops.

**Before Java 8:**
```java
for (int n : list) {
    if (n % 2 == 0)
        System.out.println(n);
}
```

**With Streams:**
```java
list.stream()
    .filter(n -> n % 2 == 0)
    .forEach(System.out::println);
```

---

## Optional
Used to **avoid `NullPointerException`**.

```java
// ❌ Without Optional — can throw NPE
String name = null;
System.out.println(name.length());

// ✅ With Optional
Optional<String> name = Optional.ofNullable(null);
System.out.println(name.orElse("Default")); // "Default"
```

---

## Method References
A **shorter way to refer to methods** using `::` instead of writing a full lambda.

```java
// Lambda
list.forEach(x -> System.out.println(x));

// Method Reference (equivalent)
list.forEach(System.out::println);
```

---

## I/O in Java
**I/O = Input / Output** — Java supports reading and writing data from/to various sources.

**Sources include:**
- Files
- Console
- Network
- Memory

### 🔢 Types of I/O Streams

**1️⃣ Byte Streams** — used for **binary data** (images, videos, audio)
- `InputStream` — reads raw bytes
- `OutputStream` — writes raw bytes

**2️⃣ Character Streams** — used for **text data**
- `Reader` — reads characters
- `Writer` — writes characters

### 🔹 FileReader
Used to **read character data from a file**.
```java
FileReader fr = new FileReader("test.txt");
int ch;
while ((ch = fr.read()) != -1) {
    System.out.print((char) ch);
}
fr.close();
```

### 🔹 BufferedReader
A **wrapper around `Reader`** that improves performance by reading large chunks at once instead of one character at a time.
```java
BufferedReader br = new BufferedReader(new FileReader("test.txt"));
String line;
while ((line = br.readLine()) != null) {
    System.out.println(line);
}
br.close();
```

### 🔹 Scanner
Used for **easily reading input** from a file or console.
```java
Scanner sc = new Scanner(System.in);   // from console
String name = sc.nextLine();

Scanner sc = new Scanner(new File("test.txt")); // from file
```

---

## NIO (New I/O)
Introduced in **Java 1.4**, significantly improved in **Java 7**.

NIO is a **faster, scalable, non-blocking I/O** framework — ideal for high-performance applications handling many connections.

---

## POJO — Plain Old Java Object
A **POJO** is a simple Java class **not bound to any special framework rules or restrictions**.

```java
class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() { return name; }
    public int getAge()     { return age; }

    // Setter
    public void setName(String name) { this.name = name; }
}
```
> ✅ No framework annotations, no special base classes — just a clean, reusable Java class.
```
