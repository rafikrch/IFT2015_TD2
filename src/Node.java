public class Node {
    private int value;
    private Node next = null;

    public Node(int value){
        this.value = value;
    }

    public Node(int value, Node next){
            this.value = value;
            this.next = next;
    }

    public void addValue(int value){
        if (this.next == null){
            this.next = new Node(value);
        }else{
            this.next.addValue(value);
        }

    }

    public void addNode(Node next){
         //TODO
    }

    public void removeLast(){
        if (this.next.next == null) {
            this.next = null;
        } else {
            this.next.removeLast();
        }
    }


    public void removeValue(int value){
        if (this.next != null) {
            if (this.next.value == value) {
                this.next = this.next.next;
                removeValue(value);
            } else {
                this.next.removeValue(value);
            }
        }
    }


public int length_iteratif(){
        int count = 1 ;
        Node current = this;
        while (current.next != null){
            count++;
            current= current.next;

        }
        return count;
    }

    public int length_recursion(){
        // TODO
        return 0;
    }

    public int returnNlast(int nLast){
        // TODO
        return 0;
    }

    public void addValue_ordered(int value){
        // TODO
    }

    public void insertSort(){
        // TODO
    }

    public static void main(String[] args) {
        Node n = new Node(0);
        n.addValue(1);
        n.addValue(2);

        System.out.println(n.length_iteratif());

    }
}
