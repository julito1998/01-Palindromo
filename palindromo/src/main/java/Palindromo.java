import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

public class Palindromo{

    public static ArrayList<Integer> ObtenerNumerosPrimos(int hasta){
        ArrayList<Integer> numerosPrimosObtenidos = new ArrayList<>();
        boolean isPrimo = true;
        for (int i=2; i<hasta; i++){
                for (int j=2;j<hasta;j++){
                    if (i%j==0 && i !=j){
                        isPrimo=false;
                    }
                    if (j > i){
                        break;
                    }
                }
            if (isPrimo){
                numerosPrimosObtenidos.add(i);
            }else{
                isPrimo=true;
            }
        }
        return numerosPrimosObtenidos;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numerosPrimos;
        System.out.println("Ingrese un numero positivo : (0 para Cerrar el programa)");
        Scanner entrada=new Scanner(System.in);
        Integer numeroIngresado=entrada.nextInt();

         do {

                if (numeroIngresado== 0){
                    System.out.println("El numero ingresado es 0 CERRANDO EL PROGRAMADA...");
                    break;
                }
                else {
                    System.out.println("PROCESANDO EL NUMERO INGRESADO...");
                    String strNumeroInvertido="";
                    //recorro desde el numero ingresado por el usuario hasta el valor maximo que es 1.000.000
                    int j=numeroIngresado;
                    while (true) {
                        //trasnformo el numero a evaluar a String
                        String strNumero = String.valueOf(j);
                        //recorro el numero ingresado de atras hacia adelante por ejemplo para darlo vuelta
                        //si n= 302 => el numero que obtengo recorriendo es 203
                        for (int i = strNumero.length() - 1; i >= 0; i--) {
                            strNumeroInvertido = strNumeroInvertido + strNumero.charAt(i);
                        }
                        //verifico si el numero es un palindromo
                        if (strNumero.equals(strNumeroInvertido)) {
                            //si es palindromo verifico que sea un numero primo

                            //obtengo la raiz cuadrada de este numero
                            String strValorDeRaiz = String.valueOf(Math.sqrt(Double.valueOf(strNumero)));
                            //me quedo con la parte entera de la raiz
                            int intValorDeRaiz = Integer.parseInt(strValorDeRaiz.substring(0, strValorDeRaiz.indexOf('.')));
                            //obtengo todos los numeros menores al resultado de la parte entera de la raiz
                            numerosPrimos = ObtenerNumerosPrimos(intValorDeRaiz);

                            //y me fijo uno por uno si lo divide al numero strNumero => es_primo
                            boolean isPrimo=true;
                            for (Integer numeroPrimoMenor:numerosPrimos) {
                                if (j%numeroPrimoMenor==0){
                                    isPrimo=false;
                                    break;
                                }
                            }

                            if (isPrimo){
                                System.out.println("El nro :" + j + " es un numero primo");
                                break;
                            }
                            //si no paso al siguiente numero
                        }
                        strNumeroInvertido="";
                        j+=1;
                    }

                    System.out.println("Ingrese un numero positivo: (0 para Cerrar el programa)");
                    numeroIngresado=entrada.nextInt();
                }
                }while (numeroIngresado !=0 && numeroIngresado >=0);
            }
    }

