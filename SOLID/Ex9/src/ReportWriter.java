public class ReportWriter implements ReportWriting {

    @Override
    public String write(Submission s, int plagiarismScore, int codeScore) {
        String file = "report-" + s.roll + ".txt";
        System.out.println("Report written: " + file);
        return file;
    }
}