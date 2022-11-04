package lombok.builderexam;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class TestFlatFileSplitter {

    @Test
    public void TestFlatFileSplitter() throws Exception {

        FlatFileSplitter flatFileSplitter = FlatFileSplitter.builder()
                .originResource(Path.of("/origin/origin.csv"))
                .targetResource(Path.of("/target/target.csv"))
                .splitLineCount(10000)
                .build();

        flatFileSplitter.exec();
    }

}
