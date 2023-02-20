public class Node
{
    private int value;
    private Node next = null;

    //Constructeurs d'un Noeud:
    public Node(int value)
    {
        this.value = value;
    }
    public Node(int value, Node next)
    {
        this.value = value;
        this.next = null;
    }

    //Méthode pour ajouter une valeur à la fin de la liste chainée: (récursif)
    public void addValue(int value)
    {
        //Condition d'arrêt: Qd il n'y a pas de noeud suivant,
        //On ajoute un nouveau noeud avec la valeur
        if (this.next == null)
        {
            this.next = new Node(value);
        }

        //Récursion sur le noeud suivant quand il existe
        else
        {
            this.next.addValue(value);
        }
    }

    //Méthode pour concaténer deux listes:
    //On ajoute un Noeud existant à la fin de la première liste
    public void addNode(Node next)
    {
        //Condition d'arrêt: Quand on est à la fin de la première liste,
        //On ajoute le noeud d'entrée de la méthode
        if (this.next == null)
        {
            this.next = next;
        }

        //Récursion sur le Noeud suivant quand il existe
        else
        {
            this.next.addNode(next);
        }
    }

    //Méthode qui retire le dernier élément de la liste:
    public void removeLast()
    {
        //Condition d'arrêt: Quand il n'y a plus de Noeud dans 2 Noeuds,
        //On supprime le noeud suivant
        if (this.next.next == null)
        {
            this.next = null;
        }

        //Récursion sur le Noeud suivant quand il y a encore 2 Noeuds ou plus
        //À la suite du Noeud actuel
        else
        {
            this.next.removeLast();
        }
    }

    //Méthode qui retire tout les Noeuds avec une certaine valeur
    public void removeValue(int value)
    {
        //S'effectue tant qu'il y a des éléments non parcourus
        if (this.next != null)
        {
            //On vérifie si la valeur du Noeud est la même que la valeur a retirer
            //Si oui, on remplace le Noeud par son prochain et on recommence
            if (this.next.value == value)
            {
                this.next = this.next.next;
                removeValue(value);
            }

            //Si la valeur est différente, on fait une récursion sur l'élément suivant
            else
            {
                this.next.removeValue(value);
            }
        }
    }

    //Méthodes pour récupérer la longueur de la liste (1: Itératif, 2: Récursif)
    public int length_iteratif()
    {
        int count = 1;
        Node current = this;

        //On passe par chaque Noeud et on incrémente un compteur
        while (current.next != null)
        {
            count++;
            current = current.next;

        }
        return count;
    }

    public int length_recursion()
    {
        int length = 1;

        //Condition d'arrêt: Lorsqu'il n'y a plus de Noeud prochain,
        //On récupère la longueur
        if(next == null)
        {
            return length;
        }

        //On incrémente la longueur à chaque appel récursif
        else
        {
            return length + next.length_recursion();
        }

    }

    //Méthode pour récupérer le n-ième élément en partant de la fin:
    public int returnNlast(int nLast)
    {
        int taille = this.length_iteratif();
        int index = taille - nLast; //Pour connaitre l'indice de l'élément où s'arrêter
        int count = 0;
        Node current = this;

        //Pour couvrir le cas où l'on chercherai un élément à une position plus grande
        //que la longueur de la liste,
        if (nLast > taille)
        {
            System.out.println("erreur : L'indice est superieur a la taille du tableau.");
            return -1;
        }

        //Tant qu'il y a un Noeud prochain, on incrémente un compteur
        //et lorsque le compteur est à la position de l'élément cherché, on récupère la valeur
        while (current.next != null)
        {
            current = current.next;
            count++;

            if (count == index)
            {
                return current.value;
            }

        }
        return -1;
    }

    //Méthode pour ajouter un élément dans une liste ordonée:
    public void addValue_ordered(int value)
    {
        Node newNode = new Node(value);
        Node current = this;

        //On a différentes conditions d'arrêt.
        //Soit on arrive à l'élément suivant plus grand ou égal à l'élément à insérer:
        if (current.next != null && current.next.value >= value)
        {
            newNode.next = current.next;
            current.next = newNode;
        }
        //Soit on arrive à la fin de la liste:
        else if (current.next == null && current.value <= value)
        {
            current.next = newNode;
        }
        else
        {
            current = current.next;
            current.addValue_ordered(value);
        }
    }

    //Méthode de tri par insertion dans l'ordre croissant des valeurs:
    public void insertSort()
    {
        if (next == null)
        {
            return; //Déjà trié
        }

        Node newHead = new Node(value);
        Node current = next;

        //On va passer sur tout les éléments
        while (current != null)
        {
            Node nextNode = current.next;

            //Si la valeur du Noeud où on se trouve est plus petite que celle de la tête,
            //Ce Noeud devient la tête
            if (current.value < newHead.value)
            {
                current.next = newHead;
                newHead = current;
            }
            //Sinon on avance dans la liste
            else
            {
                Node temp = newHead;
                while (temp.next != null && current.value >= temp.next.value)
                {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }

            current = nextNode;
        }

        value = newHead.value;
        next = newHead.next;
    }
}
