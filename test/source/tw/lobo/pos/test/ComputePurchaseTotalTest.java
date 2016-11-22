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

    private int computePurchaseTotal(List<Integer> purchaseItemPrices) {
        if (purchaseItemPrices.isEmpty())
            return 0;
        else if (purchaseItemPrices.size() == 1)
            return Sale.computePurchaseTotal(purchaseItemPrices).intValue();
        else
            return purchaseItemPrices.stream().reduce(0, Integer::sum);
    }
}
