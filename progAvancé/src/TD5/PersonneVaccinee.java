package TD5;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

public class PersonneVaccinee extends Personne implements Externalizable {

	
	private ArrayList<Vaccin> vaccins;
	
		
	public PersonneVaccinee() {
		super();
		vaccins = new ArrayList<Vaccin>();
	}
	
	public PersonneVaccinee(String nom, String prenom, int age) {
		super(nom, prenom, age);
		vaccins = new ArrayList<Vaccin>();
	}
	

	@UseMethod(nomMethode = "addVaccin", nombreParametres = 1)
	public void addVaccin (Vaccin v) {
		vaccins.add(v);
	}
	

	@UseMethod(nomMethode = "ajusterEfficacite", nombreParametres = 0)
	@UseMethod(nomMethode = "accept", nombreParametres = 1)
	public void ajusterEfficacite () {
		System.out.println("Execution de ajusterEfficacite");
		int age = this.getAge();
		vaccins.forEach(new Consumer<Vaccin>() {
			@Override
			public void accept(Vaccin vaccin) {
				if(age > 65){
					vaccin.setEfficacite(Vaccin.Efficacite.Faible);
				}
				else if(age < 40){
					vaccin.setEfficacite(Vaccin.Efficacite.Forte);
				}
			}
		});
		
	}

	public void display () {
		System.out.println("Execution de display");
		System.out.println(super.toString());
		for (int i=0;i<vaccins.size();i++) {
			System.out.println("Vaccin " + vaccins.get(i).getNomVaccin() + "- Date injection " + vaccins.get(i).getDateInjection() + " - efficacit�: " + vaccins.get(i).getEfficacite() );
		}
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(getNom());
		out.writeObject(getPrenom());
		out.writeInt(getAge());
		out.writeObject(vaccins);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		setNom((String) in.readObject());
		setPrenom((String) in.readObject());
		setAge(in.readInt());
		vaccins = (ArrayList<Vaccin>) in.readObject();
	}

	public static void main(String[] args) {
		PersonneVaccinee test = new PersonneVaccinee("ary", "kun", 67);
		Vaccin v = new Vaccin(new Date(12122021), "pfizer");
		test.addVaccin(v);

		test.display();
		test.ajusterEfficacite();
		test.display();

	}
}
