package com.order_service.order_service.service;

import com.order_service.order_service.dto.ProductDto;
import com.order_service.order_service.enums.OrderStatus;
import com.order_service.order_service.exception.ResourceNotFoundException;
import com.order_service.order_service.external.CartClient;
import com.order_service.order_service.external.CartItemClient;
import com.order_service.order_service.external.ProductClient;
import com.order_service.order_service.model.Order;
import com.order_service.order_service.model.OrderItem;
import com.order_service.order_service.payload.Cart;
import com.order_service.order_service.payload.CartItem;
import com.order_service.order_service.repository.OrderRepository;
import com.order_service.order_service.response.CartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.ReadOnlyFileSystemException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final CartClient cartClient;
    private final CartItemClient cartItemClient;
    private final ProductClient productClient;
    @Override
    public Order placeOrder(Long userId) {

        return null;
    }

    private Order createOrder(Cart cart){
        Order order =new Order();
//        order.getOrderStatus(OrderStatus.PENDING);
//        order.getOrderDate(LocalDate.now());
        return order;
    }

    private BigDecimal calculateTotalAmount(List<OrderItem> orderItems){
        return orderItems.stream()
                .map(item->item.getPrice()
                        .multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    private List<OrderItem> createOrderItems(Order order , Long cartId,Long productId){


        Cart cart = cartClient.getCart(cartId);
        ProductDto product = productClient.getProductById(productId);
        return cart.getCartItems().stream().map(cartItem -> {
            product.setInventory(product.getInventory() - cartItem.getQuantity());
            productClient.addProduct(product);
            return new OrderItem(
                    order,
                    productId,
                    cartItem.getQuantity(),
                    cartItem.getUnitPrice()
            );
        }).toList();

    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(()->new ResourceNotFoundException("not found"));
    }
}
