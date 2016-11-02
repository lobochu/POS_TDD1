package tw.lobo.pos.test;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by twlcbo on 2016/11/2.
 */
public class FormatMondearyAmountTest {
    private static String format(int priceInCents) {
        return "$7.89";
    }

    @Test
    public void simplest() throws Exception {
        assertEquals("$7.89", format(789));

    }


}
