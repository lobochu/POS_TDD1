package tw.lobo.pos.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by twlcbo on 2016/10/7.
 */
public class SellOneItemTest {
    @Test
    public void productFound() throws Exception {
        //Arrange
        Display display = new Display();
        Sale sale = new Sale();

        //Act
        sale.onBarcode("12345");

        //Assert
        assertEquals("$7.95", display.getText());

    }


    public static class Display {
        public String getText() {
            return null;
        }
    }

    public static class Sale {
        public void onBarcode(String barcode) {

        }
    }
}
