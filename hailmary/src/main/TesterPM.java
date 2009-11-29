package main;
public class TesterPM
{

    

        public static ProcessManager pm;
        
        public static void main (String[]args) throws IndexOutOfBound
        {
            int saveState;
            pm = new ProcessManager();
//Test to make sure the new job is loaded properly.
            pm.newJob(0);
            saveState = pm.loadJob(0);
            System.out.println(saveState);
// Test to make sure that the continueCurrentJob method runs properly.
            for (int i = 0;pm.continueCurrentJob(i-1);i++)
            
                if (pm.continueCurrentJob(i) == true){
                    System.out.println("Working");

                }
                else
                {
                    System.out.println("Terminate.");
//Test to make sure that the jobFinished method deletes properly.
                    pm.jobFinished(0);
                    saveState = pm.loadJob(0);
                    System.out.println(saveState);
                    saveState = pm.loadJob(1);
                    System.out.println(saveState);
                }
//Test to make sure that a deleted job does not remain in the list.
                    pm.newJob(1);
                    saveState = pm.loadJob(0);
                    System.out.println(saveState);
                    saveState = pm.loadJob(1);
                    System.out.println(saveState);
//Test to make sure that the list alternates properly between two jobs assuming a completed time quantum.
                    pm.newJob(2);
                    saveState = pm.loadJob(10);
                    System.out.println(saveState);
                    saveState = pm.loadJob(20);
                    System.out.println(saveState);
                    saveState = pm.loadJob(30);
                    System.out.println(saveState);
                    saveState = pm.loadJob(40);
                    System.out.println(saveState);
        }
        

}
