import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void defintion_instantiatesCorrectly_true() {
    Definition testCategory = new Definition("move at a speed faster than a walk");
    assertEquals(true, testCategory instanceof Definition);
  }

    @Test
  public void Definition_instantiatesWithDescription_String() {
    Definition myDefinition = new Definition("move at a speed faster than a walk");
    assertEquals("move at a speed faster than a walk", myDefinition.getInformation());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("move at a speed faster than a walk");
    Definition secondDefinition = new Definition("move about in a hurried and hectic way");
    assertEquals(true, Definition.all().contains(firstDefinition));
    assertEquals(true, Definition.all().contains(secondDefinition));
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("move at a speed faster than a walk");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_tasksInstantiateWithAnID_1() {
    Definition.clear();
    Definition myDefinition = new Definition("move at a speed faster than a walk");
    assertEquals(1, myDefinition.getId());
  }
  
  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("move at a speed faster than a walk");
    Definition secondDefinition = new Definition("move about in a hurried and hectic way");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

}
