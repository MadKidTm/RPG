
public class Arme {

	//attributs
	
	private String nom;
	private String categorie; 
	private int degats;
	private String type; //type d'arme
	
	//constructeurs
	public Arme() {
		nom = "pantoufle usée";
		categorie = ".";
		degats = 10;
		type = ".";
	}
	public Arme(String valeurnom, String valeurcategorie, int valeurdegats, String valeurtype) {
		
		nom = valeurnom;
		categorie = valeurcategorie;
		degats = valeurdegats;
		type=valeurtype;
		
	}
	
	public Arme(String valeurNom, int valeurDegats) {
		
		nom= valeurNom;
		categorie = "test";
		degats = valeurDegats;
		type = "null";
	}



	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public int getDegats() {
		return degats;
	}


	public void setDegats(int degats) {
		this.degats = degats;
	}

	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
}
	
	/* J'imagine que ici c'est ton constructeur. C'est bien mais il y a quelques regles quand tu crée une classe.
	 * -Tout d'abord il te faut toujours un constructeur par defaut ( c'est a dire une methode qui va s'appeler exactement comme ta classe mais qui ne va prendre aucun
	 * paramétre ) Ex: public Arme()
	 * A l'intérieur de celui ci , tu doit initialiser touts les attributs que posséde ta classe ( nom, catégorie, degats, type).
	 * Voila, tu as ton Constructeur par defaut.
	 * 
	 * C'est a partir de la que tu pourra le surcharger comme tu as essayer de le faire juste en dessous.
	 * Sauf que tu a bien déclarer tes paramétres formels ( string, string2...etc) Mais tu n'as pas mis d'instructions dans ton constructeur. Donc celui ci ne sais 
	 * pas quoi faire avec.
	 * C'est comme pour une fonction, une fois que tu as déclarer tes paramétres, tu doit lui dire quoi faire avec.
	 * Je te mets l'exemple concret de ce a quoi devrai ressembler ton constructeur surchargé:
	 * 
	 * public Arme(String string, String string2, int i, String string3) {
	 * 		
	 * 		nom = string;
	 * 		catégorie = string2;
	 * 		degats = i;
	 * 		type = string3;
	 * 
	 * }
	 * 
	 * Dans l'exemple ci dessu, tu as bien une initialisaton de tes attributs ( c'est le but d'un constructeur )
	 * 
	 * Et derniére petite info -> Essaye de mettre tes constructeurs en tout premier dans le code. Toujours dans cet ordre:
	 * 1.Attributs
	 * 2.Constructeurs
	 * 3.Accesseurs ( get et set)
	 * 4.Methodes 
	 * 
	 * Sinan bien de faire commencer le perso avec une épée en bois mdrr, c'est mieux que les rpg ou tu commence avec une casserole ou quoi :P.
	 */
