import java.util.List;

public class Printing {
    void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }
    void printErrors(List<String> errors) {
        System.out.println("ERROR: cannot register");
        for (String e : errors) {
            System.out.println("- " + e);
        }
    }
    void printSuccess(String id, StudentRecord rec, int total) {
        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + total);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
