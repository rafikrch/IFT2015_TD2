public class Grid 
{
    public class Cell 
    {
        private int value;
        private Cell up;
        private Cell down;
        private Cell right;
        private Cell left;

        //Constructeur d'une cell:
        public Cell(int value, Cell up, Cell down, Cell right, Cell left)
        {
            this.value = value;
            this.up = up;
            this.down = down;
            this.right = right;
            this.left = left;
        }
    }
    
    public static Cell[] grille;
    public Cell cellVide;

    //Constructeur de la grid:
    public Grid()
    {
        grille = new Cell[12];

        //Création initiale des Cells:
        grille[0] = new Cell(25, null, null, null, null);
        grille[1] = new Cell(10, null, null, null, null);
        grille[2] = new Cell(1, null, null, null, null);
        grille[3] = new Cell(10, null, null, null, null);

        grille[4] = new Cell(1, null, null, null, null);
        grille[5] = new Cell(5, null, null, null, null);
        grille[6] = new Cell(5, null, null, null, null);
        grille[7] = new Cell(10, null, null, null, null);

        grille[8] = new Cell(1, null, null, null, null);
        grille[9] = new Cell(10, null, null, null, null);
        grille[10] = new Cell(1, null, null, null, null);

        //Association des Ups:
        grille[4].up = grille[0];
        grille[5].up = grille[1];
        grille[6].up = grille[2];
        grille[7].up = grille[3];

        grille[8].up = grille[4];
        grille[9].up = grille[5];
        grille[10].up = grille[6];

        //Association des Downs:
        grille[0].down = grille[4];
        grille[1].down = grille[5];
        grille[2].down = grille[6];
        grille[3].down = grille[7];

        grille[4].down = grille[8];
        grille[5].down = grille[9];
        grille[6].down = grille[10];

        //Associations des Rights:
        grille[0].right = grille[1];
        grille[1].right = grille[2];
        grille[2].right = grille[3];

        grille[4].right = grille[5];
        grille[5].right = grille[6];
        grille[6].right = grille[7];

        grille[8].right = grille[9];
        grille[9].right = grille[10];

        //Associations des Lefts:
        grille[1].left = grille[0];
        grille[2].left = grille[1];
        grille[3].left = grille[2];

        grille[5].left = grille[4];
        grille[6].left = grille[5];
        grille[7].left = grille[6];

        grille[9].left = grille[8];
        grille[10].left = grille[9];


        //Associations du cellVide et du reste des cells après sa spécification:
        cellVide = new Cell(-1, grille[7], null, null, grille[10]);
        grille[11] = cellVide;
        grille[7].down = grille[11];
        grille[10].right = grille[11];
    }

    //Méthode permettant de déplacer une case à la place de la case vide:
    public boolean move(Cell box)
    {
        Cell temporaire = new Cell(0, null, null, null, null);
        Cell boxUp = box.up;
        Cell boxDown = box.down;
        Cell boxRight = box.right;
        Cell boxLeft = box.left;

        //On vérifie que le mouvement est légal, puis on swap les deux cells:
        if (boxUp.value == -1 || boxDown.value == -1 || boxRight.value == -1 || boxLeft.value == -1)
        {
            temporaire.value = box.value;
            temporaire.up = boxUp;
            temporaire.down = boxDown;
            temporaire.right = boxRight;
            temporaire.left = boxLeft;

            box.value = cellVide.value;
            boxUp = cellVide.up;
            boxDown = cellVide.down;
            boxRight = cellVide.right;
            boxLeft = cellVide.left;

            for (int i = 0; i < grille.length; i++)
            {
                if (grille[i] == cellVide)
                {
                    grille[i].value = temporaire.value;
                    grille[i].up = temporaire.up;
                    grille[i].down = temporaire.down;
                    grille[i].right = temporaire.right;
                    grille[i].left = temporaire.left;
                }
            }
            return true;
        }
        //Si mouvement illégal (case vide et à déplacer non-adjacentes):
        else
        {
            return false;
        } 
    }

    public boolean check_complete()
    {
        // TODO
        return true;
    }

    public void solve_game()
    {
        // TODO
    }

    public static void main(String[] args)
    {
        Grid grid = new Grid();

        System.out.println("Liste avant move: \n");
        for (Cell i: grille)
        {
            System.out.println(i.value);
        }

        System.out.println(grid.move(grille[7]));

        System.out.println("liste apres move: \n");
        for (Cell i: grille)
        {
            System.out.println(i.value);
        }
    }
}