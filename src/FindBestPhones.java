import java.io.IOException;

public class FindBestPhones {
	public static String PHONES_FILE = "phone-data-short.txt";

	public static void main(String[] args) {
		// use the parseFile method to get the phone data from the file
		PhoneParser parser = new PhoneParser();
		try {
			PhoneList phoneList = parser.parseFile(PHONES_FILE);
			// print the model names of all the best phones
			for (Phone phone : phoneList.getBestPhones()) {
				System.out.println(phone.getModel());
			}
		} catch (IOException ex) {
			// handle I/O failures by printing an error message
			System.out.println("Error Phone list not found: " + PHONES_FILE);
		}
	}
}