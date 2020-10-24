# JAVA-experiment3
JAVA第三次实验
# 计191 王博涛 2019310193
# 实验目的
初步了解分析系统需求，从学生选课角度了解系统中的实体及其关系，学会定义类中的属性以及方法；  
掌握面向对象的类设计方法（属性、方法）；  
掌握类的继承用法，通过构造方法实例化对象；  
学会使用super()，用于实例化子类；  
掌握使用Object根类的toString（）方法,应用在相关对象的信息输出中。  
# 业务要求
说明：学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择“课程”。从简化系统考虑，每名教师仅教授一门课程，每门课程的授课教师也仅有一位，每名学生选仅选一门课程。 
我的实验实例为  
`人员（编号，名称，性别）  
教师（编号，名称，性别，所授课程）  
学生（编号，名称，性别，所选课程）  
课程（编号，名称，地点，时间，教师名称）`
# 实验要求
1.编写上述实体类以及测试主类（注意类之间继承关系的适用）  
2.在测试主类中，实例化多个类实体，模拟学生选课操作、打印课程信息；模拟学生退课操作，再打印课程信息。  
# 实验过程
## （1）编写父子类：
首先我选择先编写程序所需的各个类，如上文实验实例的4个类。`Personnel` `Teacher` `Student` `Course`我还另创建了1个类为`Test`为主类。
以Personnel类举例，在类中需要定义出编号，名称和性别为String类型。
然后是构造方法，`public Personnel(String num, String name, String gender)`在其中有三个this.方法用来给这三个参数赋值。
其他类也是如此，我将Personnel作为父类，Teacher和Student作为子类，用super()实例化，再用public String toString()的方法作为输出时的格式输出方法。
## （2）编写主类：
先在主类中给其他类赋值，例`Course course1 = new Course("1", "高等数学", "教102", "9:40", teachcourse1);`以及`Teacher teachcourse1 = new Teacher("01", "赵老师", "男", "高等数学");`在类中创建新的实例并赋值。  
随后是用户输入部分，首先要在主类开头加上`import java.util.Scanner;`调用这个库，然后是`Scanner input = new Scanner(System.in);`以及`int n = input.nextInt();`一个是输入的方法，一个是用来存储用户输入的值。  
最重要的是，要对course进行初始化  
```
Course course = null;
```
* 判断用户输入并进入选课阶段：
>首先是让用户输入选课，退课，还是推出，分别对应键盘数字1，2，3；实现这部分要使用上文的检测输入方法。if语句中还应有另一个判断用户输入，即为判断用户选择课程编号，以及switch()语句进行选择对course赋值
>>实现代码：
```
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
```
>course1至course3分别是数学英语和物理，c为一个我自己设置的标记，意思为已经选择了1，2或3号课程，用于之后的退课，方便记录已经选了几号课程，简单易懂。
>随后是提醒用户是否确定选课，1为确定2为取消，判断用户输入方法和上述相同。
* 判断用户输入并进入退课阶段：
>基本方法和上述选课阶段相同，此外，我另设置了一个变量为c1并初始化为0,当用户选择对应的编号时，c1将会被赋值成为1.且这次switch语句写在了`while(c1==0)`循环之中，当c1为1，即已经决定进行退课，然后判断c1是否为1进行退课，将course中的值重新赋值为null。将上文提到的变量`c`赋值为0，意思为没有进行过选课，这样就等于没有进行过选课了。如果输入错误和退课成功，都会提醒用户，是否继续还是推出。代码会写在核心代码处。
* 添加循环：
>在之前提到的所有主类代码，写入一个while循环，并设置一个新的变量flag，初始化为1。`while (flag == 1) {`开始循环，当用户在一开始执行程序时，如果选择3（即为退出程序），flag则会赋值为0，则不会进行下一次循环，直接退出。

# 流程图
<WPS篇幅限制原因，未能全部详细画出，大体流程如下
![流程图](https://github.com/plachta2/JAVA-experiment3/raw/main/流程图.png)

# 核心代码
本次实验的核心代码为：
```
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
        ...省略
        ...省略
					 default:
						 System.out.println("输入的课程编号不存在");
					 }

```
>此为退课程序的所有代码,截取了部分。我认为核心为c1这个变量的把控，对c1进行判断从而执行不同的方法。
>以及用户确定退课后的代码：
```
if(k==1) {
							course = null;
							Student me2 = new Student("2019310193", "王博涛", "男", course);
							System.out.println("退课成功" +"  "+me2+"\n"+"退课结束");
							c = 0;
						}
```
>同样，核心为c这个变量，关乎下次执行最外层循环时课程的变化。

# 实验结果
>结果如下图：
![实验结果截图](https://github.com/plachta2/JAVA-experiment3/raw/main/实验3截图.png)

# 实验感想
>此次实验我使用了较多次根据单个核心变量判断程序执行程度的方法，c,c1,flag。我觉得很好用。此外是面向对象的设计方法，我认为已经初步掌握了如何使用，以及父子类的继承用法，通过构造对象进行实例化，也会使用super()进行实例化子类了。
>Object根类的toString（）方法确实好用，可以定义一个格式进行输出。
