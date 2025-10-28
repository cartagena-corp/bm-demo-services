package com.demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PosicionGlobalDTO {
    private List<Cuenta> cuentas;
    private String totalCuenta;
    private String totalTotalCuenta;
    private List<Credito> creditos;
    private String totalCredito;
    private String totalCupoUtilizado;
    private List<CDT> cdts;
    private String totalCdt;
}
