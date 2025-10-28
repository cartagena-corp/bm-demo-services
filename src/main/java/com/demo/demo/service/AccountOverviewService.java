package com.demo.demo.service;

import com.demo.demo.service.dto.AccountOverview;

public interface AccountOverviewService {
    AccountOverview getAccountOverview(String address, String documentType, String documentNumber);
}
