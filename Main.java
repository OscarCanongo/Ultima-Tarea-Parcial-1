import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		int semilla=0;
		double multiplicador=0;
		int corrimiento=0;
		int modulo=0;
		int numeros=0;
        double aleatorio=0;
		int cola = 0;

		Scanner sc = new Scanner(System.in);

		semilla = sc.nextInt();
		multiplicador = sc.nextInt();
		corrimiento = sc.nextInt();
		modulo = sc.nextInt();
		numeros = sc.nextInt();
		double[] array = new double[numeros];

		System.out.println(semilla);
		for (int i=0;i<numeros;i++) {
			aleatorio=(semilla*multiplicador+corrimiento)%modulo;
        	System.out.println(aleatorio);
            multiplicador=aleatorio;
			array[i]=aleatorio;	
		}
		if(esPrimo(corrimiento) && esPrimo(modulo)){
			System.out.println("No hay cola");
		}
	}

	public static boolean esPrimo(int x){
		if(x==1 || x==2 || x==3 || x==5 || x==7 || x==11){
			return true;
		}
		else{
			if(x%2==0){
				return false;
			}
			else{
				if(x%3 == 0){
					return false;
				}	
				else{
					if(x%5==0){
						return false;
					}
					else{
						if(x%7==0){
							return false;
						}
						else{
							if(x%11==0){
								return false;
							}
							else{
								return true;
							}
						}
					}	
				}
			}
		}
	}

	
}   