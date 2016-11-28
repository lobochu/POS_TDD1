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

    @Test
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
    public void severalItemsAllNotFound() throws Exception {
        Display display = new Display();
        Sale sale = new Sale(
                catalogWithoutBarcodes("product you won't find",
                        "another product your wont' find",
                        "a third product you won't find")
                , display);

        sale.onBarcode("product you won't find");
        sale.onBarcode("another product your wont' find");
        sale.onBarcode("a third product you won't find");
        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());
    }

    private Catalog catalogWithoutBarcodes(String... barcodesToExclude) {
        return emptyCatalog();
    }

    private Catalog emptyCatalog() {
        return new Catalog(Collections.emptyMap());
    }

    @Test
    public void serveralItemsOfWhichOneIsEmpty() throws Exception {
        Catalog catalog = new Catalog(new HashMap<String, Integer>() {{
            put("1", 3100);
            put("2", 460);
        }});

        Display display = new Display();
        Sale sale = new Sale(catalog, display);
        sale.onBarcode("1");
        sale.onBarcode("");
        sale.onBarcode("2");
        sale.onTotal();

        Assert.assertEquals("Total: $35.60", display.getText());
    }

    @Test
    public void severalItemsSomeNotFound() throws Exception {
        Catalog catalog = new Catalog(new HashMap<String, Integer>() {{
            put("1", 1200);
            put("2", 500);
        }});

        Display display = new Display();
        Sale sale = new Sale(catalog, display);
        sale.onBarcode("1");
        sale.onBarcode("you don't know this product");
        sale.onBarcode("2");
        sale.onTotal();

        Assert.assertEquals("Total: $17.00", display.getText());
    }

    @Test
    public void zeroItems() throws Exception {
        Display display = new Display();

        Sale sale = new Sale(null, display);
        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());
    }
}
