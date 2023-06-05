//Adam Di Cioccio
//Lab Exercise 07
//CST8116-321

public class GradingSystem {
	private String courseName;
	private String letterGrade;

	public GradingSystem() {
		
	}

	public GradingSystem(String courseName, String letterGrade) {
		setCourseName(courseName);
		setLetterGrade(letterGrade);
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public String createReport() {
		String report = null;

		 if (letterGrade.equals("A")) {
	         //do A stuff
			 report = "Course: " + courseName + " | Grade: " + letterGrade + ", Percent 80 - 100, Number grade: 4.0";
	     } else if (letterGrade.equals("B")) {
	         //do B stuff
	    	 report = "Course: " + courseName + " | Grade: " + letterGrade + ", Percent 70 - 79, Number grade: 3.0";
	     } else if (letterGrade.equals("C")) {
	         //do C stuff
	    	 report = "Course: " + courseName + " | Grade: " + letterGrade + ", Percent 60 - 69, Number grade: 2.0";
	     } else if (letterGrade.equals("D")) {
	         //do D stuff
	    	 report = "Course: " + courseName + " | Grade: " + letterGrade + ", Percent 50 - 59, Number grade: 1.0";
	     } else if (letterGrade.equals("F")) {
	         //do E stuff
	    	 report = "Course: " + courseName + " | Grade: " + letterGrade + ", Percent 0 - 49, Number grade: 0.0";
	     }

		//return result
		return report;
	}

}