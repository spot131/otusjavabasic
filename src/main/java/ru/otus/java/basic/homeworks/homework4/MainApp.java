package ru.otus.java.basic.homeworks.homework4;


import java.util.Random;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;


public class MainApp {
    public static void main(String[] args) {
        // Чтобы повысить вариатвность, решил фио и д.р. генерить случайно из вариантов
        String[] lastNames = {"Смирнов",
                "Иванов",
                "Кузнецов",
                "Соколов",
                "Попов",
                "Лебедев",
                "Козлов",
                "Новиков",
                "Морозов",
                "Петров"};
        String[] names = {"Александр",
                "Михаил",
                "Максим",
                "Лев",
                "Марк",
                "Артём",
                "Матвей",
                "Иван",
                "Дмитрий",
                "Тимофей"};
        String[] secondNames = {"Александрович",
                "Михаилович",
                "Максимович",
                "Львович",
                "Маркович",
                "Артёмович",
                "Матвеевич",
                "Иванович",
                "Дмитриевич",
                "Тимофеевич"};

        //имена почтовых ящиков - названия дистрибутивов ubuntu =)
        String[] emails = {"Warty.Warthog@gmail.com",
                "Hoary.Hedgehog@gmail.com",
                "Breezy.Badger@gmail.com",
                "Gutsy.Gibbon@gmail.com",
                "Intrepid.Ibex@gmail.com",
                "Maverick.Meerkat@gmail.com",
                "Precise.Pangolin@gmail.com",
                "Saucy.Salamander@gmail.com",
                "Utopic.Unicorn@gmail.com",
                "Zesty.Zapus@gmail.com",
        };

        User[] Users = new User[10];
        for (int i = 0; i < Users.length; i++) {
            Users[i] = new User(
                    lastNames[new Random().nextInt(lastNames.length)],
                    names[new Random().nextInt(names.length)],
                    secondNames[new Random().nextInt(secondNames.length)],
                    new Random().nextInt(70) + 1930,                   //пусть у нас будут рожденные с 1930 по 2000 гг.
                    emails[new Random().nextInt(emails.length)]
            );
        }

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int currentYear = localDate.getYear();

        for (User user : Users) {
            if ((currentYear - user.birthday) > 40) {
                System.out.println("ФИО: " + user.lastName + " " + user.name + " " + user.secondName);
                System.out.println("Год рождения: " + user.birthday);
                System.out.println("email: " + user.email);
            }
        }


        // *********** теперь с коробкой *********************

        Box theGreatBox = new Box(10,10,10,"black");
        theGreatBox.getInfo();

    }
}