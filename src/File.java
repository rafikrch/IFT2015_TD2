public class File 
{
    public int[] elements;
    public int start;
    public int end;
    public int taille;

    //Constructeur:
    public File() 
    {
        elements = new int[100];
    }

    //Méthode d'ajout d'un élément à la file circulaire:
    public void push(int element) 
    {
        elements[end] = element;
        end = (end + 1) % elements.length;
        taille++;
    }

    //Méthode pour retirer un élément de la file:
    public int pop() 
    {
        int element = elements[start];
        elements[start] = 0;
        start = (start + 1) % elements.length;
        taille--;
        return element;
    }

    //Méthode qui retourne la longueur de la file, calculée au fur et à mesure des push/pop:
    public int length() 
    {
        return taille;
    }
    
    //Méthode d'affichage de la file:
    public void print() 
    {
        String tab = "(";
        for (int i = 0; i < taille; i++) 
        {
            int index = (start + i) % elements.length;
            tab+=elements[index];
            if (i < taille-1) 
            {
                tab+=",";
            }
        }
        tab +=")";
        System.out.println(tab);
    }

    //Méthode pour vérifier l'existence d'un élément dans la file:
    public boolean search(int element) 
    {
        for(int i = 0; i < taille; i++)
        {
            if(elements[i] == element)
            {
                return true;
            }

        }
        return false;
    }

    //Méthode pour une valeur en particulier (sa première apparition):
    public void remove(int value) 
    {
        for (int i = 0; i < taille; i++) 
        {
            if (elements[i] == value) 
            {
                elements[i] = 0;
                break;
            }
        }
    }
}