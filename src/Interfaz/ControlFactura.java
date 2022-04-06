package Interfaz;
import Mundo.Factura;
import Mundo.metodosFactura;
import java.util.Scanner;

public class ControlFactura {

	public static void main(String[] args) {

		metodosFactura f1 = new metodosFactura();
		
		Scanner sc = new Scanner(System.in);
		Scanner so = new Scanner(System.in);
		int op;
		
		
		do {
			
			System.out.println("--Menu--\n" + 
							"1. Crear una nueva factura con o sin descuento.\n" +
							"2. Información de la factura.\n" + 
							"3. Modificar descuento de la factura\n" +
							"4. Cancelar una factura\n" + 
							"5. Anular una factura\n" +
							"6. Resumen.\n" +
							"7. Salir.");
			op = sc.nextInt();
			
			switch(op){
			case 1:
				System.out.println("¿Que opcion quieres realizar?\n" + 
									"1. Crear nueva factura con descuento\n" +
									"2. Crear nueva factura.");
				int auxOp = so.nextInt();
				if(auxOp == 1) {
					System.out.println("Escribe el numero de factura");
					int auxNumF = sc.nextInt();
					System.out.println("Escribe el subtotal");
					double auxSubT = sc.nextInt();
					System.out.println("Escribe el descuento");
					int auxDes = sc.nextInt();
					System.out.println(f1.crearNuevaFacturaConDescuento(auxNumF, auxSubT, auxDes));
				}
				if(auxOp == 2) {
					System.out.println("Escribe el numero de factura");
					int auxNumF = sc.nextInt();
					System.out.println("Escribe el subtotal");
					double auzSubT = sc.nextInt();
					System.out.println(f1.crearNuevaFactura(auxNumF, auzSubT)); 
				}
				
				break;
				
			case 2:
				System.out.println("Escribe el numero de factura a consultar.");
				int auxNumFa = so.nextInt();
				System.out.println(f1.consultarFactura(auxNumFa));
				break;
				
			case 3:
				System.out.println("Escriba el numero de factura\n");
				int auxNumFac = so.nextInt();
				System.out.println("Escriba el nuevo valor de descuento\n");
				int auxDesc2 = so.nextInt();
				System.out.println(f1.modificarDescuentoFactura(auxNumFac, auxDesc2));
				break;
				
			case 4:
				System.out.println("Escribe el numero de la factura a cancelar");
				int auxFacCancel = so.nextInt();
				System.out.println(f1.cancelarFactura(auxFacCancel));
				break;
				
			case 5:
				System.out.println("Escribe el numero de la factura a anular");
				int auxFacAnul = so.nextInt();
				System.out.println(f1.anularFactura(auxFacAnul)); 
				break;
				
			case 6:
				 
				break;
				
			case 7:
				op = 100;
			}
			
		}while(op != 100);

	}

}
