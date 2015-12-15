package com.tdd.training;

public class PriceReader implements PointOfSaleListener
{
    private final Display display;
    private final PriceCatalog catalog;

    public PriceReader(PriceCatalog catalog, Display display)
    {
        this.catalog = catalog;
        this.display = display;
    }

    @Override
    public void onEvent(BarcodeEvent event)
    {
        Price price = catalog.findPrice(event.getValue());

        if (price == null) display.showPriceNotFound(event.getValue());
        else display.showPrice(price);
    }
}
