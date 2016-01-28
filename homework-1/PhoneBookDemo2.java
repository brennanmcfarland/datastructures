public class PhoneBookDemo2{
    public static void main(String[] args){
	//create a phonebook object for names and SSNs
	PhoneBook names = new PhoneBook<String>();
	PhoneBook SSNs = new PhoneBook<Integer>();

	names.addPerson(333666999, 1234567890);
	long searchedname = names.findPerson(333666999);
	if(searchedname == -1L)
	    System.out.println("Person not found!");
	else
	    System.out.println(searchedname);
    }
}
