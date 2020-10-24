package 实验2;

public class Student extends Personnel{
	Course information;
	public Student(String num, String name, String gender, Course information){
		super(num, name, gender);
		this.information = information;
	}
	public String toString() {
		return "编号："+num+"  姓名："+name+"  性别："+gender+"\n"+"  所选课程："+information;
	}
}

