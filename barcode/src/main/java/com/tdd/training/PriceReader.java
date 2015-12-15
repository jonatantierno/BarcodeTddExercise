package com.tdd.training;

public class PriceReader implements PointOfSaleListener
{
    private final PriceConsumer priceConsumer;
    private final PriceCatalog catalog;
    private final Display display;

    public PriceReader(PriceCatalog catalog, PriceConsumer priceConsumer, Display display)
    {
        this.catalog = catalog;
        this.priceConsumer = priceConsumer;
        this.display = display;
    }

    @Override
    public void onEvent(SystemInputEvent event)
    {
        Price price = catalog.findPrice(event.getValue());

        if (price == null)
        {
            display.show("Price for " + event.getValue() + " not Found");
        }
        else
        {
            priceConsumer.consumePrice(price);
        }
    }
}
