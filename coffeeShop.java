import java.util.ArrayList;
import java.util.Random;
public class CoffeeShop {

    ArrayList<Employee> empList;
    ArrayList<Barista> barList;
    ArrayList<Waiter> waiList;
    ArrayList<Product> proList;
    public CoffeeShop(){
        empList=new ArrayList<Employee>();
        barList=new ArrayList<Barista>();
        waiList=new ArrayList<Waiter>();

    }

    //public void initEmployees(){}
    //public void initProducts(){}
    // Although it was mentioned they were given, those were not given by Nitel Hoca

    public void listEmployees(){

        for (int i = 0; i < empList.size(); i++){
            System.out.println(empList.get(i).toString());
        }
    }
    int i=1;
    public void addBarista(String name, double salary){
        Barista bar = new Barista(i,name,salary);
        barList.add(bar);
        empList.add(bar);
        i++;

    }
    public void addWaiter(String name){
        Waiter wai = new Waiter(i,name);
        waiList.add(wai);
        empList.add(wai);
        i++;
    }
    public Waiter assignWaiter(){
        Random random = new Random();
        int randomIndex = random.nextInt(waiList.size());
        Waiter randomElement = waiList.get(randomIndex);
        return randomElement;
    }
    public double calculateExpenses(){
        double sum = 0;
        for (int j=0; j<empList.size(); j++){
            sum += empList.get(j).calculateExpense();
        }
        for (int a=0; a<waiList.size(); a++){
            ArrayList<order> ord = waiList.get(a).getOrdersReceived();
            for (int b=0; b<ord.size();b++) {
                sum += ord.get(b).calculateTotalPrice();
            }
        }
        return sum;
    }
    public double calculateRevenue(){
        double sum = 0.0;

        for (int c=0; c<waiList.size(); c++){
            ArrayList<order> ord = new ArrayList<order>();
            ord = waiList.get(c).getOrdersReceived();
            for (int d=0; d<ord.size(); d++){
                ArrayList<Product> pro = new ArrayList<Product>();
                pro = ord.get(d).getOrderedProducts();
                for (int e = 0; e<pro.size(); e++){
                    sum+=pro.get(e).getSellingPrice();
                }
            }

        }
        return sum;
    }
    //public ArrayList<Product> getProducts(){} i did not understand where to pull products

}
