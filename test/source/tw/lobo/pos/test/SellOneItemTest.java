package tw.lobo.pos.test;


import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by twlcbo on 2016/10/7.
 */
public class SellOneItemTest {


    @Test
    public void anotherProductFound() throws Exception {
        //Arrange
        Display display = new Display();
        Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "$7.95");
            put("23456", "$12.50");
        }});

        //Act
        sale.onBarcode("23456");

        //Assert
        assertEquals("$12.50", display.getText());

    }

    @Test
    public void productFound() throws Exception {
        //Arrange
        Display display = new Display();
        Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "$7.95");
            put("23456", "$12.50");
        }});

        //Act , Sale: Input , Display: Output
        //Output closer to the input.
        sale.onBarcode("12345");

        //Assert
        assertEquals("$7.95", display.getText());
    }

    @Test
    public void productNotFound() throws Exception {
        //Arrange
        Display display = new Display();
        Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "$7.95");
            put("23456", "$12.50");
        }});

        sale.onBarcode("99999");

        assertEquals("Product not found for 99999", display.getText());
    }

    @Test
    public void emptyBarcode() throws Exception {
        Display display = new Display();
        Sale sale = new Sale(display, Collections.<String, String> emptyMap());

        sale.onBarcode("");

        assertEquals("Scanning error: empty barcode", display.getText());
    }

    public static class Display {

        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class Sale {
        private Display display;
        private Map<String, String> pricesByBarcode;

        public Sale(Display display, Map<String, String> pricesByBarcode) {
            this.display = display;
            //introduce lookup table
            this.pricesByBarcode = pricesByBarcode;
        }

        public void onBarcode(String barcode) {
            //SMELL Refused bequest; move this up the call stack?
            if ("".equals(barcode)) {
                display.setText("Scanning error: empty barcode");
                return;//guard clause
            }
            if (pricesByBarcode.containsKey(barcode))
                display.setText(pricesByBarcode.get(barcode));
            else
                display.setText("Product not found for " +
                        barcode);
        }
    }
}
