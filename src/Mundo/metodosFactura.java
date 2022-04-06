package Mundo;

import java.util.ArrayList;

public class metodosFactura {
	private ArrayList<Factura> a1;

	// Se crea un nuevo objeto factura con o sin descuento
	public metodosFactura() {
		a1 = new ArrayList<Factura>();
	}

	public int buscarNumDeFactura(int n) {
		for (int i = 0; i < a1.size(); i++) {
			if (a1.get(i).getNumDeFactura() == n) {
				return (i);
			}
		}
		return (-1);
	}

	public String crearNuevaFactura(int numFactura, double subTotal) {
		int valFactura = buscarNumDeFactura(numFactura);
		String res = "";
		if (valFactura == -1) {
			if (numFactura > 0) {
				Factura aux = new Factura(numFactura, subTotal);
				this.a1.add(aux);
				res = "Factura creada con éxito..";
			} else {
				res = "El numero de factura no puede ser negativo";
			}
		}
		return (res);

	}

	public String crearNuevaFacturaConDescuento(int numFactura, double subTotal, int descuento) {
		int valFactura = buscarNumDeFactura(numFactura);
		String res = "";
		if (valFactura == -1) {
			if (numFactura > 0) {
				Factura aux = new Factura(numFactura, subTotal, descuento);
				this.a1.add(aux);
				res = "Factura creada con éxito..";
			} else {
				res = "El numero de factura no puede ser negativo";
			}
		}
		return (res);
	}

	public String consultarFactura(int numFactura) {
		int valFactura = buscarNumDeFactura(numFactura);
		if (valFactura >= 0) {
			return (a1.get(valFactura).toString());
		}
		return ("La factura no existe.");
	}

	// funcion cambia el valor del descuento por uno nuevo
	public String modificarDescuentoFactura(int numFactura, int descuento) {
		// int valFactura = buscarNumDeFactura(numFactura);
		String rta = "";
		if (numFactura > 0) {
			for (int i = 0; i < a1.size(); i++) {
				if (a1.get(i).getNumDeFactura() == numFactura) {
					if (descuento > 0) {
						a1.get(i).setDescuento(descuento);
						rta = "Cambio exitoso";
					} else {
						rta = "Cambio no realizad";
					}

				} else {
					rta = "error al cambiar el descuento";
				}
			}
		} else {
			rta = "La factura no existe";
		}
		return (rta);

	}

	public String anularFactura(int numFactura) {
		int valFactura = buscarNumDeFactura(numFactura);
		String rta = "";
		if(a1.get(valFactura).getEstado() == "Pendiente") {
			if (valFactura >= 0) {
				for(int i=0; i<a1.size(); i++) {
					if(numFactura > 0) {
						if(a1.get(valFactura).getNumDeFactura() == numFactura) {
							this.a1.get(valFactura).setEstado("Anulado");
							rta = "Factura anulada con exito";
						}else {
							rta = "No se puede anular la factura";
						}
					}else {
						rta = "Los valores no pueden ser negativos";
					}
				}
			} else {
				rta = "La factura no exite";
			}
		}else {
			rta = "La factura debe tener un estado pendiente";
		}
		
		return (rta);
	}

	public String resumenFacturas() {
		String rta = "";
		for (int i = 0; i < a1.size(); i++) {
			rta = "Facturas : " + this.a1.get(i).getNumDeFactura(); // <--- Funcion por corregir.
		}
		return (rta);
	}

}
