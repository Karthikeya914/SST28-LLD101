public class EvaluationPipeline {

    private final PlagiarismCheck plagiarismCheck;
    private final CodeGrading codeGrading;
    private final ReportWriting reportWriting;

    public EvaluationPipeline(
            PlagiarismCheck plagiarismCheck,
            CodeGrading codeGrading,
            ReportWriting reportWriting
    ) {
        this.plagiarismCheck = plagiarismCheck;
        this.codeGrading = codeGrading;
        this.reportWriting = reportWriting;
    }

    public void evaluate(Submission sub) {
        Rubric rubric = new Rubric();

        int plag = plagiarismCheck.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = codeGrading.grade(sub, rubric);
        System.out.println("CodeScore=" + code);

        // writer already prints
        reportWriting.write(sub, plag, code);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}