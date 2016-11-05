package tw.lobo.pos.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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
        return Arrays.asList(new Object[][]{
                {789, "$7.89"},
                {520, "$5.20"},
                {400, "$4.00"},
                {0, "$0.00"},
                {2, "$0.02"},
                {37, "$0.37"},
                {418976, "$4,189.76"},
                {210832281, "$2,108,322.81"}
        });

//        return Collections.singletonList(
//                new Object[]
//                        {789, "$7.89"}
//        );
    }

    @Test
    public void test() throws Exception {
        assertEquals(expectedFormattedPrice, Catalog.format(priceInCents));

    }


}
