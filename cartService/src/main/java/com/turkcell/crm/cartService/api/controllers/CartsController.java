package com.turkcell.crm.cartService.api.controllers;

import com.turkcell.crm.cartService.business.abstracts.CartService;
import com.turkcell.crm.cartService.business.dtos.requests.AddProductToCartRequest;
import com.turkcell.crm.cartService.business.dtos.requests.CreateCartRequest;
import com.turkcell.crm.cartService.business.dtos.requests.UpdateCartRequest;
import com.turkcell.crm.cartService.business.dtos.responses.CreatedCartResponse;
import com.turkcell.crm.cartService.business.dtos.responses.GetAllCartsResponse;
import com.turkcell.crm.cartService.business.dtos.responses.GetCartResponse;
import com.turkcell.crm.cartService.business.dtos.responses.UpdatedCartResponse;
import com.turkcell.crm.cartService.entities.concretes.Cart;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartsController {

    private final CartService cartService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCartResponse add(CreateCartRequest createCartRequest) {
        return cartService.createCart(createCartRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCartResponse update(@RequestBody @Valid UpdateCartRequest updateCartRequest) {
        return cartService.updateCart(updateCartRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        cartService.deleteCart(id);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCartResponse get(@PathVariable int id) {
        return cartService.getCart(id);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCartsResponse> getAll() {
        return cartService.getAllCarts();
    }

    @PostMapping("/addproduct")
    @ResponseStatus(HttpStatus.OK)
    public void addProductToCart(@RequestBody AddProductToCartRequest addProductToCartRequest) {
        cartService.addProductToCart(addProductToCartRequest);
    }

    @DeleteMapping("/removeproduct/{productId}/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeProductFromCart(@PathVariable int productId, @PathVariable int cartId) {
        cartService.removeProductFromCart(productId, cartId);
    }

    @DeleteMapping("/clear/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public void clearCart(@PathVariable int cartId) {
        cartService.clearCart(cartId);
    }

    @GetMapping("/getByAccountId/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public GetCartResponse getByAccountId(@PathVariable String accountId) {
        return cartService.getCartByAccountId(accountId);
    }

    @GetMapping("/getAllItems")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Cart> getAllItems() {
        return cartService.getAllItems();
    }

    @GetMapping("/getTotalPrice/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public double getTotalPriceByAccountId(@PathVariable int accountId) {

        return cartService.getTotalPriceByAccountId(accountId);
    }


}
