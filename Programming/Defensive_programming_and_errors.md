# Notes

## Errors

- Syntax errors - the program won't compile
- Logic errors - e.g:
  - Wrong algorithm
  - References array with out of bounds index
  - Tries to use variables which haven't been initialised
  - Certain combinations of method calls result in broken state

### Testing

- Testing will catch errors you test for
- There may still be run-time errors, in which case:
  - Testing reduces the set of possible causes
  - When you've found the cause, test for it
- But testing doesn't catch everything

### Untestable (By You) Error

- User input: both mistakes and attacks
- Systems: memory (full/corrupt), disk (full/corrupt), network (message loss/disconnection), external software doing unexpected things (OS/databases/etc)
- Programs that yours interact with doing unexpected things:
  - UI (nicely decoupled code aids the splitting of the task)
  - Servers/clients
- In many cases you will need code that handles the unexpected gracefully as we can't unit test the users, file-system state, network connection, 3rd party state, etc.

### Assumptions

- Can do it in between 2 ways
  - The other party will do what they ought all the time
  - If it can go wrong, it will go wrong

### Whose Fault

- Things behaving unexpectedly depends on perspective
- Documentation helps, but writing it for all cases is difficult
- Not letting your code crash isn't clever

### Audience For Error Messages

- For servers, does validation need to be added?
- For clients, does validation also need to be added?
- Notify the user if there's bad input
- Notifying users:
  - Assume that a human is looking
  - `System.err.println(...)` console message
  - Log file
  - Dialog status box/message in display

## Defensive Programming

### Bad Parameters

- What assumptions are there on the range of values?
- If wrong?
- In particular:
  - Passing `null`s
  - Constructors with bad parameters

### Collections

- If it doesn't return an object
- Does the proceeding code make sense?
- Handling `null`?
- Duplicate record/key?
- ETC.

## Notifying Clients

- If code can fix, it should fix

## Exception Throwing/Handling

- Throwing example:

```java
public String addHello(String s) throws IllegalArgumentException {
  if (s == null) {
    throw new IllegalArgumentException("Passed string cannot be null");
  }
  return "Hello " + s;
}
```

- Catching exceptions example

```java
public String addHelloWorld(String s) {
  try {
    return addHello(s) + "world!";
  } catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
  }
}
```

### Acceptable Empty catch

- If there's an `InterruptedException` that is acceptable to have an empty catch, but you mostly always want to have a catch with a block of code

### Types Of Errors

![Java error type tree](https://i.imgur.com/BbxKFRq.png)

- Unchecked exceptions don't need catching and shouldn't be as it usually indicates you have broken code
- Checked exceptions need catching, it won't compile until you do catch it

## TL;DR

- Lots of shit can go wrong
- Expect and assume everything will go wrong
- Validate all the things
- Tell the client if they need telling
