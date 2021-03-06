import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/word-form.vtl");
     return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("words", Word.all());
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Word newWord = new Word(name);
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     Word word = Word.find(Integer.parseInt(request.params(":id")));
     model.put("word", word);
     model.put("template", "templates/word.vtl");
     return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      String definition = request.queryParams("definition");
      Definition newDef = new Definition(definition);
      word.addDefinition(newDef);
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/delete-success", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      word.getDefinitions().clear();
      model.put("template", "templates/delete-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
