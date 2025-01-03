public abstract class Employee implements Expense {
     private int id;
     private String name;

     public Employee(int id, String name){
        this.id = id;
        this.name = name;
     }
     public int getId(){
        return id;
     }
     public String getName(){
        return name;
     }
     public String toString(){
        return "Employee " + id + " is " + name;
     }
    
}
