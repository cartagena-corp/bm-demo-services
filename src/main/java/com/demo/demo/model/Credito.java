package com.demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Credito {
    private String id;
    private String numeroProducto;
    private String tipoCredito;
    private String pagoMinimo;
    private String fechaPagoMinimo;
    private String totalPago;
    private String diasMora;
    private String saldoMora;
    private String cupoGobal;
    private String cupoDisponible;
    private String fechaPago;
    private String valorPago;
    private String linea;
    private boolean origenAlianza;
    private String cupoUtilizado;
}
