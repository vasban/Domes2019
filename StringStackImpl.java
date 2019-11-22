import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl {

    private Node<String> firstnode;
    private Node<String> lastnode;
    private final String name;
    private static int s;

    public StringStackImpl() {
        this("StringStack");
        s = 0;

    }

    public StringStackImpl(String stackname) {
        name = stackname;
        firstnode = lastnode = null;
        s = 0;
    }

    public boolean isEmpty() {
        return firstnode == null;
    }

    public void push(String item) {
        final Node<String> temp = new Node<String>(item);

        if(isEmpty()) lastnode = temp;

        temp.nextnode = firstnode;
        firstnode = temp;
        s++;
    }

    public String pop() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        String data;
        data = firstnode.data;
        firstnode = firstnode.nextnode;
        s--;
        return data;
    }

    public String peek() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        return firstnode.data;
    }

    public void printStack(final PrintStream stream) {
        if (isEmpty())
            stream.println("the list is empty");

        Node<String> temp = firstnode;
        while (temp != null) {
            stream.println(temp.data);
            stream.flush();
            temp = temp.nextnode;
        }
    }

    public int size() {
        return s;
    }

    public static void main(final String []args){
        final StringStackImpl st = new StringStackImpl();

        
        st.printStack(System.out);

        st.push("1");
        st.push("2");
        st.push("3");
        st.push("4");
        st.push("5");
        st.push("6");
        st.push("7");
     

        st.printStack(System.out);
        System.out.println("this is size :"+st.size());

        st.pop();st.pop();st.pop();

        st.printStack(System.out);
        System.out.println("this is size :"+st.size());
        System.out.println("this is peek :"+st.peek());
        st.pop();
        System.out.println("this is peek :"+st.peek());
    
        
        
    }


}