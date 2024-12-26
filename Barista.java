public class Barista extends Employee {
    public double salary;
    public double taxRate=18/100;
    public Barista(int id, String name, double salary){
        super(id,name);
        this.salary=salary;
    }
    public double getSalary(){
        return this.salary;
    }
    public double getTaxRate(){
        return this.taxRate;
    }
    public double calculateExpense(){
        return this.salary+(this.salary*this.taxRate);
    }
    public String toString(){
        return super.toString()+" is a barista"+ " with salary "+this.salary;
    }

}
