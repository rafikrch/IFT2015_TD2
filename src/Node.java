public class Node {
    private int value;
    private Node next = null;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = null;
    }

    public void addValue(int value) {
        if (this.next == null) {
            this.next = new Node(value);
        } else {
            this.next.addValue(value);
        }

    }

    public void addNode(Node next) {
        if (this.next == null) {
            this.next = next;
        }
            else{
                this.next.addNode(next);
            }

        }

    public void removeLast() {
        if (this.next.next == null) {
            this.next = null;
        } else {
            this.next.removeLast();
        }
    }


    public void removeValue(int value) {
        if (this.next != null) {
            if (this.next.value == value) {
                this.next = this.next.next;
                removeValue(value);
            } else {
                this.next.removeValue(value);
            }
        }
    }


    public int length_iteratif() {
        int count = 1;
        Node current = this;
        while (current.next != null) {
            count++;
            current = current.next;

        }
        return count;
    }

    public int length_recursion() {
        int length = 1;
        if(next == null){
            return length;
        }
        else{
            return length + next.length_recursion();
        }

    }

    public int returnNlast(int nLast) {
        int taille = this.length_iteratif();
        int index = taille - nLast;
        int count = 0;
        Node current = this;
        if (nLast > taille) {
            System.out.println("erreur : L'indice est superieur a la taille du tableau.");
        }
        while (current.next != null) {
            current = current.next;
            count++;

            if (count == index) {
                return current.value;
            }
        }
       return -1;
    }

    public void print() {
        String s = "[";
        Node current = this;
        while (current != null) {
            s += current.value ;

            if (current.next != null){
                s += ",";
            }
            current = current.next;
        }
        s+="]";
        System.out.println(s);

    }
    public void addValue_ordered(int value){
            Node newNode = new Node(value);
            Node current = this;
            while (current.next != null && current.next.value < value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }


    public void insertionSort() {
        if (next == null) {
            return; // Already sorted
        }

        Node newHead = new Node(value);
        Node current = next;

        while (current != null) {
            Node nextNode = current.next;

            if (current.value < newHead.value) {
                current.next = newHead;
                newHead = current;
            } else {
                Node temp = newHead;
                while (temp.next != null && current.value >= temp.next.value) {
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
