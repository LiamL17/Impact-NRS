# Number Range Summarizer
This project aims to take a string of comma separated integer values 
and output these values as ranges. This project was built on Windows.

## Usage
This program can be executed with two different inputs. These options are a file 
or simply a string as a command line argument. If it is used incorrectly the program
will display how it should be used.
Below are examples of both methods
```bash
mvn exec:java -"Dexec.args"="'-4, -3, -2, 1, 2, 3, 5, 7'"
mvn exec:java -"Dexec.args"="-f src/main/resources/in1.txt"
```

## Testing
This program uses Maven with JUnit and Jacoco PIT testing. 
Tests are automated through github actions, but can be executed locally with:
```bash
mvn test
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```

## Examples
- "1,2,3,5" -> "[1..3], 5"
- "-4, -3, -2, 1, 2, 3, 5, 7" -> "[-4..-2], [1..3], 5, 7"
- "" -> ""

## Future work
- Different separators
- Implement for different data types such as string, double, long
- Unix integration