/*
 * Autor : personnage tomasia
 * Creation: 22/09/2017
 * Last modification: 10/10/2017
 */

import java.util.Scanner; 

public class Main {

	// programme principal ou vont se dérouler les differentes phases de jeu
	public static void main(String[] args) {
		
		
		Personnage personnage = new Personnage();
		Map map = new Map();		
		map.setCarte('X', personnage.getPositionX(), personnage.getPositionY());
		
		
		
		while(personnage.enVie()) {
			
			Action(personnage,map);
			Evenement(personnage,map);
		}	
	}
	
	//##################################################################################################
	
	//Fonction qui gere le déroulement d'un combat. celle ci prend en paramettre deux objet de type personnage ( le joueur, et son ennemi)
	static void  combat(Personnage joueur, Personnage monstre) {
		//initialisation de mes variables
		int reponse = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n--"+" Debut du combat "+"--\n");
		
		//Le combat continue tant que le joueur ou le monstre sont en vie
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
	
	/*Cette fonction gére les déplacement du joueur sur la map, celle ci prend en parametre un objet 
	de type personnage ( le joueur) et un objet de type map ( la carte du jeu)*/
	static void Deplacement(Personnage perso, Map map) {
		
		map.afficher();
		map.setCarte(' ', perso.getPositionX(), perso.getPositionY());
		perso.seDeplacer(map);
		map.setCarte('X', perso.getPositionX(), perso.getPositionY());
		map.afficher();
		
	}
	
	/*Cette fonction gere le déclenchement des événement lorsque le joueur se déplace sur la map, 
	 * celle ci prend en paramétre un objet de type personnage ( le joueur ) et un objet de type Map ( la carte du jeu)
	 */
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
	
	/* fonction qui va gerer le menu permettant au joueur de choisir son action, 
	 * celle ci prend en paramétre un objet de type personnage ( le joueur ) et un objet de type Map ( la carte du jeu) 
	 */
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
