/*
    Menyimpan informasi tentang player seperti
    - barang yang dibawa
    - kesehatan

 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    int kesehatan = 100;
    static boolean isSelesai = false;
    Adegan adeganAktif; //adegan tempat player berada

    /* barang yang dimiliki player*/
    ArrayList<Barang> arrBarang = new ArrayList<>();
    int jumBarang  = 0;


    //jika dipanggil akan lengkapi dengan nim, nama dan tulisan saya berjanji tdk akan dst..
    public void printIdentitas() {
        System.out.println("Identitas");
        System.out.println("NIM: 1603489");
        System.out.println("Nama: Rayhan Zafiar");
        System.out.println("\"Saya bernjanji tidak berlaku curang dan/atau membantu orang lain berbuat curang\"");
    }


    public void tambahBarang(Barang oBarang) {
        //arrBarang[jumBarang] = oBarang;
        //jumBarang++;
        arrBarang.add(oBarang);
    }

    /*
        cetak isi barang yang dimiliki player
        return adalah objek barang yang dipilih user untuk digunakan
        jika user tidak jadi memilih maka akan return null
        hati-hati dapat menyebabkan NullPointer exception jadi selalu cek return
     */

    public Barang pilihBarang() {

        int i = 0;
        for(Barang brg : arrBarang){
            System.out.println(String.format("%d. %s",i+1,brg.deskripsi));
            i++;
        }

        System.out.println(String.format("99. %s","Hanya lihat, tidak menggunakan barang"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Pilihan anda?");
        int pilihan = sc.nextInt();
        if (pilihan!=99)
            return(arrBarang.get(pilihan-1));
        else
            return null;
    }

    public static void main(String[] args) {
        //untuk test
        Barang permen = new Barang("p_kopiko","Permen Kopiko");
        Barang bolpen = new Barang("bolpen","Bolpen");
        Player p = new Player();
        p.tambahBarang(permen);
        p.tambahBarang(bolpen);
        Barang barangPilih = p.pilihBarang(); //
        if (barangPilih!=null) {
            System.out.println(barangPilih.deskripsi);
        }
    }
    public void printKesehatan(){
        System.out.println("Kesehatan Pemain: " + kesehatan);
    }
    public void tambahKesehatan(Barang makanan){
        this.kesehatan += 50;

        //menghapus barang tersebut
        Adegan.oPlayer.arrBarang.remove(makanan);

        System.out.println("Kesehatan Bertambah 50!");
        if(this.kesehatan>100){
            this.kesehatan = 100;
        }
    }
    public void Kecapekan(){
        this.kesehatan -= 2;
        if(this.kesehatan < 0){
            this.kesehatan = 0;
        }
    }


}

