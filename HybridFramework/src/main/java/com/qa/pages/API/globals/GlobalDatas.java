package com.qa.pages.API.globals;


import lombok.Data;
import com.qa.pages.API.API_BasePage;

@Data
public class GlobalDatas extends API_BasePage {

    private int statusCode;
    private String bookingId;
    private String token;

}
