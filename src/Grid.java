public class Grid 
{
    public class Cell 
    {
        private int value;
        private Cell up;
        private Cell down;
        private Cell right;
        private Cell left;

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

        //Association des ups:
        grille[4].up = grille[0];
        grille[5].up = grille[1];
        grille[6].up = grille[2];
        grille[7].up = grille[3];

        grille[8].up = grille[4];
        grille[9].up = grille[5];
        grille[10].up = grille[6];

        //Association des downs:
        grille[0].down = grille[4];
        grille[1].down = grille[5];
        grille[2].down = grille[6];
        grille[3].down = grille[7];

        grille[4].down = grille[8];
        grille[5].down = grille[9];
        grille[6].down = grille[10];

        //Associations des rights:
        grille[0].right = grille[1];
        grille[1].right = grille[2];
        grille[2].right = grille[3];

        grille[4].right = grille[5];
        grille[5].right = grille[6];
        grille[6].right = grille[7];

        grille[8].right = grille[9];
        grille[9].right = grille[10];

        //Associations des lefts:
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

    public boolean move(Cell box)
    {
        Cell temp = null;
        Cell boxUp = box.up;
        Cell boxDown = box.down;
        Cell boxRight = box.right;
        Cell boxLeft = box.left;

        if (boxUp.value == -1)
        {
            temp = boxUp;
            boxUp = cellVide;
            cellVide = temp;
            return true;
        }
        else if (boxDown.value == -1)
        {
            temp = cellVide;
            for (Cell i: grille)
            {
                if (i == cellVide)
                {
                    i.value = box.value;
                    i.up = box.up;
                    i.down = box.down;
                    i.right = box.right;
                    i.left = box.left;
                }
            }

            box.value = temp.value;
            boxUp = temp.up;
            boxDown = temp.down;
            boxRight = temp.right;
            boxLeft = temp.left;
            return true;
        }
        // boxRight.value == -1 || boxLeft.value == -1) A ajouter
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
        System.out.println(grille[8].right.value);

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