import junit.framework.Assert;
import org.junit.Test;
import romanNumerals.RomanNumerals;

public class romanTestCases /*extends TestCase*/ {



    int testNum;
    String testString;
    RomanNumerals rn = new RomanNumerals();

    @Test
    public void getZero() {
        testNum = rn.numeralToNumbers("");
        Assert.assertEquals(0, testNum);
        testNum = rn.numeralToNumbers("JK");
        Assert.assertEquals(0,testNum);

    }

    @Test
    public void getTen() {
        testNum = rn.numeralToNumbers("X");
        Assert.assertEquals(10, testNum);

    }

    @Test
    public void getTwentyNine() {
        testNum = rn.numeralToNumbers("XXIX");
        Assert.assertEquals(29, testNum);

    }

    @Test
    public void getNineHundred() {
        testNum = rn.numeralToNumbers("CM");
        Assert.assertEquals(900, testNum);

    }

    @Test
    public void getNinteenFortyFive() {
        testNum = rn.numeralToNumbers("MCMXLV");
        Assert.assertEquals(1945, testNum);
    }
    //For Some reason, the code does NOT remove "CM" and "IV" and retains the full string
    @Test
    public void getNinteenSixtyFour(){
        Assert.assertEquals(1964,rn.numeralToNumbers("MCMLXIV"));
    }

    @Test
    public void getMCMXCII(){
        testString = rn.numberToNumeral(1992);
        Assert.assertEquals("MCMXCII",testString);
    }
    @Test
    public void getMMXIX(){
        testString = rn.numberToNumeral(2019);
        Assert.assertEquals("MMXIX",testString);
    }
    @Test
    public void getMCMLIX(){
        testString = rn.numberToNumeral(1959);
        Assert.assertEquals("MCMLIX",testString);
    }
    @Test
    public void getMCMXLV(){
        testString = rn.numberToNumeral(1945);
        Assert.assertEquals("MCMXLV",testString);
    }
    @Test
    public void getNegativeIn(){
        testString = rn.numberToNumeral(-1);
        Assert.assertEquals("",testString);
    }
}
