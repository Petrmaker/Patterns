package Patterns.Composite;

import java.util.ArrayList;

public class Composite{
    public static void main(String[] args){
        Teachers teachers = new Teachers();

        School math = new Math();
        School history = new History();
        School language = new Language();

        teachers.addSchool(math);
        teachers.addSchool(history);
        teachers.addSchool(language);
        teachers.createTeach();
    }
}
interface School{
    void teach();
}
class Math implements School{
    public void teach(){
        System.out.println("Уроки математики");
    }
}
class History implements School {
    public void teach() {
        System.out.println("Уроки истории");
    }
}

    class Language implements School {
        public void teach() {
            System.out.println("Уроки языка");
        }
    }
        class Teachers{
            private ArrayList<School> lessons = new ArrayList<School>();
            public void addSchool(School lesson){
                lessons.add(lesson);
            }
            public void cancelSchool(School lesson){
                lessons.remove(lesson);
            }
            public void createTeach() {
                for (School school : lessons) {
                    school.teach();
                }
            }
        }
