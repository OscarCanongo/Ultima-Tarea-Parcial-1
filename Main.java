import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		int semilla=0;
		double multiplicador=0;
		int corrimiento=0;
		int modulo=0;
		int numeros=0;
        double aleatorio=0;

		Scanner sc = new Scanner(System.in);

		semilla = sc.nextInt();
		multiplicador = sc.nextInt();
		corrimiento = sc.nextInt();
		modulo = sc.nextInt();
		numeros = sc.nextInt();

		for (int i=0;i<numeros;i++) {
			aleatorio=(semilla*multiplicador+corrimiento)%modulo;
        	System.out.println(aleatorio);
            multiplicador=aleatorio;	
		}
	}
}   