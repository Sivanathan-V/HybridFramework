package com.qa.pages.API.output_pojo.booking_output_pojo;

import lombok.Data;
import com.qa.pages.API.API_BasePage;

@Data
public class BookingOutput extends API_BasePage {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingdatesOutput bookingdates;
    private String additionalneeds;


}
