# HexDecConversion

Program created using Apache NetBeans IDE 18. It's main use is to convert values from HEXadecimal system to DECimal system and vice-versa. 

# Changelog:

##### Final v1 - Basic MVC project with cmd interaction.
##### Final v2 - Expanded on Final v1 functionality. Added tests and exceptions. Improved code overall.
##### Final v3 - Expanded on Final v2 functionality. Added GUI using Swing components. Improved code overall.
##### Final v4 - All functionalities  from Final v3. Changed GUI to HTML Servlet format, added cookies. Improved code overall.
##### Final v5 - Expanded on Final v4 functionality. Added database integration to HTML format. Improved code overall.

# Details:

Loose translation:  

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

### Original Polish Details:

##### FinalV1.0:

•	aplikacja konsolowa lub graficzna,  
•	podział na pakiety klas wg szablonu model-widok-kontroler (MVC),  
•	przekazywanie parametrów wywołania programu do aplikacji w linii poleceń,  
•	opis kolejności przekazywania parametrów w komentarzu metody "main",  
•	w przypadku braku lub niewłaściwej liczby parametrów w linii wywołania, aplikacja powinna zapewnić interakcję z użytkownikiem w celu pobrania danych z użyciem strumieni systemowych bądź GUI,  
•	zdefiniowanie i rzucenie własnego wyjątku w modelu i jego obsługa w kontrolerze,  
•	stosowanie "czystego" podejścia obiektowego: składniki wyłącznie prywatne i publiczne; pełna hermetyzacja w szczególności pól modelu,  
•	stosowanie konwencji nazewniczej Javy (identyfikatory w języku angielskim),  
•	stosowanie sensownych komentarzy w języku angielskim do wszystkich klas. metod i pól (również prywatnych),  
•	wygenerowanie dokumentacji w języku angielskim (javadoc) uwzględniającej autora i wersję klas oraz opisy pakietów, klas i interfejsów, publicznych składników klas; opisy metod powinny zawierać informacje o parametrach, zwracanej wartości oraz sytuacji, w której rzucany jest wyjątek, jeśli taka ma miejsce;
•	poprawne przygotowanie całości raportu w postaci zarchiwizowanego katalogu projektu NetBeans IDE 18.  

##### FinalV2.0:

•	pełny zakres finalnej wersji aplikacji z FinalV1.0  
•	zastąpienie istniejących tablic kolekcjami;  
•	dodanie kolekcji bezpiecznej ze względu na typy obiektów do klasy modelu,  
•	wykorzystanie pętli for-each  
•	wykorzystanie wyrażenie lambda (ze zdefiniowanym interfejsem).  
•	wykorzystanie strumieniowego przetwarzania danych z kolekcji (przynajmniej jednokrotnie),  
•	zdefiniowanie testów jednostkowych dla wszystkich publicznych metod znajdujących się w modelu (za wyjątkiem konstruktorów, akcesorów i mutatorów)  
•	testy powinny obejmować sytuacje poprawne, niepoprawne i graniczne dla każdej testowanej jednostki,  
•	wywołanie każdej metody asercji powinno zawierać dodatkowy parametr będący komunikatem wyświetlanym w sytuacji jej niespełnienia;   
•	nie testujemy wartościami granicznymi z zakresu wartości typów prostych,  
•	parametryzacja wszystkich testów,  
•	testy jednostkowe powinny być skomentowane.  

##### FinalV3.0:

•	zakres obowiązujący dla finalnej wersji aplikacji z FinalV2.0  
•	całkowita zmiana widoku z konsolowego na GUI opracowane z wykorzystaniem komponentów Swing, okno konsoli musi pozostać puste,  
•	projekt powinien zawierać tylko jedną metodę main(),  
•	GUI powinno zapewniać dostęp do wszystkich funkcjonalności modelu,  
•	Każda kontrolka (poza etykietą) musi być wyposażona w podpowiedź (tooltip) oraz być osiągalna skrótem klawiszowym,  
•	GUI powinno zawierać co najmniej jedną kontrolkę złożoną tj. listę, tabelę lub drzewo; elementy kontrolki powinny być osiągalne paskiem przewijania,   
•	pola wprowadzania danych należy zainicjować parametrami uruchomienia programu, o ile takie będą,  
•	reakcja na sytuacje wyjątkowe powinna być raportowana w formie graficznej (okno konsoli musi pozostać puste),  
•	wszelkie komunikaty (w szczególności informujące o niepoprawnie wprowadzonych danych) powinny być sygnalizowane z użyciem metod z klasy JOptionPane,  
•	typ okienka komunikacyjnego (informacyjne bądź ostrzeżenie) powinien być sygnalizowany odpowiednią ikoną,  
•	główny obiekt modelu powinien być tworzony jednokrotnie w czasie działania aplikacji,  
•	kod programu nie może zawierać nic niemówiących identyfikatorów komponentów np. jButton1, jButton2 itp.  

##### FinalV4.0:

•	model aplikacji z FinalV3.0  
•	widok w postaci formatki zrealizowanej w języku HTML uruchamianej pod kontrolą przeglądarki internetowej;  
•	jednokrotne tworzenie obiektu modelu do obsługi wszystkich żądań (bez użycia słowa kluczowego static) w całym cyklu życia aplikacji,  
•	minimum dwa serwlety z dostępem do tego samego obiektu modelu:   
  - pierwszy - realizujący dostęp do części obliczeniowej modelu,  
  - drugi - realizujący dostęp do historii obliczeń (lub innych danych przechowywanych w kolekcji danych w modelu),
  
•	jednakowa obsługa metod GET i POST,  
•	obsługa braku i błędnych danych przesyłanych w wywołaniu usługi,  
•	informowanie klienta o wyjątkach występujących w modelu,   
•	wykorzystanie ciastek (zapis, odczyt i użycie w programie inne niż w programie demonstracyjnym). Uwaga! Ciastka ze spacją lub przecinkiem w środku, mogą nie być dozwolone przez przeglądarkę internetową.  

##### FinalV5.0:

•	pełny zakres FinalV4.0  
•	automatyczne tworzenie schematu BD podczas pierwszego uruchomienia aplikacji (baza: lab, użytkownik: app, hasło: app)  
•	nazwy tabel i kolumn powinny być adekwatne do przechowywanych danych.  
•	jednokrotne otwarcie połączenia w aplikacji lub jednokrotne utworzenie menadżera encji w całym cyklu życia aplikacji  
•	utrwalanie w BD wszystkich operacji na modelu  
•	udostępnienie wszystkich wpisów w BD na stronie internetowej   
•	opcja czyszczenia zawartości BD ze strony internetowej (np. odpowiedni przycisk ekranowy),  
•	obsługa sytuacji wyjątkowych BD  
•	jednoznaczna informacja w widoku  o temacie zadania:  
  - co należy wpisać w które pole tekstowe,   
  - które z wyświetlanych informacji są odczytane z ciastek,   
  - które wyświetlanych informacji są odczytane z BD  
