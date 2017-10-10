import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * 
 * @author William Turmel
 *	Teste les méthodes Calcul et valeurConcole de la classe LectureFichier
 */
public class LectureFichierTest {
	/**
	 * Vérifie le résultat de l'addition
	 */
    @Test
	public void addition() {
        
    	final int resultat = LectureFichier.calcul("6 + 2");
    	
        assertEquals(resultat, 8);
    }
	/**
	 * Vérifie le résultat de la substraction
	 */
    @Test
	public void substraction() {
        
    	final int resultat = LectureFichier.calcul("5 - 1");
    	
        assertEquals(resultat, 4);
    }
	/**
	 * Vérifie le résultat de la multiplication
	 */
    @Test
	public void multiplication() {
        
    	final int resultat = LectureFichier.calcul("6 * 6");
    	
        assertEquals(resultat, 36);
    }
	/**
	 * Vérifie le résultat de la division
	 */
    @Test
	public void division() {
        
    	final int resultat = LectureFichier.calcul("10 / 2");
    	
        assertEquals(resultat, 5);
    }
	/**
	 * Vérifie le résultat de la division avec deux zéro
	 */
    @Test
	public void divisionAvecDeux0() {
        
    	final int resultat = LectureFichier.calcul("0 / 0");
    	
        assertEquals(resultat, 0);
    }
	/**
	 * Vérifie le résultat de la division avec un nombre et un zéro
	 */
    @Test
	public void divisionAvecUnNombreEt0() {
        
    	final int resultat = LectureFichier.calcul("3 / 0");
    	
        assertEquals(resultat, 0);
    }
	/**
	 * Vérifie le résultat de la division avec un zéro et un nombre
	 */
    @Test
	public void divisionAvec0EtUnNombre() {
        
    	final int resultat = LectureFichier.calcul("0 / 5");
    	
        assertEquals(resultat, 0);
    }
	/**
	 * Vérifie le résultat avec un nombre non valide (ex : lettre)
	 */
    @Test
	public void UnNombreNonValide() {
        
    	final int resultat = LectureFichier.calcul("w + t");
    	
        assertEquals(resultat, 0);
    }
	/**
	 * Vérifie le résultat avec un opérateur non valide (ex : t)
	 */
    @Test
	public void OperateurNonValide() {
        
    	final int resultat = LectureFichier.calcul("3 w 3");
    	
        assertEquals(resultat, 0);
    }
	/**
	 * Vérifie le résultat après une série de test
	 */
    @Test
	public void EntrerDesValeursNonValide() {
        /* test : plus grand que 99 (100)
    		*	: plus petit que 0 (-1)
    		*	: une valeur qui n'est pas un nombre (t)
    		*	: un nombre valide (99)
    		*/	
    	final int resultat = LectureFichier.valeurConcole();
    	
    	assertEquals(resultat, 3);
    }
}
