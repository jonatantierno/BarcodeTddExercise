package com.tdd.training;

public class CommandParser implements PointOfSaleListener
{
    private final InputEventListener barcodeListener;
    private final CheckoutListener checkoutListener;

    public CommandParser(InputEventListener inputEventListener, CheckoutListener checkoutListener)
    {
        this.barcodeListener = inputEventListener;
        this.checkoutListener = checkoutListener;
    }

    @Override
    public void onEvent(SystemInputEvent event)
    {
        if ("t".equals(event.getValue())) checkoutListener.onCheckout();
        else barcodeListener.onBarcode(event);
    }
}
