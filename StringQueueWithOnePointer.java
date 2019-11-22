import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueWithOnePointer{
    private Node<String> lastnode;
    private String name;
    private int s;

    public StringQueueWithOnePointer(){
        this("StringQueueWithOnePointer");
        s =0;

    }

    public StringQueueWithOnePointer(String name){
        this.name = name;
        lastnode = null;
        s = 0;
    }

    public boolean isEmpty() {
        return lastnode == null;
    }

    public void enqueue (String item){
        Node<String> temp = new Node<String>(item);
        if(isEmpty()){
            lastnode=temp;
            lastnode.nextnode = lastnode;
        }else{
            temp.nextnode = lastnode.nextnode;
            lastnode.nextnode = temp;
            lastnode = temp;
        }
        s++;
    }
    public String dequeue()throws NoSuchElementException{
        if(isEmpty())throw new NoSuchElementException();
        String data= lastnode.nextnode.data;
        if(size() == 1){
            lastnode = null;
        }else{
            lastnode.nextnode = lastnode.nextnode.nextnode;
        }
        s--;
        return data;
    }
    public String peek()throws NoSuchElementException{
        if(isEmpty())throw new NoSuchElementException();
        return lastnode.nextnode.data;
    }
    public int size(){
        return s;
    }
    public void printQueueWithOnePointer(PrintStream stream){
        if(isEmpty()) stream.println("The queue is empty");
        Node<String> current = lastnode.nextnode;
        for(int i=0;i<size();i++){
            stream.println(current.data);
            stream.flush();
            current = current.nextnode;
        }

    }

    public static void main(String []args){

        StringQueueWithOnePointer sqwop = new StringQueueWithOnePointer("string queue with one pointer");

        sqwop.enqueue("a");
        sqwop.enqueue("b");
        sqwop.enqueue("c");
        sqwop.enqueue("d");

        sqwop.printQueueWithOnePointer(System.out);

        System.out.println(sqwop.peek()+"<---this is peek");
        System.out.println(sqwop.size()+"<---- this is size");
        System.out.println(sqwop.dequeue()+"<---- this is dequeue");
        sqwop.printQueueWithOnePointer(System.out);
        System.out.println(sqwop.dequeue()+"<---- this is dequeue");
        System.out.println(sqwop.dequeue()+"<---- this is dequeue");
        sqwop.printQueueWithOnePointer(System.out);
        System.out.println(sqwop.dequeue()+"<---- this is dequeue");
        sqwop.printQueueWithOnePointer(System.out);

    }

}