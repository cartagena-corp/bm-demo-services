package com.demo.demo.factory;

import com.demo.demo.service.dto.Cdt;
import com.nsbt.demo.model.PosPeNaRta.Productos.CDTs.CDT;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CdtFactory {
	
	@Mapping(target = "token", expression = "java(com.demo.demo.util.TokenizationUtil.generateCdtToken(cdt.getNumProTot()))")
	@Mapping(target = "tipoProducto", source = "tipPro")
	@Mapping(target = "numeroProductoTotal", source = "numProTot")
	@Mapping(target = "numeroProducto", source = "numPro")
	@Mapping(target = "descripcionProducto", source = "desPro")
	@Mapping(target = "nombreProductoCliente", source = "aliPro")
	@Mapping(target = "fechaVencimiento", source = "fecVen")
	@Mapping(target = "valorApertura", source = "valApe")
	@Mapping(target = "proximoVecimiento", source = "proxVencim")
	@Mapping(target = "tasaPactada", source = "tasPac")
	@Mapping(target = "periodoPagoInteres", source = "period")
	@Mapping(target = "instruciones", source = "instruc")
	@Mapping(target = "estadoBanTotal", source = "estCod")
	@Mapping(target = "tipoOperacion", source = "estOpe")
	@Mapping(target = "descripcionEstadoProducto", source = "estDes")
	Cdt from(CDT cdt);
	
	List<Cdt> from (List<CDT> cdts);

}
