/*
 * Autor : Alex tomasia
 * Creation: 22/09/2017
 * Last modification: 02/10/2017
 */


public class Map {
	
	private char carte[][];
	private int tailleX;
	private int tailleY;
	
	Map(){
		
		tailleY=6;
		tailleX=8;	
		carte = new char[tailleY][tailleX];
		initialiser();
		
	}
	
	Map(int lignes, int colonnes) {
		
		tailleX = colonnes;
		tailleY = lignes;
		carte= new char[tailleY][tailleX];
		initialiser();
	}

	//##################################################################################################//
	
	public int getTailleX() {
		
		return tailleX;
	}
	
	public int getTailleY() {
		
		return tailleY;
	}
	
	public char getCarte(int X, int Y) {
		
		return carte[Y][X];
	}
	
	public void setTailleX(int valeurTaille) {
		
		tailleX = valeurTaille;
	}
	
	public void setTailleY(int valeurTaille) {
		
		tailleY = valeurTaille;
	}
	
	public void setCarte(char caractere, int X, int Y) {
		
		
		if (X > tailleX || Y > tailleY || X <= 0 || Y < 0 ) {
			
			System.out.print("OutOfBoundsErrorOnSetCarte");
			
		}else
			carte[Y-1][X-1] = caractere;
		
	}
	
	//##################################################################################################//
	
	private void initialiser() {
		
		for (int i=0 ; i<tailleY; i++) {
			
			for (int j=0; j < tailleX; j++) {				
				carte[i][j] = ' ';			
			}		
		}
	}
	
	public void afficher() {
		
		System.out.print("\n ### MAP ### \n");
		for (int i=0 ; i < tailleY; i++) {
			
			for (int j=0; j < tailleX; j++) {
				System.out.print("[");
				System.out.print(carte[i][j]);
				System.out.print("]");
			}
			System.out.print("\n");
		}
	}	
	
	public boolean caseValide(int X, int Y) {
		
		if( X < 0 || Y < 0 || X > tailleX || Y > tailleY) {
			
			return false;
		}
		else
			return true;
	}
}
