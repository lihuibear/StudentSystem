import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();

        login();

        menu(array);


    }

    public static void login() {
//login界面
        String my_password = "admin";

        Scanner sc = new Scanner(System.in);

        System.out.println("===============");
        System.out.println("输入登录系统密码");
        System.out.println("===============");

        String password = sc.nextLine();

        while (!password.equals(my_password)) {
            System.out.println("密码错误请重试");
            password = sc.nextLine();
        }
    }

    public static void menu(ArrayList<Student> array) {
        //menu界面
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===============");
            System.out.println("1. 查看成绩");
            System.out.println("2. 添加信息");
            System.out.println("3. 删除信息");
            System.out.println("0. 退出程序");
            System.out.println("===============");

            String num = sc.nextLine();

            switch (num) {
                case "1":
                    find(array);
                    break;
                case "2":
                    addStudent(array);
                    break;
                case "3":
                    deleteStudet(array);
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("你的输入有误,请重新输入");
            }
        }
    }

    public static void find(ArrayList<Student> array) {

        int j = array.size();
        System.out.println("共有" + j + "名同学");

        System.out.println("姓名\t\tjava\tpython\t总分");

        array.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num1 = s1.getJavascore() + s1.getPythonscore();
                int num2 = s2.getJavascore() + s2.getPythonscore();
//                return num1 - num2;升序
                return num2 - num1;//降序
            }
        });

        for (Student s : array) {
            int sum = s.getJavascore() + s.getPythonscore();
            System.out.println(s.getName() + "\t" + s.getJavascore() + "\t\t" + s.getPythonscore() + "\t\t" + sum);
        }
    }

    public static void addStudent(ArrayList<Student> array) {


        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        System.out.println("请输入学生姓名");

        String name = sc.nextLine();
        if (namesame(array, name)) {

            System.out.println("输入java成绩");
            int javascore = 0;
            try {
                javascore = sc.nextInt();
                if (javascore < 0 || javascore > 100) {
                    System.out.println("分数错误");
                    menu(array);
                }
            } catch (NoSuchElementException e1) {
                System.out.println("输入错误");
                menu(array);
            }


            System.out.println("输入python成绩");
            int pythonscore = 0;
            try {
                pythonscore = sc.nextInt();
                if(pythonscore<0||javascore>100){
                    System.out.println("分数错误");
                    menu(array);
                }
            } catch (NoSuchElementException e2) {
                System.out.println("输入错误");
                menu(array);
            }


            s.setJavascore(javascore);
            s.setPythonscore(pythonscore);
            s.setName(name);
            array.add(s);

            System.out.println("添加成功！");
        } else {
            System.out.println("已有该同学");
        }

    }

    public static void deleteStudet(ArrayList<Student> array) {

        System.out.println("请输入要删除学生的姓名");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        boolean a = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getName().equals(name)) {
                array.remove(i);

                System.out.println("删除成功！");
                a = true;
                break;
            }
        }
        if (a == false) {
            System.out.println("未找到名为" + name + "的信息");
        }

    }

    public static boolean namesame(ArrayList<Student> array, String name) {
        for (Student s : array) {
            if (s.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

}
