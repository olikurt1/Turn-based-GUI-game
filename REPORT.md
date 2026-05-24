Module Code: CS1OP
Assignment report Title: Project
Student Number: az003784
Actual hrs spent for the assignment: 53
Which Artificial Intelligence tools used: Claude.ai, Codex


#Report

##Introduction
The project is a single player GUI interface survival mode turn based combat game. The project includes the main source code for the game along with resources such as images and a save game data file. Furthermore, the game uses Maven for build configuration and project configuration. It includes a pom.xml file with all the configurations for Maven. Along with this the game has a test directory which includes JUnit tests for the important components of the game. The objectives of the project is to show good object-oriented programming practices including clean, readable code, effective implementation of design patterns and scholarship. It also shows effective error handling. 

##AI support in Software Development
AI tools such as Codex and Claude were used in the development of this project. The most important and main in which these tools were used was when converting the game from text based to GUI based. This is because I didn't have previous exposure to the libraries and syntax for GUI creation and customisation in Java. The start menu was done using AI completely as it was the example that exposed me to the javax and swing libraries. After this, I implemented the rest of the GUIs on my own using the boilerplate in the start menu and further research to understand how the different syntax affects the behaviour and look of the GUI's. AI tools were also used to help with converting the GUI's into one window and having them a separate JPanels instead of JFrames. 

AI was also used implement the strategy design pattern for CombatAction, DodgeAction and AttackAction.
![image alt text](<Screenshot 2026-05-06 151405.png>)
![image alt text](<Screenshot 2026-05-06 151426.png>)
These images show codex providing the syntax for the strategy design pattern that was used to categorise the dodge and attack action for the player to choose from.

The benefits of using AI tools is that it allows significant improving and upgrading to a program through providing the solutions to implement the improvement. Furthermore, AI tools also help with optimising programs and codebases which can make the game more responsive. Along with this, using AI tools can also include the automated use of Agentic AI such as Claude Code and Codex. This can be extremely benefical as it can provide LLM's with access directly to a project folder and it can have AI implement changes to the project directly rather than just generating syntax that has to be copy, pasted and check if it even works with the rest of the codebase. 

The challenges and limitations of using AI are also a significant factor. One challenge is that LLM's have limited context windows. This means that after a certain amount of messages it starts forgetting previous messages and as a result future results could be hallucinated or not factor in the codebase context enough where the results don't fit with the codebase and can cause errors which need debugging and further prompting or manual resolution. Another limitation of using AI is over reliance. This can lead to a lack of understanding of the codebase and when debugging needs to occur it can become impossible to resolve due to not understanding why an error is ocurring. Getting AI to debug may seem like the correct move but as mentioned before, the context window would likely be too small to process the codebase and then also correctly debug.

The overall impact on learning is that it provided me with knowledge on how to create GUI's in Java using relevant libraries and also how to configure projects using build tools such as Maven. It also taught me an important concept of saving data to JSON files and loading data back from that JSON file which is essentially the smalled and most basic version of a database. AI also helped me reinforce and learn how to implement the OOP concepts such as encapsulation, abstraction etc. The overall impact on development is that it sped up the development of the game. Specifically, it helped with repetitive tasks like GUI JPanel boilerplate and finding logical errors that I may have missed and wouldn't have been able to find otherwise.

##Software Patterns in the Project
