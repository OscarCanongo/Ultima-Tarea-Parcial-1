import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		int semilla=0;
		int multiplicador=0;
		int corrimiento=0;
		int modulo=0;
		int numeros=0;
        int aleatorio=0;
		int cola = 0;
		int mediana = 0;

		Scanner sc = new Scanner(System.in);

		semilla = sc.nextInt();
		multiplicador = sc.nextInt();
		corrimiento = sc.nextInt();
		modulo = sc.nextInt();
		numeros = sc.nextInt();
		int[] array = new int[numeros+1];
		double media = semilla;

		System.out.println(semilla);
		array[0]=semilla;
		for (int i=0;i<numeros;i++) {
			aleatorio=(semilla*multiplicador+corrimiento)%modulo;
        	System.out.println(aleatorio);
            multiplicador=aleatorio;
			array[i+1]=aleatorio;
			media+=aleatorio;	
		}
		//Revisando si se cumple un ciclo completo
		if(esPrimo(corrimiento) && esPrimo(modulo)){
			System.out.println("No hay cola");
		}

		double mediaImprimir = media/(numeros+1);

		InsertionSort(array); //Ordenando el array

		//Media
		System.out.print("La media es: ");
		System.out.printf("%.2f",  mediaImprimir);
		System.out.println();

		//Mediana
		if((numeros+1)%2==0){
			System.out.println("Las medianas son: ");
			System.out.println(array[(numeros+1)/2]);
			System.out.println(((numeros+1)/2)+1);
		}
		else{
			System.out.print("La mediana es ");
			System.out.println(((numeros+1)/2)+1);
		}

		//Desviacion Estandar y varianza
		desviacionEstandar(array, mediaImprimir);



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

	public static void InsertionSort(int arr[]) { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    }

	public static void desviacionEstandar(int[]arr, double media){
		double counter=0;
		for (int i=0; i<arr.length; i++){
			counter+=(arr[i]-media)*(arr[i]-media);
		}
		double varianza=counter/arr.length;
		double desviacion=Math.sqrt(varianza);
		System.out.printf("La varianza es: %.2f",  varianza);
		System.out.println();
		System.out.printf("La desviacion estandar es: %.2f",  desviacion);
		System.out.println();
	}
	
}   