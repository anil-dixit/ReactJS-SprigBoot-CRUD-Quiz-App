//some questions entry for the Quiz. we need to create quiz manually using postman then we can see the Quiz in QuizList.  



INSERT INTO public.question(
    id, category, diffiulty_level, option1, option2, option3, option4, question_title, right_answer)
VALUES
    (1, 'Java', 'Easy', 'A. int x = 5;', 'B. float x = 5.0f;', 'C. double x = 5.0;', 'D. String x = "5";', 'What is the correct way to declare an integer variable in Java?', 'A. int x = 5;'),

    (2, 'JavaScript', 'Easy', 'A. let x = 5;', 'B. var x = 5;', 'C. const x = 5;', 'D. int x = 5;', 'How do you declare a variable in JavaScript?', 'A. let x = 5;'),

    (3, 'Java', 'Easy', 'A. ==', 'B. =', 'C. ===', 'D. !=', 'Which operator is used for equality comparison in Java?', 'A. =='),

    (4, 'JavaScript', 'Easy', 'A. ==', 'B. =', 'C. ===', 'D. !=', 'What is the correct equality operator in JavaScript?', 'C. ==='),

    (5, 'Java', 'Medium', 'A. ArrayList', 'B. LinkedList', 'C. HashSet', 'D. HashMap', 'Which Java collection framework class implements a dynamic array?', 'A. ArrayList'),

    (6, 'JavaScript', 'Medium', 'A. forEach', 'B. for...in', 'C. for...of', 'D. map', 'Which loop is used to iterate over the values of an iterable object in JavaScript?', 'C. for...of'),

    (7, 'Java', 'Medium', 'A. try', 'B. catch', 'C. finally', 'D. throw', 'In Java, which block is used to handle exceptions?', 'B. catch'),

    (8, 'JavaScript', 'Medium', 'A. null', 'B. undefined', 'C. NaN', 'D. 0', 'What is the default value of a variable in JavaScript if it is not assigned a value?', 'B. undefined'),

    (9, 'Java', 'Hard', 'A. AbstractFactory', 'B. FactoryMethod', 'C. Singleton', 'D. Builder', 'Which design pattern is used to create an object in a way that the client can specify the type of object it wants to create?', 'B. FactoryMethod'),

    (10, 'JavaScript', 'Hard', 'A. callback', 'B. promise', 'C. async', 'D. await', 'Which feature in JavaScript is used for handling asynchronous operations?', 'B. promise'),

    (11, 'Java', 'Hard', 'A. static', 'B. final', 'C. abstract', 'D. private', 'Which keyword is used to declare a method that cannot be overridden in a subclass?', 'B. final'),

    (12, 'JavaScript', 'Hard', 'A. Object.create()', 'B. new Object()', 'C. {}', 'D. createObject()', 'What is the correct way to create an empty object in JavaScript?', 'C. {}'),

    (13, 'Java', 'Easy', 'A. JDK', 'B. JRE', 'C. JVM', 'D. JAR', 'Which one is responsible for executing Java programs?', 'C. JVM'),

    (14, 'JavaScript', 'Easy', 'A. alert()', 'B. log()', 'C. print()', 'D. message()', 'How do you display a message box in JavaScript?', 'A. alert()'),

    (15, 'Java', 'Easy', 'A. constructor', 'B. initializer', 'C. destructor', 'D. method', 'What is used to initialize an object in Java?', 'A. constructor'),

    (16, 'JavaScript', 'Easy', 'A. for', 'B. while', 'C. do...while', 'D. forEach', 'Which loop is used when you want to execute a block of code at least once?', 'C. do...while'),

    (17, 'Java', 'Medium', 'A. super', 'B. this', 'C. base', 'D. parent', 'In Java, which keyword is used to refer to the immediate parent class object?', 'B. this'),

    (18, 'JavaScript', 'Medium', 'A. slice()', 'B. splice()', 'C. split()', 'D. cut()', 'Which array method is used to remove elements from an array in JavaScript?', 'B. splice()'),

    (19, 'Java', 'Medium', 'A. TreeMap', 'B. LinkedHashMap', 'C. HashMap', 'D. Hashtable', 'Which Java collection class guarantees the order of its elements?', 'B. LinkedHashMap'),

    (20, 'JavaScript', 'Hard', 'A. call()', 'B. apply()', 'C. invoke()', 'D. execute()', 'Which method is used to call a function with a given this value and arguments provided individually in JavaScript?', 'B. apply()'),
	
	(21, 'Python', 'Easy', 'A. 3', 'B. 4', 'C. 5', 'D. 6', 'How many indentation spaces are recommended in Python?', 'A. 3'),

    (22, 'Python', 'Easy', 'A. list', 'B. tuple', 'C. set', 'D. dictionary', 'Which of the following is an immutable data type in Python?', 'B. tuple'),

    (23, 'Python', 'Medium', 'A. __init__', 'B. __main__', 'C. __start__', 'D. __begin__', 'What is the name of the constructor method in Python?', 'A. __init__'),

    (24, 'Python', 'Medium', 'A. break', 'B. continue', 'C. pass', 'D. return', 'Which statement is used to do nothing in Python?', 'C. pass'),

    (25, 'Python', 'Hard', 'A. local', 'B. global', 'C. nonlocal', 'D. var', 'Which keyword is used to declare a variable inside a function as global in Python?', 'B. global'),

    (26, 'Python', 'Hard', 'A. lambda', 'B. anonymous', 'C. inline', 'D. function', 'What is the keyword used to create anonymous functions in Python?', 'A. lambda'),

    (27, 'Python', 'Easy', 'A. int', 'B. float', 'C. str', 'D. bool', 'Which data type is used to represent true or false values in Python?', 'D. bool'),

    (28, 'Python', 'Easy', 'A. append()', 'B. extend()', 'C. insert()', 'D. add()', 'Which method is used to add an element to the end of a list in Python?', 'A. append()'),

    (29, 'Python', 'Medium', 'A. pop()', 'B. remove()', 'C. delete()', 'D. discard()', 'Which method is used to remove and return the last element from a list in Python?', 'A. pop()'),

    (30, 'Python', 'Medium', 'A. map()', 'B. filter()', 'C. reduce()', 'D. apply()', 'Which function is used to apply a particular function passed in its argument to all of the items in an iterable object?', 'A. map()');
	
	
