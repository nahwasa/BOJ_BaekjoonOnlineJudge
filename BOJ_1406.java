import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node {
   private char c;
   private Node next;
   private Node prev;
   
   Node(char c) {
      this.c = c;
      next = null;
      prev = null;
   }

   public char getC() {
      return c;
   }

   public void setC(char c) {
      this.c = c;
   }

   public Node getNext() {
      return next;
   }

   public void setNext(Node next) {
      this.next = next;
   }

   public Node getPrev() {
      return prev;
   }

   public void setPrev(Node prev) {
      this.prev = prev;
   }
}

class DoublyLinkedList {
   Node start;
   Node pointer;
   
   DoublyLinkedList(String s) {
      if (s.isEmpty())
         return;
      
      start = pointer = new Node('\0');   //Not use
            
      insert(s.charAt(0));
      
      for(int i = 1; i < s.length(); i++) {
         insert(s.charAt(i));      
      }
   }
   
   void insert(char c) {
      Node tmp = pointer.getNext();
      pointer.setNext(new Node(c));      
      pointer.getNext().setPrev(pointer);      
      pointer = pointer.getNext();
      if (tmp != null) {
         tmp.setPrev(pointer);
         pointer.setNext(tmp);
      }
   }
   
   void removeNode() {
      if (pointer == start)
         return;
      pointer.getPrev().setNext(pointer.getNext());
      if (pointer.getNext() != null)
         pointer.getNext().setPrev(pointer.getPrev());
      pointer = pointer.getPrev();
   }
   
   void movePointerToPrev() {
      if (pointer == start)
         return;
      pointer = pointer.getPrev();
   }
   
   void movePointerToNext() {
      if (pointer.getNext() == null)
         return;
      pointer = pointer.getNext();
   }

   @Override
   public String toString() {
      StringBuffer sb = new StringBuffer();      
      Node tmp = start;
      while (true) {
         tmp = tmp.getNext();
         if (tmp == null)
            break;
         sb.append(tmp.getC());
      }
      return sb.toString();
   }
   
   
}

public class Main {   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      DoublyLinkedList dll = new DoublyLinkedList(br.readLine());
      
      int n = Integer.parseInt(br.readLine());
      
      for(int i = 0; i < n; i++) {
         StringBuffer input = new StringBuffer(br.readLine());         
         
         if (input.charAt(0) == 'L') {
            dll.movePointerToPrev();
         } else if (input.charAt(0) == 'D') {
            dll.movePointerToNext();
         } else if (input.charAt(0) == 'B') {
            dll.removeNode();
         } else if (input.charAt(0) == 'P') {
            dll.insert(input.charAt(2));
         }     
       
      }
      
      bw.write(dll.toString() + "\n");      
      bw.flush();
      br.close();
      bw.close();      
   }
}
