
Serialization Interview Exercise:

The Serialization exercise is based around serialization as well as other core Java techniques.
The basic outline of tasks helps to guide a developer through the process of correcting and improving the solution.
The exercise is provided as two IDE projects.

This is an open book (or open web) assignment. 

- Please provide links to any articles you use to guide your decisions in working through the exercise.

- Please make small comment notes in this readme on each of the exercise steps to note your approach to the solution.
  Expect the reviewer to use these comments as a guide to review your submission.

Components:

	SerializationExercises:
		The main driver.  Little to no functionality contained in the main class.  This is designed to provide sample 
		data objects to be serialized and a place to house test cases, of which the initial solution provides a single test case.

	Serialization:
		The core implementation of the serialization library.


Exercises:

	1) Fix serialization:
		The solution does not run correctly due to issues in serializing the sample data objects.
		Make the needed changes to successfully serialize the objects and run the solution successfully.

	2) Partial serialization:
		The goal of the solution is to serialize all of DataObject1 but only a portion of DataObject2.
		Make the needed adjustments to DataObject2 to serialize only Property1 and Property2 but not the SourceIdentifier
		property.  Adjust the test case (or add additional test case) to prove this is functioning.

	3) Fix unmanaged resource issues
		The functionality in the SerializationManager is making use of a typical unmanaged resource.
		Make the needed code changes to properly handle the resource.

	4) Improve the solutions error handling
		Treat the Serialization.jar as a generally usable/reusable utility library and treat the driver SerializationExercises.jar
		as one of many different environments in which Serialization.jar will be used.  Improve the code with exception handling
		and diagnostic trace to provide a more managable/debuggable solution.  
		
		You may use "System.out" as the trace facility.

		Things to consider:
			4.a) The main application should never crash.
			4.b) The library should provide diagnostic trace about any serialization errors.
			4.c) The library should NOT mask any error from its driver application.
			4.d) The trace should provide enough detail to allow (within reason) the ability to correct issues without needing to recreate the bug.

	5) General Improvements
		Make any other general improvements you feel bring the code more inline with best practices, style, supportability, etc.

	6) Extra credit unit test
		Create and add a JUnit UnitTest to the solution to exercise the behavior of Serialization.jar.

	7) Extra credit code analysis
		Activate JavaHints and FindBugs code analysys in the NetBeans IDE and address any warnings raised.

