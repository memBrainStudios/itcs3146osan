package main;

public class DNode<T> {
    private T e;
    private DNode<T> prev, next;
    
    public DNode () {
        e = null;
        next = null;
    }
    
    public DNode ( T e1, DNode<T> n0, DNode<T> n1 ) {
        e = e1; 
        prev = n0; 
        next = n1;
    }
    
    public T getE () {
        return e;
    }
    
    public void setE ( T e1 ) {
    	e = e1;
   	}
    
    public DNode<T> getNext () {
    	return next;
    }
    
    public void setNext ( DNode<T> n1 ) {
    	next = n1;
   	}

    public DNode<T> getPrev () {
    	return prev;
    }
    
    public void setPrev ( DNode<T> n1 ) {
    	prev = n1;
   	}
}
