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
	private int vieMax;
	private int attaque;
	private int niveau;
	private int experience;
	private int experienceMax;
	private Arme arme;

	
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
		
		vieMax= 40;
		vie = vieMax;
		
		attaque = 5;
		niveau = 1;
		experience = 0;
		experienceMax=1000;
		
		positionX = 0;
		positionY=0;
		
		force = 10;
		agilite = 10;
		dexterite = 10;
		resistance = 10;
	
		arme = new Arme();
	}
	
	//Constructeurs surchargé (Pour les monstres)
	Personnage(String valeurNom, int valeurVie, String nomArme, int degatsArme, int valeurForce, int valeurAgilite, int valeurDexterite, int valeurResistance){
		
		nom = valeurNom;
		vie = valeurVie;
		
		arme = new Arme(nomArme, degatsArme);
		
		force = valeurForce;
		agilite = valeurAgilite;
		dexterite = valeurDexterite;
		resistance = valeurResistance;
		
	}
	
	Personnage(String valeurNom, int valeurVie, int valeurAttaque, int valeurForce, int valeurAgilite, int valeurDexterité, int valeurResistance)
	{
		
	}
	
	Arme pantoufle = new Arme("Pantoufle usée","basique", 8, "arme");
	
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
		
		if( valeurVie > vieMax)
			valeurVie = vieMax;
		
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
	

	public Arme getArme() {
		
		return arme;
	}

	public void setArme(Arme arme) {
		
		this.arme = arme;
	}

	
	//##################################################################################################//
	
	//Methodes
	//permet a un personnage d'attaquer une cible. la cible est un objet de type personnage
	
	public void boirePotion() {
		this.setVie(this.getVie() + 20);
	}
	
	//Fonction permetant a un perssonage d'attaquer une cible qui est un objet de type Personnage 
	public void attaquer(Personnage cible) {
		
		System.out.print("\n--"+this.nom+" attaque "+ cible.getNom()+"--\n");
		
		//Si la cible n'esquive pas on appelle sa fonction recevoirDegats
		if (!cible.esquive()) {
			int degats;	
			Random rand = new Random();	
			
			/*Pour les degats on a une partie fixe qui prend en compte les degats bruts de l'arme
			 * Ensuite on a une partie aléatoire qui va de 0 a 25% de la force du personnage
			 */
			degats = this.arme.getDegats() + rand.nextInt(Math.round(this.force * 25 / 100));
			
			cible.recevoirDegats(degats);
		
		}else//Si la cible esquive
			System.out.print("\n-- "+cible.getNom()+" esquive l'attaque"+" --\n");
	
	}
		
	//permet a un personnage de recevoir des degats en prennant en parametre un Entier qui correspondra a la valeur des degats reçus
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

		else 
			return false;
		
	}
	
	// Fonction qui va permettre a un personnage d'avoir une chance d'esquiver une attaque
	public boolean esquive() {
		
		Random rand = new Random();
		
		//Le personnage esquive si le nombre aléatoire est plus petit que 30% de son agilité
		if(rand.nextInt(99)+1 >= this.agilite * (30 / 100))
			return false;
		else
			return true;
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
	
	
	public void gagnerExperience(int valeurExperience) {
		
		//Verifie si le joueur va passer un niveau
		if ( this.experience + valeurExperience >= this.experienceMax) {
			this.gagnerNiveau();
			
			/* Afin de ne pas gacher d'expérience, j'ajoute l'expérience qu'il y avait en trop a la nouvelle expérience du joueur
			 * Exemple: Le joueur a 990 d'expérience et il lui en faut 1000 pour le niveau suivant
			 * Si il gagne 100 d'valeurExperience il va passer un niveau et 90 pts d'experience serons rajouté a sa nouvelle expérience.
			 */
			this.experience = 0 + (this.experience + valeurExperience) - this.experienceMax;
			
			/* Pour calculer l'expérience qui sera nécessaire pour le niveau suivant je multiplie l'expérience necessaire pour le premier niveau
			 * et je la multiplie par l'exponentielle du niveau du joueur divisé par 10.
			 * J'utilise Math.Round afin d'avoir le resultat arrontit a l'entier le plus proche
			 * Comme la fonction Math.round me renvoi un long, je convertit le tout en int grace a Math.toIntExact
			 */
			this.experienceMax = Math.toIntExact(Math.round(experienceMax + Math.exp(this.niveau/10)));
		}
		else {
			
			this.experience += valeurExperience;
	
		}
	}
	
	// Fonction permettant au personnage de gagner un niveau
	//Ici on va gerer tout les changements sur les attributs du a la prise de niveau
	public void gagnerNiveau() {
		
		
		
	}
	
}
