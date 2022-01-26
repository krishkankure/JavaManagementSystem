package mgmt; // apart of the mgmt package

public class KusUtils { // Main utilities for the Load Class and the program as a whole
    public static void write(String text) { // typewriter effect for text output
        for(int i = 0; i < text.length(); i++){ // for each iteration, i increased and.  The iterations are based on the text.length
            System.out.printf("%c", text.charAt(i)); // prints out the character at the lenght of i.
            try {
                Thread.sleep(5); // gives a delay for a typewriter effect (5ms)
            }
            catch(InterruptedException ex){  // throws exception if broke.
                Thread.currentThread().interrupt(); //breaks
            }
            
        }
        System.out.println(" "); // empty text so it gives space for next line
    }
    public static void sleep(int i) { // condenses thread sleeps into a single method to avoid always making try and catch function
        try {
            Thread.sleep(i); // sleeps for i amount passed through when the method is called
        }
        catch(InterruptedException ex) { // throws exception for when interrupted
            Thread.currentThread().interrupt();
        }
    }
    public static void pour(String text) { // alternative version of the write function method made for the info screen
        for(int i = 0; i < text.length(); i++){
            System.out.printf("%c", text.charAt(i));
            try {
                Thread.sleep(1); /* much faster here because the write function creates an animation too slow in this menu. 
                I did not pass through multiple variables into write because by the time this was added, 
                I had KusUtils.write all over load and it would be pretty intensive to replace them all */
            }
            catch(InterruptedException ex){ // throws exception if interupted
                Thread.currentThread().interrupt();
            }
            
        }
        System.out.println(" "); // gives space after the text is "typed" out
    }
}
