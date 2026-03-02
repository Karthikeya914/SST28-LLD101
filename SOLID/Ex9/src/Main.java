public class Main {
    public static void main(String[] args) {

        System.out.println("=== Evaluation Pipeline ===");

        Submission sub = new Submission(
                "23BCS1007",
                "public class A{}",
                "A.java"
        );

        PlagiarismCheck plagiarismCheck = new PlagiarismChecker();
        CodeGrading codeGrading = new CodeGrader();
        ReportWriting reportWriting = new ReportWriter();

        EvaluationPipeline pipeline = new EvaluationPipeline(
                plagiarismCheck,
                codeGrading,
                reportWriting
        );

        pipeline.evaluate(sub);
    }
}