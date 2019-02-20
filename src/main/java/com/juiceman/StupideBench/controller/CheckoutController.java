package com.juiceman.StupideBench.controller;


import com.juiceman.StupideBench.exception.NumNotAvailalbeException;
import com.juiceman.StupideBench.exception.ResourceNotFoundException;
import com.juiceman.StupideBench.model.Address;
import com.juiceman.StupideBench.payload.ApiResponse;
import com.juiceman.StupideBench.security.CurrentUser;
import com.juiceman.StupideBench.security.PersonPrincipal;
import com.juiceman.StupideBench.service.CheckoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class CheckoutController {


    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @Autowired
    private CheckoutService checkoutService;


    @PutMapping("/choutoutonitems")
    public ResponseEntity<?> checkoutOnShoppingcart(@CurrentUser PersonPrincipal currentUser){

        try{

            Address address = new Address();
            address.setName("home");
            address.setCity("San Jose");
            address.setState("CA");
            address.setZip("95131");
            address.setStreet("1383 Pine Lake Dr");

            checkoutService.checkoutOnShoppingcart(currentUser.getUsername(), currentUser.getId(), address);
        }catch (ResourceNotFoundException e){
            logger.error(e.getMessage());
            return new ResponseEntity(new ApiResponse(false, e.getMessage()),
                    HttpStatus.NOT_FOUND);

        }catch (NumNotAvailalbeException e){
            logger.error(e.getMessage());
            return new ResponseEntity(new ApiResponse(false, e.getMessage()),
                    HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(new ApiResponse(true, "your orders have been placed !, thanks "));
    }

}
