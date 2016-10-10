package tw.lobo.pos.test;


import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by twlcbo on 2016/10/7.
 */
public class SellOneItemTest {


    @Test
    public void anotherProductFound() throws Exception {
        //Arrange
        Display display = new Display();
        Sale sale = new Sale(display);

        //Act
        sale.onBarcode("23456");

        //Assert
        assertEquals("$12.50", display.getText());

    }

    @Test
    public void productFound() throws Exception {
        //Arrange
        Display display = new Display();
        Sale sale = new Sale(display);

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
        Sale sale = new Sale(display);

        sale.onBarcode("99999");

        assertEquals("Product not found for 99999", display.getText());
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

        public Sale(Display display) {
            this.display = display;
        }

        public void onBarcode(String barcode) {
            if ("12345".equals(barcode))
                display.setText("$7.95");
            else if ("23456".equals(barcode))
                display.setText("$12.50");
            else
                display.setText("Product not found for " +
                        barcode);
        }
    }
}
