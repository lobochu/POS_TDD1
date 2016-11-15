package tw.lobo.pos.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lobo on 2016/10/23.
 */
public class SellMultipleItemsTest {
    @Test
    public void oneItemNotFound() throws Exception {
        Catalog catalog = new Catalog(Collections.singletonMap("12345", 650));
        Display display = new Display();
        Sale sale = new Sale(catalog, display);

        sale.onBarcode("99999");
        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());
    }

    @Test
    public void OneItemFound() throws Exception {
        Catalog catalog = new Catalog(Collections.singletonMap("12345", 650));
        Display display = new Display();
        Sale sale = new Sale(catalog, display);
        sale.onBarcode("12345");
        sale.onTotal();

        Assert.assertEquals("Total: $6.50", display.getText());
    }

    @Ignore
    public void severalItemsAllFound() throws Exception {
        Catalog catalog = new Catalog(new HashMap<String, Integer>() {{
            put("1", 850);
            put("2", 1275);
            put("3", 330);
        }});

        Display display = new Display();
        Sale sale = new Sale(catalog, display);
        sale.onBarcode("1");
        sale.onBarcode("2");
        sale.onBarcode("3");
        sale.onTotal();

        Assert.assertEquals("Total: $24.55", display.getText());
    }

    @Test
    public void zeroItems() throws Exception {
        Display display = new Display();

        Sale sale = new Sale(null, display);
        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());
    }
}
