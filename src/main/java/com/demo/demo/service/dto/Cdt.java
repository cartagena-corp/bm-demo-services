package com.demo.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cdt implements Serializable {
	private String token;
	private String tipoProducto;
	private String numeroProductoTotal;
	private String numeroProducto;
	private String descripcionProducto;
	private String nombreProductoCliente;
	private String fechaVencimiento;
	private String valorApertura;
	private String proximoVecimiento;
	private String tasaPactada;
	private String periodoPagoInteres;
	private String instruciones;
	private String estadoBanTotal;
	private String tipoOperacion;
	private String descripcionEstadoProducto;
}
