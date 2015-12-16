package com.tdd.training;

import java.util.Formatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoCheckoutWithCart
{
    public static final Price PRICE = Price.cents(15);
    @Mock
    ShoppingCart shoppingCart;
    @Mock
    DisplayFormatter formatter;

    @Test
    public void checkoutPrice() {
        when(shoppingCart.getTotal()).thenReturn(PRICE);

        CheckoutCart cart = new CheckoutCart(shoppingCart,formatter);

        cart.onCheckout();

        verify(formatter).checkout(PRICE);
    }
}
