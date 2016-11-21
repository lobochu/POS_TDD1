package tw.lobo.pos.test;

/**
 * Created by Lobo on 2016/10/23.
 */
public class Display {

    private String text;

    // SMELL Move this behavior somewhere else, why author think about that..??
    public static String formatMonetaryAmount(int priceInCents) {
        return String.format("$%,.2f",
                priceInCents / 100.0d);
    }

    public String getText() {
        return text;
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
        this.text = "Total: " + formatMonetaryAmount(purchaseTotal);
    }

    public void displayPrice(Integer priceInCents) {
        this.text = formatMonetaryAmount(priceInCents);
    }
}
