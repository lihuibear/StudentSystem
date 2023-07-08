public class Student {
    String name;
    int javascore;
    int pythonscore;

    public Student (){

    }

    public Student(String name, int javascore, int pythonscore) {
        this.name = name;
        this.javascore = javascore;
        this.pythonscore = pythonscore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJavascore() {
        return javascore;
    }

    public void setJavascore(int javascore) {
        this.javascore = javascore;
    }

    public int getPythonscore() {
        return pythonscore;
    }

    public void setPythonscore(int pythonscore) {
        this.pythonscore = pythonscore;
    }
}
