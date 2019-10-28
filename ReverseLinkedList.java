/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 10-15-19
 *  Description: This class is the runner for reverse linked list.
 **************************************************************************** */

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> myList= new LinkedList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        System.out.println("List: ");
        for(Integer x: myList) System.out.print(x + " ");
        System.out.println("");

        myList.iReverse();
        System.out.println("Iteratively Reverse: ");
        for(Integer x: myList) System.out.print(x + " ");
        System.out.println("");

        myList.rReverse();
        System.out.println("Recursively Reverse: ");
        for(Integer x: myList) System.out.print(x + " ");
    }
}
