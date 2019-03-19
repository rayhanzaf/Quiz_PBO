/*
    Adegan dijendela, ada state terkunci
 */

public class AdeganJendela extends  Adegan {
    boolean isTerkunci = true;
    String narasiTerkunci = "Rudi mendekati jendela. Rudi mencoba membuka jendela. \"Ah terkunci\"";
    String narasiTerbuka  = "Rudi mencoba membuka jendela dan terbuka!";

    //constructor
    public AdeganJendela () {
        narasi = narasiTerkunci;
    }

    /* user berhasil menggunakan obeng untuk membuka jendela */
    @Override
    public void gunakanBarang(Barang barangPilih) {
        super.gunakanBarang(barangPilih); //panggil parent
        isTerkunci = false;
        narasi = narasiTerbuka;

        //karena kunci sudah terbuka ada pilihan baru keluar dari kamar
        Adegan  adeganKeluarJendela = new Adegan();
        adeganKeluarJendela.narasi = "Rudi pelan-pelan membuka jendela dan keluar dari kamar. Rudi sekarang berada di luar jendela " +
                "yang sangat besar";
        Pilihan pilihanMenujuKeluarJendela = new PilihanGantiAdegan(adeganKeluarJendela,"Keluar kamar, ke luar jendela");
        //tambahPilihan(pilihanMenujuKoridor);
    }

}
