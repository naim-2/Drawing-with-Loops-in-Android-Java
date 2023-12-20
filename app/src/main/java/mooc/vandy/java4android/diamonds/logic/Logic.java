package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        printEnds(size);
        for (int i = 0; i < size - 1; i++) {
            printRestUp(size, i);
        }
        printCenter(size);
        for (int j = size - 2; j >= 0; j--) {
            printRestDown(size, j);
        }
        printEnds(size);
    }

    // TODO -- add any helper methods here
    private void printEnds(int size) {
        for (int i = 0; i < size * 2 + 2; i++) {
            mOut.print((i == 0 || i == size * 2 + 1) ? "+" : "-");
        }
        mOut.println();
    }
    private void printRestUp(int size, int row){
        mOut.print("|");
        for (int i = 0; i < size - row - 1; i++) {
            mOut.print(" ");
        }
        mOut.print("/");
        for (int j = 0; j < row * 2; j++) {
            mOut.print((row % 2 == 0) ? "=" : "-");
        }
        mOut.print("\\");
        for (int k = 0; k < size - row - 1; k++) {
            mOut.print(" ");
        }
        mOut.println("|");
    }
    private void printCenter(int size){
        mOut.print("|<");
        for (int i = 0; i < size * 2 - 2; i++) {
            mOut.print((size % 2 == 0) ? "-" : "=");
        }
        mOut.print(">|");
        mOut.println();
    }
    private void printRestDown(int size, int row){
        mOut.print("|");
        for (int i = 0; i < size - row - 1; i++) {
            mOut.print(" ");
        }
        mOut.print("\\");
        for (int j = 0; j < row * 2; j++) {
            mOut.print((row % 2 == 0) ? "=" : "-");
        }
        mOut.print("/");
        for (int k = 0; k < size - row - 1; k++) {
            mOut.print(" ");
        }
        mOut.println("|");
    }
}
