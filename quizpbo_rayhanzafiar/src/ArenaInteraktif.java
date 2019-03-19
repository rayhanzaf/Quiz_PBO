import java.util.Scanner;

public class ArenaInteraktif extends Arena {
    @Override
    public void bertanding(){
        boolean isSelesai = false;
        System.out.println("Tugas 1 6 Maret 2019");
        System.out.println("NIM, NAMA");
        System.out.println("1603489, RAYHAN ZAFIAR");
        System.out.println("Pertandingan dimulai");
        Robot robotAktif = getRobot1();
        Robot robotPasif = getRobot2();
        System.out.print(robotAktif.nama);
        System.out.print("\n"+robotPasif.nama);
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        while (!isSelesai){
            System.out.println("");
            System.out.println("Giliran robot:"+robotAktif.nama);
            boolean isPilihan1 = false;
            while (!isPilihan1){
            System.out.println("Aksi:");
            System.out.println("1. Serang 2. Ganti Peralatan");
            System.out.print("Pilihan: ");
            int pilihAksi;
            pilihAksi = input.nextInt();
                if (pilihAksi==1){
                    isPilihan1 = true;
                }else if (pilihAksi==2){
                System.out.println("Ganti item");
                System.out.println("1.Senjata 2.Perisai");
                System.out.print("Pilihan: ");
                int pilihItem = input2.nextInt();
                    if (pilihItem==1){
                        int i = 0;
                        System.out.printf("%-5s    %-25s    %-3s\n", "NO", "NAMA", "KEKUATAN");
                        System.out.println("==============================================");
                        for(Senjata s : robotAktif.tasSenjata){
                            System.out.printf("%-5d %-25s %-3d\n", i+1, s.nama, s.kekuatan);
                            i++;
                        }
                    if(i!=0){
                      int isPilihan2=0;
                      int pilihSenjata;
                      SenjataPukulan pukul = new SenjataPukulan();
                      while(isPilihan2==0) {
                          System.out.println("Pilih Senjata: ");
                          pilihSenjata = input3.nextInt();
                          if (pilihSenjata>i||pilihSenjata<1){
                              System.out.println("Pilihan tidak tersedia.");
                          }else{
                              robotAktif.pakaiSenjata(robotAktif.tasSenjata.get(pilihSenjata-1));
//
                              System.out.println("Senjata yang digunakan: "+robotAktif.oSenjata.nama +
                                      "Kekuatan" + robotAktif.oSenjata.kekuatan);
                              isPilihan2 = 1;
                          }
                      }
                    }else{
                        System.out.println("Senjata Kosong");
                    }
                }else if(pilihItem==2){
                    System.out.printf("%-5s    %-25s    %-3s\n", "NO", "NAMA", "KEKUATAN");
                    System.out.println("==============================================");
                    int j=0;
                    for (Perisai p:robotAktif.tasPerisai){
                        System.out.printf("%-5d %-25s %-3d\n",j+1,p.nama,p.kekuatan);
                        j++;
                    }
                    if(j!=0){
                        int isPilihan2=0;
                        int pilihPerisai;
                        while (isPilihan2==0){
                            System.out.println("Pilih Perisai");
                            pilihPerisai = input3.nextInt();
                            if (pilihPerisai>j||pilihPerisai<1){
                                System.out.println("Pilihan tidak tersedia");
                            }else{
                                robotAktif.pakaiPerisai(robotAktif.tasPerisai.get(pilihPerisai-1));
                                System.out.println("Perisai yang digunakan: "+
                                        robotAktif.oPerisai.nama+"Kekuatan"+
                                        robotAktif.oPerisai.kekuatan);
                                isPilihan2=1;
                            }
                        }
                    }
                }
            }
        }
            System.out.println("Robot menyerang dengan"+robotAktif.oSenjata.nama);
            robotAktif.serang(robotPasif);
            //print kesehatan
            getRobot1().printStatistik();
            getRobot2().printStatistik();
            //tukar peran
            Robot temp = robotAktif; //supaya tdk tertimpa
            robotAktif = robotPasif;
            robotPasif = temp;

            //stop jika salah satu robot skor kesehatanya nol
            isSelesai = (robotAktif.kesehatan<=0 || robotPasif.kesehatan<=0);
    }System.out.println("Pertandingan Selesai\n");
        if(getRobot1().kesehatan <=0 && getRobot2().kesehatan <=0){
            System.out.println("Pemenang: Tidak Ada (Draw)");
        }else if(getRobot1().kesehatan >0){
            System.out.println("Pemenang: " + getRobot1().nama);
        }else if(getRobot2().kesehatan >0){
            System.out.println("Pemenang: " + getRobot2().nama);
        }
    }
    public static void main(String [] args) {
        //buat arena
//        Arena oArena = new Arena();
        ArenaInteraktif oArena = new ArenaInteraktif();

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
        robot1.pakaiPerisai(oPerisaiMidas1);
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
