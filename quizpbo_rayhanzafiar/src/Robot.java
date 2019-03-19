import java.util.ArrayList;

/*
     Robot yang akan bertarung. Robot punya senjata, perisai dan skor kesehatan.
 */
public class Robot {
    Senjata oSenjata;
    Perisai oPerisai;
    int kesehatan;
    String nama = "";
    ArrayList<Senjata> tasSenjata = new ArrayList<>();
    ArrayList<Perisai> tasPerisai = new ArrayList<>();
    //isi senjata milik robot
    public void  pakaiSenjata(Senjata s) {
        oSenjata = s;
    }
    //menambah senjata ke inventory
    public void pakaiSenjataKeTas(Senjata s){
        this.tasSenjata.add(s);
    }
    //perisai yang sedang digunakan
    public void  pakaiPerisai(Perisai p) {
        oPerisai = p;
    }
    //perisai yang sedang digunakan
    public void  tambahPerisaiKeTas(Perisai p) {
        this.tasPerisai.add(p);
    }
    //print kesehatan dsb
    public void printStatistik() {
        System.out.println("Nama Robot: "+nama);
        System.out.println("Kesehatan:"+kesehatan);
    }
    //constructor
    public Robot(String vNama) {
        nama = vNama;
        kesehatan = 100; //default
    }

    /* menyerang robot lain, skor kesehatan robot lain akan berkurang
    */
    public void serang(Robot rLawan) {
       //skor kesehatan robot lawan akan dikurangi
        if(rLawan.oPerisai.kekuatan - oSenjata.kekuatan < 0){
            rLawan.kesehatan -= (oSenjata.kekuatan - rLawan.oPerisai.kekuatan);
        }
        if(rLawan.kesehatan <0){
            rLawan.kesehatan = 0;
        }
    }
}
