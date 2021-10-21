package poo1;

public class Persona {

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", cognom1=" + cognom1 + ", cognom2=" + cognom2 + ", professio=" + professio + ", edat=" + edat + '}';
    }
    
	// ATRIBUTOS.
	public String nom;
	public String cognom1;
	public String cognom2;
    
	private String professio;
	private int edat;

        // CONSTRUCTOR. 
	public Persona() {
   	 
	}
    
	public Persona(String nom, int edat) {
            this.nom = nom;
            this.edat = edat;
	}
       	 
	public Persona(String nom, String cognom1, String cognom2, String professio, int edat) {
            this.nom = nom;
            this.cognom1 = cognom1;
            this.cognom2 = cognom2;
            this.professio = professio;
            this.edat = edat;
	}
    
	// METODOS. 

	//	SalutacioInformal. Mostra per pantalla una salutació amb el nom
	//SalutacioFormal. Mostra per pantalla “Bon dia, em dic ” + nom + cognom1 + cognom2
	//Diredat. Mostra per pantalla “Em dic “ + nom + “ i tinc “ + edat + “anys.”
    
	public void salutacioInformal() {
            System.out.println("Sóc el " + nom);
	}
    
	public void salutacioFormal() {
            System.out.println("Bon dia em dic " + nom + " " + cognom1 + " " + cognom2 + " i tinc " + edat + " anys.");
	}
    
	public void dirEdat() {
            StringBuilder sb = new StringBuilder();
            sb.append("Em dic ");
            sb.append(nom);
            sb.append(" i tinc ");
            sb.append(edat);
            sb.append(" anys.");
            System.out.println(sb.toString());
	}

}
