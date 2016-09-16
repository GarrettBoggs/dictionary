import java.util.List;
import java.util.ArrayList;

public class Word {
  private String mSpelling;
  private static List<Word> instances = new ArrayList<Word>();
  private int mId;
  private List<Definition> mDefinitions;

  public Word(String spelling)
  {
    mSpelling = spelling;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getSpelling() {
     return mSpelling;
  }

  public static List<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
     return mId;
  }

  public static Word find(int id) {
    return instances.get(id - 1);
  }

  public List<Definition> getDefinitions() {
     return mDefinitions;
  }

   public void addDefinition(Definition def) {
     mDefinitions.add(def);
   }
}
