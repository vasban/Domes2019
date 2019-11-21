import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueImpl{
    private Node<String> firstnode;
    private Node<String> lastnode;
    private String name;
    private int s;

    public StringQueueImpl(){
        this("StringQueue");
        s=0;
    }
    public StringQueueImpl(String queuename){
        name = queuename;
        firstnode = lastnode = null;
        s =0;
    }
    public boolean isEmpty(){
        return firstnode == null;
    }
    public void put(String item){
        Node<String> temp = new Node<String>(item);
        
        if(isEmpty()) {
            firstnode = temp;
            lastnode =temp;
        }else{ 
            lastnode.nextnode = temp;
            lastnode = temp;
        }
        s++;

    }
    public String get()throws NoSuchElementException{
        if(isEmpty())throw new NoSuchElementException();

        String data;
        data = firstnode.data;
        firstnode =firstnode.nextnode;
        s--;
        return data;
    }
    public String peek()throws NoSuchElementException{
        if(isEmpty())throw new NoSuchElementException();

        return firstnode.data;
    }
    public void printQueue(PrintStream stream){
        if(isEmpty())stream.println("The queue is empty");

        Node<String> current = firstnode;
        while(current!= null){
            stream.println(current.data);
            stream.flush();
            current = current.nextnode;
        }
    }
    public int size(){
        return s;
    }

    public static void main(String []args){

        StringQueueImpl sq = new StringQueueImpl();

        sq.printQueue(System.out);

        sq.put("1");
        sq.put("2");
        sq.put("3");
        
        sq.printQueue(System.out);
        System.out.println(sq.peek());
        System.out.println(sq.size()+"<-- this is size");
        sq.get();
        sq.get();
        sq.printQueue(System.out);
    }


}