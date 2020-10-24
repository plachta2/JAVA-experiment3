package 实验2;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		int flag = 1;
		int c = 0;
		Course course = null;
		while (flag == 1) {
			Teacher teachcourse1 = new Teacher("01", "赵老师", "男", "高等数学");
			Teacher teachcourse2 = new Teacher("02", "王老师", "女", "大学英语读写译");
			Teacher teachcourse3 = new Teacher("03", "孙老师", "男", "大学物理");
			Course course1 = new Course("1", "高等数学", "教102", "9:40", teachcourse1);
			Course course2 = new Course("2", "大学英语读写译", "教103", "7:50", teachcourse2);
			Course course3 = new Course("3", "大学物理", "教104", "13:30", teachcourse3);
			System.out.println("选课输入1， 退课输入2，退出输入3");
			Scanner input = new Scanner(System.in);
			int n = input.nextInt();
			if(n==1) {
				System.out.println("请输入要查询的课程编号:");
				Scanner input1 = new Scanner(System.in);
				int i = input1.nextInt();
				switch(i) {
				 case 1:
					 course = course1;
					 c = 1;
					 break;
				 case 2:
					 course = course2;
					 c = 2;
					 break;
				 case 3:
					 course = course3;
					 c = 3;
					 break;
				 default:
					 System.out.println("输入的课程编号不存在");
				 }
				Student me = new Student("2019310193", "王博涛", "男", course);
				System.out.println(me);
				System.out.println("是否选课?是：1  否：2");
				Scanner input2 = new Scanner(System.in);
				int k = input2.nextInt();
				if(k==1) {
					Student me2 = new Student("2019310193", "王博涛", "男", course);
					System.out.println("选课成功" +"  "+me2+"\n"+"选课结束");
				}
				else {
					System.out.println("选课结束");
					course = null;
				}
			}
			
			else if(n==2) {
				int c1 = 0;
				while(c1==0) {
					System.out.println("请输入要退课的课程编号:");
					Scanner input3 = new Scanner(System.in);
					int i = input3.nextInt();
					switch(i) {
					 case 1:
						 if(c == 1) {
							 c1 = 1;
						 }
						 else {
							 System.out.println("你未选择该课程！"); 
						 }
						 break;
					 case 2:
						 if(c == 2) {
							 c1 = 1;
						 }
						 else {
							 System.out.println("你未选择该课程！"); 
						 }
						 break;
					 case 3:
						 if(c == 3) {
							 c1 = 1;
						 }
						 else {
							 System.out.println("你未选择该课程！"); 
						 }
						 break;
					 default:
						 System.out.println("输入的课程编号不存在");
					 }
					if(c1==1) {
						Student me = new Student("2019310193", "王博涛", "男", course);
						System.out.println(me);
						System.out.println("是否退课?是：1  否：2");
						Scanner input5 = new Scanner(System.in);
						int k = input5.nextInt();
						if(k==1) {
							course = null;
							Student me2 = new Student("2019310193", "王博涛", "男", course);
							System.out.println("退课成功" +"  "+me2+"\n"+"退课结束");
							c = 0;
						}
						else {
							System.out.println("退课结束");
						}
					}
					else {
						System.out.println("是否继续退课？请输入2退出");
						Scanner input4 = new Scanner(System.in);
						int k1 = input4.nextInt();
						if(k1==2) {
							break;
						}
					}
				}
			}
			else if(n==3) {
				flag = 0;
                System.out.println("退出");
                break;
			}	
		}
	}
}
