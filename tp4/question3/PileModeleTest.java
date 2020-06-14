package question3;

/**
 * Classe-test PileModeleTest.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class PileModeleTest extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    question3.tp3.PileI pile;
    /**
     * Constructeur de la classe-test PileModeleTest
     */
    public PileModeleTest() {
    }

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        pile = new question3.tp3.Pile2 (3);

    }

    /**
     * Supprime les engagements
     * 
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Libérez ici les ressources engagées par setUp()
    }
    public void test_Pile_capacite() {
        PileModele p = new PileModele(pile);
        assertEquals(pile.capacite(), 3);
    }
    public void test_Pile_estPleine() throws Exception {
        PileModele p = new PileModele(pile);
        p.empiler(1);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(3);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question3.tp3.PilePleineException);
        }
    }
    public void test_Pile_toString() throws Exception {
        PileModele p = new PileModele(pile);
        assertEquals("toString incorrect ? ", "[]", p.toString());
        p.empiler(8);
        assertEquals("toString incorrect ? ", "[8]", p.toString());
        p.empiler(1);
        assertEquals("toString incorrect ? ", "[8, 1]", p.toString());
        p.empiler(100);
        assertEquals("toString incorrect ? ", "[8, 1, 100]", p.toString());
   }

    /**
     * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
     * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
     * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
     * "Enregistrer une méthode de test".
     */

}
