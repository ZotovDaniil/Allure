import org.junit.jupiter.api.Test;

public class AnnotatedAttachments1 {
    @Test
    public void testAnnotatedAttachmentsOne() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.takeScreenshot();
    }
}
