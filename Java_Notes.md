# Notes

## HashCode

- `Object.hashCode();`
- An Object method that you can override
  - Used for HashMap, HashSet, etc.

## Equals

- `Object.equals();`
- Used when doing comparisons between objects - better than doing `==` since that compares the pointer references

## Scope Modifiers

![Image of Java modifiers](https://www.programcreek.com/wp-content/uploads/2011/11/access-level.png 'Java Modifiers')

- Avoid using anything but `private` for fields
- Scope justification order:
  - `private`
  - No scope modifier
  - `protected`
  - `public`
- Go through the previous modifiers and if you need to go to the next level and there's good justification to do so, then you can

## Abstract Method

- A method in the super class that doesn't have a body, that will have to be overridden in a subclass
- Only provide a method signature
- E.g

```java
public abstract getMostEfficientSpeed();
```

## Types Of Classes

### Abstract Class

- Cannot be instantiated to create an object, can only be inherited
- E.g

```java
public abstract class Vehicle { ...
```

- Fields can be in abstract classes
- They cannot be overridden though
- Ways to overcome this:
  - Make getters/setters for the field
    - Then override the getters/setters if you want to add your own
- No abstract fields

### Concrete class

- A class that can be instantiated
- Has to override all the abstract methods to be complete

### E.g

```java
public abstract class Vehicle {
  public void vroom() {
    System.out.println("vroom vroom");
  }
  public int getMaxSpeed();
}

public class Car {
  @Override
  public int getMaxSpeed() {
    return 69;
  }
}
}

public class Boat {
  @Override
  public int getMaxSpeed() {
    return 420;
  }

  @Override
  public void vroom() {
    System.out.println("whoosh whoosh");
  }
}
```

### Abstract JDK Classes

- Number
- AbstractCollection

## Summary

- Static vs dynamic types
  - Static - compile time
  - Dynamic - run time
- Method overriding
- Method lookup works from dynamic type through the super types
- Method polymorphism
- super, instanceof
- toString, hashCode, equals
- private, default, protected, public
- abstract classes/methods
