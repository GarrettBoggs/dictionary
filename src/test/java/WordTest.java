import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("run");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getSpelling_wordInstantiatesWithSpelling_run() {
    Word testWord = new Word("run");
    assertEquals("run", testWord.getSpelling());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("run");
    Word secondWord = new Word("sprint");
    assertEquals(true, Word.all().contains(firstWord));
    assertEquals(true, Word.all().contains(secondWord));
  }

  @Test
  public void clear_emptiesAllWordsFromList_0() {
   Word testWord = new Word("run");
   Word.clear();
   assertEquals(Word.all().size(), 0);
  }

  @Test
  public void getId_wordInstantiateWithAnId_1() {
   Word.clear();
   Word testWord = new Word("run");
   assertEquals(1, testWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondWord() {
   Word.clear();
   Word firstWord = new Word("run");
   Word secondWord = new Word("sprint");
   assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyList_ArrayList() {
    Word.clear();
    Word testWord = new Word("run");
    assertEquals(0, testWord.getDefinitions().size());
  }

  @Test
  public void addDefinition_addsDefinitionToList_true() {
    Word testWord = new Word("run");
    Definition testDefinition = new Definition("move at a speed faster than a walk");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }
}
