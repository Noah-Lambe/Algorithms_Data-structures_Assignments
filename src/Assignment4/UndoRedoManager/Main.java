package Assignment4.UndoRedoManager;

public class Main {
    public static void main(String[] args) {
        stateHistory<String> editor = new stateHistory<>();
        editor.addState("1");
        editor.addState("2");
        editor.addState("3");
        editor.addState("4");
        editor.addState("5");

        System.out.println("Current State: " + editor.getCurrentState());

        editor.undo(); // back to "4"
        editor.redo(); // back to "5"
        editor.undo(); // back to "4"
        editor.undo(); // back to "3"

        System.out.println("Current State: " + editor.getCurrentState());

        editor.undo(); // back to "2"
        editor.undo(); // back to "1"

        System.out.println("Current State: " + editor.getCurrentState());
    }
}
