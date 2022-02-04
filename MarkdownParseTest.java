import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

// javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
// java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest

public class MarkdownParseTest {

  @Test
  public void addition() {
    assertEquals(2, 1 + 1);
  }

  @Test
  public void test1() throws IOException {
    String s = Files.readString(Path.of("test-file.md"));
    ArrayList<String> check = MarkdownParse.getLinks(s);
    List expected = List.of("https://something.com", "some-page.html");
    assertEquals(expected, check);
  }

  @Test
  public void test2() throws IOException {
    String s = Files.readString(Path.of("test2.md"));
    ArrayList<String> check = MarkdownParse.getLinks(s);
    List expected = List.of("https://something.com", "some-page.html");
    assertEquals(expected, check);
  }
    @Test
    public void test3() throws IOException {
      String s = Files.readString(Path.of("test3.md"));
      ArrayList<String> check = MarkdownParse.getLinks(s);
      ArrayList<String> expected = new ArrayList<>();
      expected.add("");
      assertEquals(expected, check);
    }

    @Test
    public void test4() throws IOException {
      String s = Files.readString(Path.of("test4.md"));
      ArrayList<String> check = MarkdownParse.getLinks(s);
      List<String> expected = List.of("");
      assertEquals(expected, check);
    }

    @Test
    public void test5() throws IOException {
      String s = Files.readString(Path.of("test5.md"));
      ArrayList<String> check = MarkdownParse.getLinks(s);
      List expected = List.of("page.com");
      assertEquals(expected, check);
    }

  //   @Test
  //   public void test6() throws IOException {
  //     String s = Files.readString(Path.of("test6.md"));
  //     ArrayList<String> check = MarkdownParse.getLinks(s);
  //     List expected = List.of("");
  //     assertEquals(expected, check);
  //   }

  //   @Test
  //   public void test7() throws IOException {
  //     String s = Files.readString(Path.of("test7.md"));
  //     ArrayList<String> check = MarkdownParse.getLinks(s);
  //     List expected = List.of("");
  //     assertEquals(expected, check);
  //   }

  //   @Test
  //   public void test8() throws IOException {
  //     String s = Files.readString(Path.of("test8.md"));
  //     ArrayList<String> check = MarkdownParse.getLinks(s);
  //     List expected = List.of("");
  //     assertEquals(expected, check);
  //   }
}
