all: User.java Student.java Teacher.java Admin.java Menu.java Course.java Enrollment.java FileHandler.java Main.java 
	javac User.java
	javac Student.java
	javac Teacher.java
	javac Admin.java
	javac Menu.java
	javac Course.java
	javac Enrollment.java
	javac FileHandler.java
	javac Main.java


run: all
	java Main

clean:
	rm -f *.class
