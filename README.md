## Monkey Banana Game 

# Design : 
>The client in our case is a user who uses 2 functions viz key press and key release using the keyboard cursor Keys. The Subject is Monkey which represents n object that possess state dependent behaviour.  which has 2 states, moving and idle and that is modeled using the state machine design. The state class contains 2 methods keyPressed and keyReleased which are again overridden in the 2 concrete classes MonkeyMove and MonkeyIdle which represents the 2 states that the monkey can be in. The Banana has to be eaten in a specified amount of time else it gets repositioned to a different randomly chosen position.


# Implementation:
> The Monkey Banana Game is designed using the Java Swings API.  There are 2 Separate classes for Monkey and Banana. ActionListners  are used to time various events (javax.swing) of the GUI and Event Listeners are used to take the various inputs  from the KeyBoard(KeyEvent and KeyAdapter).  Class MonkeyBananaGame host a Jframe and initializes a Wonderland Class which extends Jpanel where all the GUI events take place. Monkey which represents the subject has got 2 States and those are implemented using MonkeyMove and MonkeyIdle concrete classes; Both these methods overrides the keyPressed and KeyReleased methods which allow the monkey to change states and move according to the inputs provided by the User .
The State Class defines a method for each transition in the state machine and implements it as return self.   Monkey Class delegates the client(Wonderland Class) requests to the corresponding operations of the state object.
 

### More Info & Tech : 
The game is developed in Java and have used JAVA SWINGS API.
The MonkeyBananaClass extends JFrame. The WonderLand class extends JPanel and is the Client Class for the Subject. The Subject in our Case is the Monkey which can exist in 2 possible states MonkeyIdle and MonkeyMove.  The Banana Class represents a banana and the collision between the monkey and the banana is considered to be a eating exercise for the Monkey which is followed by placing the banana in random place using Math.Random Function.  The Monkey has the states and is initialized to the MonkeyIdle State. Based on the Key Press or Release the monkey changes its state and moves left,Right, Up,Down based on the which key is pressed.

If the monkey eats 15 Banana’s in 60 sec, then the player wins else he looses.

**State Transition table** for Monkey Banana Game.

|States / Events|	keyPressed|	keyRelease|
|---------------|:------------:|----------|
|MonkeyIdle|MonkeyMove|	MonkeyIdle|
|MonkeyMove|MonkeyMove|	MonkeyIdle |

**State Diagram**

![alt text](https://github.com/Rudresh-Ajgaonkar/mbgame/blob/master/Data/StateDiagram.png "State Diagram")

**Class Diagram**

![alt text](https://github.com/Rudresh-Ajgaonkar/mbgame/blob/master/Data/ClassDiagram.png "Class Diagram")

