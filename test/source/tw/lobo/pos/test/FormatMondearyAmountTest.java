package tw.lobo.pos.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by twlcbo on 2016/11/2.
 */
@RunWith(Parameterized.class)
public class FormatMondearyAmountTest {

    private final int priceInCents;
    private final String expectedFormattedPrice;

    public FormatMondearyAmountTest(int priceInCents, String expectedFormattedPrice) {
        this.priceInCents = priceInCents;
        this.expectedFormattedPrice = expectedFormattedPrice;
    }

    @Parameterized.Parameters(name = "Monetary amount {0} formats to {1}")
    public static Collection<Object[]> data() {

        return Collections.singletonList(
                new Object[]
                        {789, "$7.89"}
        );
    }

    private static String format(int priceInCents) {
        return "$7.89";
    }

    @Test
    public void test() throws Exception {
        assertEquals(expectedFormattedPrice, format(priceInCents));

    }


}
