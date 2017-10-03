/*
 * Autor : Alex tomasia
 * Creation: 22/09/2017
 * Last modification: 02/10/2017
 */


import java.util.Scanner;
import java.util.Random;

public class Personnage {
	
	
	private String nom;
	private int vie;
	private int attaque;
	
	//Déplacement
	private int positionX;
	private int positionY;
	
	
	
	Personnage(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"+"Comment vous appelez vous?"+"\n");
		nom=sc.nextLine();
		
		vie = 10;
		attaque = 5;
		positionX = 1;
		positionY=1;
			
	}
	
	Personnage(String valeurNom, int valeurVie, int valeurAttaque)
	{
		nom = valeurNom;
		vie = valeurVie;
		attaque= valeurAttaque;
		
	}
	
	
	//##################################################################################################//
	
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
	
	
	public void attaquer(Personnage cible) {
		
		Random rand = new Random();
		System.out.print("\n--"+this.nom+" attaque "+ cible.getNom()+"--\n");
			
		cible.recevoirDegats(this.getAttaque()+ rand.nextInt(9) + 1);
		
	}
	
	public void recevoirDegats(int nbrDegats) {
		
		System.out.print("\n--"+this.nom+" reçois "+nbrDegats+" pts de dommage"+"--\n");
		
		if (vie - nbrDegats < 0) {
			vie = 0;
		}
		else {		
			vie = vie - nbrDegats;
		}	
	}
	
	public boolean enVie() {
		
		if (this.vie > 0)
			return true;
		else 
			return false;		
	}
	
	public void info() {
		
		System.out.print("\n~~"+"Nom : "+this.nom+"\n");
		System.out.print("~~"+"Vie : "+this.vie+"\n");
	}
	
	public void seDeplacer(Map map) {
		Scanner sc = new Scanner(System.in);
		byte reponse = 0;
		boolean haut = false ,bas = false ,droite = false, gauche = false;
		
		while ( reponse == 0 ) {
			
			System.out.print("\n--"+"Déplacement"+"--\n");
			if(this.positionY != 1 ) {
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
			if(this.positionX != 1) {
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
