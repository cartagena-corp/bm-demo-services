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
public class Account implements Serializable {
	private String token;
	private String tipoProducto;
	private String numeroProductoTotal;
	private String numeroProducto;
	private String descripcionProducto;
	private String nombreProductoCliente;
	private String disponible;
	private String canje;
	private String saldoTotal;
	private String estadoBanTotal;
	private String tipoOperacion;
	private String descripcionEstadoProducto;
	private String tipoOperacionCuenta;
	private String aplicaInteres;
	private String rentabilidad;
}
