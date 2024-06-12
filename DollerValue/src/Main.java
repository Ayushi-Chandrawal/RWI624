//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String Str = "$2000";
        String numStr = Str.replace("$", "");

        int value = Integer.parseInt(numStr);

        value = value + 1;

        String incrementedValue = "$" + Integer.toString(value);

        System.out.println(" incremented value is: " + incrementedValue);
        }
    }
