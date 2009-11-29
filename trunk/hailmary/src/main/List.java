package main;

public class List<String> {
    DNode<String> head, tail, pointer;
    int size;
    
    public List() {
        head = null;
        tail = null;
        pointer = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        if ( size == 0 ) {
            return true;
        } else {
            return false;
        }
    }
    
    public int movePointer()
    {
        pointer = pointer.getNext();
        return indexOf(pointer.getE());
    }
    
    public int getPointer()
    {
        return indexOf(pointer.getE());
    }
    
    public void add ( int index, String e) throws IndexOutOfBound {
        // check pre-condition
        if ( ( index < 0 ) || ( index > size ) ) {
            throw new IndexOutOfBound();
        }
        
        // insert
        DNode<String> newNode = new DNode<String> ( e, null, null );
        
        // case 1.  currently empty
        if ( size == 0 ) {
            head = newNode;
            pointer = newNode;
            tail = newNode;
        // case 2.  not empty
        } else {
            // 2.1  to front
            if ( index == 0 ) {
                newNode.setNext ( head );    
                head.setPrev ( newNode );
                newNode.setNext ( head );
                head = newNode;
            
            // 2.2 to end
            } else if ( index == size ) {
                tail.setNext ( newNode );
                head.setPrev(newNode);
                newNode.setPrev ( tail );
                newNode.setNext(head);
                tail = newNode;
            
            // 2.3  middle
            } else {
                DNode<String> temp = head;
                for ( int i = 0; i < index-1; i++ ) {
                    temp = temp.getNext();   
                }
        
                newNode.setNext ( temp.getNext() );
                newNode.setPrev ( temp );
                temp.getNext().setPrev ( newNode );
                temp.setNext ( newNode );
            }   
        }
        size++;
    }
    
    
    public String get ( int index ) throws IndexOutOfBound {
        // check pre-condition
        if ( ( index < 0 ) || ( index >= size ) ) {
            throw new IndexOutOfBound();
        }
        
        // return it depending on where it is
        if ( index == (size-1) ) {
            return tail.getE();
        } else {
            DNode<String> temp;
            temp = head;
            for ( int i = 0; i < index; i++ ) {
                temp = temp.getNext();   
            }
            
            return temp.getE();
        }
    }
    
    
    public int indexOf ( String target ) {
        DNode<String> temp = head;
        int i = 0;
        while ( temp != null ) {
            if ( temp.getE().equals ( target ) == true ) {
                return i;   
            }
            i = i + 1;
            temp = temp.getNext();
        }
        
        return -1;
    }
    
    
    
    public int lastIndexOf ( String target ) {
        DNode<String> temp = tail;
        int i = size-1;
        while ( temp != null ) {
            if ( temp.getE().equals ( target ) == true ) {
                return i;   
            }
            i = i - 1;
            temp = temp.getPrev();
        }
        
        return -1;
    }

    
    public String remove ( int index ) throws IndexOutOfBound {
        // check pre-condition
        if ( ( index < 0 ) || ( index >= size ) ) {
            throw new IndexOutOfBound();
        }
        
        
        
        // case 1: only 1 item
        if ( size == 1 ) {
            String e= head.getE();
            head = null;
            tail = null;
            size--;
            return e;

        // case 2: > 1 items
        } else {
            // 2.1  from front
            if ( index == 0 ) {
                String e= head.getE();
                head = head.getNext();
                size--;
                return e;
            
            // 2.2  from end
            } else if ( index == (size-1) ) {
                String e= tail.getE();
                tail = tail.getPrev();
                tail.setNext (null);
                size--;
                return e;

            // 2.3  from middle
            } else {
                // move to one before index
                DNode<String> temp = head;
                for ( int i = 0; i < index-1; i++ ) {
                    temp = temp.getNext();   
                }

                String e= temp.getNext().getE();
                
                // delete now
                temp.setNext ( temp.getNext().getNext() );
                if ( temp.getNext() != null ) {
                    temp.getNext().setPrev ( temp );
                }
                size--;

                return e;
            }   
        }
    }


    
    public String set ( int index, String newE ) throws IndexOutOfBound {
        // check pre-condition
        if ( ( index < 0 ) || ( index >= size ) ) {
            throw new IndexOutOfBound();
        }
        
        
        // move to one before index
        DNode<String> temp = head;
        for ( int i = 0; i < index; i++ ) {
            temp = temp.getNext();   
        }

        String e= temp.getE();
        
        temp.setE ( newE );
        
        return e;
    }
    
    
    public List sublist ( int fromIndex, int uptoIndex ) throws IndexOutOfBound {
        // check pre-condition
        if ( ( fromIndex < 0 ) || ( fromIndex >= size ) ) {
            throw new IndexOutOfBound();
        }
        
        
        if ( ( uptoIndex < 0 ) || ( uptoIndex >= size ) ) {
            throw new IndexOutOfBound();
        }
        
        if ( fromIndex > uptoIndex ) {
            throw new IndexOutOfBound();
        }
        
        
        // create a sublist
        List<String> sub = new List<String>();
        
        // go to the first index
        DNode<String> temp = head;
        
        // move to the fromIndex node
        for ( int i = 0; i < fromIndex; i++ ) {
            temp = temp.getNext();
        }
        
        // start adding each node
        int ctr = 0;
        for ( int i = fromIndex; i < uptoIndex; i++ ) {
            sub.add ( ctr, temp.getE() );
            temp = temp.getNext();  
            ctr++;
        }
        
        return sub;
        
    }
    
    public void print () {
        DNode<String> temp = head;
        while ( temp != null ) {
            System.out.print ( temp.getE() + " > " );   
            temp = temp.getNext();
        }
        
        System.out.println ( "**" );
    }
}
    
    
class IndexOutOfBound extends Exception {
    public IndexOutOfBound() { 
        super();
    }
}