import java.util.StringJoiner;

public class ConditionalAssignment {

    public static void main(String[] args) {
        int v1 = 7;
        int v2 = 5;
        int result = v1 > v2 ? v1 : v2;
        System.out.println(result);

        float students = 75;
        float rooms = 14;
        float StudentsPerRoom = (students == 0.0f ? 0.0f : students / rooms);
        System.out.println(StudentsPerRoom);
    }
}
