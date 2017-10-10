import java.io.*;
import java.util.Scanner;
public class LectureFichier {

	/** 
	 * Programme qui fait la lecture de données dans le fichierAvant. 
	 * Ensuite, le programme fait le calcul (multiplication, soustraction ou addition) des deux nombres lus dans le fichier 
	 * Ensuite, le programme écrit le résultat avec le calcul des deux nombres (par exemple: a + b = c) dans le fichierApres.txt
	 * 
	 */
	public static void main(String[] args) {
		

// lecture du fichier de données
		try {
			
			File monFichier = new File("fichierAvant.txt");
			FileReader lecture = new FileReader(monFichier);			
			BufferedReader reader = new BufferedReader(lecture);
			viderFichier();
			
			String ligne = null;

// traitement de la ligne pour le calcul			
			while ((ligne = reader.readLine()) != null && !ligne.isEmpty()) {
				
				
				System.out.println(ligne);	
				
				
				/*exécution de la méthode statique calcul
				qui lit une ligne du fichier et retourne le résultat du calcul
				dans la variable resultat*/
				
				
				int resultat=LectureFichier.calcul(ligne);
				ligne += " = " + resultat + "\n";
				// écriture des données dans le fichier résultat.			
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("fichierApres.txt",true));
						writer.write(ligne);
						writer.close();
						
						
					} catch(IOException ex) {
						ex.printStackTrace();
					}
					
			}
			
			reader.close();
			
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		int chiffreConsole = valeurConcole();
		
		
	}

	public static int calcul(String ligne) {
		String [] separation = ligne.split(" ");
		
		int chiffre1;
		int chiffre2;
		char operateur;
		int resultat = 0; 
		
		try{
			
			chiffre1 = Integer.parseInt(separation[0]);
			chiffre2 = Integer.parseInt(separation[2]);
			operateur =separation[1].charAt(0);
			
			
			switch(operateur){
			case '+':
				resultat = (chiffre1 + chiffre2);
				break;
			case '-':
				resultat = (chiffre1 - chiffre2);
				break;
			case '*':
				resultat = (chiffre1 * chiffre2);
				break;
			case '/':
				if(chiffre1 != 0 && chiffre2 != 0){
					resultat = chiffre1 / chiffre2;
				} else {
					resultat = 0;
				}
				break;
			
			
				
			
			}
			
		}catch(IllegalArgumentException e){
			System.out.println(" Les nombres doit être des entiers. (pas de lettres!)");
		}		
		
		
		
	
		return (resultat);
	}
	
	public static void viderFichier() {
		BufferedWriter writerVider;
		try {
			writerVider = new BufferedWriter(new FileWriter("fichierApres.txt"));
			writerVider.write(" ");	
			writerVider.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public static int valeurConcole() {
		Scanner lire = new Scanner(System.in);
		
		int chiffre = 0;
		String ligne = "";
		boolean valide = false;
		while(!valide){
			System.out.println("Entrez un entier de 0 à 99: ");
			ligne = lire.nextLine();
			try{
				
				chiffre = Integer.parseInt(ligne);
				
				if(chiffre < 100 && chiffre >= 0){
					valide = true;
				}
				
				
			}catch(Exception e){
				
				System.out.println("ERREUR: Entrez un chiffre entre 0 et 99!");			
			}
			
			
			
			
			
		}
		
		return chiffre;
		
		
	
	}

}
