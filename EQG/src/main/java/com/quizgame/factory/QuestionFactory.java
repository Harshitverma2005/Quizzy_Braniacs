package com.quizgame.factory;

import com.quizgame.model.Question;

import java.util.ArrayList;
import java.util.List;


public class QuestionFactory {


    public static List<Question> createSampleQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What is the capital of France?",
                new String[]{"Berlin", "London", "Paris", "Madrid"},
                2, "easy", "General"));

        questions.add(new Question(
                "Which planet is known as the Red Planet?",
                new String[]{"Venus", "Mars", "Jupiter", "Saturn"},
                1, "easy", "Science"));

        questions.add(new Question(
                "Who wrote 'To Kill a Mockingbird'?",
                new String[]{"Harper Lee", "J.K. Rowling", "Jane Austen", "Mark Twain"},
                0, "easy", "Literature"));

        questions.add(new Question(
                "What is the time complexity of binary search?",
                new String[]{"O(n)", "O(log n)", "O(n log n)", "O(1)"},
                1, "hard", "Computer Science"));

        questions.add(new Question(
                "Which design pattern ensures a single instance of a class?",
                new String[]{"Factory", "Singleton", "Observer", "Strategy"},
                1, "hard", "Programming"));

        questions.add(new Question("What does CPU stand for?", new String[]{"Central Processing Unit", "Control Processing Unit", "Computer Personal Unit", "Central Performance Unit"}, 0, "easy", "Hardware"));
        questions.add(new Question("What is the main function of an operating system?", new String[]{"To manage hardware resources", "To run software applications", "To store files", "To display output"}, 0, "easy", "OS"));
        questions.add(new Question("Which language is used to style web pages?", new String[]{"HTML", "JQuery", "CSS", "XML"}, 2, "easy", "Web Development"));
        questions.add(new Question("What does RAM stand for?", new String[]{"Read Access Memory", "Random Access Memory", "Run Access Memory", "Readily Available Memory"}, 1, "easy", "Hardware"));
        questions.add(new Question("What is a variable in programming?", new String[]{"A container for storing data", "A type of loop", "A syntax error", "An output command"}, 0, "easy", "Programming"));
        questions.add(new Question("Which of the following is a programming language?", new String[]{"HTTP", "HTML", "Python", "FTP"}, 2, "easy", "Programming"));
        questions.add(new Question("What symbol is commonly used to end a statement in many programming languages?", new String[]{";", ".", ",", ":"}, 0, "easy", "Programming"));
        questions.add(new Question("What does IDE stand for?", new String[]{"Integrated Development Environment", "Interactive Debugging Environment", "Integrated Design Editor", "Internal Development Edition"}, 0, "easy", "Programming"));
        questions.add(new Question("Which of the following is NOT an operating system?", new String[]{"Windows", "Linux", "Microsoft Word", "macOS"}, 2, "easy", "OS"));
        questions.add(new Question("What is the binary number system base?", new String[]{"2", "8", "10", "16"}, 0, "easy", "Computer Fundamentals"));
        questions.add(new Question("Which part of the computer is responsible for permanent data storage?", new String[]{"RAM", "CPU", "Hard Drive", "Cache"}, 2, "easy", "Hardware"));
        questions.add(new Question("In HTML, which tag is used to create a hyperlink?", new String[]{"<a>", "<p>", "<div>", "<h1>"}, 0, "easy", "Web Development"));
        questions.add(new Question("What type of loop repeats a block of code while a condition is true?", new String[]{"For loop", "While loop", "If statement", "Switch case"}, 1, "easy", "Programming"));
        questions.add(new Question("What does HTML stand for?", new String[]{"Hyper Text Markup Language", "Hyperlinks and Text Markup Language", "Home Tool Markup Language", "Hyperlinking Textual Markup Language"}, 0, "easy", "Web Development"));
        questions.add(new Question("What is an IP address?", new String[]{"A unique address for a computer on the internet", "The internet provider address", "The address of a website", "The physical location of a computer"}, 0, "easy", "Networking"));
        questions.add(new Question("Which of the following is NOT a database management system?", new String[]{"MySQL", "Oracle", "Excel", "MongoDB"}, 2, "easy", "Databases"));
        questions.add(new Question("What is a boolean data type?", new String[]{"Data type storing decimal numbers", "Data type storing characters", "Data type storing true/false values", "Data type storing strings"}, 2, "easy", "Programming"));
        questions.add(new Question("Which keyword in Java is used to create an object?", new String[]{"class", "new", "void", "object"}, 1, "easy", "Programming"));
        questions.add(new Question("What is the output of 5 % 2 in most programming languages?", new String[]{"1", "2", "0", "5"}, 0, "easy", "Programming"));
        questions.add(new Question("What is GUI?", new String[]{"Graphical User Interface", "General User Interaction", "Graphical Unique Interface", "Grand User Interaction"}, 0, "easy", "General"));
        questions.add(new Question("Which command is used to compile a Java program?", new String[]{"java", "javac", "javadoc", "jdb"}, 1, "easy", "Programming"));
        questions.add(new Question("What is a loop in programming?", new String[]{"Decision making", "Repetitive execution", "Data storage", "Compilation"}, 1, "easy", "Programming"));
        questions.add(new Question("Which HTML tag is used to display an image?", new String[]{"<img>", "<image>", "<src>", "<pic>"}, 0, "easy", "Web Development"));
        questions.add(new Question("What does CSS control in a website?", new String[]{"Content", "Structure", "Style and layout", "Hyperlinks"}, 2, "easy", "Web Development"));
        questions.add(new Question("Which programming language is known as the language of the web?", new String[]{"C++", "Python", "JavaScript", "Java"}, 2, "easy", "Programming"));

        questions.add(new Question("What is recursion in programming?", new String[]{"Repeating a set of instructions with a loop", "A function calling itself", "Using variables inside functions", "Returning values from a function"}, 1, "hard", "Programming"));
        questions.add(new Question("Which data structure uses FIFO (First In First Out)?", new String[]{"Stack", "Queue", "Tree", "Graph"}, 1, "hard", "Data Structures"));
        questions.add(new Question("What is the function of DNS in networking?", new String[]{"To translate domain names to IP addresses", "To secure data", "To route emails", "To control bandwidth"}, 0, "hard", "Networking"));
        questions.add(new Question("Which of these is a NoSQL database?", new String[]{"MySQL", "Oracle", "MongoDB", "PostgreSQL"}, 2, "hard", "Databases"));
        questions.add(new Question("Which algorithm ensures only one instance of a class?", new String[]{"Factory", "Singleton", "Observer", "Strategy"}, 1, "hard", "Programming"));
        questions.add(new Question("Which keyword is used in Java to inherit a class?", new String[]{"this", "super", "extends", "implements"}, 2, "hard", "Programming"));
        questions.add(new Question("Which algorithm is used to find the shortest path in graphs?", new String[]{"Bubble Sort", "Dijkstra’s Algorithm", "Merge Sort", "Binary Search"}, 1, "hard", "Algorithms"));
        questions.add(new Question("Which HTTP method is used to retrieve data?", new String[]{"POST", "PUT", "GET", "DELETE"}, 2, "hard", "Web Development"));
        questions.add(new Question("Which sorting algorithm has the best average-case time complexity?", new String[]{"Bubble Sort", "Merge Sort", "Insertion Sort", "Selection Sort"}, 1, "hard", "Algorithms"));
        questions.add(new Question("What does API stand for?", new String[]{"Application Programming Interface", "Application Program Interaction", "Applied Programming Interface", "Advanced Programming Interface"}, 0, "hard", "General"));
        questions.add(new Question("Which protocol is used to send email?", new String[]{"FTP", "HTTP", "SMTP", "POP3"}, 2, "hard", "Networking"));
        questions.add(new Question("Which device is used as input to draw on the computer screen?", new String[]{"Scanner", "Printer", "Mouse", "Graphics Tablet"}, 3, "hard", "Hardware"));
        questions.add(new Question("Which of these is a characteristic of Object-Oriented Programming?", new String[]{"Inheritance", "Compilation", "Interpretation", "Linking"}, 0, "hard", "Programming"));
        questions.add(new Question("What is latency in networking?", new String[]{"Amount of data transferred", "Delay in data transfer", "Speed of data", "Error rate"}, 1, "hard", "Networking"));
        questions.add(new Question("Which layer of the OSI model deals with routing?", new String[]{"Physical Layer", "Network Layer", "Transport Layer", "Application Layer"}, 1, "hard", "Networking"));
        questions.add(new Question("Which of these is a high-level programming language?", new String[]{"Assembly", "Machine Code", "Python", "Binary"}, 2, "hard", "Programming"));
        questions.add(new Question("What does Git do?", new String[]{"Project management", "Version control system", "Programming language", "Text editor"}, 1, "hard", "Tools"));
        questions.add(new Question("Which of these is a popular OS for servers?", new String[]{"Windows 10", "Ubuntu", "Android", "iOS"}, 1, "hard", "OS"));
        questions.add(new Question("What is a stack data structure?", new String[]{"FIFO", "LIFO", "Random", "Sorted"}, 1, "hard", "Data Structures"));
        questions.add(new Question("Which design pattern ensures a single class instance?", new String[]{"Factory", "Singleton", "Decorator", "Observer"}, 1, "hard", "Design Patterns"));
        questions.add(new Question("What is polymorphism in OOP?", new String[]{"Multiple forms", "Single inheritance", "Encapsulation", "Abstraction"}, 0, "hard", "OOP"));
        questions.add(new Question("Which Java collection class implements a hash table?", new String[]{"ArrayList", "HashMap", "LinkedList", "TreeMap"}, 1, "hard", "Java Collections"));
        questions.add(new Question("What is the worst-case complexity of quicksort?", new String[]{"O(n)", "O(n log n)", "O(n^2)", "O(log n)"}, 2, "hard", "Algorithms"));
        questions.add(new Question("Which of these represents the OSI model's transport layer?", new String[]{"HTTP", "TCP", "IP", "FTP"}, 1, "hard", "Networking"));
        questions.add(new Question("In Java, which method is called when an object is garbage collected?", new String[]{"finalize()", "dispose()", "destroy()", "cleanup()"}, 0, "hard", "Java"));

        return questions;
    }
}
