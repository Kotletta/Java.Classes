import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created be Kotletta on 10.11.2020.
 */

public class Task {
    public static void main(String[] args) {
        Shop kotlettashop = new Shop ("Kotlettashop");
        kotlettashop.addClientToShopList (new Client ("Илья", "Сперанский", "Владимирович", "Терешкова", 12_58_00_00, 12345));
        kotlettashop.addClientToShopList (new Client ("Валерий", "Сперанский", "Владимирович", "Терешкова", 21_22_33_44, 75864));
        kotlettashop.addClientToShopList (new Client ("Василий", "Пупкин", "Ильич", "Россия", 32_21_43_53, 60456));
        kotlettashop.addClientToShopList (new Client ("Антон", "Прозоров", "Игорьевич", "Южный", 86_94_53_38, 45867));
        kotlettashop.addClientToShopList (new Client ("Дарья", "Прозорова", "Анатольевна", "Южный", 47_23_63_64, 12354));
        kotlettashop.addClientToShopList (new Client ("Сурен", "Цатуров", "Суренович", "Чайка", 46_63_24_16, 45687));
        kotlettashop.addClientToShopList (new Client ("Анастасия", "Бойко", "Николаевна", "Пролетарка", 87_15_11_63, 45687));
        kotlettashop.addClientToShopList (new Client ("Екатерина", "Белова", "Ивановна", "Питер", 45_53_18_83, 45678));
        kotlettashop.addClientToShopList (new Client ("Татьяна", "Калинина", "Владимировна", "Центр", 74_20_23_29, 12383));
        kotlettashop.addClientToShopList (new Client ("Ольга", "Тихонова", "Андреевна", "Москва", 97_15_63_55, 11111));

        System.out.println("Сортировка по имени покупателя: ");
        List<Client> listSortByName = kotlettashop.getListByName();
        for (Client c : listSortByName) {
            System.out.println(c);
        }

        System.out.println("Сортировка по диапозону кредитной карты: ");
        List<Client> listSortByRangeCreditCard = kotlettashop.getListByRangeCreditCard(31_23_43_54, 87_15_63_55);
        for (Client c : listSortByRangeCreditCard) {
            System.out.println(c);
        }

    }
}

class Shop {
    private String shopName;
    private ArrayList<Client> clientList = new ArrayList<>();

    Shop (String shopName) {
        this.shopName = shopName;
    }
    void addClientToShopList (Client client) {
        clientList.add(client);
    }

    List<Client> getListByName () {
        List<Client> list = new ArrayList<>(clientList);
        Collections.sort(list, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return list;
    }
    List<Client> getListByRangeCreditCard (int rangeStart, int rangeEnd) {
        List<Client> list = new ArrayList<>();
        for (Client c : clientList) {
            if (c.getCreditCardId() >= rangeStart && c.getCreditCardId() <=rangeEnd) {
                list.add (c);
            }
        }

        return list;
    }

}

class Client {
    {
        idGeneratior++;
    }
    private static int idGeneratior = 0;
    private int id = idGeneratior;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private int creditCardId;
    private int bankNumberCard;

    Client (String name, String surname, String patronymic, String address, int creditCardId, int bankNumberCard) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardId = creditCardId;
        this.bankNumberCard = bankNumberCard;
    }
    public String getName () {
        return name;
    }
    public String getSurname () {
        return surname;
    }
    public String getPatronymic () {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public int getBankNumberCard() {
        return bankNumberCard;
    }
    public String toString () {
        return String.format ("ID: %d\t name: %s\t surname: %s\t patronymic %s\t from: %s\t credit card %d\t bank number %d",
                id, name, surname, patronymic, address, creditCardId, bankNumberCard);
    }
}