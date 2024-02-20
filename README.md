# HexDecConversion

Program created using Apache NetBeans IDE 18. It's main use is to convert values from HEXadecimal system to DECimal system and vice-versa. 

# Changelog:

##### Final v1 - Basic MVC project with cmd interaction.
##### Final v2 - Expanded on Final v1 functionality. Added tests and exceptions. Improved code overall.
##### Final v3 - Expanded on Final v2 functionality. Added GUI using Swing components. Improved code overall.
##### Final v4 - All functionalities  from Final v3. Changed GUI to HTML Servlet format, added cookies. Improved code overall.
##### Final v5 - Expanded on Final v4 functionality. Added database integration to HTML format. Improved code overall.

# Details:

##### FinalV1.0:  

• Console or graphical application,    
• division into class packages according to the model-view-controller (MVC) template,  
• passing command-line invocation parameters to the application,  
• description of the parameter passing order in the "main" method comment,  
• in case of absence or incorrect number of parameters in the invocation line, the application should interact with the user to retrieve data using system streams or GUI,  
• definition and throwing of a custom exception in the model and its handling in the controller,  
• application of "clean" object-oriented approach: components are exclusively private and public; full encapsulation especially of model fields,  
• use of Java naming conventions (identifiers in English),  
• use of meaningful comments in English for all classes, methods, and fields (including private ones),  
• generation of English documentation (javadoc) including author and class version information, descriptions of packages, classes, and interfaces, public class components; method descriptions should include information about parameters, return value, and situations where an exception is thrown, if applicable;  
• correct preparation of the entire report in the form of an archived NetBeans IDE 18 project directory.  

##### FinalV2.0:  

• full scope of the final version of the application from FinalV1.0  
• replacing existing arrays with collections;  
• adding a type-safe collection to the model class due to object types,  
• utilization of the for-each loop  
• utilization of lambda expression (with a defined interface).  
• utilization of stream data processing from collections (at least once),  
• definition of unit tests for all public methods in the model (except constructors, accessors, and mutators)  
• tests should cover correct, incorrect, and boundary situations for each tested unit,  
• each assertion method call should include an additional parameter as a message displayed in case of failure;  
• boundary values from the range of primitive types are not tested,  
• parameterization of all tests,  
• unit tests should be commented.  


##### FinalV3.0:

• scope applicable to the final version of the application from FinalV2.0  
• total change of view from console to GUI developed using Swing components, the console window must remain empty,  
• the project should contain only one main() method,  
• GUI should provide access to all model functionalities,  
• Each control (except for labels) must have a tooltip and be accessible by a keyboard shortcut,  
• GUI should contain at least one compound control such as a list, table, or tree; control elements should be accessible by a scroll bar,  
• input fields should be initialized with program invocation parameters, if any,  
• reaction to exceptional situations should be reported graphically (the console window must remain empty),  
• all messages (especially those informing about incorrectly entered data) should be signaled using methods from the JOptionPane class,  
• the type of the communication window (informational or warning) should be indicated by an appropriate icon,  
• the main model object should be created only once during the application's runtime,  
• the program code must not contain meaningless component identifiers such as jButton1, jButton2, etc.  

##### FinalV4.0:

• application model from FinalV3.0  
• view in the form of a form implemented in HTML and run under the control of a web browser;  
• creation of the model object once to handle all requests (without using the static keyword) throughout the application's lifecycle,  
• at least two servlets with access to the same model object:  
- the first one - implementing access to the computational part of the model,  
- the second one - implementing access to the history of computations (or other data stored in a data collection in the model),  
 
• equal handling of GET and POST methods,  
• handling of missing and incorrect data sent in the service call,  
• informing the client about exceptions occurring in the model,  
• utilization of cookies (writing, reading, and usage in the program other than in the demonstration program). Note! Cookies with spaces or commas inside may not be allowed by the web browser.  

##### FinalV5.0:

• full scope of FinalV4.0  
• automatic creation of a DB schema during the first run of the application (database: lab, user: app, password: app)  
• table and column names should be adequate to the stored data.  
• one-time opening of a connection in the application or one-time creation of an entity manager throughout the application's lifecycle  
• persisting all model operations in the database  
• providing all entries in the database on the website  
• option to clear the contents of the database from the website (e.g., appropriate on-screen button),  
• handling of exceptional situations in the database  
• clear indication in the view of the task's topic:
  - what to enter in which text field,
  - which displayed information is read from cookies,
  - which displayed information is read from the database.
