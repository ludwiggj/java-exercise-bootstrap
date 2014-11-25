
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class Placeholder {
	@Test
	public void useless() {
		assertThat(1, is(1));
	}
}