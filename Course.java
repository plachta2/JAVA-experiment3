package 实验2;

public class Course {
	String name;
	String num;
	String place;
	String time;
	Teacher teachername;
	public Course(String num, String name, String place, String time, Teacher teachername) {
		this.num = num;
		this.name = name;
		this.place = place;
		this.time = time;
		this.teachername = teachername;
	}
	public String toString() {
		return "\n"+"编号："+num+"  课程名称："+name+"  上课地点："+place+"  时间："+time+ "\n"+"  授课教师："+teachername;
	}
}
