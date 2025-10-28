package com.demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CDT {
    private String id;
    private String totalPago;
    private String numeroProducto;
    private String tipoCdt;
    private String plazo;
    private String fechaVencimento;
    private String monto;
    private String tasaAnual;
    private String pagoInteres;
    private String condicionManejo;
    private String fechaConstituicion;
    private String fechaRenovacion;
    private String tasaNominal;
}
