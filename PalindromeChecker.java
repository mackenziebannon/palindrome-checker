import java.util.Scanner;

/*  Author: Mackenzie Bannon
 *
 *  This class implements a Deque which is implemented using a
 *      Doubly-Linked List.
 *  The program will check and verify whether an inputted string of characters
 *      is a palindrome. (Case sensitive).
 */

public class PalindromeChecker {
  private static class Deque<T> {
    private class Node <T> {
      T item;
      Node<T> prev;
      Node<T> next;


      private Node(T item, Node <T> prev, Node<T> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
      }

      /**
       * Sets the previous node of a node.
       * @param prev - node to be set as the previous node of the node it is
       *               called on.
       */

      public void setPrev(Node<T> prev) {
                this.prev = prev;
            }

      /**
       * Sets the next node of a node.
       * @param next - node to be set as the next node of the node it is
       *               called on.
       */

      public void setNext(Node<T> next) {
                this.next = next;
            }

      /**
       * Returns the previous node of a node.
       * @return prev - the previous node of the node the method is called on.
       */

      public Node<T> getPrev() {
                return prev;
            }

      /**
       * Returns the next node of a node.
       * @return next - the next node of the node the method is called on.
       */

      public Node<T> getNext() {
                return next;
            }

      /**
       * Returns the item at a node.
       * @return item
       */

      public T getItem() {
                return item;
            }
    }

    // instantiate variables
    Node<T> head;
    Node<T> tail;
    int count;

    // constructor
    private Deque(){
      count = 0;
      head = null;
      tail = null;
    }

    /**
     * @return - returns the first item at the head of the
     *     doubly linked list (deque).
     */

    private T getFirst() {
            return head.getItem();
        }

    /**
     * @return - returns the last item at the tail of the
     *     doubly linked list(deque).
     */

    private T getLast() {
            return tail.getItem();
        }

    /**
     * Inserts an item before the first item (or head) of the doubly
     *     linked list (deque).
     * @param item - item to be inserted into the deque
     */

    private void addFirst(T item) {
      Node<T> node = new Node<>(item, null, null);
      if (isEmpty()){
        head = node;
        tail = node;
      } else {
          node.setNext(head);
          head.setPrev(node);
          head = node;
      }
      count++;
    }


    /**
     * Inserts an item after the last item (or tail) of the doubly
     *     linked list(deque).
     * @param item - item to be inserted into the deque
     */

    private void addLast(T item){
      if (isEmpty()){
        head = new Node <T> (item, null, null);
        tail = new Node <T> (item, null, null);
      } else {
        tail.setNext(new Node <T> (item, tail, null));
        tail = tail.getNext();
      }
      count++;
    }

    /**
     * Removes the first item (head) of the doubly linked list (deque)
     * @return item - the item that was removed.
     */
    private T removeFirst() {
      if (head!=null) {
        T item = head.item;
        head = head.getNext();
        count--;
        return item;
      }
      return null;
    }


    /**
     * Removes the last item (tail) of the doubly linked list (deque)
     * @return item - the item that was removed.
     */
    private T removeLast() {
      T item = tail.item;
      tail = tail.getPrev();
      count--;

      return item;
    }

    /**
     * Returns but does not modify the first element in the deque.
     * @return the first element in the deque.
     */
    private T peekFirst(){
            return head.getItem();
        }

    /**
     * Checks if the deque is empty.
     * @return boolean - true if it is empty, false otherwise.
     */
    private Boolean isEmpty() {
            return count() == 0;
        }

    /**
     * Returns the count of the deque.
     * @return count - current number of nodes in the doubly linked list.
     */
    private int count() {
            return count;
        }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String palindrome = "";
    Deque<String> emordnilap = new Deque<>();

    System.out.println("Please enter your word as single characters separated by a new line:");
    System.out.println("When finished inputting, please enter 'Done'");
    String input = in.nextLine();
    while (input.length() <= 1) {
      palindrome += input;
      emordnilap.addFirst(input);
      input = in.nextLine();
    }

    String palindromeChecker = "";

    while(!emordnilap.isEmpty()){
      palindromeChecker += emordnilap.removeFirst();
    }

    if(palindrome.equals(palindromeChecker)){
      System.out.println("Yes");
      System.out.println("Forwards: " + palindrome);
      System.out.println("Backwards: " + palindromeChecker);
    } else {
      System.out.println("No");
      System.out.println("Forwards: " + palindrome);
      System.out.println("Backwards: " + palindromeChecker);
    }
  }

}

