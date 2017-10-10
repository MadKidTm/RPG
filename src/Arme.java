
public class Arme {

	//attributs
	
	private String nom;
	private String categorie; 
	private int degats;
	private String type; //type d'arme
	

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
	

	public Arme(String string, String string2, int i, String string3) {
		
	}

	Arme arme = new Arme("épée en bois","basique", 5, "bois"); //exemple pour une épée basique
}
