# Notes

- GUI
- JavaFX
- Stages, scenes and the scene graph
- Controls and components
- Layout and panes

## Why JavaFX

- GUIs use similar design patterns
  - The design patterns are the important learning outcome, not any technology
- JavaFX uses CSS for styling
- Swing is older and can be taught for basics of GUIs

## Program That Runs

- Using tests we have, so far, avoided programs which runs
  - No public static void main
  - No user interface
  - Lets us focus on getting units of code correct, "but doesn't do anything useful in the end" - 🤔🤔🤔🤔🤔🤔🤔

## Types Of User Interfaces

- Command line
  - Has arguments, I/O files, text prompts and responses
- Graphical user interface
  - Windows, buttons, menus, input fields, displays etc.
- Web interface
  - Delegates the interaction to the web browser

## 3 Things A GUI Has

1. What components can be shown to render the UI?
2. How can those components be arranged to create a usable layout? Programmed relationship between components and the display
3. How can user input be captured and reacted to - event handling? Display of a component and reacting to it are handled seperately

## Overloading Interface

- Interface definition
  - Class has an interface
  - Defined and implemented by class
  - User will use an interface to interact with program

## JavaFX And Swing

- JavaFX is pure java implementation for modern java apps
- Can use older swing libraries
- Provides declarative interface for FXML
- Uses CSS
- Integrates with webview

## A First Application

- JavaFX applications extend the `javafx.application.Application` class
- The `main` method must call the `launch()` in the `Application`
  - This creates a new instance of the specified Application
  - The `init()` on the instance is called, should only create `controls`, not scenes/stages
  - The `main` application is entered via the `start(Stage)` method

### Source Code

```java
public class SimpleHelloWorldextends Application {
  @Override
  public void start(Stage ps) {
    Label txt = new Label("HelloWorld");
    FlowPaneroot = new FlowPane();
    root.getChildren().add(txt);
    Scene scene = new Scene(root);
    ps.setTitle("Hello World!");
    ps.setScene(scene);
    ps.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
```

## Stage

- Starting point for the app is a window - can be minmized, resized etc.
- JavaFX calls this a `Stage`
- Will look, more or less, like any other application in the OS
- Acts as a container for the rest of the GUI

## Scene

- Container for all the content
- Within the scene, the content is represented as a hierarchical scene graph
- The `Scene` has a root node; this is typically the `parent` node
- `parent`s can be either:
  - A `Region` which provides an area for controls to have their layout managed and to have CSS applied
  - A `Group` brings together child components such as graphics to be managed together through transforms, but does not have a layout. We won't be focusing on these 😉
