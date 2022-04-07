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

	/*
	 * Se crea un nuevo objeto factura, el cual va a recibir como parámetros el
	 * numero de factura y el subtotal y se valida si la cuenta existe o no para
	 * proceder a crearla
	 */
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

	/*
	 * Se crea un nuevo objeto factura, el cual va a recibir como parámetros el
	 * numero de factura, el subtotal y el porcentaje de descuento
	 */
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

	/*
	 * Se cambia el valor por descuento por uno nuevo digitado por teclado. La
	 * función tiene como parámetros el numero de factura para buscar la facctura a
	 * la cual se le va a realizar el cambio y el descuento que será el nuevo valor
	 */
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

	/*
	 * Cambia el estado de la factura de Pendiente a cancelada, se busca la factura
	 * por su numero y se procede a eliminar. Tambien se valida si el estado de la
	 * factura es pendiente y si la factura existe.
	 */
	public String cancelarFactura(int numFactura) {
		int valFactura = buscarNumDeFactura(numFactura);
		String rta = "";
		if (a1.get(valFactura).getEstado() == "Pendiente") {
			if (valFactura >= 0) {
				for (int i = 0; i < a1.size(); i++) {
					if (numFactura > 0) {
						if (a1.get(valFactura).getNumDeFactura() == numFactura) {
							this.a1.get(valFactura).setEstado("Cancelada");
							rta = "Factura cancelada con exito";
						} else {
							rta = "No se puede cancelar la factura";
						}
					} else {
						rta = "Los valores no pueden ser negativos";
					}
				}
			} else {
				rta = "La factura no exite";
			}
		} else {
			rta = "La factura debe tener un estado pendiente";
		}

		return (rta);
	}

	/*
	 * Cambia el estado de la factura de Pendiente a Anulado, se busca la factura
	 * por su numero y se procede a eliminar. Tambien se valida si el estado de la
	 * factura es pendiente y si la factura existe.
	 */
	public String anularFactura(int numFactura) {
		int valFactura = buscarNumDeFactura(numFactura);
		String rta = "";
		if (a1.get(valFactura).getEstado() == "Pendiente") {
			if (valFactura >= 0) {
				for (int i = 0; i < a1.size(); i++) {
					if (numFactura > 0) {
						if (a1.get(valFactura).getNumDeFactura() == numFactura) {
							this.a1.get(valFactura).setEstado("Anulada");
							rta = "Factura anulada con exito";
						} else {
							rta = "No se puede anular la factura";
						}
					} else {
						rta = "Los valores no pueden ser negativos";
					}
				}
			} else {
				rta = "La factura no exite";
			}
		} else {
			rta = "La factura debe tener un estado pendiente";
		}

		return (rta);
	}

	/* La funcion calculará el numero de facturas */
	public String resumenFacturas() {
		int x = 0, y = 0, z = 0;
		for (int i = 0; i < a1.size(); i++) {
			if (a1.get(i).getEstado() == "Pendiente") {
				x++;
			}
		}
		for (int i = 0; i < a1.size(); i++) {
			if (a1.get(i).getEstado() == "Anulada") {
				y++;
			}
		}
		for (int i = 0; i < a1.size(); i++) {
			if (a1.get(i).getEstado() == "Cancelada") {
				z++;
			}
		}
		return ("Facturas Pendientes: " + x + 
				"\n" + "Facturas Anuladas: " + y + 
				"\n" + "Facturas Canceladas: " + z + "\n");

	}

}
