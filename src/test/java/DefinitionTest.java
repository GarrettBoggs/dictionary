import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class DefinitionTest {

  @Test
  public void defintion_instantiatesCorrectly_true() {
    Definition testCategory = new Definition("to move quickly");
    assertEquals(true, testCategory instanceof Definition);
  }

}
