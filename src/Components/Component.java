package Components;

public class Component {
    private String name;
    private Integer caloric;
    public Component(String name,Integer caloric)
    {
        this.name = name;
        this.caloric = caloric;
    }
    public int getCaloric(){
        return caloric;
    }
    public String getName()
    {
        return name;
    }



}
