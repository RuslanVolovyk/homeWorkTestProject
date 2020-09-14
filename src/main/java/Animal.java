public interface Animal {

    void height();

    void weight();

    void movement();

    void eating();

}

class Dog implements Animal {
    private int height;
    private int weight;
    private String movement = "no";
    private String eating = "no";


    public Dog(int height, int weight, String movement, String eating) {
        this.height = height;
        this.weight = weight;
        this.movement = movement;
        this.eating = eating;

    }

    public void height(int centimetre) {
        this.height = centimetre;
    }

    public void height(String measurementUnit, int inch) {
        if (measurementUnit == "inch")
            this.height = (int) (inch * 2.52);
        else
            System.out.println("Only inches are acceptable");
    }

    public void weight(int grams) {
        this.weight = grams;
    }

    public void weight(String measurementUnit, int oz) {
        if (measurementUnit == "oz")
            this.weight = (int) (oz * 28.3495);
        else
            System.out.println("Only oz is acceptable");
    }

    public void movement(String status) {
        if (status == "moving")
            this.movement = "moving";
        else
            System.out.println("Only moving or no status is available");
    }

    @Override
    public void height() {
        System.out.println("Dog " + movement);
    }

    @Override
    public void weight() {
        System.out.println("Dog " + movement);
    }

    @Override
    public void movement() {
        System.out.println("Dog " + movement);

    }

    @Override
    public void eating() {
        System.out.println("Dog " + eating);
    }
}