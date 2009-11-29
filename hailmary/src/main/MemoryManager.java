   package main;

   import java.lang.ref.*;

    public class MemoryManager {
      private Computer comp;
      private String[] cacheIndex;
   
       public MemoryManager(Computer inComp)
      {
         comp = inComp;
         cacheIndex = new String[comp.cache.length];
         for(int i = 0; i < cacheIndex.length; i++)
         {
        	 cacheIndex[i] = "";//initialize the array.
         }      
      }
   
   /*
    * returns true is the specified line is in cache
    */
       public boolean lineInCache(int jobNumber, int lineNumber)
      {
         String temp = "" + jobNumber + " " + lineNumber;
        
         for(String s: cacheIndex)
         {
            if(s.equals(temp))
               return true;
         }
         return false;
      }
   
   /*
    * returns true if the specified line is in memory
    */
       public boolean lineInMemory(int jobNumber, int lineNumber)
      {
         for(Command c : comp.memory)
         {
        	if(c != null)
        	{
            if(c.equals(G4Final.jList[jobNumber].getLine(lineNumber)))
               return true;
        	}
         }
         return false;
      }
   
   /*
    * loads a line from secondary storage into main memory
    * Assumes no job is longer than 50 lines
    */
       public void loadToMemory(int jobNumber, int lineNumber)
      {
         comp.memory[(jobNumber*50 + lineNumber)] = G4Final.jList[jobNumber].getLine(lineNumber);
      //loads the current Line into memory from secondary storage
      
      }
   
   /*
    * loads a line from main memory into cache if possible
    * 
    */
       public void loadToCache(int jobNumber, int lineNumber)
      {
         for(int x = 0 ; x < comp.cache.length; x++)
         {
            if(comp.cache[x] == null)
            {
               comp.cache[x] = comp.memory[(jobNumber*50 + lineNumber)];
               cacheIndex[x] = "" + jobNumber + " " + lineNumber;
               break;
            }
         }
      }
   
   /*
    * gets the specified line from cache
    * 
    * @param jobNumber
    * @param lineNumber
    */
       public Command getLine(int jobNumber, int lineNumber)
      {
         String temp = "" + jobNumber + " " + lineNumber;
         for(int x = 0; x < cacheIndex.length; x++)
         {
            if(cacheIndex[x].equals(temp))
            {
            return comp.cache[x];
            }
         }
         return null; //if the line isn't in cache.
      }
   }
