# Kotlin
This project will be a medium to learn kotlin from the basic to advanced how to build an app with kotlin language

## Kotlin introduction
Kotlin is a JVM based language develop by JetBrains that was created with Java developers in mind, 
and with Intellij as its main development IDE.

These are advantages of Kotlin when compared to Java 6:
- More expressive: we can write more with much less code
- Safer: Kotlin is null safe, which means that we deal with possible null situations in compile time, to prevent execution time exceptions. We need to explicitly specify  that an object can be null, and then check its nullity before using it.
- Functional: Not a pure functional language but It uses many concepts from functional programming, such as lambda expressions, to solve some problems in a much easier way. And also the way it deals with collections.
- Extension functions: We can extend any class even if we don’t have access to the source code.
- High interoperable: It’s possible to create mixed project, with both Kotlin and Java files coexisting because the interoperability between both languages is excellent

### Classes and Objects
#### Classes and Inheritance
The Class declaration in Kotlin consist of the class name, class header (specifying its type parameter, the primary constuctor etc.)
and the class body, surrounded by curly braces. But the header and the body are optional. For the example:
`class Employee { /*...*/}`
**Constructors**
A class in Kotlin can have a **primary constructor** and one or more **secondary constructor**. The primary constructor is part of the class header.
```kotlin
class Employee constructor(firstName: String) { /*...*/ }
```

The primary constructor cannot contain any code. Initialization code can be placed in **initializer blocks**, which are prefixed with the **init** keyword.
```kotlin
class Employee(firstName: String) {
    val firstProperty = "First property: $firstName".also(::println)
    init {
        println("First initializer block that prints $firstName")
    }
    val secondProperty = "Second property: ${firstName.length}".also(::println)
    init {
        println("Second initializer block that prints ${firstName.length}")
    }
}
```

During  an instance initialization, the initializer blocs are executed in the same order as they appear in the class body.
**Secondary Constructor**
The class can also declare **secondary constructors**, which are prefixed with constructor:
```kotlin
class Person(val name: String) {
    var children: MutableList<Person> = mutableListOf<Person>();
    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }
}
```

Creating instances of classes
To create an instance of a class, we call the constructor without using **new** keyword, for example:
`val person = Person()`
`val employee = Employee("Joe Smith")`

**Inheritance**
By default, Kotlin classes are final: they can't be inherited. Use `open` keyword to make a class inheritable;
```kotlin
open class Base(p: Int)

class Derived(p:Int) : Base(p)
```

**Abstract classes**
May be declared as abstract to a class and some of its members. An abstract member does not have an implementation in its class.
```kotlin
open class Person {
    open fun hobby() {}
}

abstract class Children : Person() {
    abstract override fun hobby()
}
```

**Companion Object**
Companion object used to write a function that can be called withoud having an instances of the class but need access to internals of class

#### Interfaces
Interface in kotlin can contain declaration of abstract methods, as well as method implementations. The Difference from abstract classes
is that interfaces cannot store state and it can have properties but need to be abstract or to provide accessor implementations.
```kotlin
interface Named {
    val name: String
}
interface Person : Named {
    val firstName: String
    val lastName: String

    override val name: String
        get() = "$firstName $lastName"

    fun saveName()
}
class Employee(
    override val firstName: String,
    override val lastName: String
) : Person {

    override fun saveName() {
        println("Your name $name is saved")
    }
}
```

#### Data Classes
In kotlin to create classes whose main purpose is to hold data, we can use *data class*.
```kotlin
data class Movie(val name: String = "", val genre: String = "")
```
This class will automatically derives the members from all the properties declared in the primary constructor in the compiler time:
* equals()/hashCode() pair
* toString() of the form "User(name=John, age=42)"
* componentN() functions corresponding to the properties in their order of declaration
* copy() function

#### Sealed Classes
To declared a sealed class, we use `sealed` keyword before the name of the class. This classes are used to representing 
restricted class hirarchies, when a value can have one of the types from a limited set, but cannot have any other type.
```kotlin
sealed class Expr

fun eval(expr: Expr): Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
    // the `else` clause is not required because we've covered all the cases
}
```

#### Enum Classes
To declared a enum class, we use `enum` keyword before the name of the class. Each enum constant is an object. Enum constants are separated with commas
```kotlin
enum class Direction {
     NORTH, SOUTH, WEST, EAST
 }
```
**Implementing Interfaces in Enum Classes**
An enum class may implement an interface, as an example:
```kotlin
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
        PLUS {
            override fun apply(t: Int, u: Int): Int = t + u
        },
        TIMES {
            override fun apply(t: Int, u: Int): Int = t * u
        };

        override fun applyAsInt(t: Int, u: Int) = apply(t, u)
    }
```

#### Objects
**Object Expressions**
To create an object of an anonymous class that inherits from some type (or types), and code in object expression can access variables
from the enclosing scope.
```kotlin
fun countClicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent) {
            enterCount++
        }
    })
    // ...
}
```

**Object Declarations**
Object declaration is not an expression, and cannot be used on the right hand side of an assignment statement. 
Singleton may be useful in several cases, and Kotlin (after Scala) makes it easy to declare singletons:
```kotlin
object DataProviderManager {
    fun registerDataProvider(provider: DataProvider) {
        // ...
    }

    val allDataProviders: Collection<DataProvider>
        get() = // ...
}
```
Object declaration's initialization is thread-safe and done at first access.
Such objects can have supertypes:
```kotlin
object DefaultListener : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) { ... }

    override fun mouseEntered(e: MouseEvent) { ... }
}
```

**Companion Objects**
An object declaration inside a class can be marked with the `companion` keyword:
```kotlin
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}
```
Semantic difference between object expressions and declarations:
* object expressions are executed (and initialized) immediately, where they are used
* object declarations are initialized lazily, when accessed for the first time
* a companion object is initialized when the corresponding class is loaded (resolved), 
matching the semantics of a Java static initializer

#### Type Aliases
Type aliases provide alternative names for existing type. If the type name it too long you can introduce a 
different shorted name and use the new one instead.
```kotlin
typealias NodeSet = Set<Network.Node>

typealias FileTable<K> = MutableMap<K, MutableList<File>>
```
Type aliases do not introduce new types. They are equivalent to the corresponding underlying types. 
When you add typealias Predicate<T> and use Predicate<Int> in your code, the Kotlin compiler always expands it to (Int) -> Boolean.
Thus you can pass a variable of your type whenever a general function type is required and vice versa:

```kotlin
typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Int>) = p(42)

fun main() {
    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f)) // prints "true"

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p)) // prints "[1]"
}
```
#### Delegation
**Implementation by Delegation**
The *Delegation Pattern* has proven to be a good alternative to implementation inheritance.
```kotlin
interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
}
```
The by-clause in the supertype list for Derived indicates that b will be stored internally in objects of Derived 
and the compiler will generate all the methods of Base that forward to b.

**Delegation Properties**
Simply put, delegated properties are not backed by a class field and delegate getting and setting to another piece of code.
Delegated properties are used by declaring the property and the delegate that it uses. 
The by keyword indicates that the property is controlled by the provided delegate instead of its own field.
```kotlin
class DatabaseDelegate<in R, T>(readQuery: String, writeQuery: String, id: Any) : ReadWriteDelegate<R, T> {
    fun getValue(thisRef: R, property: KProperty<*>): T {
        return queryForValue(readQuery, mapOf("id" to id))
    }
 
    fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        update(writeQuery, mapOf("id" to id, "value" to value))
    }
}

class DatabaseUser(userId: String) {
    var name: String by DatabaseDelegate(
      "SELECT name FROM users WHERE userId = :id", 
      "UPDATE users SET name = :value WHERE userId = :id",
      userId)
    var email: String by DatabaseDelegate(
      "SELECT email FROM users WHERE userId = :id", 
      "UPDATE users SET email = :value WHERE userId = :id",
      userId)
}
```

**Standard Delegates**
1. Lazy
The lazy delegate allows the value of a property to be computed only on first access and then cached
```kotlin
class DatabaseBackedUser(userId: String) {
    val name: String by lazy {
        queryForValue("SELECT name FROM users WHERE userId = :userId", mapOf("userId" to userId)
    }
}
```
2. Observable
The observable delegate allows for a lambda to be triggered any time the value of the property changes
```kotlin
class ObservedProperty {
    var name: String by Delegates.observable("<not set>") {
        prop, old, new -> println("Old value: $old, New value: $new")
    }
}
```

### Function and Lambdas
#### Function
Functions in Kotlin are declared using the fun keyword:
```kotlin
fun double(x: Int): Int {
    return 2 * x
}
val result = double(2)
```

**Unit-returning functions**
If a function does not return any useful value, its return type is Unit. 
Unit is a type with only one value - Unit. This value does not have to be returned explicitly:
```kotlin
fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello ${name}")
    else
        println("Hi there!")
    // `return Unit` or `return` is optional
}
```

**Variable number of arguments(Varags)**
A parameter of a function (normally the last one) may be marked with vararg modifier
```kotlin
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

val list = asList(1, 2, 3)
```
if we already have an array and want to pass its contents to the function, 
we use the spread operator (prefix the array with *)
```kotlin
val a = arrayOf(1, 2, 3)
val list = asList(-1, 0, *a, 4)
```

**Infix notation**
Functions marked with the infix keyword can also be called using the infix notation 
(omitting the dot and the parentheses for the call). Infix functions must satisfy the following requirements:
- Must be member functions or extension functions
- Must have a single parameter
- Must not accept variable number of arguments and must not have no default value
```kotlin
infix fun Int.shl(x: Int): Int { ... }
// calling the function using the infix notation
1 shl 2

// is the same as
1.shl(2)
```
Note that infix functions always require both the receiver and the parameter to be specified. 
When you're calling a method on the current receiver using the infix notation, you need to use this explicitly
```kotlin
class MyStringCollection {
    infix fun add(s: String) { /*...*/ }
    
    fun build() {
        this add "abc"   // Correct
        add("abc")       // Correct
        //add "abc"        // Incorrect: the receiver must be specified
    }
}
```

**Generic Functions**
Function can have generic parameters which are specified using angle brackets before the function name
`fun <T> singletonList(item: T): List<T> { /*...*/ }`

**Tail Recursive Function**
This allows some algorithms that would normally be written using loops to instead be written using a recursive function, 
but without the risk of stack overflow
```kotlin
val eps = 1E-10 // "good enough", could be 10^-15

tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))
```

#### Lambdas
A lambda is a way of representing a function and if we wanted to defince that function, here the example:
`fun setOnClickListener(listener: (view: View) -> Unit){}`
This known as a **Higher-Order Function**, because it is a function that receives a function by parameter, 
or that returns a function.

**Inline Functions**
The ugly part of receiving functions as an argument is that the compiler needs to create classes for them, 
which can impact the performance. But this can be easily solved by using the reserved word *inline*
```kotlin
inline fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}

toast("Hello World")
```