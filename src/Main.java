/*
 * Autor : personnage tomasia
 * Creation: 22/09/2017
 * Last modification: 02/10/2017
 */

import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		
		
		Personnage personnage = new Personnage();
		Map map = new Map();		
		map.setCarte('X', personnage.getPositionX(), personnage.getPositionY());
		
		
		
		while(personnage.enVie()) {
			
			Action(personnage,map);
			System.out.print(personnage.getPositionX() + " " + personnage.getPositionY());
			Evenement(personnage,map);
		}	
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
	
	
	static void Evenement(Personnage perso, Map map) {
		
		char event = map.getEvenement(perso.getPositionX(), perso.getPositionY());
		
		if (event == 'C') {
			
			Personnage monstre = new Personnage("vil gobelin", 20, 1);
			map.setEvenement(' ', perso.getPositionX(), perso.getPositionY());
			combat(perso, monstre);
			
		}
		else if (event == 'E') {
			System.out.print("Vous arrivez au niveau d'une clairiere, l'atmostphere y est "
					+ "bien calme, et quelques animaux sauvages vous observent au loin...");
		}
		else
			System.out.print("rien de particulier dans cette zone");
			
	}
	
	// fonction qui va gerer le menu action permettant au joueur de choisir son action.
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
