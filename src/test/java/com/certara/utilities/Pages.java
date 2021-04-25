package com.certara.utilities;

import com.certara.pages.*;

public class Pages {

    private ContactPage contactPage;

    public ContactPage contactPages(){
        if(contactPage==null){
            contactPage = new ContactPage();
        }
        return contactPage;
    }


}
