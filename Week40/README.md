Computer mouse
<br>Identify the types of testing you would perform on a computer mouse, to
make sure that it is of the highest quality.
<br>Accesability test, to confirm that anyone with can use the mouse properly
<br>Stress testing, to make sure it's as durable as promised
<br>Maybe unit testing to see if the buttons and and laser each work independently

<br><br>Catastrophic failure
<br>Find a story where a software system defect had a bad outcome. Describe
what happened. Can you identify a test that would have prevented it?
<br>-Amazons new world causes problems with high end gpus. A small percentage of players experiences bricking of their brand new GPUs.
<br>-The problem is both with amazon and the GPU manufacturer.
<br>-The GPU manufactorers should've stress tested their products better as they claim a soldering problem contributed to the problems.
<br>-Amazon should've had a wide array of machines to stress test their game on.

<br><br>Investigation of tools

<br><br>JUnit 5
<br>Investigate JUnit 5 (Jupiter). Explain the following, and how they are useful.
<br>• @Tag
<br>A way to categorise test for filtering and describing.
<br>• @Disabled
<br>Prevents the test from being run, can be used to make sure deprecated functionality doesn't break, by having some test ready to test it thouroughly.
<br>• @RepeatedTest
<br>The test is repeated according to the paramaters set up, useful to test for variance.
<br>• @BeforeEach, @AfterEach
<br>Activates some code before and after all test, useful to setup functionality that needs to be clean in every instance of tests.
<br>• @BeforeAll, @AfterAll
<br>Sames as above but only once for the class, useful for setting down and tearing down variables and functionality that many tests will use.
<br>• @DisplayName
<br>Used to give a custom name to tests, can be used to ease understanding of the tests.
<br>• @Nested
<br>Used to denote a new Test class in a test class, useful for splitting tests into parts that test specific areas/scenarios of the functionality
<br>• assumeFalse, assumeTrue
<br>Used to test if it makes sense to continue the test, stops the test from running if the assumption about the needed functionality is wrong.

<br><br>Mocking frameworks
<br>Investigate mocking frameworks for your preferred language. Choose at least
two frameworks, and answer the questions. (One could be Mockito, which
we saw in class.)
<br>JMOCKIT vs MOCKITO
<br>• What are their similarities?
<br>Both mocking languages, can utilize static method/constructor mocking.
<br>• What are their differences?
<br>MOCKITO has inconsistencies in invoking methods JMOCKIT doesn't, MOCKITO has no built-in coverage report upposed to JMOCKIT, MOCKITO is easier to learn than JMOCKIT, its harder to utilize custom argument matching in MOCKITO, MOCKITO is the larger and much more well know of the 2, MOCKITO utilizes proxy api design arcitechture whilst JMOCKIT uses Java 1.5 instrumentation api framework. 
<br>• Which one would you prefer, if any, and why?
<br>I would be up for learning either as i haven't really utiized a mocking tool yet, would maybe prefer JMOCKIT as it's based on java which I'm very familiar with. 
