import java.util.*;

public class OnboardingService {
    private final StudentRepository repo;

    public OnboardingService(StudentRepository repo) {
        this.repo = repo;
    }

    public void registerFromRawInput(String raw) {

        Printing printer = new Printing();
        printer.printInput(raw);

        StudentInputParser parser = new StudentInputParser();
        Map<String, String> kv = parser.parse(raw);
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        StudentValidator validator = new StudentValidator();
        List<String> errors = validator.validate(name, email, phone, program);
        if (!errors.isEmpty()) {

            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);
        repo.save(rec);

        printer.printSuccess(id, rec, repo.count());
    }
}
