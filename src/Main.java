// Burak Kızılay
// 05180000063
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // DoublyLinkedList oluşturulur.
        DoublyLinkedList dll = new DoublyLinkedList();
        // keyboard, string ve dosya okuyucu Scanner'lar tanımlanır.
        Scanner keyboard = new Scanner(System.in);
        Scanner stringOkuyucu = null;
        Scanner dosyaOkuyucu = null;
        // Döngü için kullanılan değişkenler tanımlanır.
        String islem, adSoyad, adres;
        boolean devam = true;

        System.out.println("Müşteri Programına Hoşgeldiniz!");
        System.out.println("""
                İşlemler:
                1 - customer.txt okuma ve listeye ekleme
                2 - Klavyeden müşteri ekleme
                3 - Adı soyadı girilen müşteriyi listede arama
                4 - Adı soyadı girilen müşteriyi listeden silme
                5 - Listenin içindeki kayıtları A-Z'ye yazdırma
                6 - Listenin içindeki kayıtları Z-A'ya yazdırma
                7 - Çıkış""");

        while (devam) {
            // Kullanıcıdan işlem istenir
            System.out.print("İşlemi seçiniz: ");
            islem = keyboard.nextLine();
            switch (islem) {
                case "1":
                    // İşlem 1'se dosya okunur.
                    try {
                        dosyaOkuyucu = new Scanner(new FileInputStream("customer.txt"));
                    } catch (FileNotFoundException e) {
                        System.out.println("Dosya bulunamadı.");
                        System.out.println("Programdan çıkılıyor.");
                        System.exit(0);
                    }
                    CustomerInfo yeniMusteriler;
                    while (dosyaOkuyucu.hasNext()) {
                        String bilgiler = dosyaOkuyucu.nextLine();
                        stringOkuyucu = new Scanner(bilgiler);
                        stringOkuyucu.useDelimiter(",");
                        adSoyad = stringOkuyucu.next();
                        adres = stringOkuyucu.next();
                        ArrayList<String> numaralar = new ArrayList<>();
                        while (stringOkuyucu.hasNext()) {
                            numaralar.add(stringOkuyucu.next());
                        }
                        // Dosyadan okunan bilgilerle CustomerInfo tipinde obje yaratılır.
                        // Objeler yazdığımız linkedliste atılır.
                        yeniMusteriler = new CustomerInfo(adSoyad, adres, numaralar);
                        dll.add(yeniMusteriler);
                    }
                    break;
                case "2":
                    // İşlem 2 ise klavyeden veri girişi alınır.
                    System.out.println("Müşteri verilerini [ad soyad, adres, numara(lar)] olacak şekilde arada virgül olarak giriniz:");
                    String bilgiler = keyboard.nextLine();
                    stringOkuyucu = new Scanner(bilgiler);
                    stringOkuyucu.useDelimiter(",");
                    adSoyad = stringOkuyucu.next();
                    adres = stringOkuyucu.next();
                    ArrayList<String> numaralar = new ArrayList<>();
                    while (stringOkuyucu.hasNext()) {
                        numaralar.add(stringOkuyucu.next());
                    }
                    // Girilen verilerle CustomerInfo tipinde onje oluşturulur.
                    // Objeler yazdığımız linkedliste atılır.
                    CustomerInfo yeniMusteri = new CustomerInfo(adSoyad, adres, numaralar);
                    dll.add(yeniMusteri);
                    break;
                case "3":
                    // İşlem 3 ise klavyeden isim soyisim bilgisi alınır ve müşteri listede aranır.
                    System.out.print("Bilgilerini almak istediğiniz müşterinin adını soyadını giriniz: ");
                    adSoyad = keyboard.nextLine();
                    // Müşteri listede varsa fonksiyon müşteri bilgilerini döndürür.
                    dll.musteriYazdir(adSoyad);
                    break;
                case "4":
                    // İşlem 4 ise klavyeden isim soyisim bilgisi alınır.
                    System.out.print("Silmek istediğiniz müşterinin adını soyadını giriniz: ");
                    adSoyad = keyboard.nextLine();
                    // Müşteri listede varsa listeden silinir.
                    dll.remove(adSoyad);
                    break;
                case "5":
                    // İşlem 5 ise kayıtlar A'dan Z'ye yazılır.
                    System.out.println("Kayıtlar artan alfabetik sırada yazdırılıyor...");
                    dll.AdanZyeYazdir();
                    break;
                case "6":
                    // İşlem 6 ise kayıtlar Z'den A'ya yazılır.
                    System.out.println("Kayıtlar azalan alfabetik sırada yazdırılıyor...");
                    dll.ZdenAyaYazdir();
                    break;
                case "7":
                    // İşlem 7 ise kayıtlar Z'den A'ya yazılır.
                    System.out.println("Çıkış yapılıyor...");
                    devam = false;
                    break;

            }
        }
    }
}
