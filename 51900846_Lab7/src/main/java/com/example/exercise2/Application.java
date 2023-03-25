package com.example.exercise2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentRepositoryClone studentRepositoryClone;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student(null, "Sam ", 20, "sam@gmail.com", 7.0);
        Student student2 = new Student(null, "Justin", 28, "justin@gmail.com", 8.0);
        Student student3 = new Student(null, "Taylor", 30, "taylor@gmail.com", 9.0);
        Student student4 = new Student(null, "Micheal", 25, "sam@gmail.com", 7.0);
        Student student5 = new Student(null, "Harry", 31, "justin@gmail.com", 8.0);
        Student student6 = new Student(null, "Kevin", 40, "justin@gmail.com" , 6.0);
        Student student7 = new Student(null, "T van", 23, "sam@gmail.com", 7.0);
        Student student8 = new Student(null, "Bob", 27, "justin@gmail.com", 8.0);
        Student student9 = new Student(null, "Ben", 37, "taylor@gmail.com", 8.0);
        Student student10 = new Student(null, "Dustin", 24, "sam@gmail.com", 7.0);
        Student student11 = new Student(null, "Scoot", 27, "justin@gmail.com", 5.0);
        Student student12 = new Student(null, "Thomas", 31, "taylor@gmail.com", 9.0);
        //Add
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        studentRepository.save(student7);
        studentRepository.save(student8);
        studentRepository.save(student9);
        studentRepository.save(student10);
        studentRepository.save(student11);
        studentRepository.save(student12);
        //Read
        Iterable<Student> students = studentRepository.findAll();
        System.out.println("Student in database: ");
        for(Student student : students){
            System.out.println(student.toString());
        }
        //Update
        Student stu_update = studentRepository.findById(1L).orElse(null);
        if(stu_update != null){
            stu_update.setName("Tran Duc Van");
            stu_update.setIeltsScore(9.0);
            studentRepository.save(stu_update);
            System.out.println("Student update: "+stu_update.toString());
        }

        //Delete
        Student stu_delete = studentRepository.findById(2L).orElse(null);
        if (stu_delete != null) {
            studentRepository.delete(stu_delete);
            System.out.println("Deleted student: " + stu_delete.toString());
        }

        //Exercise 4
        System.out.println("Exercise 4:");
        List<Student> age_4 = studentRepository.findByAgeGreaterThan(25);
        System.out.println("Students have age > 25:");
        age_4.forEach(System.out::println);

        int count_4 = studentRepository.countByieltsScore(9.0);
        System.out.println("Students have Ielts Score = 9.0: " + count_4);

        List<Student> contain_4 = studentRepository.findByNameContaining("van");
        System.out.println("Students name containing 'van': ");
        contain_4.forEach(System.out::println);

        //Exercise 5
        System.out.println("Exercise 5:");
        List<Student> age_5 = studentRepository.findStudentByAge(25);
        System.out.println("Students have age >= 30:");
        age_5.forEach(System.out::println);

        int count_5 = studentRepository.countStudent9IelesScore(9.0);
        System.out.println("Students have Ielts Score = 9.0: " + count_5);

        List<Student> contain_5 = studentRepository.nameStudentContaining("van");
        System.out.println("Students name containing 'van': ");
        contain_5.forEach(System.out::println);

        //Exercise 6
        System.out.println("Exercise 6: ");
        Page<Student> studentPage = studentRepositoryClone.findAllByOrderByAgeDescIeltsScore(PageRequest.of(0,10));
        studentPage.getContent().forEach(System.out::println);

        if(studentPage.getTotalElements() > 10){
            Page<Student> students456 = studentRepositoryClone.findAllByOrderByAgeDescIeltsScore(PageRequest.of(1,3));
            students456.getContent().forEach(System.out::println);
        }

    }
}
