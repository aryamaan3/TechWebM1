package TD5;

import java.io.*;
import java.util.Date;

public class Vaccin implements Externalizable {

	public enum Efficacite {Forte, Normale, Faible}

	private Date dateInjection;
	
	private transient String nomVaccin;
	
	private Efficacite efficacite;
	
	public Vaccin() {
		System.out.println("Constructeur par d�faut de vaccin");
	}
	
	public Vaccin(Date dateInjection, String nomVaccin) {
		super();
		this.dateInjection = dateInjection;
		this.nomVaccin = nomVaccin;
		this.efficacite = Efficacite.Normale;
	}

	@Override
	public String toString() {
		return "Vaccin{" +
				"dateInjection=" + dateInjection +
				", nomVaccin='" + nomVaccin + '\'' +
				", efficacite=" + efficacite +
				'}';
	}

	public Date getDateInjection() {
		return dateInjection;
	}
	public void setDateInjection(Date dateInjection) {
		this.dateInjection = dateInjection;
	}
	public String getNomVaccin() {
		return nomVaccin;
	}
	public void setNomVaccin(String nomVaccin) {
		this.nomVaccin = nomVaccin;
	}
	public Efficacite getEfficacite() {
		return efficacite;
	}
	public void setEfficacite(Efficacite e) {
		this.efficacite = e;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.dateInjection);
		out.writeObject(this.efficacite);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.dateInjection = (Date) in.readObject();
		this.efficacite = (Efficacite) in.readObject();
	}
}
