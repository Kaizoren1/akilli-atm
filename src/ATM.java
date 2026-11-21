import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bakiye = 10000;          // baslangic bakiyesi
        int islemSayisi = 0;         // basarili islem sayisi
        int toplamYatirilan = 0;     // basarili yatirmalarin toplami
        int toplamCekilen = 0;       // basarili cekmelerin toplami
        boolean devam = true;

        System.out.println("=== AKILLI ATM'YE HOS GELDINIZ ===");

        while (devam) {
            System.out.println();
            System.out.println("----- ANA MENU -----");
            System.out.println("1. Bakiye goruntuleme");
            System.out.println("2. Para yatirma");
            System.out.println("3. Para cekme");
            System.out.println("4. Cikis");
            System.out.print("Seciminiz: ");

            // Sayi girilmediyse hatali girdiyi atla ve menuye don
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("HATA: Gecersiz secim! Lutfen 1-4 arasinda bir sayi giriniz.");
                continue;
            }
            int secim = scanner.nextInt();

            if (secim == 1) {
                System.out.println("Guncel bakiyeniz: " + bakiye + " TL");
                islemSayisi++;

            } else if (secim == 2) {
                System.out.print("Yatirilacak tutar: ");
                if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("HATA: Gecerli bir sayi giriniz.");
                    continue;
                }
                int tutar = scanner.nextInt();

                if (tutar <= 0) {
                    System.out.println("HATA: Negatif veya sifir tutar yatirilamaz.");
                } else {
                    bakiye = bakiye + tutar;
                    toplamYatirilan = toplamYatirilan + tutar;
                    islemSayisi++;
                    System.out.println(tutar + " TL yatirildi. Yeni bakiye: " + bakiye + " TL");
                }

            } else if (secim == 3) {
                System.out.print("Cekilecek tutar: ");
                if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("HATA: Gecerli bir sayi giriniz.");
                    continue;
                }
                int tutar = scanner.nextInt();

                if (tutar <= 0) {
                    System.out.println("HATA: Negatif veya sifir tutar cekilemez.");
                } else if (tutar > bakiye) {
                    System.out.println("HATA: Yetersiz bakiye. Mevcut bakiye: " + bakiye + " TL");
                } else {
                    bakiye = bakiye - tutar;
                    toplamCekilen = toplamCekilen + tutar;
                    islemSayisi++;
                    System.out.println(tutar + " TL cekildi. Yeni bakiye: " + bakiye + " TL");
                }

            } else if (secim == 4) {
                devam = false;

            } else {
                System.out.println("HATA: Gecersiz secim! Lutfen 1-4 arasinda bir sayi giriniz.");
            }
        }

        System.out.println();
        System.out.println("===== ISLEM OZETI =====");
        System.out.println("Son bakiye          : " + bakiye + " TL");
        System.out.println("Toplam islem sayisi : " + islemSayisi);
        System.out.println("Toplam yatirilan    : " + toplamYatirilan + " TL");
        System.out.println("Toplam cekilen      : " + toplamCekilen + " TL");
        System.out.println("Iyi gunler dileriz!");

        scanner.close();
    }
}
