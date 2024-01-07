package com.mruruc.authentication;

import com.mruruc.exceptions.AddressAuthExceptions;
import com.mruruc.model.client.Address;

import static com.mruruc.authentication.AuthUtils.checkForBlankAndEmptyAndNull;

public class AddressAuth {

    public AddressAuth() {
    }

    public boolean authNewAddress(Address address) throws AddressAuthExceptions{
        if (address.getCountry() == null ||
                address.getCity() == null ||
                address.getStreet() == null ||
                address.getZip() == null ||
                address.getDoorNo() == null

        ) {
            throw new AddressAuthExceptions("Must be fill!");
        }
        if (address.getZip().trim().length() > 6) {
            throw new AddressAuthExceptions("Zip Code Must Be 5 Digit.{ex: xx-xxx}");
        }
        checkForBlankAndEmptyAndNull(address.getCountry(), AddressAuthExceptions.class, "Country Must Be Filled.");
        checkForBlankAndEmptyAndNull(address.getCity(), AddressAuthExceptions.class, "City Must Be Filled.");
        checkForBlankAndEmptyAndNull(address.getStreet(), AddressAuthExceptions.class, "Street Must Be Filled.");
        checkForBlankAndEmptyAndNull(address.getZip(), AddressAuthExceptions.class, "Zip Code Is Empty!");
        checkForBlankAndEmptyAndNull(address.getDoorNo().toString(), AddressAuthExceptions.class, "Door Number Must Be Filled.");
        return true;
    }


}

