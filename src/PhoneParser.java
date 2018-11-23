import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PhoneParser {
	/*
	 * Parses a phone data string, in the following format:
	 * 
	 * model screenSize batteryCapacity
	 * 
	 * The model name is encoded with underscores instead of spaces.
	 */
	public static Phone parse(String data) {
		// TODO: parse the phone data string, and return a Phone object.
		// you may use string manipulation, a regex, or a Scanner
		String[] parts = data.split(" ");
		return new Phone(parts[0].replace('_', ' '), Double.parseDouble(parts[1]), Integer.parseInt(parts[2]));
	}

	/*
	 * Returns a PhoneList by parsing a text file containing the phone data.
	 */
	public static PhoneList parseFile(String filename) throws IOException {

		// TODO: create a PhoneList
		PhoneList phoneList = new PhoneList();
		try {
		    // TODO: create a BufferedReader to read from the file
		    BufferedReader file = new BufferedReader(new FileReader(filename));

		    // TODO: for each line, parse it as a Phone and add it to the list
		    while (true) {
                String line = file.readLine();
                if (line == null) {
                    file.close();
                    break;
                }
                phoneList.addPhone(parse(line));
            }
		}catch(FileNotFoundException ex) {
            System.out.println("File not found: " + filename);
        } catch(IOException ex) {
            System.out.println("Error while reading the file:");
            throw new IOException("IO Error");
        }
		return phoneList;
	}
}
