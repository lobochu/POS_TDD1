package tw.lobo.pos.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lobo on 2016/10/23.
 */
public class Sale {
    private final Catalog catalog;
    private Display display;
    private Collection<Integer> pendingPurchaseItemPrices = new ArrayList<Integer>();

    public Sale(Catalog catalog, Display display) {
        this.display = display;
        //introduce lookup table
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        //SMELL Refused bequest; move this up the call stack?
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;//guard clause
        }

        //1. Find scannedPrice.
        Integer priceInCents = catalog.findPrice(barcode);

        //2. If didn't get one, display product not found
        if (priceInCents == null) {
            display.displayProductNotFoundMessage(barcode);
            //3. If I did get one, diplay the scannedPrice.
        } else {
            pendingPurchaseItemPrices.add(priceInCents);
            display.displayPrice(priceInCents);
        }
    }

    public void onTotal() {
        //Reverse conditional logic to normal path
        boolean saleInProgress = !pendingPurchaseItemPrices.isEmpty();
        if (saleInProgress) {
            display.displayPurchaseTotal(pendingPurchaseTotal() );
        } else {
            display.displayNoSaleInProgressMessage();
        }
    }

    // REFACTOR Looks like Model behavior to me
    private Integer pendingPurchaseTotal() {
        return pendingPurchaseItemPrices.iterator().next();
    }

}
