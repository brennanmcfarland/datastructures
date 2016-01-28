import java.util.ArrayList;

public class PhoneBook<T>{

    private ArrayList<T> IDs;
    private ArrayList<Long> numbers;

    public PhoneBook(){
	IDs = new ArrayList<T>();
	numbers = new ArrayList<Long>();
    }
    
    //return # of person with specified ID, -1 if not found
    public long findPerson(T personid){
	for(int i=0; i<IDs.size();i++){
	    if(IDs.get(i) == personid){
		return numbers.get(i);
	    }
	}
	return -1;
    }
    //store given ID and phone #, returns false if failed
    public void addPerson(T personid, long number){
	IDs.add(personid);
	numbers.add(number);
    }
    //deletes person with secified ID, returns false if not found
    public boolean deletePerson(T personid){
	for(int i=0;i<IDs.size();i++){
	    if(IDs.get(i) == personid){
		IDs.remove(i);
		numbers.remove(i);
		return true;
	    }
	}
	return false;
    }
}
