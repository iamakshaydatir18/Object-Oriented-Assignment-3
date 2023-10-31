package edu.neu.csye6200;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.BufferedReader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import edu.neu.csye6200.School.Person.Student;

public class School {
	
	List<Student> students;
	List<Person> persons;
	
	static class Person{
		
		String firstName;
		Date birthDate;
		String bloodGroup;
		String email;
		
		public Person(String firstName, Date birthDate, String bloodGroup, String email) {
			super();
			this.firstName = firstName;
			this.birthDate = birthDate;
			this.bloodGroup = bloodGroup;
			this.email = email;
		}
		

		@Override
		public String toString() {
			return "Person [firstName=" + firstName + ", birthDate=" + birthDate + ", bloodGroup=" + bloodGroup
					+ ", email=" + email + "]";
		}


		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public Date getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}

		public String getBloodGroup() {
			return bloodGroup;
		}

		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}





		class Student extends Person{
			
			int Id;
			int age;
			String lastName;
			double gpa;
			
			
			public Student(String firstName, Date birthDate, String bloodGroup, String email, int id, int age,
					String lastName, double gpa) {
				super(firstName, birthDate, bloodGroup, email);
				Id = id;
				this.age = age;
				this.lastName = lastName;
				this.gpa = gpa;
				
			}

			public int getId() {
				return Id;
			}

			public void setId(int id) {
				Id = id;
			}

			public int getAge() {
				return age;
			}

			public void setAge(int age) {
				this.age = age;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

			public double getGpa() {
				return gpa;
			}

			public void setGpa(double gpa) {
				this.gpa = gpa;
			}

			@Override
			public String toString() {
				return "Student [Id=" + Id + ", age=" + age + ", lastName=" + lastName + ", gpa=" + gpa + ", firstName="
						+ firstName + ", birthDate=" + birthDate + ", bloodGroup=" + bloodGroup + ", email=" + email
						+ "]";
			}

		}
	}

	public School() {
		super();
		this.students = new ArrayList<>();
		this.persons = new ArrayList<>();
	}
	
	
	public void addStudents(Student s) {
		
		students.add(s);
		Person p = new Person(s.firstName,s.birthDate,s.bloodGroup,s.email);
		addPersons(p);
		
	}
	
	public void addPersons(Person p) {
		
		persons.add(p);
		
	}
	
	public void creteStudentandPerson() throws Exception {

		try {

			BufferedReader inLine = new BufferedReader(new FileReader("data.csv"));
			String inputLine = null;

			while ((inputLine = inLine.readLine()) != null) {

				String[] row = inputLine.split(",");

				String firstName = row[0];
				String lastName = row[1];
				Date birthDate = new SimpleDateFormat("MM/dd/yy").parse(row[2]);
				String email = row[3];
				String bloodGroup = row[4];
				String id = row[5];
				String age = row[6];
				String gpa = row[7];

				Person person = new Person(bloodGroup, birthDate, bloodGroup, bloodGroup); // object
				Student student = person.new Student(firstName, birthDate, bloodGroup, email, Integer.parseInt(id),
						Integer.parseInt(age), lastName, Double.parseDouble(gpa));
				addStudents(student);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void demo() throws Exception {
		
		
		//Added Person and Student from CSV File.
		creteStudentandPerson();
		
		System.out.println("Five Object for Person and Student Created from CSV File.");
		System.out.println();
		System.out.println("====================================================================================");
		System.out.println("Sorting Students on ID and Persons on FirstName");
		System.out.println();
		students.sort( (o1, o2) -> ((Integer) o1.getId()).compareTo((Integer) o2.getId()));
		persons.sort( (o1, o2) ->  o1.getFirstName().compareTo(o2.getFirstName()));
		for(Student s: students) {
			System.out.println(s.toString());
		}
		System.out.println();
		for(Person p: persons) {
			System.out.println(p.toString());
		}
		System.out.println();
		System.out.println("====================================================================================");
		System.out.println();
		System.out.println("====================================================================================");
		System.out.println("Sorting Students on Age and Persons on Birth Date");
		System.out.println();
		students.sort( (o1, o2) -> ((Integer) o1.getAge()).compareTo((Integer) o2.getAge()));
		persons.sort( (o1, o2) ->  o1.getBirthDate().compareTo(o2.getBirthDate()));
		for(Student s: students) {
			System.out.println(s.toString());
		}
		System.out.println();
		for(Person p: persons) {
			System.out.println(p.toString());
		}
		System.out.println();
		System.out.println("====================================================================================");
		System.out.println();
		System.out.println("====================================================================================");
		System.out.println("Sorting Students on Last Name and Persons on Blood Group");
		System.out.println();
		students.sort( (o1, o2) -> ( o1.getLastName()).compareTo(o2.getLastName()));
		persons.sort( (o1, o2) ->  o1.getBloodGroup().compareTo(o2.getBloodGroup()));
		for(Student s: students) {
			System.out.println(s.toString());
		}
		System.out.println();
		for(Person p: persons) {
			System.out.println(p.toString());
		}
		System.out.println();
		System.out.println("====================================================================================");
		System.out.println();
		System.out.println("====================================================================================");
		System.out.println("Sorting Students on GPA and Persons on Email");
		System.out.println();
		students.sort( (o1, o2) -> ((Double) o1.getGpa()).compareTo((Double) o2.getGpa()));
		persons.sort( (o1, o2) ->  o1.getEmail().compareTo(o2.getEmail()));
		for(Student s: students) {
			System.out.println(s.toString());
		}
		System.out.println();
		for(Person p: persons) {
			System.out.println(p.toString());
		}
		System.out.println();
		System.out.println("====================================================================================");
		
	}
	
	
	
}
