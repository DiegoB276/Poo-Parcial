package Mundo;

public class Factura {
	private int numDeFactura;
	private double subTotal;
	private  int iva;
	private int descuento;
	private double total;
	private String estado;
	
	/*En este constructor se calcula el 19% del iva y 
	 * el 0% de descuento, y el estado se asignará a pendiente*/
	public Factura(int numDeFactura, double subTotal) {
		this.numDeFactura = numDeFactura;
		this.subTotal = subTotal;
		this.iva = 19;
		this.descuento = 0;
		this.estado = "Pendiente";
		
	}
	
	/*Se calcula el 19% del iva y el % de descuento correspondiente
	 * y el estado se asignará en Pendiente.*/
	public Factura(int numDeFactura, double subTotal, int descuento) {
		this.numDeFactura = numDeFactura;
		this.subTotal = subTotal;
		this.iva = 19;
		this.descuento = descuento;
		this.estado = "Pendiente"; //<--- Corregido
	}
	
	//--------------------------------------------------------------
	public int getNumDeFactura() {
		return numDeFactura;
	}

	public void setNumDeFactura(int numDeFactura) {
		this.numDeFactura = numDeFactura;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	//--------------------------------------------------------------
	
	public String toString(){
		return("Información de la factura:" + "\n" +
				"Numero de factura: " + this.numDeFactura + "\n" + 
				"SubTotal: " + this.subTotal + "\n" +
				"Iva: " + this.iva + "%\n" +
				"Descuento: " + this.descuento + "%\n" +
				"Total: " + this.total +  "\n" +
				"Estado: " + this.estado + "\n" );
	}
	
}
