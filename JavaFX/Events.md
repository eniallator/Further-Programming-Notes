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

#### Solution - Inner Classes

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

#### Style Notes

- Inner classes put at the end of the code, rather than scattered about
- Registering the listener with the event source component is sufficient, no need to assign to a variable
- Usually specialised and cohesive
- One instance per class

#### Anonymous Inner Classes

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

#### More Style Notes

- Using a class per event source to handle events removes the need for a method which knows lots of different objects, which will become complex and lack cohesion
- Inner classes give nicely cohesive code - one class, one issue
- Anonymous inner classes remove the naming problem
- But long anonymous inner classes are hard to read
