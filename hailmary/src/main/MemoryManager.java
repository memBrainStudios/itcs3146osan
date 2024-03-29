   package main;
   
   /*
    * @author Mike Iannacone
    * @version 9001
    */

    public class MemoryManager {
      private Computer comp;
      private String[] cacheIndex;
      private String[] memoryIndex;
      private int[] memLastLoaded;
      private int[] cacheLastLoaded;
   
       public MemoryManager(Computer inComp)
      {
         comp = inComp;
         cacheIndex = new String[comp.cache.length];
         memoryIndex = new String[comp.memory.length];
         memLastLoaded = new int[comp.cache.length/50];
         cacheLastLoaded = new int[comp.cache.length/50];
         for(int i = 0; i < cacheIndex.length; i++)
         {
        	 cacheIndex[i] = "";//initialize the cacheIndex array.
         } 
         for(int i = 0; i < cacheLastLoaded.length; i++)
         {
           	 cacheLastLoaded[i] = 0;//initialize the cacheIndex array.
         } 
         for(int i = 0; i < memLastLoaded.length; i++)
         {
        	 memLastLoaded[i] = 0;//initialize the cacheIndex array.
         } 
      }
   
   /*
    * returns true is the specified line is in cache
    */
       public boolean lineInCache(int jobNumber, int lineNumber)
      {
         String temp = "" + jobNumber + " 0" + lineNumber;
        
         for(String s: cacheIndex)
         {
            if(s!=null && s.equals(temp))
               return true;
         }
         return false;
      }
   
   /*
    * returns true if the specified line is in memory
    */
       public boolean lineInMemory(int jobNumber, int lineNumber)
      {
    	   String temp = "" + jobNumber + " 0" + lineNumber;
         for(String s : memoryIndex)
         {
        	if(s!=null && s.equals(temp))
        	  return true;
        	
         }
         return false;
      }
   
   /*
    * loads a line and its job from secondary storage into main memory
    */
       public void loadToMemory(int jobNumber, int lineNumber)
      {
    	   int ln = lineNumber - (lineNumber%50);
    	   for(int i= 0; i < 50; i++)
    	   {
    		   if(G4Final.jList[jobNumber].numLines()>ln+i)
    		   {
    			   comp.memory[lru(memLastLoaded)*50+i]= G4Final.jList[jobNumber].getLine(ln+i);
    			   memoryIndex[lru(cacheLastLoaded)*50+i]= "" + jobNumber + " " + ln+i;
    		   }
    	   }
    	   for(int i=0; i < memLastLoaded.length; i++)
    	   {
    		   memLastLoaded[i]++;
    	   }
    	   memLastLoaded[lru(memLastLoaded)] = 0;
      }
   
   /*
    * loads a line from "main memory" into cache if possible
    * 
    */
       public void loadToCache(int jobNumber, int lineNumber)
      {
    	   int ln = lineNumber - (lineNumber%50);
    	   for(int i= 0; i < 50; i++)
    	   {
    		   if(G4Final.jList[jobNumber].numLines()>ln+i)
    		   {
    			   comp.cache[lru(cacheLastLoaded)*50+i]= G4Final.jList[jobNumber].getLine(ln+i);
    			   cacheIndex[lru(cacheLastLoaded)*50+i]= "" + jobNumber + " " + ln+i;
    		   }
    	   }
    	   for(int i=0; i < cacheLastLoaded.length; i++)
    	   {
    		   cacheLastLoaded[i]++;
    	   }
    	   cacheLastLoaded[lru(cacheLastLoaded)] = 0;
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

	public int lru(int[] x) {
		int max = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] > x[max]) {
				max = i;
			}
		}
		return max;
	}
}
  
