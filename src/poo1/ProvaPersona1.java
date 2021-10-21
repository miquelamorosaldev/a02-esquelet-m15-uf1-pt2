package poo1;

public class ProvaPersona1 {
    
    public static void main(String[] args) {
        
        Persona p1 = new Persona("Miquel","Amoros","Alberich","Profesor",37);
    	System.out.println(p1.nom);
    	p1.salutacioInformal();
    	p1.salutacioFormal();
    	p1.dirEdat();
    	Persona pA = new Persona("Anonimus","","","Anonimus",1000);
    	pA.dirEdat();
    	pA.salutacioInformal();
    	pA.dirEdat();
        
        Persona pB = new Persona("Persona","","","Anonima",99);
        pB.salutacioInformal();
        pB.salutacioFormal();
    }
}
