package com.mruruc.authentication;

import com.mruruc.exceptions.ClientAuthException;
import com.mruruc.model.client.Client;

import java.time.LocalDate;

public class ClientAuth {
    public ClientAuth(){}

    public boolean authNewClient(Client client) throws ClientAuthException{
        if(client.getFirstName()== null ||
           client.getLastName() == null ||
           client.getDob()== null ||
           client.getGender() == null || client.getPhone() == null ||
           client.getEmail() == null || client.getAddressID() == null){
            throw new NullPointerException("Field Can Not Be Null!");
        }


        AuthUtils.checkForBlankAndEmptyAndNull(client.getFirstName(), ClientAuthException.class,"First Name Must Be Filled!");
        AuthUtils.checkForBlankAndEmptyAndNull(client.getLastName(), ClientAuthException.class,"Last Name Must Be Filled!");
        AuthUtils.checkForBlankAndEmptyAndNull(client.getDob().toString(), ClientAuthException.class,"Date Of Birth Must Be Filled!");

        if(!this.dateOfBirthAuthentication(client.getDob())){
            throw new ClientAuthException("Invalid Date Of Birth.");
        }

        AuthUtils.checkForBlankAndEmptyAndNull(client.getGender().toString(), ClientAuthException.class,"Gender Must Be Filled!");

        if(client.getPhone().getFirst() == null ||
                client.getPhone().getFirst().isEmpty() ||
                client.getPhone().getFirst().isBlank()){

            throw new ClientAuthException("At least One Phone Number Must Be Provided!");
        }

        AuthUtils.checkForBlankAndEmptyAndNull(client.getEmail(), ClientAuthException.class,"Email Must Be Filled!");

        return true;
    }

    private boolean dateOfBirthAuthentication(LocalDate dob){
        if(dob == null){
            throw new ClientAuthException("Invalid Date Of Birth.");
        }

        LocalDate currentDate=LocalDate.now();
        LocalDate earliestDOB=LocalDate.of(1990,1,1);

        return dob.isAfter(earliestDOB) && dob.isBefore(currentDate);
    }


}
