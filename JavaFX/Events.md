# Notes

- FEESH
- Also fizz buzz stuff
  - Lets look at the code a little closer 🔎
  - LETS INTEROGATE THE FUCK OUT OF THE PROPERTIES
    - _**FBI OPEN UP**_

## Events

- When something happens, an event is raised
- In JavaFX, input components can raise events
  - Button clicked or menu item selected, causes an `ActionEvent`
  - Frame closed or minimised, causes a `WindowEvent`
  - etc.

## Event Handling

- For events to have a purpose, something must act on them
- Event handlers are objects which are attached to components and handle events that are raised
- To be a handler, the object has to implement the relevant `EventHandler` interface
  - `ActionEvent`s are handled by an `EventHandler<ActionEvent>`
  - Note that the handler is parameterised by the type of the event

### Event Handler Implementation

```java
public interface EventHandler<T extends Event> {
  void handle(T event);
}
```

### Where To Handle

- A single object may do everything
- Not advised though
- Can have multiple handlers for an event

### How To Handle

- `button.setOnAction(handlerObject);`
  - Where `handlerObject` implements `EventHandler<ActionEvent>`
- For a simple user interface, the class doing the creating might also be the listener, so `button.setOnAction(this);`
- Seperating the display and the response soon becomes desirable however

### Lots Of Handler Classes

- Potentially many sources creating events/handlers
- Leading to many files
- Closely coupled to the display class

## Inner Classes

```java
class OuterClass {
  class InnerClass {
    ...
  }
  ...
}
```

- Inner class instance only exists in the outer class instance
- Inner class can see attributes of outer class
- Tight coupling is clearer/cleaner using inner classes rather than sibling classes

### Style Notes

- Inner classes put at the end of the code, rather than scattered about
- Registering the listener with the event source component is sufficient, no need to assign to a variable
- Usually specialised and cohesive
- One instance per class

### Anonymous Inner Classes

- Can use anonymous in-line definitions
- Classes that we don't name

```java
button.setOnAction(new EventHandler<ActionEvent>() {
  public void handle(ActionEvent e) {
    button.blah();
  }
})
```

- Identify the super type of our anonymously typed sub-class - in this case `EventHandler<ActionEvent>`
- Fill in any implementations of abstract and/or interface defined and/or overridden methods - e.g `handle(ActionEvent e)`
- `new SuperType(constructor params) {implemented methods}`

### More Style Notes

- Using a class per event source to handle events removes the need for a method which knows lots of different objects, which will become complex and lack cohesion
- Inner classes give nicely cohesive code - one class, one issue
- Anonymous inner classes remove the naming problem
- But long anonymous inner classes are hard to read

## Lambda Expressions

- A way to declare an anonymous inner class without having to declare which class/do any of the modifiers

### Syntax

```java
(Type1 param1, Type2 param2, ...) -> {
  // Method body
}
```

- Brackets can be removed if there's only a single parameter
- E.g

```java
param -> {
  // Method body
}
```

#### Example JavaFX Usage

```java
button.setOnAction(e -> {button.blah();});
```

- The compiler knows the static type of `button` so knows the argument is an `EventHandler<ActionEvent>`
- An `EventHandler<ActionEvent>` object must implement a void `handle(ActionEvent event)` method
- The specified lamdba expression can then type check to a `void handle(ActionEvent event)` so the compiler can rewrite as an anonymous class

### When To Use Them

- Lambdas reduce verbiage
  1. Use them in places where they are expected
  2. Make sure the method bodies are short
- Lambdas are useful for manipulating collections in functional styles of programming

## More Event Listeners

### Adding A Menu

```java
MenuBar menuBar = new MenuBar();
Menu menu = new Menu("A Menu");
MenuItem menuItem = new MenuItem("Choice 1");
menuItem.setOnAction(e->{doChoice1();});
menu.add(menuItem);
menuItem = new MenuItem("Choice 2");
menuItem.setOnAction(e->{doChoice();});
menu.add(menuItem);
menuBar.add(menu);
pane.setTop(menuBar); // menubar always uses BorderPane
```

### Other Types

- Network messages
- Timers
- Multithreaded code
- We won't go over these

## Events Versus Polling

### Event Pros

- This style of programming is called event driven
  - Your code apparently starts executing from the event handler each time the user does something to cause an event
  - `main` is used to setup and do things that aren't user prompted, but can finish
  - Java deals with keeping the program running whilst the window is open

### Polling Cons

- Have a loop to check each button's state repeatedly
- But you might miss something 😱
- And your program becomes busy waiting or has to block waiting for an event and then sort out what the event is
- The event driven style is usual in modern languages and systems

## Testing

- Can't use JUnit
- Hard to make UI tests automated
- Tools available to help these issues, but won't cover in this module

## Summary

- Mostly JavaFX interfaces covered
  - Components for display
  - Layout for nice display
  - Events for input
- Lambdas, inner and anonymous classes for event handling code
- LOOK SHIT UP

### And Finally

- Netbeans provide graphical tools for making GUIs
  - Create a JFrame
  - Drag components onto a visual layout
  - Set properties and fill in event handling code
- But
  - You need to understand how this works
  - If you know what the tool is doing, you can create cleaner, more efficient interfaces with less effort
