package com.fudgelate.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fudgelate.model.Cart;
import com.fudgelate.repository.CartRepository;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    @Test
    public void testCreateCart() {
        // Arrange
        Cart cart = new Cart();
        cart.setId(1L); // Assuming Cart has an ID field

        // Assume that persist throws an exception
        doThrow(new RuntimeException()).when(cartRepository).persist(any(Cart.class));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> cartService.createCart(cart));
        verify(cartRepository, times(1)).persist(cart);
    }
}