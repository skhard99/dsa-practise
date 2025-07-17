package priorityqueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PQLearning {

    public static void main (String[] args) {
        System.out.println("By default it is ascending");
        defaultCase();
        System.out.println("-----------------");
        System.out.println("Comparator reversed for descending");
        reversedCase();
        System.out.println("-----------------");
        System.out.println("Sorting first by id, then within same id by name in desc");
        compareObject();
        System.out.println("-----------------");
        sortMapKeys();
        
    }

    private static void defaultCase() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(5);
        pq.add(-1);
        pq.add(10);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    private static void reversedCase() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(2);
        pq.add(5);
        pq.add(-1);
        pq.add(10);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    private static void compareObject() {
        Comparator personComparator = Comparator.comparingInt(Person::getId).thenComparing(Person::getName, Comparator.reverseOrder());
        PriorityQueue<Person> pq = new PriorityQueue<>(personComparator);
        pq.add(new Person(1, "Shivank", "Address"));
        pq.add(new Person(2, "AA", "Address"));
        pq.add(new Person(2, "AB", "Address"));
        pq.add(new Person(2, "ZZ", "Address"));
        pq.add(new Person(-1, "AB", "Address"));

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }

    private static void sortMapKeys() {
        Map<Integer, Person> map = new HashMap<>();
        map.put(10, new Person(1, "Shivank", "Address"));
        map.put(20, new Person(2, "AA", "Address"));
        map.put(30, new Person(2, "ZZ", "Address"));
        Comparator<Person> personComparator = Comparator.comparingInt(Person::getId).thenComparing(Person::getName, Comparator.reverseOrder());
        List<Integer> sortedKeys = map.entrySet().stream().sorted(Map.Entry.comparingByValue(personComparator)).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(sortedKeys);
        List<Person> sortedPersons = map.entrySet().stream().sorted(Map.Entry.comparingByValue(personComparator)).map(Map.Entry::getValue).collect(Collectors.toList());
        System.out.println(sortedPersons);
    }
    
}

class Person {
    private String name;
    private int id;
    private String address;

    public Person(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "Person=" + "Id:" + id + ",Name:" + name;
    }
    
}