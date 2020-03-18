//Oscar Canongo Vergara A01730443
//Benny Aldahir Ruiz Jimenez A01328177
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
		double mediana = 0;

		Scanner sc = new Scanner(System.in);

		semilla = sc.nextInt();
		multiplicador = sc.nextInt();
		corrimiento = sc.nextInt();
		modulo = sc.nextInt();
		numeros = sc.nextInt();
		double media = 0;
		int[] array;

		if(modulo<numeros){
			array = new int[numeros+1];
		    array[0]=semilla;
			for (int i=0;i<numeros;i++) {
				aleatorio=(semilla*multiplicador+corrimiento)%modulo;
				semilla=aleatorio;
				array[i+1]=aleatorio;
			}
		}
		else{
			array = new int[modulo+1];
		    array[0]=semilla;
			for (int i=0;i<modulo;i++) {
				aleatorio=(semilla*multiplicador+corrimiento)%modulo;
				semilla=aleatorio;
				array[i+1]=aleatorio;
			}
		}

		//Cola, periodo y ciclo
		buscarLaCola(array, modulo);

		int[]array2 = new int[numeros];
		for(int v=0; v<numeros; v++){
			array2[v]=array[v];
			media+=array2[v];	
		}
		
		double mediaImprimir = (double)media/(double)(numeros);

		//Ordenando el array
		InsertionSort(array2); 

		//Media
		System.out.print("La media es: ");
		System.out.printf("%.2f",  mediaImprimir);
		System.out.println();

		//Mediana
		if(numeros%2==0){
			System.out.print("Las mediana es: ");
			mediana = (array2[(numeros/2)-1] + array2[(numeros)/2])/2;
			System.out.println(mediana);
		}
		else{
			System.out.print("La mediana es ");
			System.out.println(array2[(int)(numeros/2)]);
		}

		//Desviacion Estandar y varianza
		desviacionEstandar(array2, mediaImprimir);


		//Moda
		moda(array2, numeros);

		//System.out.println(array.length);

		//Ajuste
		ajustar(array2,modulo);

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
			counter+=Math.pow((arr[i]-media),2);
		}
		double varianza=counter/(arr.length-1);
		double desviacion=Math.sqrt(varianza);
		System.out.printf("La varianza es: %.2f",  varianza);
		System.out.println();
		System.out.printf("La desviacion estandar es: %.2f",  desviacion);
		System.out.println();
	}

	public static void moda(int[] arr, int numeros){
		int counter=0;
		int num=arr[0];
		int counter2=0;
		int max=0;
		for(int i=0; i<numeros-1; i++){
			if(num==arr[i+1]){
				counter++;
				if(counter>max)
					max=counter;
			}
			else{
				if(counter>max)
					max=counter;
				counter=0;
				num=arr[i+1];
			}
		}
		num=arr[0];
		int bandera=0;
		int counterNumeros=0;
		System.out.println("La moda es: ");
		for(int j=0; j<numeros-1; j++){
			if(num==arr[j+1]){
				counter2++;
				if(counter2==max){
					System.out.println(num + " Con " + (max+1) + " repeticiones");//ESTO SE PUEDE QUITAR PARA FACILITAR LA LECTURA DEL PROGAMA------------------------------------------------------------
					counter2=0;
					bandera=1;	
					counterNumeros++;
				}
				num=arr[j];
			}	
			else{
				counter2=0;
				num=arr[j+1];
			}
		}
		if(bandera==0){
			System.out.println("Todos los datos son distintos, algunos matematicos se refieren a esto como No hay moda");
		}
		else{
			System.out.println("Los numeros de moda son: " + counterNumeros);
		}
	}

	public static void buscarLaCola(int[] arr, int modulo){
		int counter=0;
		int aux=1;
		int algo=0;
		if(arr[0] == arr[modulo]){
			System.out.println("No hay cola. La longitud de la cola es 0");
			System.out.println("La longitud del periodo es: ");
			System.out.println(modulo);
			System.out.println("El periodo es: ");
			for(int k=0; k<modulo;k++){
				System.out.println(arr[k]);//ESTO SE PUEDE QUITAR PARA FACILITAR LA LECTURA DEL PROGAMA------------------------------------------------------------
			}
			System.out.println("La longitud del ciclo es: ");
			System.out.println(modulo);
			System.out.println("El ciclo es: ");
			for(int ii=0; ii<modulo; ii++){
				System.out.println(arr[ii]);//ESTO SE PUEDE QUITAR PARA FACILITAR LA LECTURA DEL PROGAMA------------------------------------------------------------
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
			System.out.println("La longitud de la cola es: " + aux);
			System.out.println("La cola es: ");
			for(int j=0; j<aux; j++){
				System.out.println(arr[j]);
			}
			counter=0;
			int aux2=0;
			for(int q=aux; q<arr.length; q++){
				if(arr[aux]==arr[q+1]){
					aux2=q+1;
					q=arr.length;
				}
			}
			System.out.println("La longitud del periodo es: ");
			System.out.println((aux2-aux));
			System.out.println("El periodo es: ");
			for(int l=aux; l<aux2; l++){
				System.out.println(arr[l]);//ESTO SE PUEDE QUITAR PARA FACILITAR LA LECTURA DEL PROGAMA------------------------------------------------------------
			}

			System.out.println("La longitud del ciclo es: ");
			System.out.println((aux2));
			System.out.println("El ciclo es: ");
			for(int zz=0; zz<aux; zz++){
				System.out.println(arr[zz]);//ESTO SE PUEDE QUITAR PARA FACILITAR LA LECTURA DEL PROGAMA------------------------------------------------------------
			}
			for(int xx=aux; xx<aux2; xx++){
				System.out.println(arr[xx]);//ESTO SE PUEDE QUITAR PARA FACILITAR LA LECTURA DEL PROGAMA------------------------------------------------------------
			}

		}
	}

	public static void ajustar(int[]arr, int modulo){
		double[] array = new double[arr.length];
		double l = array.length;
		for(int i=0; i<arr.length; i++){
			array[i]=(double)arr[i]/modulo;
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