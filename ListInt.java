/*-----------------------
 * ListInt interface:
 * Interface making sure that Array has:
 * -get, set value at index.
 * -return size of list.
 * -remove/add given index.
 * -append value to end of list.
----------------------------*/


public interface ListInt{

    /*
     - Pre: Index > 0; Index < Size;
     - Post: Int at given index.
     -*/
    public int get(int index);

    /*
     - Pre: Index > 0; Index < Size; 
     - Post: Int value at given index of list. overwrites item at list index with newVal.
      */
    public int set(int index, int newVal);

    /*
     - Pre:
     - Post: Size of list.
     - Desc: Returns size of list.
     */
    public int size();

    /*
     - Pre: Index > 0; Index < Size;
     - Post: Removes index from list. Indices past given shift down. Size is changed.
     */
    public void remove(int index);

    /*
     - Pre: Index > 0; Index < Size;
     - Post:
     - Desc: Appends val at end of list
     -       Size is changed.
     */
    public void add(int val);

    /*
     - Pre: Index > 0; Index < Size;
     - post: Adds index with value newVal into list.
            Indices past are bumped up an index.
            Size is changed.
     */
    public void add(int index, int newVal);
    public int[] getData();
    public int getSize();
    public int getLastPos();
}
