package TD5;

import java.io.IOException;
import java.io.Serializable;

public class Personne {

	private String nom;
	private String prenom;
	private int age;
	
	public Personne() {
		System.out.println("Constructeur par d�faut de personne");
	}
	
	public Personne (String n, String p, int a) {
		nom = n;
		prenom = p;
		age = a;
	}
     
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString () {
		System.out.println("Execution de toString (personne)");
		return "nom: " + nom + "- Pr�nom: " + prenom + " - age: " + age ;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeObject(this.nom);
		out.writeObject(this.prenom);
		out.writeInt(this.age);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		this.nom = (String) in.readObject();
		this.prenom = (String) in.readObject();
		this.age = in.readInt();
	}
}
