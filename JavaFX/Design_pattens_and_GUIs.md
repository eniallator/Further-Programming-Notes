# Notes

## Lambdas Again

- E.g

```java
button.addActionHandler(e -> {reactToButton();});
```

## Design Patterns

- Reusable templates for solving problems
  - Not a solution, but an approach
  - Not just for one problem domain
  - Not just for Java
  - Not describing a single class, but patterns of relationships and interactions
  - Best practice responses to common situations, with well understood implications

### Model - View - Controller

- Model: data and methods for manipulating it
- View: the visual representation of the data
- Controller: handling of user
  - Including arranging the view into a UI

#### Interaction

![Interaction diagram](get.this.link.from.the.slides)

#### MVC Relationships

- View gets data to display
- Controller interprets user input and causes the correct model methods to be called with the relevant data
- Changes to the model may update the view
- Some controller actions may just change the view
- Some view components do double service as input and so forward

#### Building MVC Applications

- Each of the MVC may take up multiple objects of various classes to realise
- Each class is cohesive: it either does the model or view or controller
- The view won't care about internal representations
- The model won't care about the view, formatting etc.
- The model won't care about the input components used
- Possible to rewrite any one of model, view or controller alone, e.g use a command-line view

#### MVC in JavaFX

- If we programmatically use JavaFX, we're using a "seperable model architecture" rather than MVC
- The view and controller are tightly bound, even disible
- Which matches our note that some display components also capture input and forward to the controller
- If we declare the view using FXML, then we have better separation
