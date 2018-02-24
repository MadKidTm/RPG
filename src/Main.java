/*
 * Autor : personnage tomasia
 * Creation: 22/09/2017
 * Last modification: 10/10/2017
 */

import java.util.Scanner; 
import java.util.Random;

public class Main {

	// programme principal ou vont se dérouler les differentes phases de jeu
	public static void main(String[] args) {
		
		DataBaseRPG.selectMonstre("1");
		
		Personnage tableauMonstre[] = new Personnage[10];
		tableauMonstre[0] = new Personnage("vil gobelin", 20, "griffe", 5, 10, 10, 10, 10);
		tableauMonstre[1] = new Personnage("troll", 45, "gourdin", 8, 20, 5, 5, 20); 
		tableauMonstre[2] = new Personnage("fée maléfique", 15, "Poudre magique", 5, 5, 500, 10, 0 );
		
		Scanner pause = new Scanner(System.in);
		System.out.print("Bienvenue dans MAD-SKIP RPG Version 0.1 \n");

		System.out.print("Appuyer sur la touche entrée....");
		pause.nextLine();
		
		Personnage personnage = new Personnage();
		Map map = new Map();		
		map.setCarte('X', personnage.getPositionX(), personnage.getPositionY());
		
		
		//Boucle principale du jeu
		while(personnage.enVie()) {
			
			Action(personnage,map);
			Evenement(personnage,map,tableauMonstre);
		}
		
		System.out.print("\n--"+" Game Over "+"--\n");
	}
	
	//##################################################################################################
	
	//Fonction qui gere le déroulement d'un combat. celle ci prend en paramettre deux objet de type personnage ( le joueur, et son ennemi)
	static void  combat(Personnage joueur, Personnage monstre) {
		//initialisation de mes variables
		int reponse;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n--"+" Debut du combat "+"--\n");
		
		//Le combat continue tant que le joueur ou le monstre sont en vie
		while (joueur.enVie() && monstre.enVie() ) {
			joueur.info();
			monstre.info();
			System.out.print("\n**"+" Que souhaitez vous faire ? "+"**\n");
			System.out.print("\n"+"1.Attaquer"+"\n");
			System.out.print("2.Boire potion"+"\n");
			reponse = sc.nextInt();
			

			while (reponse < 1 && reponse > 2) {
				
				System.out.print("\n"+"Commande incorrecte"+"\n"+"1.Attaquer"+"\n" +"2.Utiliser Arme"+"\n");

				reponse = sc.nextInt();
			}
			
			switch (reponse)
			{
				case 1:
					joueur.attaquer(monstre);
					break;
				case 2:
					joueur.boirePotion();
					break;
					
				default:
					System.out.print("\n"+"Commande incorrecte"+"\n"+"1.Attaquer"+"\n" +"2.Utiliser Arme"+"\n");
			}	
			

			
			if (monstre.enVie())
				monstre.attaquer(joueur);
			else
				System.out.print("\n--"+monstre.getNom()+" est mort "+"--\n");
		}
			
			
		
		
		if (!joueur.enVie())
			System.out.print("\n--"+joueur.getNom()+" est mort "+"--\n");
		
		if (!joueur.enVie())
			System.out.print("\n--"+joueur.getNom()+" est mort "+"--\n");
		
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
	static void Evenement(Personnage perso, Map map, Personnage[] tableauPersonnage) {
		
		char event = map.getEvenement(perso.getPositionX(), perso.getPositionY());
		
		if (event == 'C') {
			
			Random rand = new Random();
			
			int indiceMonstre = rand.nextInt(3);
			Personnage monstre = tableauPersonnage[2];

			map.setEvenement(' ', perso.getPositionX(), perso.getPositionY());
			combat(perso, monstre);
			
		}
		else if (event == 'E') {
			System.out.print("\nVous arrivez au niveau d'une clairiere, l'atmostphere y est "
					+ "bien calme, et quelques animaux sauvages vous observent au loin...\n");
		}
		else if(event == 'M') {
			System.out.print("\nVous arrivez devant une magnifique devanture de magasin... Malheureusement celui ci a l'air fermé. \n"
					+ "vous vous approchez de la porte. Sur celle ci vous pouvez y lire un mot.\n"
					+ "\"En construction. Revenez apres la prochaine mise a jour \"\n");
			
		}else if(event == 'R') {
			System.out.print("\nVous arrivez a une auberge, vous decider d'y passer la nuit pour vous reposer un peu...\n");
			
			perso.setVie(40);
				
		}else
			System.out.print("rien de particulier dans cette zone");
			
	}
	
	/* fonction qui va gerer le menu permettant au joueur de choisir son action, 
	 * celle ci prend en paramétre un objet de type personnage ( le joueur ) et un objet de type Map ( la carte du jeu) 
	 */
	static void Action(Personnage joueur, Map map) {
		Scanner sc = new Scanner(System.in);
		byte reponse = 0;
		
		while(reponse == 0) {
			
			System.out.print("\n--"+"Que souhaitez-vous faire ?"+"--\n");
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
