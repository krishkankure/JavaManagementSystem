package mgmt;

public class KusUtils {
    public static void write(String text) {
        for(int i = 0; i < text.length(); i++){
            System.out.printf("%c", text.charAt(i));
            try {
                Thread.sleep(5);//0.5s pause between characters
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            
        }
        System.out.println(" ");
    }
    public static void sleep(int i) {
        try {
            Thread.sleep(i);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
