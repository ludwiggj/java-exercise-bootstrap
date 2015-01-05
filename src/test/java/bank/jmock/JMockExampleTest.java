package bank.jmock;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JMock.class) // Use the JMock test runner to get automatic verification
public class JMockExampleTest {
  Mockery context = new JUnit4Mockery();

  @Ignore
  @Test
  public void failingTest() {
    // Create mock instances
    final Comparable<String> mock1 = context.mock(Comparable.class);

    // Set expectations
    context.checking(new Expectations() {{
      oneOf(mock1).compareTo("BOB");
      will(returnValue(0));
    }});

    // Call the method to be tested on the class under test
    assertThat(new BadClassUnderTest().compare(mock1), is(0));

    // JMock will automatically verify that all of the expectations have been met.
    // If any have not been met then the test will fail and JMock will report the cause of the failure.
  }

  @Test
  public void passingTest() {
    // Create mock instances
    final Comparable<String> mock1 = context.mock(Comparable.class);

    // Set expectations
    context.checking(new Expectations() {{
      oneOf(mock1).compareTo("BOB");
      will(returnValue(0));
    }});

    // Call the method to be tested on the class under test
    assertThat(new GoodClassUnderTest().compare(mock1), is(0));

    // JMock will automatically verify that all of the expectations have been met.
    // If any have not been met then the test will fail and JMock will report the cause of the failure.
  }
}

// This is the class being tested. Normally this would be in src/main/java
class BadClassUnderTest {
  public int compare(Comparable comparable) {
    return 0;
  }
}

// This is the class being tested. Normally this would be in src/main/java
class GoodClassUnderTest {
  public int compare(Comparable comparable) {
    return comparable.compareTo("BOB");
  }
}