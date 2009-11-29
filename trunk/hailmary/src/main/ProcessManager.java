

/*
 *      processManager.java
 *      
 *  
 */


public class ProcessManager {
     List<String> list = new List<String>();
    int timeQuantum = 10;
    int endCycle;
    private int size;
    
    public ProcessManager()
    {
        size = 0;
    }
    public void newJob(int activeJob) throws IndexOutOfBound {
            list.add(size,Integer.toString(activeJob));
            size = size + 1;
    }
    public void jobFinished(int deleteJob) throws IndexOutOfBound{
        int jobCounter = 0;
        if (jobCounter < size){
            String holder = list.get(jobCounter);
            if (Integer.parseInt(holder) == deleteJob){
                list.remove(jobCounter);
                size--;
            }
            else{
                jobCounter = jobCounter + 1;
            }
        }
    }
    /*
     * returns true if the CPU is to continue processing the current job
     */
    public boolean continueCurrentJob(int cpuCycle){
        if (cpuCycle == endCycle)
        //determine whether or not to continue processing the current job
            return false;
        else 
            return true;
    }
    
    /*
     * tells the CPU which job to process next
     */
    public int loadJob(int cpuCycle) throws IndexOutOfBound
    {
        if( size == 0)
        {
            return -1;
        }
        else{
            if (size == 1){
                endCycle = cpuCycle + timeQuantum;
                return Integer.valueOf(list.get(list.getPointer()));
            }
            else{
                endCycle = cpuCycle + timeQuantum;
                return Integer.valueOf(list.get(list.movePointer()));
            }
        
        }
        //returns the next job that will be processed by the cpu
    }
}
