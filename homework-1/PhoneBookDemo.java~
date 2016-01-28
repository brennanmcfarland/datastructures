public class PhoneBookDemo{
    public static void main(String[] args){
	//create a phonebook object for names and SSNs
	PhoneBook names = new PhoneBook<String>();
	PhoneBook SSNs = new PhoneBook<Integer>();

	//add an entry into each phonebook
	names.addPerson("John Smith", 5555555555L);
	SSNs.addPerson(123456789,3141592653L);

	//try to find a person in each phonebook and print result
	long searchedname = names.findPerson("John Smith");
	if(searchedname == -1L)
	    System.out.println("Person not found!");
	else
	    System.out.println(searchedname);
	long searchedSSN = SSNs.findPerson(111222333);
	if(searchedSSN == -1L)
	    System.out.println("Person not found!");
	else
	    System.out.println(searchedSSN);
    }
}
