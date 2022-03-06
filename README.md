# StringGenerator

The application generates random unique lines of text with the given parameters:
- min: minimal number of characters in line
- max: maximal number of characters in line
- numberOfStrings: number of strings
- chars: specify possible chars of string (from what characters string should be made)

# End-points

- `/generate`: generate file with given parameters in JSON
- `/file/{fileName}`: gets the file with the given name 
- `/content/{fileName}`: gets the contents of a file with a given name
- `/jobs`: get the number of currently running processes

# Commands

To start the application, use the method:
```
java -jar ../target/StringGenerator-0.0.1-SNAPSHOT.jar
```
The file will be created in the place where the application was started.
For example, if the terminal is started on the desktop, the file will be generated there

To run tests, use the method:
```
mvn test
```

# Example JSON

```
{
    "numberOfStrings": 20000,
    "min": 2,
    "max": 17,
    "chars": "abcdefg"
}
```
