package com.demo.demo.controller;

import com.demo.demo.factory.PosicionGlobalDTOFactory;
import com.demo.demo.model.PosicionGlobalDTO;
import com.demo.demo.service.AccountOverviewService;
import com.demo.demo.service.dto.AccountOverview;
import jakarta.servlet.http.HttpServletRequest;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account-overview")
public class AccountOverviewController {

    private final AccountOverviewService accountOverviewService;

    private final HttpServletRequest httpServletRequest;

    public AccountOverviewController(AccountOverviewService accountOverviewService, HttpServletRequest httpServletRequest) {
        this.accountOverviewService = accountOverviewService;
        this.httpServletRequest = httpServletRequest;
    }

    @GetMapping
    public ResponseEntity<PosicionGlobalDTO> getAccountOverview() {
        AccountOverview accountOverview = accountOverviewService.getAccountOverview("10.31.160.91",
                "1", "1193270812");

        PosicionGlobalDTO dto = Mappers.getMapper(PosicionGlobalDTOFactory.class).from(accountOverview);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dto);
    }


}
