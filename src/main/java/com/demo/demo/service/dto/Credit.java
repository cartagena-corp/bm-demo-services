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
public class Credit implements Serializable {
	private String token;
	private String tipoProducto;
	private String numeroProductoTotal;
	private String numeroProducto;
	private String descripcionProducto;
	private String nombreProductoCliente;
	private String valorCuota;
	private String pagoTotal;
	private String valorProximCuota;
	private String fechaProximaCuota;
	private String interesMora;
	private String diasMora;
	private String fechaCorte;
	private String saldoVencido;
	private String saldoPagar;
	private String fechaLimitePago;
	private String estadoBanTotal;
	private String tipoOperacion;
	private String descripcionEstadoProducto;
	private boolean origenAlianza;
	private String cupoGlobal;
	private String cupoDisponible;
	private String cupoUtilizado;
	private String fechaPago;
	private String valorPago;
}
