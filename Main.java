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
		//Buscando la cola y tambien termino dando el periodo
		buscarLaCola(array, modulo);

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

		//Moda
		moda(array);

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

	public static void moda(int[] arr){
		int counter=0;
		int num=arr[0];
		int counter2=0;
		int max=0;
		for(int i=0; i<arr.length; i++){
			if(num==arr[i]){
				counter++;
				if(counter>max)
					max=counter;
			}
			else{
				if(counter>max)
					max=counter;
				counter=1;
				num=arr[i];
			}
		}
		num=arr[0];
		System.out.println("La moda es: ");
		for(int j=0; j<arr.length; j++){
			if(num==arr[j]){
				counter2++;
				if(counter2==max){
					System.out.println(num + " Con " + max + " repeticiones");
					counter2=0;
				}
			}
			else{
				counter2=1;
				num=arr[j];
			}
		}
	}

	public static void buscarLaCola(int[] arr, int modulo){
		int counter=0;
		int aux=1;
		int algo=0;
		if(arr[0] == arr[modulo]){
			System.out.println("No hay cola");
			System.out.println("El periodo es: ");
			for(int k=0; k<modulo;k++){
				System.out.println(arr[k]);
			}
		}
		else{
			while(counter==0){
				for(int i=aux; i<arr.length-1; i++){
					if(arr[aux]==arr[i+1]){
						counter = 1;
						i=arr.length;
					}
				}
				if(counter==0){
					aux++;
				}
			}
			System.out.println("La cola es: ");
			for(int j=0; j<aux; j++){
				System.out.println(arr[j]);
			}
			System.out.println("El periodo es: ");
			counter=0;
			int aux2=0;
			for(int q=aux; q<arr.length; q++){
				if(arr[aux]==arr[q+1]){
					aux2=q+1;
					q=arr.length;
					//System.out.println("el aux2 " + aux2);	
				}
			}
			for(int l=aux; l<aux2; l++){
				System.out.println(arr[l]);
			}

		}
	}
	
}   