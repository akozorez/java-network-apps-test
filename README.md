# java-network-apps-test
#### Java Test for Network Application Course
#### Вопрос 0.
##### Student.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<student>
    <fi>Козорез Александр</fi>
    <groupId>381708-1</groupId>
    <number>16380700</number>
</student>
```
#### Вопрос 1.
##### В какой относительной директории должны располагаться исходные коды приложения на Java при использовании Maven?
```text
/src/main/java - исходные коды приложения
```
#### Вопрос 2.
##### Приведите реализацию класса timer. Класс должен содержать целочисленный счетчик. И методы "запустить счетчик" и "получить значение счетчика". Инкрементация счетчика должна выполняться асинхронно 
```java
class Timer extends Thread
{
    private int seconds;

    Timer(int seconds){
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public void run()
    {
        do {
            try {
                if(this.seconds > 0) {
                    this.seconds--;
                    Thread.sleep(1000);
                }else{
                    System.out.println("Timer has been finished!");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(true);
    }
}
```
[Полный код для этого вопроса тут](https://github.com/akozorez/java-network-apps-test/src/main/java/question2)
#### Вопрос 3.
##### Как приостановить выполнение потока с возможностью продолжить исполнение по команде пользователя? 
```text
synchronized(sync):
sync.wait(), sync.notify() - актуальные методы.
Thread:
suspend(), resume() - устаревшие методы.
```
#### Вопрос 4.
##### Приведите код визуального приложения на Swing по кнопке выводящего на экран "Привет мир!" 
```java
public class HelloWorldSwing extends JFrame {

    private JTextField textField;

    public HelloWorldSwing() {
        super("Hello world!");
        createGUI();
    }

    public void createGUI() {/**/}

    public class sayHello implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textField.setText(e.getActionCommand());
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                HelloWorldSwing frame = new HelloWorldSwing();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
```
[Полный код для этого вопроса тут](https://github.com/akozorez/java-network-apps-test/src/main/java/question4/HelloWorldSwing.java)

#### Вопрос 5.
##### Приведите код создания сервера, ожидающего единственное подключение клиента на Java  
```java
int port = 3000;
ServerSocket ss = new ServerSocket(port);
System.out.println("Listen on ::*"+port);

Socket client = ss.accept();
System.out.println("Client connected");
BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
PrintWriter out = new PrintWriter(client.getOutputStream());

String clientMsg = in.readLine();
System.out.println("Client: "+clientMsg);

if(clientMsg.equals("Hello server, I`m user!")){
    out.println("We got your message bruda! Its ok!");
    out.flush();
    client.close();
}
```
[Полный код для этого вопроса тут](https://github.com/akozorez/java-network-apps-test/src/main/java/clientserver)
#### Вопрос 6.
##### Приведите код подключения клиента к серверу и получение одной строки на Java  
```java
Socket clientSocket = new Socket("127.0.0.1", 3000);

PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
out.println("Hello server, I`m user!");
out.flush();

BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
String result = in.readLine();
System.out.println("server: "+ result);
if(result.equals("We got your message bruda! Its ok!")){
    clientSocket.close();
}
```
[Полный код для этого вопроса тут](https://github.com/akozorez/java-network-apps-test/src/main/java/clientserver)
#### Вопрос 7.
##### Приведите код перевода объекта в формат JSon и получения объекта из JSon  
```java
ArrayList<Student> objectStudents = new ArrayList<Student>();
for (int i = 1; i < 10; i++){
    String name = "student"+i;
    Student stud = new Student(i, name);
    objectStudents.add(stud);
}
JSONArray students_1 = new JSONArray(objectStudents);
printStudents(students_1);

String stringifiedJSON = "{\"students\":[{\"id\": 1, \"name\": \"student1\"}, {\"id\": 2, \"name\": \"student2\"}, {\"id\": 3, \"name\": \"student3\"}]}";
JSONObject obj = new JSONObject(stringifiedJSON);
JSONArray students_2 = obj.getJSONArray("students");
printStudents(students_2);
```
[Полный код для этого вопроса тут](https://github.com/akozorez/java-network-apps-test/src/main/java/question7/JSONExample.java)
#### Вопрос 8.
##### Приведите код получения подключения к базе данных с использованием JDBC
```java
private Connection connection = null;
private void initConnection(UserConfig user, DatabaseConfig db_cfg) throws ClassNotFoundException, SQLException {
    if(connection == null){
        Class.forName(db_cfg.getDriver());
        connection = DriverManager.getConnection(db_cfg.getUrl(), user.getUser(), user.getPass());
    }
}
```  
[Полный код для этого вопроса тут](https://github.com/akozorez/java-network-apps-test/src/main/java/question8/JDBC.java)
###### Дополнительные вопросы (необязательно)
#### Вопрос 9.
##### О каких технологиях Java Вы бы хотели дополнительно услышать в курсе?
```text
Java в Web, Полезные фичи/шорткаты IDE для уменьшения boilerplate кода.
```
#### Вопрос 10.
##### Дополнительные пожелания к курсу
```text
Дополнительных пожеланий нет.
```


