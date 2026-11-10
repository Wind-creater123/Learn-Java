package JUnitDemo;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    @Test
    public void testPrintNumber() {
        StringUtil.printNumber("abc");
        StringUtil.printNumber("");
        StringUtil.printNumber(null);
    }

    @Test
    public void testGetMaxIndex() {
        int index1 = StringUtil.getMaxIndex("abc");
        int index2 = StringUtil.getMaxIndex("");
        int index3 = StringUtil.getMaxIndex(null);

        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);

        Assert.assertEquals(2,index1);
        Assert.assertEquals(-1,index2);
        Assert.assertEquals(-1,index3);
    }
}
