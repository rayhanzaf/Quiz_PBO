/*
    inisialisasi adegan dsb, jalankan adegan sampai permainan selesai.

 */

public class GameEngine {
    Player oPlayer;

    public GameEngine() {
        Barang koin = new Barang("koin","uang koin");
        oPlayer = new Player();
        oPlayer.tambahBarang(koin);  //dummy saja
        //perhatikan Adegan  disini adalah class, oPlayer adalah static atribut sehingga berlaku untuk semua objek
        //artinya semua objek adegan punya objek player yang sama
        Adegan.oPlayer = oPlayer;
    }

    public void mulai() {
        oPlayer.printIdentitas();
        do {
            oPlayer.adeganAktif.mainkan();
        } while (!oPlayer.isSelesai && oPlayer.kesehatan > 0);
        System.out.println(String.format("Kesehatan: %d\nPermainan Selesai!", Adegan.oPlayer.kesehatan));
    }

    public static void main(String[] args) {

        Barang kunci = new Barang("kunci_besar","Kunci Besar");


        Adegan adeganPintu = new AdeganPintu();
        Adegan adeganMeja  = new Adegan();
        Adegan adeganJendela = new AdeganJendela();

        Pilihan pilihanMenujuPintu = new PilihanGantiAdegan(adeganPintu,"Menuju pintu");
        Pilihan pilihanMenujuMeja  = new PilihanGantiAdegan(adeganMeja,"Menuju meja");
        Pilihan pilihanMenujuJendela = new PilihanGantiAdegan(adeganJendela,"Menuju jendela");

        //init data cerita
        // == adegan awal
        Adegan  adeganAwal = new Adegan();
        adeganAwal.narasi =
                "Rudi terbangun disebuah ruangan yang tidak dikenal. Dia melihat sekeliling, \n" +
                "terlihat jendela, pintu dan sebuah meja kecil";
        adeganAwal.tambahPilihan(pilihanMenujuPintu);
        adeganAwal.tambahPilihan(pilihanMenujuMeja);
        adeganAwal.tambahPilihan(pilihanMenujuJendela);

        // == adegan di depan pintu
        adeganPintu.tambahPilihan(pilihanMenujuMeja); //pilihan ke meja direuse
        adeganPintu.idBarangBisaDigunakan = "kunci_besar"; //kunci_besar bisa digunakan di adegan ini
        adeganPintu.tambahBarang(new Barang("obeng", "Obeng")); //ada obeng di dekat pintu

        // == adegan di depan meja
        adeganMeja.narasi = "Rudi mendekati meja. Ada beberapa barang di atas meja";
        adeganMeja.tambahBarang(new Barang("kunci_besar", "Kunci berukuran besar"));
        adeganMeja.tambahBarang(new Barang("senter", "Senter kecil"));
        adeganMeja.tambahBarang(new Barang("makanan", "Rice Box"));
        adeganMeja.tambahPilihan(pilihanMenujuPintu); //dari meja bisa ke pintu
        adeganMeja.tambahPilihan(pilihanMenujuJendela); //dari meja bisa ke jendela

        // == adegan di jendela
        adeganJendela.idBarangBisaDigunakan = "obeng"; //obeng bisa digunakan di adegan ini
        adeganJendela.tambahPilihan(pilihanMenujuMeja); //dari jendela bisa ke meja
        adeganJendela.tambahPilihan(pilihanMenujuPintu); //dari jendela bisa ke meja
        //== init game engine
        GameEngine ge = new GameEngine();
        //ge.tambahAdegan(adeganMeja);
        ge.oPlayer.adeganAktif = adeganAwal; //start dari adegan awal
        ge.mulai();
    }
}
