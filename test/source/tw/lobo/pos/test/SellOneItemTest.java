package tw.lobo.pos.test;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by twlcbo on 2016/10/7.
 */
public class SellOneItemTest {


    private Display display;
    private Display display1;
    private Sale sale;

    @Before
    public void setUp() throws Exception {
        //Arrange
        display = new Display();

        //Act , Sale: Input , Display: Output
        //Output closer to the input.
        sale = new Sale(new Catalog(display, new HashMap<String, String>() {{
            put("12345", "$7.95");
            put("23456", "$12.50");
        }}), this.display);
    }

    @Test
    public void anotherProductFound() throws Exception {

        //Act
        sale.onBarcode("23456");

        //Assert
        assertEquals("$12.50", display.getText());

    }

    @Test
    public void productFound() throws Exception {

        sale.onBarcode("12345");

        //Assert
        assertEquals("$7.95", display.getText());
    }

    @Test
    public void productNotFound() throws Exception {

        sale.onBarcode("99999");

        assertEquals("Product not found for 99999", display.getText());
    }

    @Test
    public void emptyBarcode() throws Exception {
        Sale sale = new Sale(new Catalog(display, null), this.display);
        sale.onBarcode("");

        assertEquals("Scanning error: empty barcode", display.getText());
    }

    public static class Catalog {
        private final Display display;
        private final Map<String, String> pricesByBarcode;

        public Catalog(Display display, Map<String, String> pricesByBarcode) {
            this.display = display;
            this.pricesByBarcode = pricesByBarcode;
        }

        public Display getDisplay() {
            return display;
        }


        public String findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }
}
