 package Client.RunOs;

import Client.OS_Application.DisplayOS.Display;
import resourceOS.Loading;
import java.util.Random;

public class RunOS {
    private static boolean canProceed = true;
    public static void main(String[] args) throws InterruptedException {
        Loading loadOSApplication = new Loading();
        loadOSApplication.setVisible(true);
        Random randLoadAppli = new Random();
        int randDomApp = (int) (randLoadAppli.nextInt(10000) + (Math.tan(100) / Math.sin(589)) / Math.sinh(100));
        
        System.err.println("Time: " + randDomApp);
        
        Thread.sleep(randDomApp);
        loadOSApplication.dispose();
        try{
            if(canProceed){
                new Display();
            } else{
                
            }
        } catch (ExceptionInInitializerError e){
            
        }
    }
}
