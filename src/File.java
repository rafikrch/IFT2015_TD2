public class File {
    public int[] elements;
    public int start;
    public int end;
    public int taille;

    public File() {
        elements = new int[100];
    }

    public void push(int element) {
        elements[end] = element;
        end = (end + 1) % elements.length;
        taille++;

    }


    public int pop() {
        int element = elements[start];
        elements[start] = 0;
        start = (start + 1) % elements.length;
        taille--;
        return element;
    }

    public int length() {
        return taille;
    }
    
    public void print() {
        String tab = "(";
        for (int i = 0; i < taille; i++) {
            int index = (start + i) % elements.length;
            tab+=elements[index];
            if (i < taille-1) {
                tab+=",";
            }
        }
        tab +=")";
        System.out.println(tab);
    }
    public boolean search() {
        for(int i = 0; i < taille; i++){

        }
        return false;
    }

    public void remove(int value) {
        for (int i = 0; i < taille; i++) {
            if (elements[i] == value) {
                elements[i] = 0;
                break;
            }

        }
    }


}
