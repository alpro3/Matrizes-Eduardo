import java.util.ArrayList;
import java.util.HashSet;


public class Matrizes {
	public static int[][] matrizSomaCoordenadas(int altura, int largura){
		int mat[][];
		if(altura>0 && largura>0){
			mat = new int [altura][largura];
		}
		mat = new int [5][6];
		for (int i = 0; i < mat.length; i++) {
			String linha = "Linha "+i+":";
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = i+j;
				linha+= " "+mat[i][j];
			}
			System.out.println(linha);
		}
		System.out.println("");
		for (int i = 0; i < mat[0].length; i++) {
			String coluna = "Coluna "+i+":";
			for (int j = 0; j < mat.length; j++) {
				coluna+= " "+mat[j][i];
			}
			System.out.println(coluna);
		}
		return mat;
	}
	
	public static int [][] somaMatrizes(int a[][], int b[][]){
		int mat[][] = {{},{}};
		if(a.length!=b.length || a[0].length!=b[0].length){
			return mat;
		}
		else{
			mat = new int[a.length][a[0].length];
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[0].length; j++) {
					mat[i][j] = a[i][j] + b[i][j];
				}
			}
		}
		return mat;
	}
	
	public static void printMatrizBidimencional(int mat [][]){
		for (int i = 0; i < mat.length; i++) {
			String linha = "";
			for (int j = 0; j < mat[0].length; j++) {
				linha += " "+mat[i][j];
			}
			System.out.println(linha);
		}
	}
	
	public static int[][] transposta(int a[][]){
		int mat[][] = new int[a[0].length][a.length];
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				mat[i][j] = a[j][i];
			}
		}
		return mat;
	}
	
	public static int[][] multiplicaMatrizes(int a[][], int b[][]){
		int mat[][] = {{},{}};
		int soma = 0;
		if ( a[0].length != b.length ){
			return mat;
		}
		else{
			mat = new int[a.length][b[0].length];
			for (int i = 0 ; i < a.length ; i++ ){
				for (int j = 0 ; j < b[0].length ; j++ ){
					for (int k = 0 ; k < b.length ; k++ ){
						soma = soma + a[i][k]*b[k][j];
					}
					mat[i][j] = soma;
					soma = 0;
	            }
	         }
	         return mat;
	    }
	}
	
	public static int [] repetidos(int a[][]){
		HashSet<Integer> l = new HashSet<Integer>();
		HashSet<Integer> l2 = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				int numero = a[i][j];
				if(l.contains(numero) && !l2.contains(numero)){
					l2.add(numero);
				}
				l.add(numero);
			}
		}
		int res[] = new int[l2.size()];
		int cont = 0;
		for (int i : l2) {
			res[cont] = i;
			cont++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		matrizSomaCoordenadas(5, 6);
		int matA [][] = {{0,1,2},{3,4,5},{6,7,8}};
		int matB [][] = {{8,7,6},{5,4,3},{2,1,0}};
		int matC [][] = {{8,7,6},{5,4,3}};
		int matD [][] = {{2,3},{0,1},{-1,4}};
		int matE [][] = {{1,2,3},{-2,0,4}};
		System.out.println("\nmatA:\n");
		printMatrizBidimencional(matA);
		System.out.println("\nmatB:\n");
		printMatrizBidimencional(matB);
		System.out.println("\nmatA + matB:\n");
		printMatrizBidimencional(somaMatrizes(matA, matB));
		System.out.println("\nmatA + matC:\n");
		printMatrizBidimencional(somaMatrizes(matA, matC));
		System.out.println("\nTransposta de matA\n");
		printMatrizBidimencional(transposta(matA));
		System.out.println("\nMultiplica��o de matD e matE\n");
		printMatrizBidimencional(multiplicaMatrizes(matD, matE));
		System.out.println("Repetidos na multiplica��o de matD e matE:");
		int vet[] = repetidos(multiplicaMatrizes(matD, matE));
		for (int i = 0; i < vet.length; i++) {
			System.out.print(vet[i]+" ");
		}
		
	}
}
