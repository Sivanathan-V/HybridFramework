package com.qa.pages.API.output_pojo.booking_output_pojo;

import lombok.Data;
import com.qa.pages.API.API_BasePage;

@Data
public class BookingdatesOutput extends API_BasePage {
    private String checkin;
    private String checkout;
}
