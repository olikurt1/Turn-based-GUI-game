Module Code: CS1OP
Assignment report Title: Project
Student Number: az003784
Actual hrs spent for the assignment: 53
Which Artificial Intelligence tools used: Claude.ai, Codex


# Report

## Introduction

The project is a single player GUI interface survival mode turn based combat game. The project includes the main source code for the game along with resources such as images and a save game data file. Furthermore, the game uses Maven for build configuration and project configuration. It includes a pom.xml file with all the configurations for Maven. Along with this the game has a test directory which includes JUnit tests for the important components of the game. The objectives of the project is to show good object-oriented programming practices including clean, readable code, effective implementation of design patterns and scholarship. It also shows effective error handling. 

## AI support in Software Development

### How AI tools were used
AI tools such as Codex and Claude were used in the development of this project. The most important and main in which these tools were used was when converting the game from text based to GUI based. This is because I didn't have previous exposure to the libraries and syntax for GUI creation and customisation in Java. The start menu was done using AI completely as it was the example that exposed me to the javax and swing libraries. After this, I implemented the rest of the GUIs on my own using the boilerplate in the start menu and further research to understand how the different syntax affects the behaviour and look of the GUI's. AI tools were also used to help with converting the GUI's into one window and having them a separate JPanels instead of JFrames. 

AI was also used implement the strategy design pattern for CombatAction, DodgeAction and AttackAction.
![image alt text](<resources/Screenshot 2026-05-06 151405.png>)
![image alt text](<resources/Screenshot 2026-05-06 151426.png>)

These images show codex providing the syntax for the strategy design pattern that was used to categorise the dodge and attack action for the player to choose from.

### Benefits of AI tools

The benefits of using AI tools is that it allows significant improving and upgrading to a program through providing the solutions to implement the improvement. Furthermore, AI tools also help with optimising programs and codebases which can make the game more responsive. Along with this, using AI tools can also include the automated use of Agentic AI such as Claude Code and Codex. This can be extremely benefical as it can provide LLM's with access directly to a project folder and it can have AI implement changes to the project directly rather than just generating syntax that has to be copy, pasted and check if it even works with the rest of the codebase. 

### Challenges of limitations of AI tools

The challenges and limitations of using AI are also a significant factor. One challenge is that LLM's have limited context windows. This means that after a certain amount of messages it starts forgetting previous messages and as a result future results could be hallucinated or not factor in the codebase context enough where the results don't fit with the codebase and can cause errors which need debugging and further prompting or manual resolution. Another limitation of using AI is over reliance. This can lead to a lack of understanding of the codebase and when debugging needs to occur it can become impossible to resolve due to not understanding why an error is ocurring. Getting AI to debug may seem like the correct move but as mentioned before, the context window would likely be too small to process the codebase and then also correctly debug.

### Overall impact on learning and development

The overall impact on learning is that it provided me with knowledge on how to create GUI's in Java using relevant libraries and also how to configure projects using build tools such as Maven. It also taught me an important concept of saving data to JSON files and loading data back from that JSON file which is essentially the smalled and most basic version of a database. AI also helped me reinforce and learn how to implement the OOP concepts such as encapsulation, abstraction etc. The overall impact on development is that it sped up the development of the game. Specifically, it helped with repetitive tasks like GUI JPanel boilerplate and finding logical errors that I may have missed and wouldn't have been able to find otherwise.

## Software Patterns in the Project

I implemented the Factory, singleton and strategy design pattern. The factory design pattern was used for room, enemy and weapon creation. By using the factory design pattern, these components which had inherited types could be created as their parent type and created using the same function. Eg: the rifle, pistol and melee classes all inherit Weapon class and by using WeaponFactory, these classes can be generated as objects of Weapon class type and all generated using the same createWeapon() function. 

The singleton design pattern is used to always reference the same game object instance rather than a new game object be initialised every time an object such as player within the game class needs to be referenced. 

The strategy design pattern is used with the CombatAction interface which identifies the single execute method which all strategies (attack and dodge) must implement. The separate algorithms are hidden from the code that calls the strategy pattern. The action listener relevant to the separate algorithms only sees the CombatAction interface. 

### Benefits of using software patterns

The benefits of design patterns includes reusability of proven solutions to problems that may arise again. If I were to add a new room type or weapon then I only have to create a new class and update the relevant factory. Another benefit is separation of concerns meaning if a components logic has to change then I don't have to adapt other components or main game logic. Eg: updating the AttackAction only means changing the class without having to adjust anything else in the codebase. Testing is also easier due to loose coupling meaning individual components can be tested. 

### Challenges and limitations

Overengineering is a common limitation where patterns are implemented when not needed. This can increase complexity unnecessarily where hypothetical problems are fixed rather than real ones. Misapplication of patterns can lead to more problmems than implementing the pattern in the first place. Another limitation is additional performance overhead because these patterns can require additional object creation or method execution before an inherited or relevant class to the pattern can be generated. This requires more execution and potentially doesn't optimise a codebase the way a pattern should. 

### Overall impact on project

The patterns mean that the project can be scaled and much more readable. By using factories and strategies, I am able to customise and expand assets. I can increase the different weapon types by just creating a new class and adding it to the factory. I can also increase the different room types by making a class which inherits room and add to room factory. The strategy pattern means complexity is highly reduced as branching is minimise since different options are their own classes that are called based on buttons such as AttackAction and DodgeAction. 

## Ethical and Legal Considerations

### Ethical concerns on AI tools

Over reliance of AI tools means that it could hinder understanding and learning of the actual project. This is because a feature may be prompted to add despite me/student not understanding how the syntax works or the syntax at all. Over-relying on AI means students don't learn anything because they don't feel they have to as the feature/project works. 

Bias in AI tools is also an ethical concern because the results that it produces are based on the data its trained on. This means it outputs the most frequent patterns and results that it has received in its dataset. This is fine in a general sense but such results aren't always compatible or best for a specific project as unnecessary complexity may arise. 

Academic integrity is the ethical issue between using AI as a learning tool and AI as a crutch to do the work itself. It means that students lose the point of the project in the first place which is to learn and reinforce OOP. While the project says to use AI for a design pattern, students may misunderstand this as use AI to create the pattern and forget about it without understanding it ever. Similarly, AI is good enough to generate the entire project on its own and a student can pass it along as their own work.

### Data handling and privacy

Relevant data stored includes a username. The player has the freedom of creating their own username. This means they could use their real name. Based on GDPR, user's data should be stored as long as there is consent. This can raise an issue with my project as username is stored in the JSON file. This is the only personal data attribute thats stored which means that it doesn't necessarily idenitfy one singular person. However, it potentially does so this has to be taken into consideration. It should also be considered that the username isn't used for anything within the game so could be removed completely as a feature. 

### Broader ethical and legal implications

Misuse issues have to be covered as well. While its not harmful in a visual sense the context of the game could be inappropriate for a younger audience. It also lack accessibility for people with disabilities. It doesn't include colourblind options but users who require such can adjust their display settings. It doesn't include screen reader compatibility for blind people either which limits that demographic from playing. Licensing also has to be taken into account such as using existing code covered by MIT license from GitHub etc. Some AI generated code is also licensed however based on Anthropic terms all AI generated code created by Claude is owned by the user so isn't under license. It does include the open source Apache license for Maven but since its open source its accessible for free by anyone.

## Conclusion

This project allowed me to experience how AI tools can be used to assist and optimise the workflow of a project. By using Codex I learned how agents work within a project and how they can implement code themselves. I also learned how OOP theoretical concepts such as encapsulation can be implemented in a real project along with design patterns also look in a real codebase.I learned how to implement Apache Maven into the project and use it for official testing libraries and compilation. I also learned how to create a Java GUI. To improve this project I'd look at turning the game into an open world and letting the player move around regions using standardised keys like WASD for movement. Using AI to implement this would be beneficial as long as it works well with the existing codebase and is understood for future documentation.

Tests are logged in test-results.txt

Project URL: [Project](https://csgitlab.reading.ac.uk/az003784/cs1op-textgame)
