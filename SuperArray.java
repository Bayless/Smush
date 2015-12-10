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

public class SuperArray implements Comparable {

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
    public void setData(int[] array){
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
    /*
     */
    public int linSearch(Comparable c){}
    /*
     */
    publib boolean isSorted(){}
		
    //double capacity of this SuperArray
    private void expand() {
	int [] newData = getData();
	int[] newArr = new int[2 *getData().length];
	for (int i = 0; i < getLastPos(); i++){
	    newArr[i] = newData[i];	}
	newData = newArr;
	setData(newData);
    }


		
    //accessor -- return value at specified index
    public int get( int index ) { 
	return getData()[index];	
	}
		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) {
	int[] newData = getData();
	int temp = getData()[index];
	newData[index] = newVal;
	setData(newData);
	return temp;
	
    }

  // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( int newVal ) {
	if (getSize() == getData().length)
		expand();
	int[] newData = getData();
	newData[getSize()] = newVal;
	setData(newData);
	setSize(getSize() + 1);
	setLastPos(getLastPos() + 1);
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, int newVal ) {
	int[] newData = getData();
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
	int[] newData = getData();
	for (int i = index; i < getLastPos(); i++)
		newData[i] = newData[i + 1];
	setSize(getSize()- 1);
	setLastPos(getLastPos() - 1);
	}


    //return number of meaningful items in _data
    public int size() {
	return getSize();
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	
	//testing SuperJava methods
	ListInt curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);
	for( int i = 0; i < 10; i++ ) {
	    curtis.add(i,i*2);
	}
	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);
	System.out.println("testing get()...");
	for( int i = 0; i < 10; i++ ) {
	    System.out.print( "item at index " + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}
	ListInt bayle = new SuperArray();
	System.out.println("Printing empty bayle");
	System.out.println(bayle);
	for (int i = 0; i < 10; i++){
	    bayle.add(i * 3);
	}
	System.out.println("Printing numberified bayle...");
	System.out.println(bayle);
	System.out.println("Removing 5th element");
	bayle.remove(4);
	System.out.println(bayle);
	System.out.println(bayle.size());

    }
}
