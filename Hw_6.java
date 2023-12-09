import java.util.HashMap;

public class Hw_6 {
    public static void main(final String[] args) {
        HashMap<String, String> contact = new HashMap<>();
        contact.put("88001122333", "Василий Иванов");
        contact.put("88001662333", "Павел Калугин");
        contact.put("88001112333", "Павел Калугин");
        contact.put("88001112453", "Олег Остапов");
        contact.put("88001632145", "Олег Остапов");
        contact.put("88001424214", "Сергей Маслов");
        contact.put("88001424215", "Сергей Маслов");
        contact.put("88001424216", "Сергей Маслов");
        contact.put("88001234374", "Михаил Набоков");
        contact.put("88001127344", "Игорь Иванов");
        contact.put("88001127333", "Игорь Иванов");
        contact.put("88001129313", "Иван Петров");
        contact.put("88001127323", "Павел Калугин");
        contact.put("88001129353", "Игорь Иванов");
        contact.put("88009129353", "Игорь Иванов");

        HashMap<String, Integer> a = get(contact);
        a.entrySet().stream()
                .sorted((v1, v2) -> -v1.getValue().compareTo(v2.getValue()))
                .forEach(v -> System.out.println("кол-во номеров: "
                        + v.getValue() + ", фио: " + v.getKey()));
    }

    public static HashMap<String, Integer> get(HashMap<String, String> contact) {
        HashMap<String, Integer> result = new HashMap<>();
        for (var item : contact.entrySet()) {
            if (result.containsKey(item.getValue())) {
                var key = item.getValue();
                var value = result.get(item.getValue());
                result.replace(key, value + 1);
            } else {
                result.put(item.getValue(), 1);
            }
        }
        return result;
    }

}

// Вывод:
// кол-во номеров: 4, фио: Игорь Иванов
// кол-во номеров: 3, фио: Павел Калугин
// кол-во номеров: 3, фио: Сергей Маслов
// кол-во номеров: 2, фио: Олег Остапов
// кол-во номеров: 1, фио: Василий Иванов
// кол-во номеров: 1, фио: Иван Петров
// кол-во номеров: 1, фио: Михаил Набоков