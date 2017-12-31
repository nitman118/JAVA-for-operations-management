
public class Reptile extends Pet {
    public String speak() { // overrides pet.speak
        return "Yuck";
        
    }
    
    public static void main(String[] args) {
        Pet p ;
        p = new Reptile();
        System.out.println(p.speak());
        System.out.println(((Reptile)p).typec()); // typecasting because p typec is unique to reptile subclass
    }
    
    public String typec() {
    return "This is possible because of typecasting";

}
}
