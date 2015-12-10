//Max Bertfield and Bayle Smith-Salzberg
//APCS1 pd10
//HW42 -- Array of Titanium
//2015 - 12 - 07

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *****************************/

public class SuperArray {

    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private  int _size;

    //accessors so the interface has access
    public Comparable[] getData(){
	return _data;
    }
    public int getLastPos(){
	return _lastPos;
    }
    public int getSize(){
	return _size;
    }
        //setters so the interface has access
    public void setData(Comparable[] array){
	_data = array;
    }
    public void setLastPos(int pos){
	_lastPos = pos;
    }
    public void setSize(int s){
	_size = s;
    }

		
    //~~~~~METHODS~~~~~
    //default constructor initializes 10-item array
    public SuperArray() {
	_data = (new Comparable[10]);
	_lastPos = (-1);
	_size=(0);
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"

    public String toString() {
	String s = "[";
	for (int i = 0; i < _size; i++){
	    s += getData()[i];
	    s += ",";
	}
	if (getSize() > 0){
	    s = s.substring(0,s.length() - 1);
	}
	s += "]";
	return s;
    }
    /*looks for a specific comparable in the superarray
     */
    public int linSearch(Comparable c){
	for (int i = 0; i < getSize(); i++)
	    if (get(i).equals(c)){
		return i;
	    }
	return -1;
    }
    /*makes sure the array goes from least to greatest value
     */
    public boolean isSorted() {
	for (int i=0; i<_size-1; i++) {
	    if (getData()[i].compareTo(getData()[i+1]) > 0) return false;
	}
	return true;
    }

		
    //double capacity of this SuperArray
    private void expand() {
	Comparable [] newData = getData();
	Comparable[] newArr = new Comparable[2 *getData().length];
	for (int i = 0; i < getLastPos(); i++){
	    newArr[i] = newData[i];	}
	newData = newArr;
	setData(newData);
    }


		
    //accessor -- return value at specified index
    public Comparable get( int index ) { 
	return getData()[index];	
	}
		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) {
	Comparable[] newData = getData();
	Comparable temp = getData()[index];
	newData[index] = newVal;
	setData(newData);
	return temp;
	
    }

  // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	if (getSize() == getData().length)
		expand();
	Comparable[] newData = getData();
	newData[getSize()] = newVal;
	setData(newData);
	setSize(getSize() + 1);
	setLastPos(getLastPos() + 1);
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
	Comparable[] newData = getData();
	if (index >= getSize()){
		//Let's throw an error!
	}
	if (getSize() == getData().length)
		expand();
	for (int i = getSize(); i > index + 1; i--){
	    newData[i] = newData[i - 1];
	}
	newData[index] = newVal;
	setData(newData);
	setSize(getSize() + 1);
	setLastPos(getLastPos() + 1);
    }


    //removes the item at index
    //shifts elements left to fill in newly-emptied slot
    public void remove( int index ) {
	Comparable[] newData = getData();
	for (int i = index; i < getLastPos(); i++)
		newData[i] = newData[i + 1];
	setSize(getSize()- 1);
	setLastPos(getLastPos() - 1);
    }


    //return number of meaningful items in _data
    public int size() {
	return getSize();
    }


    public static void main( String[] args ) {
	//Rational array
	SuperArray jerry = new SuperArray();
	jerry.add(new Rational(24, 12));
	jerry.add(new Rational(9, 27));
	jerry.add(new Binary(8));
	jerry.add(new Binary("10"));
	jerry.add(new Hexadecimal(79));
	jerry.add(new Hexadecimal("4F"));
	System.out.println("jerry:\t" + jerry);
	
for (int i=0; i < jerry._size-1; i++) {
	    System.out.println("jerry._data[" + i + "]:\t" + jerry.get(i) +
			       "\njerry._data[" + (i+1) + "]:\t" + jerry.get(i+1) +
			       "\ncompare:\t" +
			       jerry.get(i).compareTo(jerry.get(i+1)) + "\n");
	}
Binary a = (null);
String bad = "hi y'all, i'm not comparable!";
System.out.print(jerry.get(0).compareTo(a));
    }//end main
    
}

