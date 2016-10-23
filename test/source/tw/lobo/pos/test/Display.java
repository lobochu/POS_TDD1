package tw.lobo.pos.test;

/**
 * Created by Lobo on 2016/10/23.
 */
public class Display {

    private String text;

    public String getText() {
        return text;
    }

    public void displayPrice(String priceAsText) {
        this.text = priceAsText;
    }

    public void displayProductNotFoundMessage(String text) {
        this.text = "Product not found for " + text;
    }

    public void displayEmptyBarcodeMessage() {
        this.text = "Scanning error: empty barcode";
    }

    public void displayNoSaleInProgressMessage() {
        text = "No sale in progress. Try scanning a product.";
    }
}
