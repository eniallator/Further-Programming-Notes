# Notes

- Giving us his life story
- Literally just coding in front of us
  - Weird flex, but ok

## Inheritance

- 20 MINS CODING, ALL LEADING TO THIS
  - HOLY SHIT THAT WAS LONG
- TL;DR subclass get's superclass' stuff
- 2manyinheritance4me
- In java, use `class SUBCLASS extends SUPERCLASS`

## Abstraction

- TL;DR getting rid of things u don't need

## Polymorphism

- Context is key
- E.g `+` used for string concatentation and addition
- Can be used with classes as well
  - E.g `SUPERCLASS var = new SUBCLASS();`

```java
Vehicle v;
Car c = new Car();
v = c; // Correct syntax
c = v; // Compiler error
c = (Car)v; // Casting fixes it
```

### More Subtypes

- Can pass sub-types in parameters
- The objects don't change types, but are just held in a variable which has the super type

### Casting

```java
SuperType x = new SubType();
SubType y = (SubType)x;
```

- Doesn't change actual object
- Pushes check of type into run time
- Things will break if using this

## Polymorphic Collections

- Can have superclass objects in a subclass collection
- Easier to iterate over
