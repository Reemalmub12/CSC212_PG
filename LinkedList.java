public class LinkedList<T>{

private Node<T> head;
private Node<T> current;
int size=0;

public LinkedList(){
head=current=null;
}

public boolean empty(){
return head==null;
}

public boolean isFull(){
return false;
}

public boolean last(){
return current.next==null;
}

public void findFirst(){
current=head;
}

public void findNext(){
current=current.next;
}

public void update(T d){
current.data=d;
}

public T retrieve(){
return current.data;
}

public void insert(T d){
Node<T> p=new Node<T>(d);

if(head==null){
head=p;
current=p;
}

else{
p.next=current.next;
current.next=p;
current=p;}
size++;
}

public void remove(){

if(current==head){
head=head.next;
current=current.next;
}

else{
Node<T> s=head;

while(s.next!=current)
s=s.next;

s.next=current.next;

if(current.next!=null)
current=current.next;
else
current=head;
}
size--;
}

public void insertBeforeCurrent(T d){
Node<T> tmp=new Node<T>(d);

if(head==null){
head=tmp;
current=tmp;
}

else
if(current==head){
tmp.next=head;
head=tmp;
}

else{
Node<T> p=head;

while(p.next!=current)
p=p.next;

p.next=tmp;
tmp.next=current;}
size++;
}


public void display(){
if(head==null){
System.out.println("Empty List");
return;
}

Node<T> h=head;

while(h!=null){
System.out.println("Data: "+h.data);
h=h.next;
}
System.out.println("Number of items: "+size);
}

public int getSize(){
return size;
}
}