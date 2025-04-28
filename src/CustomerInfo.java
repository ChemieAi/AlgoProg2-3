import java.util.ArrayList;
import java.util.Scanner;

public class CustomerInfo {
    // CustomerInfo class'ının değişkenleri
    private String adSoyad;
    private String adres;
    private ArrayList<String> telefonNumaralari;

    // Parametreli constructor
    public CustomerInfo(String adSoyad, String adres, ArrayList<String> telefonNumaralari) {
        this.adSoyad = adSoyad;
        this.adres = adres;
        this.telefonNumaralari = telefonNumaralari;
    }

    // toString methodu
    @Override
    public String toString() {
        // Numaralar arraylistten okunup Stringe yazılır
        String numaralar = "";
        for(int i = 0; i < telefonNumaralari.size(); i++) {
            numaralar += telefonNumaralari.get(i) + " ";
        }
        return "CustomerInfo{" +
                "adSoyad='" + adSoyad + '\'' +
                ", adres='" + adres + '\'' +
                ", telefonNumaralari=" + numaralar +
                '}';
    }

    // getSoyad methodu soyadı döner
    public String getSoyad() {
        Scanner scanner = new Scanner(getAdSoyad());
        String soyad = null;
        while (scanner.hasNext()) {
            soyad = scanner.next();
        }
        return soyad;
    }

    // ad soyad ve adres için get set methodları
    public String getAdSoyad() {
        return adSoyad;
    }
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }

}
