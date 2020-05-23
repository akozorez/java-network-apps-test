package question7;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class JSONExample {
    static class Student {
        public int id;
        public String name;
        Student(int id, String name){
            this.id = id;
            this.name = name;
        }
    }
    public static void printStudents(JSONArray students) throws JSONException{
        System.out.println(students.toString());
    }
    public static void main(String[] args) throws JSONException {
        ArrayList<Student> objectStudents = new ArrayList<Student>();
        for (int i = 1; i < 10; i++){
            String name = "student"+i;
            Student stud = new Student(i, name);
            objectStudents.add(stud);
        }
        JSONArray students_1 = new JSONArray(objectStudents);
        printStudents(students_1);

        String stringifiedJSON = "{\"students\":[{\"id\": 1, \"name\": \"student1\"}, {\"id\": 2, \"name\": \"student2\"}, {\"id\": 3, \"name\": \"student3\"}]}";
        JSONObject obj = new JSONObject(stringifiedJSON);
        JSONArray students_2 = obj.getJSONArray("students");
        printStudents(students_2);
    }
}
