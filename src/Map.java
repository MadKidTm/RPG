import java.util.Random;

/*
 * Autor : Alex tomasia
 * Creation: 22/09/2017
 * Last modification: 10/10/2017
 */


public class Map {
	
	//Attributs
	private char carte[][];
	private char evenement[][];
	private int tailleX;
	private int tailleY;
	
	//Constructeur par defaut
	Map(){
		
		tailleY=6;
		tailleX=8;	
		carte = new char[tailleY][tailleX];
		evenement = new char[tailleY][tailleX];
		initialiser();
		
	}
	
	//Constructeur surchargé
	Map(int lignes, int colonnes) {
		
		tailleX = colonnes;
		tailleY = lignes;
		carte= new char[tailleY][tailleX];
		initialiser();
	}

	//##################################################################################################//
	//Accesseurs
	public int getTailleX() {
		
		return tailleX;
	}
	
	public int getTailleY() {
		
		return tailleY;
	}
	
	public char getCarte(int X, int Y) {
		
		return carte[Y][X];
	}
	
	public char getEvenement(int X, int Y){
		
		return evenement[Y][X];
	}
	
	public void setTailleX(int valeurTaille) {
		
		tailleX = valeurTaille;
	}
	
	public void setTailleY(int valeurTaille) {
		
		tailleY = valeurTaille;
	}
	
	public void setCarte(char caractere, int X, int Y) {
		
		
		if (X > tailleX || Y > tailleY || X < 0 || Y < 0 ) {
			
			System.out.print("OutOfBoundsErrorOnSetCarte");
			
		}else
			carte[Y][X] = caractere;
		
	}
	
	public void setEvenement(char caractere, int X, int Y) {
		
		if (X > tailleX || Y > tailleY || X < 0 || Y < 0 ) {
			
			System.out.print("OutOfBoundsErrorOnSetEvenement");
			
		}else
			evenement[Y][X] = caractere;
		
	}
	
	//##################################################################################################//
	//Methodes
	
	//initialise la carte de jeu ainsi que la carte des evenements
	private void initialiser() {
		Random rand = new Random();
		int valeurAleatoire;
		
		for (int i=0 ; i<tailleY; i++) {
			
			for (int j=0; j < tailleX; j++) {				
				carte[i][j] = ' ';
				
				valeurAleatoire = rand.nextInt(9) + 1;
				
				if (valeurAleatoire <= 3 ) {
					evenement[i][j] = 'C';
				}
				else if (valeurAleatoire > 4 && valeurAleatoire <= 7) {
					evenement[i][j] = 'E';
				}
				else if(valeurAleatoire > 7 && valeurAleatoire < 9){
					evenement[i][j] = 'M';
				}else
					evenement[i][j] = ' '; 
			}		
		}
	}
	
	//Affiche la carte de jeu
	public void afficher() {
		
		System.out.print("\n ### MAP ### \n");
		for (int i=0 ; i < tailleY; i++) {
			
			for (int j=0; j < tailleX; j++) {
				System.out.print("[");
				System.out.print(evenement[i][j]);
				System.out.print(carte[i][j]);
				System.out.print("]");
			}
			System.out.print("\n");
		}
	}	
	
	// fonction qui renvoie true si la case est valide ou false si elle ne l'est pas
	
	public boolean caseValide(int X, int Y) {
		
		if( X < 0 || Y < 0 || X > tailleX || Y > tailleY) {
			
			return false;
		}
		else
			return true;
	}
}
