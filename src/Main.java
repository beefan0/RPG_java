// Classe représentant un combattant
class Combattant {
    // Attributs privés pour le nom, les points de vie et la force d'attaque du combattant
    private String nom; // Nom du combattant
    private int pointsDeVie; // Points de vie actuels du combattant
    private int force; // Force d'attaque du combattant

    // Constructeur pour initialiser un combattant avec son nom, ses points de vie et sa force
    public Combattant(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
    }

    // Méthode pour obtenir le nom du combattant
    public String getNom() {
        return nom;
    }

    // Méthode pour obtenir les points de vie restants du combattant
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    // Méthode pour réduire les points de vie du combattant lorsqu'il reçoit des dégâts
    public void recevoirDegats(int degats) {
        pointsDeVie -= degats; // Réduit les points de vie de la valeur des dégâts reçus
        if (pointsDeVie < 0) { // Assure que les points de vie ne deviennent pas négatifs
            pointsDeVie = 0;
        }
    }

    // Méthode pour attaquer un autre combattant
    public void attack(Combattant adversaire) {
        System.out.println(nom + " attaque " + adversaire.getNom() + " pour " + force + " points de dégâts !");
        adversaire.recevoirDegats(force); // Inflige des dégâts à l'adversaire
    }

    // Méthode pour vérifier si le combattant est encore en vie
    public boolean estVivant() {
        return pointsDeVie > 0; // Retourne vrai si les points de vie sont supérieurs à 0
    }
}

// Classe représentant le jeu
class Game {
    private Combattant equipe1; // Le combattant de la première équipe
    private Combattant equipe2; // Le combattant de la deuxième équipe

    // Constructeur pour initialiser le jeu avec deux combattants
    public Game(Combattant equipe1, Combattant equipe2) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
    }

    // Méthode principale pour exécuter le combat entre les deux combattants
    public void play() {
        System.out.println("Début du combat entre " + equipe1.getNom() + " et " + equipe2.getNom() + " !");

        // Boucle tant que les deux combattants sont vivants
        while (equipe1.estVivant() && equipe2.estVivant()) {
            equipe1.attack(equipe2); // Le combattant de l'équipe 1 attaque l'autre
            if (!equipe2.estVivant()) { // Si le combattant de l'équipe 2 est KO, on arrête la boucle
                break;
            }
            equipe2.attack(equipe1); // Le combattant de l'équipe 2 attaque l'autre
        }

        // Affichage du vainqueur du combat
        if (equipe1.estVivant()) { // Si l'équipe 1 est encore en vie
            System.out.println("Le vainqueur est : " + equipe1.getNom() + " !");
        } else { // Sinon, l'équipe 2 est le vainqueur
            System.out.println("Le vainqueur est : " + equipe2.getNom() + " !");
        }
    }
}

// Classe principale pour executer le programme
public class Main {
    public static void main(String[] args) {
        // Création de deux combattants avec des points de vie et une force d'attaque
        Combattant combattant1 = new Combattant("Guerrier", 100, 20); // Un guerrier avec 100 PV et 20 de force
        Combattant combattant2 = new Combattant("Mage", 80, 25); // Un mage avec 80 PV et 25 de force

        // Création d'un jeu avec les deux combattants
        Game game = new Game(combattant1, combattant2);
        game.play(); // Lancement du combat
    }
}
