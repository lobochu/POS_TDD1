package tw.lobo.pos.test;

/**
 * Created by Lobo on 2016/10/23.
 */
public class Display {

    public String text;

    // SMELL Move this behavior somewhere else, why author think about that..??
    public static String format(int priceInCents) {
        return String.format("$%,.2f",
                priceInCents / 100.0d);
    }

    public String getText() {
        return text;
    }

    public void displayText(String priceAsText) {
        this.text = priceAsText;
    }

    public void displayProductNotFoundMessage(String text) {
        this.text = "Product not found for " + text;
    }

    public void displayEmptyBarcodeMessage() {
        this.text = "Scanning error: empty barcode";
    }

    public void displayNoSaleInProgressMessage() {
        this.text = "No sale in progress. Try scanning a product.";
    }

    public void displayPurchaseTotal(Integer purchaseTotal) {
        this.text = "Total: " + format(purchaseTotal);
    }

    public void displayPrice(Integer priceInCents) {
        displayText(format(priceInCents));
    }
}
