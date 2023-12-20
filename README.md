# XML_Sorter
This project is a Java application that parses XML files using the SAX parser to sort GenBank XML data into the designed sections.

Execute with a terminal:

```java -jar SAX_Parse.jar```


## Project Structure

The main Java files in this project are:

- [`CSVWritter.java`](src/CSVWritter.java): This file is responsible for writing the parsed data to a CSV file.
- [`GenBankEntry.java`](src/GenBankEntry.java): This file represents a GenBank entry.
- [`MyHandler.java`](src/MyHandler.java): This file is the handler used by the SAX parser.
- [`XMLParserSAX.java`](src/XMLParserSAX.java): This file is the main entry point for the SAX parser.

## How to Run

To run this project, you need to compile the Java files and then run the `XMLParserSAX.java` file.

## Output

The output of this project is a CSV file named `parsed_output.csv`.

## Contributing

If you want to contribute to this project, please feel free to fork the repository and submit a pull request.

## License

This project is licensed under the MIT License.