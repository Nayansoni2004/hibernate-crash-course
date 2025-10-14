# Hibernate Crash Course — Learning Project  

A simple and beginner-friendly **Java backend project** built while learning **Hibernate (ORM Framework)** and **Maven (Dependency Management Tool)**.  
This project helped me understand how real-world Java applications manage dependencies automatically and connect to relational databases efficiently.

---

## 📘 About the Project  

This project demonstrates how **Hibernate** simplifies database interactions in Java through **Object Relational Mapping (ORM)**.  
Using **Maven**, all dependencies were automatically managed through the `pom.xml` file, eliminating manual .jar handling used earlier in servlet-based projects.

---

## 🧩 Key Concepts Learned  

- 🔹 **Maven** – handled dependency management and build automation  
- 🔹 **Hibernate ORM** – simplified connection between Java classes and MySQL tables  
- 🔹 **SessionFactory**, **Session**, **Transaction** – learned to manage object persistence lifecycle  
- 🔹 **CRUD Operations** – performed Create, Read, Update, Delete using Hibernate APIs  
- 🔹 Understood the **`pom.xml`** and **`hibernate.cfg.xml`** configuration files — the heart of Maven and Hibernate  
- 🔹 Explored how Hibernate maps Java objects to database tables seamlessly  

---

## ⚙️ Technologies Used  

| Component | Technology |
|------------|-------------|
| Language | Java (JDK 17 or above) |
| Framework | Hibernate ORM |
| Build Tool | Maven |
| Database | MySQL (Workbench + Command Line) |
| IDE | Eclipse IDE |
| Server | Apache Tomcat (optional for servlet-based integration) |

---

## 🗄️ Database Setup  

If you want to use the same database that this project connects with:

1. Create a new MySQL database:
   ```sql
   CREATE DATABASE hibernate_crash_course;
2. Import the backup file:
   mysql -u root -p hibernate_crash_course < database/hibernate_crash_course_db_backup.sql
3. Update your hibernate.cfg.xml with your MySQL username & password.

---

##  ▶️ How to Run

1.  Clone this repository:    git clone https://github.com/Nayansoni2004/hibernate-crash-course.git
2.  Open in Eclipse IDE
3.  Right-click on project → Run As → Java Application
4.  Observe Hibernate logs & SQL execution results in console

