import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
//        разделенные пробелом:
//        Фамилия Имя Отчество датарождения номертелефона пол
//
//        Форматы данных:
//        фамилия, имя, отчество - строки
//        датарождения - строка формата dd.mm.yyyy
//        номертелефона - целое беззнаковое число без форматирования
//        пол - символ латиницей f или m.
//
//        Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
//        вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных,
//        чем требуется.
//
//        Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
//        Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
//        Можно использовать встроенные типы java и создать свои.
//        Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
//
//<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//
//Не забудьте закрыть соединение с файлом.
//
//При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
//
//Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет"
//
//"Зачет" ставится, если слушатель успешно выполнил
//"Незачет"" ставится, если слушатель успешно выполнил
//
//Критерии оценивания:
//Слушатель напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробело
public class Main {
    public static void main(String[] args) {
        Main program = new Main();
        program.run();

    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        String value = null;
        StringChecker stringChecker = new StringChecker();
        System.out.printf("Введите Фамилию Имя Отчество, пол(f/m), дату рождения (dd.mm.yyyy), телефон из %d цифр через пробел: \n", stringChecker.getPhoneNumberLength());
        value = scanner.nextLine();
        try {
            stringChecker.checkString(value);
        } catch (StringLengthException e) {
            System.out.println(e.getMessage());;
        }
        User user = stringChecker.chekingUser();
        StringBuilder stringBuilder = new StringBuilder();
        if (user != null){
            stringBuilder.append("<" + user.getSurname() +">");
            stringBuilder.append("<" + user.getName() +">");
            stringBuilder.append("<" + user.getPatronymic() +">");
            stringBuilder.append("<" + user.getDateOfBirth() +">");
            stringBuilder.append("<" + user.getPhoneNumber() +">");
            stringBuilder.append("<" + user.getSex() +">");
            FileReaderWriter fileReaderWriter = new FileReaderWriter();
            fileReaderWriter.writeFile(user.getSurname(), stringBuilder);
        }
    }
}