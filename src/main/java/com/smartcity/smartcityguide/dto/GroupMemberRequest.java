package com.smartcity.smartcityguide.dto;

import lombok.Data;

@Data
public class GroupMemberRequest {

    private String priceRange;

    private String bestFor;

    private String timeAvailable;

    private String transport;

}