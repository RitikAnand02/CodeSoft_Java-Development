import java.util.Scanner;

public class StudentGradeCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Math Marks: ");
		int math = sc.nextInt();
		System.out.print("Enter Biology Marks: ");
		int bio = sc.nextInt();
		System.out.print("Enter Chemistry Marks: ");
		int che = sc.nextInt();
		System.out.print("Enter Physics Marks: ");
		int phy = sc.nextInt();
		System.out.print("Enter English Marks: ");
		int eng = sc.nextInt();

		int total_Marks = (math + bio + che + phy + eng);
		System.out.println("Total Marks = " + total_Marks);
		double average = (math + bio + che + phy + eng) / 5;
		System.out.println("Average = " + average);

		if (average >= 90) {
			System.out.println("Pass");
			System.out.println("Grade : A");
		} else if (average >= 80 && average < 90) {
			System.out.println("Pass");
			System.out.println("Grade : B");
		} else if (average >= 70 && average < 80) {
			System.out.println("Pass");
			System.out.println("Grade : C");
		} else if (average >= 60 && average < 70) {
			System.out.println("Pass");
			System.out.println("Grade : D");
		} else if (average >= 40 && average < 60) {
			System.out.println("Pass");
			System.out.println("Grade : E");
		} else {
			System.out.println("Fail");
			System.out.println("Grade : F");
		}

		sc.close();

	}

}
