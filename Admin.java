import java.util.Locale;
import java.util.Objects;

public class Admin extends Daftar{
    public static void viewMenuPage(String user) {
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("SELAMAT DATANG DI SEOUL BANK " + user.toUpperCase(Locale.ROOT));
        if(user!="admin"){
            System.out.println("Berikut ini status saldo Anda : "+SeoulbankApp.cekSaldo(user));
        }
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        if (user == "admin") {
            Admin.listMenu();
        } else {
            User.listMenu();
        }
        System.out.print("Selamat datang, Masuk dan pilih : ");
        String pilih = SeoulbankApp.input();
        if (user.equals("admin")) {
            Admin.proses(pilih);
        } else {
            User.proses(pilih);
        }
    }

    public static void listMenu() {
        System.out.println("1. Lihat Riwayat Seluruh Transaksi");
        System.out.println("2. Lihat Riwayat Transaksi User Tertentu");
        System.out.println("3. Exit");
    }

    public static void proses(String pilih) {
        if (Objects.equals(pilih, "1")) {
            Transaksi.viewTransaksi(null);
        } else if (Objects.equals(pilih, "2")) {
            for (int i = 1; i < SeoulbankApp.username.length; i++) {
                System.out.println(i + " . " + SeoulbankApp.username[i]);
            }
            System.out.print("Masukkan Pilihanmu : ");
            int name = Integer.parseInt(SeoulbankApp.input());
            Transaksi.viewTransaksi(SeoulbankApp.username[name]);
        } else if (Objects.equals(pilih, "3")){
            Login.viewLoginPage();
        } else {
            SeoulbankApp.salah();
            viewMenuPage(user);
        }
    }
}
