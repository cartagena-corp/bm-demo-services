package com.demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cuenta {
    private String id;
    private String numeroProducto;
    private String numeroProductoCompleto;
    private String tipoProducto;
    private String tipoCuenta;
    private String saldoDisponible;
    private String saldoTotal;
    private boolean origenPago;
    private String tipoOperacionCuenta;
    private int estadoCuenta;
    private String aplicaInteres;
    private String rentabilidad;
}
