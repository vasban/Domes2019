public class Node<T> {
	T data;
	Node<T> nextnode;
	
	Node(T data){
		this(data,null);
	}
	
	Node(T data, Node<T> nextnode){
		this.data = data;
		this.nextnode = nextnode;
	}
	
	 T getData(){
		return data;
	}
	 
	
	Node<T> getNext(){
		return nextnode;
	}
	
}