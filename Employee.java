public class Employee{
    String name;
    double salary;
    int workHours, hireYear;
    public Employee(){
        this.name = "Null";
        this.salary = 0;
        this.workHours = 0;
        this.hireYear = 0;
    }
    public Employee(String name, double salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }
    public double tax(){
        if(salary > 1000)
            return (salary * 3) / 100;
        else
            return 0;
    }
    public double bonus(){
        if(workHours > 30)
            return (workHours - 40) * 30;
        else    
            return 0;
    }
    public double raiseSalary(){
        if(2021 - hireYear < 10){
            return ((salary * 5) / 100);
        }
        else if(2021 - hireYear > 9 && 2021 - hireYear < 20){
            return ((salary * 10) / 100);
        }
        else if(2021 - hireYear > 19 ){
            return ((salary * 15) / 100);
        }
        else
            return 0;
    }
    public void toStringg(){
        double total = salary + bonus() - tax();
        double netSalary= salary + raiseSalary();

        System.out.println("Adı: " + name + "\n" +
                           "Maaşı: " + salary + "\n" + 
                           "Çalışma Saati: " + workHours + "\n" +
                           "Başlangıç Yılı: " + hireYear + "\n" + 
                           "Vergi: " + tax() + "\n" + 
                           "Bonus: " + bonus() + "\n" +
                           "Maaş Artışı: " + raiseSalary() + "\n" + 
                           "Vergi ve Bonuslar ile birlikte maaş: "  + total + "\n" +
                           "Toplam Maaş: " + netSalary);
    }
      
    public static void main(String[] args)
    {
        Employee employee = new Employee("kemal", 2000, 45, 1985);          
        employee.toStringg();
    }

}