# CarWEBAPI


This Project consists of several stages.

There are 4 Drivers to test different functionality of the program.
The output is created only for testing purposes.

Driver 


I created model and util packages. The util package has the FileIO class that implements Serializable. 
FileIO reads data from .txt files and uses FileReader and BufferedReader to populate Automobile instances with data.


Driver 1

This driver tests two things: the ability to edit my data and the ability to catch exeptions.

Part1
At this stage I had Model package(a component), which had Automobile class. 
I provided a set of methods, whizh act as a Programming Interfaces for accessing functionality, in Model package.

The code is organized to encapsulate Automobile. For this purpose I created a package called Adapter.
It has CreateAuto and UpdateAuto Interfaces.
I also added a new abstract class called proxyAutomobile. 
This class contains all the implementation of any method declared in the interfaces.
Also I created a class BuildAuto in order to "hide" proxyAutomobile, that contains all the functionality.
This class will implement all the Interfaces. Whenever a new interface has to be added I can simply update BuildAuto declaration
and write all the new methods in Abstract class called proxyAutomobile.

I encapsulated access to Automobile instance, from the API and also hidden the code (artificially) in the abstract class.

Part2
There is an array of txt files in the second part of the assignment, which was created in order to test the catch/fix methods. 
These files have various errors in them. The program catches and fixes some of them. 
First 4 exceptions are fixable, last one - throws exception.

I wrote a defencive mechanism that makes software self healing.
I created a custom exception handler to deal with issues in runtime.

AutoException has following features:
  -tracks error number and error message;
  -contains an enumeration of all possible numbers and messages that can be used when AutoException is instantiated;
  -logs AutoException with timestamps into a log file;
  -has a helper class to delegate fixes for each method;
  -has a method accessible through FixAuto interface.
  

Driver 2

The code is re-implemented with a better functionality to handle multiple models of cars.
I added LinkedHashMap to store all the models and tested find, delete, update methods.

I also added methods for keeping track of which options user has chosen to pick for each car model.

The method setOptionChoice() is for choosing a particular option in an option set.
getOptionChoice("nameofoption") would return the picked value for the named option.

Driver 3

At this stage of developing I wanted to ensure that my application can handle concurrency.
In order to setup a scalable structure for the app, I added LinkedHashMap in ProxyAutomotive.
I designed a class called EditOptions that can be used to edit Options for a given model in its own thread.
I put this class in a new package called scale.

In the Driver3 I tested different behavior of the threads, comparing synchronized and unsinchronized methods.

