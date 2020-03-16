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

		//System.out.println(array.length);

		//Ajuste
		ajustar(array,modulo);

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

	public static void ajustar(int[]arr, int modulo){
		double[] array = new double[arr.length];
		double l = array.length;
		//System.out.println(modulo);
		for(int i=0; i<arr.length; i++){
			array[i]=(double)arr[i]/modulo;
			//System.out.println(array[i]);
			//System.out.println(modulo);
		}
		int uno=0;
		int dos=0;
		int tres=0;
		int cuatro=0;
		int cinco=0;
		int seis=0;
		int siete=0;
		int ocho=0;
		int nueve=0;
		int diez=0;
		
		for(int j=0; j<array.length; j++){
			if(array[j]<=0.1){
				uno++;
			}
			else{
				if(array[j]<=0.2){
					dos++;
				}
				else{
					if(array[j]<=0.3){
						tres++;
					}
					else{
						if(array[j]<=0.4){
							cuatro++;
						}
						else{
							if(array[j]<=0.5){
								cinco++;
							}
							else{
								if(array[j]<=0.6){
									seis++;
								}
								else{
									if(array[j]<=0.7){
										siete++;
									}
									else{
										if(array[j]<=0.8){
											ocho++;
										}
										else{
											if(array[j]<=0.9){
												nueve++;
											}
											else{
												diez++;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(uno);
		System.out.println("Porcentaje de valores entre 0.0 y 0.1");
		double algo=(double)(uno/l*100);
		System.out.println(algo + "%");

		System.out.println("Porcentaje de valores entre 0.1 y 0.2");
		double algo2=(double)(dos/l*100);
		System.out.println(algo2 + "%");

		System.out.println("Porcentaje de valores entre 0.2 y 0.3");
		double algo3=(double)(tres/l*100);
		System.out.println(algo3 + "%");

		System.out.println("Porcentaje de valores entre 0.3 y 0.4");
		double algo4=(double)(cuatro/l*100);
		System.out.println(algo4 + "%");

		System.out.println("Porcentaje de valores entre 0.4 y 0.5");
		double algo5=(double)(cinco/l*100);
		System.out.println(algo5 + "%");

		System.out.println("Porcentaje de valores entre 0.5 y 0.6");
		double algo6=(double)(seis/l*100);
		System.out.println(algo6 + "%");

		System.out.println("Porcentaje de valores entre 0.6 y 0.7");
		double algo7=(double)(siete/l*100);
		System.out.println(algo7 + "%");

		System.out.println("Porcentaje de valores entre 0.7 y 0.8");
		double algo8=(double)(ocho/l*100);
		System.out.println(algo8 + "%");

		System.out.println("Porcentaje de valores entre 0.8 y 0.9");
		double algo9=(double)(nueve/l*100);
		System.out.println(algo9 + "%");

		System.out.println("Porcentaje de valores entre 0.9 y 1.0");
		double algo10=(double)(diez/l*100);
		System.out.println(algo10 + "%");
	}
	
}   