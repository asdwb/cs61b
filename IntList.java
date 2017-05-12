/** Defines a recursive list of integers.
 *  @author Josh Hug
 */

public class IntList {
    public int head;
    public IntList tail;

    public IntList(int h, IntList t) {
        /* your code here */
		this.head= h;
		this.tail=t;
    }

    /** Retuns the size of this IntList */
    public int size() {
        /* your code here */   
		if(this.tail==null){
			return 1;
		}
        return 1+this.tail.size(); 
    }

    /** Returns the size of this IntList. */
    public int iterativeSize() {
        /* your code here */
		int size=1;
		IntList p=this;
		while(p.tail!=null){
			size+=1;
			p=p.tail;
		} 
        return size;
    }

    /** In class exercise 1: 
      * Returns ith item of this IntList. For 
      * simplicity, assume the item exists. */
    public int get(int i) {
		/** your code here */
		if(i==0){
			return this.head;
		}
        return this.tail.get(i-1);
        
    }

    /** Returns the Intlist as a string. Automatically called
      * whenever you try to print an IntList. */
    public String toString() {
        /* your code here */
		int sizeofList=this.size();
		String str="";
		for(int i=0;i<sizeofList;i++){
			str+=Integer.toString(this.get(i))+" ";
		}
        return str;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. so Construct the new IntList. And this is the static method, so cannot accese the instance variable and no object */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
		IntList newList= new IntList(L.head+x,null);
		IntList pointer =newList;
		while(L.tail!=null){
			pointer.tail=new IntList(L.tail.head+x,null);
			pointer=pointer.tail;
			L=L.tail;
		}
	    return newList;        
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
		IntList pointer =L;
		while(pointer.tail!=null){
			pointer.head=pointer.head+x;
			pointer=pointer.tail;
		}
		pointer.head=pointer.head+x;
        return L;
    }    

    public static void main(String[] args) {

        // Test your answers by uncommenting. Or use the Visualizer.
		   IntList L = new IntList(5, null);
           L.tail = new IntList(7, null);    
           L.tail.tail = new IntList(9, null);
		   System.out.println(L.size());
           System.out.println(L.iterativeSize());
		   System.out.println(L.get(1));
		   System.out.println(L.toString());
           System.out.println(incrList(L, 3));
		   System.out.println(dincrList(L, 3));  

    }
} 