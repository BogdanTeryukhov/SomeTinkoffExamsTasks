package SummerJavaCourse2023.Tests;

import SummerJavaCourse2023.Tasks.Task1;
import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Task1Test {

    @Test
    public void lineUp() {
        assertThat(Task1.lineUp(Arrays.asList(1,2,3,4)),is(true));
        assertThat(Task1.lineUp(Arrays.asList(4,3,2,1)),is(true));
        assertThat(Task1.lineUp(Arrays.asList(1,3,2,4)),is(false));
        assertThat(Task1.lineUp(Arrays.asList(4,4,4,4)),is(true));
    }
}