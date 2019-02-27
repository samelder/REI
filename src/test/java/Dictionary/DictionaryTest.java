package Dictionary;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class DictionaryTest {

    @Test
    public void workingTest() throws Exception {
        String s = "working";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertTrue(a.contains("king"));
    }
    @Test
    public void numberTest() throws Exception {
        String s = "w345orking";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertTrue(a.contains("king"));
    }

    @Test
    public void spaceTest() throws Exception {
        String s = "wor k ing";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertTrue(a.contains("king"));
    }
    @Test
    public void puctuationTest() throws Exception {
        String s = "wor!@#k*&ing";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertTrue(a.contains("king"));
    }
    @Test
    public void multibyteCharactorTest() throws Exception {
        String s = "wor名k平ing";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertTrue(a.contains("king"));
    }

    @Test
    public void reverseTest() throws Exception {
        String s = "gnikrow";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertTrue(a.contains("king"));
    }

    //Invalid Tests
    @Test
    public void numberInvalidTest() throws Exception {
        String s = "12345";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertFalse(a.contains("4231"));
    }
    @Test
    public void upperCaseInvalidTest() throws Exception {
        String s = "WORKING";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertFalse(a.contains("KING"));
    }
    @Test
    public void mulitbiteInvalidTest() throws Exception {
        String s = "名平";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertFalse(a.contains("平"));
    }
    @Test
    public void emptyStringInvalidTest() throws Exception {
        String s = "";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertFalse(a.contains(""));
    }
    @Test
    public void puctuationInvalidTest() throws Exception {
        String s = "!@#$(*%";
        ArrayList a = new ArrayList();
        a = Dictionary.isEnglishWord(s);
        Assert.assertFalse(a.contains("@#$(*"));
    }

}
