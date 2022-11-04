package lombok.builderexam;

import java.nio.file.Path;

import lombok.Builder;
import lombok.Builder.Default;

@Builder
public class FlatFileSplitter {

    private Path originResource;
    private Path targetResource;
    @Default
    private int splitLineCount = 1000;

    public void exec() throws Exception {

        // Valid parameteres

        System.out.println(
                String.format(
                        "originResource path %s \n" +
                                "targetResource path %s \n" +
                                "splitLineCount %d",
                        originResource.toAbsolutePath(),
                        targetResource.toAbsolutePath(),
                        splitLineCount));
    }

}
