import java.util.ArrayList;
import java.util.List;

public class Definition {
  private String mInformation;
  private static List<Definition> instances = new ArrayList<Definition>();
  private int mId;

  public Definition(String info){
    mInformation = info;
    instances.add(this);
    mId = instances.size();
  }

  public String getInformation() {
   return mInformation;
  }

 public static List<Definition> all() {
   return instances;
 }

 public static void clear() {
   instances.clear();
 }

 public int getId() {
   return mId;
 }

 public static Definition find(int id) {
 return instances.get(id - 1);
 }

}
