/*
 * Autor : Alex tomasia
 * Creation: 22/09/2017
 * Last modification: 10/10/2017
 * 
 * Classe personnage
 */
//


import java.util.Scanner;
import java.util.Random;

public class Personnage {
	
	//Attributs
	private String nom;
	private int vie;
	private int attaque;
	private int niveau;
	private int experience;
	
		//Déplacement
	private int positionX;
	private int positionY;
	
		//Caractéristiques qui vont influer sur les capacités du personnage
	private int force;
	private int agilite;
	private int dexterite;
	private int resistance;
	
	
	//Constructeurs par default
	Personnage(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"+"Comment vous appelez vous?"+"\n");
		nom=sc.nextLine();
		
		vie = 40;
		attaque = 5;
		niveau = 1;
		experience = 0;
		
		positionX = 0;
		positionY=0;
		
		force = 0;
		agilite = 0;
		dexterite = 0;
		resistance = 0;
				
	}
	
	//Constructeurs surchargé (Pour les monstres)
	Personnage(String valeurNom, int valeurVie, int valeurAttaque)
	{
		nom = valeurNom;
		vie = valeurVie;
		attaque= valeurAttaque;
		
	}
	
	Personnage(String valeurNom, int valeurVie, int valeurAttaque, int valeurForce, int valeurAgilite, int valeurDexterité, int valeurResistance)
	{
		
	}
	
	
	//##################################################################################################//
	//Accesseurs
	
	public String getNom() {
		
		return nom;
	}
	
	public void setNom(String nouveauNom) {
		
		nom = nouveauNom;
	}
	
	public int getVie() {
		
		return vie;
	}
	
	public void setVie(int valeurVie) {
		
		vie = valeurVie;
	}
	
	public int getAttaque() {
		
		return attaque;
	}
	
	public void setAttaque(int valeurAttaque) {
		
		attaque = valeurAttaque;
	}
	
	public int getPositionX() {
		
		return positionX;
	}
	
	public int getPositionY() {
		
		return positionY;
	}
	
	public void setPosition(int X, int Y) {
		
		positionX = X;
		positionY = Y;
	}
	
	//##################################################################################################//
	
	//permet a un personnage d'attaquer une cible. la cible est un objet de type personnage
	public void attaquer(Personnage cible) {
		
		Random rand = new Random();
		System.out.print("\n--"+this.nom+" attaque "+ cible.getNom()+"--\n");
			
		cible.recevoirDegats(this.getAttaque()+ rand.nextInt(9) + 1);
		
	}
	
	//permet a un personnage de recevoir des degats
	public void recevoirDegats(int nbrDegats) {
		
		System.out.print("\n--"+this.nom+" reçois "+nbrDegats+" pts de dommage"+"--\n");
		
		if (vie - nbrDegats < 0) {
			vie = 0;
		}
		else {		
			vie = vie - nbrDegats;
		}	
	}
	
	//Fonction qui renvoie true si le personnage est en vie, ou false si il ne l'est pas
	public boolean enVie() {
		
		if (this.vie > 0)
			return true;
		else {
			System.out.print("\n--"+this.getNom()+" est mort "+"--\n");
			return false;
		}
	}
	
	//Affiche des infos sur le personnage
	public void info() {
		
		System.out.print("\n~~"+"Nom : "+this.nom+"\n");
		System.out.print("~~"+"Vie : "+this.vie+"\n");
	}
	
	//Permet au personnage de se déplacer sur la carte du jeu. cette procédure prend en parametre un objet de type Map
	public void seDeplacer(Map map) {
		Scanner sc = new Scanner(System.in);
		byte reponse = 0;
		boolean haut = false ,bas = false ,droite = false, gauche = false;
		
		while ( reponse == 0 ) {
			
			System.out.print("\n--"+"Déplacement"+"--\n");
			if(this.positionY != 0 ) {
				System.out.print("\n"+"1.Haut"+"\n");
				haut = true;
			}
			if(this.positionX != map.getTailleX()) {
				System.out.print("2.Droite"+"\n");
				droite = true;
			}
			if(this.positionY != map.getTailleY()) {	
				System.out.print("3.Bas"+"\n");
				bas = true;
			}
			if(this.positionX != 0) {
				System.out.print("4.Gauche"+"\n");
				gauche = true;
			}
			
			System.out.print("5.Retour"+"\n");
			
			
			reponse=sc.nextByte();
			
			if( reponse == 1) {
				if(!haut) {
					System.out.print("\n--"+"Commande invalide"+"--\n");
					reponse = 0;
				}
				else
					this.positionY -=1;
			}
			else if ( reponse == 2 ) {
				if(!droite) {
					System.out.print("\n--"+"Commande invalide"+"--\n");
					reponse = 0;
				}
				else
					this.positionX += 1;
			}
			else if ( reponse == 3) {
				if(!bas) {
					System.out.print("\n--"+"Commande invalide"+"--\n");
					reponse = 0;
				}
				else
					this.positionY += 1;
			}
			else if (reponse == 4){
				if(!gauche) {
					System.out.print("\n--"+"Commande invalide"+"--\n");
					reponse = 0;
				}
				else
					this.positionX -= 1;				
			}
			else if( reponse == 5 ){
				
			}
		}
	}
}
