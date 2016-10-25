package tw.lobo.pos.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lobo on 2016/10/23.
 */
public class SellMultipleItemsTest {
    @Test
    public void OneItemFound() throws Exception {
        Catalog catalog = new Catalog(Collections.singletonMap("12345", "$6.50"));
        Display display = new Display();
        Sale sale = new Sale(catalog, display);
        sale.onBarcode("12345");
        sale.onTotal();

        Assert.assertEquals("Total: $6.50", display.getText());
    }

    @Test
    public void zeroItems() throws Exception {
        Display display = new Display();

        Sale sale = new Sale(null, display);
        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());

    }
}
