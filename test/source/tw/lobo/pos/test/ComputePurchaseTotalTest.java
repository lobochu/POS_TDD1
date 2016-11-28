package tw.lobo.pos.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by twlcbo on 2016/11/22.
 */
public class ComputePurchaseTotalTest {
    @Test
    public void oneItem() throws Exception {
        Assert.assertEquals(795, computePurchaseTotal(Collections.singletonList(795)));

    }

    @Test
    public void severalItems() throws Exception {
        Assert.assertEquals(2455, computePurchaseTotal(Arrays.asList(850, 1275, 330)));

    }

    @Test
    public void zeroItems() throws Exception {
        Assert.assertEquals(0, computePurchaseTotal(Collections.<Integer>emptyList()));

    }

    private static int computePurchaseTotal(List<Integer> purchaseItemPrices) {
        return Sale.computePurchaseTotal(purchaseItemPrices);
    }
}
