/*
     Menjalankan pertarungan antar dua robot

 */

public class Arena {
    private Robot robot1;
    private Robot robot2;
    public Robot getRobot1(){
        return this.robot1;
    }
    public Robot getRobot2(){
        return this.robot2;
    }
    public void tambahRobot(Robot r1,Robot r2) {
        robot1 = r1;
        robot2 = r2;
    }

    public void bertanding() {
        //UI sederhana untuk pertandingan

        //loop sampai salah satu robot habis skor kesehatannya
        boolean isSelesai = false;

        //LENGKAPI dengan NIM dan NAMA
        System.out.println("Saya berjanji tdk berbuat curang dan/atau membantu orang lain berbuat curang");
        System.out.println(" Quiz 1 27 Feb ");
        System.out.println(" NIM, NAMA ");
        System.out.println("1603489, Rayhan Zafiar");

        System.out.print("Pertandingan dimulai =====\n");

        //player
        Robot robotAktif = robot1;
        Robot robotPasif = robot2;

        while (!isSelesai) {
            System.out.println("");
            System.out.println("Giliran robot:"+robotAktif.nama);
            System.out.println("Robot menyerang dengan"+robotAktif.oSenjata.nama);
            robotAktif.serang(robotPasif);
            //print kesehatan
            robot1.printStatistik();
            robot2.printStatistik();
            //tukar peran
            Robot temp = robotAktif; //supaya tdk tertimpa
            robotAktif = robotPasif;
            robotPasif = temp;

            //stop jika salah satu robot skor kesehatanya nol
            isSelesai = (robotAktif.kesehatan<=0 || robotPasif.kesehatan<=0);
        }
        System.out.println("Pertandingan Selesai");

        //cek pemenang
        //lengkapi
        if(robot1.kesehatan <=0 && robot2.kesehatan <=0){
            System.out.println("Pemenang: Tidak Ada (Draw)");
        }else if(robot1.kesehatan >0){
            System.out.println("Pemenang: " + robot1.nama);
        }else if(robot2.kesehatan >0){
            System.out.println("Pemenang: " + robot2.nama);
        }
    }



    public static void main(String [] args) {
        //buat arena
        Arena oArena = new Arena();

        //siapkan robot
        Robot robot1 = new Robot("Robot pertama");
        Robot robot2 = new Robot("Robot kedua");

        //tambahkan senjata dan perisai ke robot1
        Senjata oSenjataPukulan1 = new SenjataPukulan();
        Senjata oSenjataKilat1 = new SenjataKilat();
        PerisaiAegis oPerisaiAegis1 = new PerisaiAegis();
        PerisaiMidas oPerisaiMidas1 = new PerisaiMidas();
        robot1.pakaiSenjataKeTas(oSenjataPukulan1);
        robot1.pakaiSenjataKeTas(oSenjataKilat1);
        robot1.pakaiSenjata(robot1.tasSenjata.get(1));
        robot1.tambahPerisaiKeTas(oPerisaiAegis1);
        robot1.tambahPerisaiKeTas(oPerisaiMidas1);
        robot1.pakaiPerisai(oPerisaiAegis1);
        //tambahkan senjata dan perisai ke robot2
        Senjata oSenjataPukulan2 = new SenjataPukulan();
        Senjata oSenjataKilat2 = new SenjataKilat();
        PerisaiAegis oPerisaiAegis2 = new PerisaiAegis();
        PerisaiMidas oPerisaiMidas2 = new PerisaiMidas();
        robot2.pakaiSenjataKeTas(oSenjataPukulan2);
        robot2.pakaiSenjataKeTas(oSenjataKilat2);
        robot2.pakaiSenjata(robot2.tasSenjata.get(0));
        robot2.tambahPerisaiKeTas(oPerisaiAegis2);
        robot2.tambahPerisaiKeTas(oPerisaiMidas2);
        robot2.pakaiPerisai(robot2.tasPerisai.get(0));

        //tambahkan robot ke arena
        oArena.tambahRobot(robot1,robot2);

        //mainkan
        oArena.bertanding();

    }

}
