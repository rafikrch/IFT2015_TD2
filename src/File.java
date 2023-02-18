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
    public boolean search(int value) {
        for(int i = 0; i < taille; i++){
            if (elements[i] == value){
                return true;
            }
        }
        return false;
    }

    public void remove(int value) {
        int index = start;
        for (int i = 0; i < taille; i++) {
            if (elements[index] == value) {
                elements[index] = 0;
                break;
            }
            index = (index+1) % elements.length;

        }
    }
}
