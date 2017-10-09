/*
 * Autor : character tomasia
 * Creation: 22/09/2017
 * Last modification: 02/10/2017
 */

import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		
		
		Personnage character = new Personnage();
		Map map = new Map();
		Personnage monstre = new Personnage("vil goblin", 60, 1);		
		map.setCarte('X', character.getPositionX(), character.getPositionY());
		
		Action(character,map);
		combat(character,monstre);
	
		
	}
	
	//##################################################################################################
	
	static void  combat(Personnage joueur, Personnage monstre) {
		int reponse = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n--"+" Debut du combat "+"--\n");
		
		while (joueur.enVie() && monstre.enVie() ) {
			joueur.info();
			monstre.info();
			System.out.print("\n**"+" Action "+"**\n");
			System.out.print("\n"+"1.Attaquer"+"\n");
			reponse = sc.nextInt();
			
			while (reponse != 1) {
				
				System.out.print("\n"+"Commande incorrecte"+"\n"+"1.Attaquer"+"\n");
				reponse = sc.nextInt();
			}
			
			joueur.attaquer(monstre);
			
			if (monstre.enVie())
				monstre.attaquer(joueur);
			else
				System.out.print("\n--"+monstre.getNom()+" est mort "+"--\n");
			
		}
		
		System.out.print("\n--"+" Fin du combat "+"--\n");	
	}
	
	static void Deplacement(Personnage perso, Map map) {
		
		map.afficher();
		map.setCarte(' ', perso.getPositionX(), perso.getPositionY());
		perso.seDeplacer(map);
		map.setCarte('X', perso.getPositionX(), perso.getPositionY());
		map.afficher();
	}
	
	static void Action(Personnage joueur, Map map) {
		Scanner sc = new Scanner(System.in);
		byte reponse = 0;
		
		while(reponse == 0) {
			
			System.out.print("\n--"+"Action"+"--\n");
			System.out.print("1.Se deplacer"+"\n");
			System.out.print("2.Inventaire"+"\n");
			System.out.print("3."+"\n");
			
			reponse = sc.nextByte();
			
			if(reponse == 1) {
				Deplacement(joueur, map);
			}
			else if (reponse == 2) {					
				System.out.print("\n--"+"Commande invalide"+"--\n");
				reponse = 0;
			}
			else if(reponse == 3) {
				System.out.print("\n--"+"Commande invalide"+"--\n");
				reponse = 0;
			}
			else {
				System.out.print("\n--"+"Commande invalide"+"--\n");
				reponse = 0;
			}
		}
	}
}
