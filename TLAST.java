//Agnes Anela Walysa Panngaribuan-12S25032 //
import java.util.*;
import java.lang.Math;

public class Program {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] kodeMatkul = new String[10];
        String[] namaTugas = new String[10];
        String[] status = new String[10];
        int[] deadline = new int[10];
        int[] kesulitan = new int[10];
        double[] prioritas = new double[10];
        int jumlahData;

        jumlahData = 0;
        boolean running;

        running = true;
        String perintah;

        while (running) {
            perintah = input.nextLine();
            if (perintah.equals("(Add task)")) {
                tambahTugas(jumlahData, kodeMatkul, namaTugas, deadline, kesulitan, status, prioritas, running);
            } else {
                if (perintah.equals("(Update task status)")) {
                    updateStatus(jumlahData, kodeMatkul, status);
                } else {
                    if (perintah.equals("(Show assignment)")) {
                        tampilkanTugas(jumlahData, kodeMatkul, namaTugas, deadline, kesulitan, status, prioritas);
                    }
                }
            }
        }
    }
    
    public static void tambahTugas(int n, String[] kode, String[] nama, int[] dead, int[] sulit, String[] stat, double[] prio, boolean run) {
        if (n >= 10) {
            System.out.println("Memori Penuh");
        } else {
            String tempNama;

            kode[n] = input.nextLine();
            tempNama = input.nextLine();
            if (tempNama.equals("---")) {
                run = false;
            } else {
                nama[n] = tempNama;
                dead[n] = input.nextInt();
                sulit[n] = input.nextInt();
                stat[n] = input.nextLine();
                prio[n] = sulit[n] * 1.0 / dead[n];
                n = n + 1;
            }
        }
    }
    
    public static void tampilkanTugas(int n, String[] kode, String[] nama, int[] dead, int[] sulit, String[] stat, double[] prio) {
        urutkan(n, kode, nama, dead, sulit, stat, prio);
        int i;

        for (i = 0; i <= n - 1; i++) {
            System.out.println("Kode: " + kode[i]);
            if (!stat[i].equals("Selesai")) {
                System.out.println("Tugas: " + nama[i]);
                System.out.println("Deadline: " + dead[i]);
            }
            System.out.println("Status: " + stat[i]);
            System.out.println("Prioritas: " + prio[i]);
            if (prio[i] > 3) {
                System.out.println("Penting! Anda harus mengerjakan tugas ini segera");
            } else {
                if (prio[i] >= 1.5) {
                    System.out.println("Tugas ini memiliki prioritas menengah");
                } else {
                    System.out.println("Tugas ini relatif ringan, namun jangan tunda terlalu lama");
                }
            }
            System.out.println("------------------------------");
        }
    }
    
    public static void updateStatus(int n, String[] kode, String[] stat) {
        String target;
        String baru;
        int i;

        target = input.nextLine();
        baru = input.nextLine();
        for (i = 0; i <= n - 1; i++) {
            if (kode[i].equals(target)) {
                stat[i] = baru;
            }
        }
    }
    
    public static void urutkan(int n, String[] kode, String[] nama, int[] dead, int[] sulit, String[] stat, double[] prio) {
        int i, j;
        String tempS;
        int tempI;
        double tempR;

        for (i = 0; i <= n - 1; i++) {
            for (j = 0; j <= n - 2 - i; j++) {
                if (prio[j] < prio[j + 1]) {
                    tempR = prio[j];
                    prio[j] = prio[j + 1];
                    prio[j + 1] = tempR;
                    tempS = kode[j];
                    kode[j] = kode[j + 1];
                    kode[j + 1] = tempS;
                    tempS = nama[j];
                    nama[j] = nama[j + 1];
                    nama[j + 1] = tempS;
                    tempS = stat[j];
                    stat[j] = stat[j + 1];
                    stat[j + 1] = tempS;
                    tempI = dead[j];
                    dead[j] = dead[j + 1];
                    dead[j + 1] = tempI;
                    tempI = sulit[j];
                    sulit[j] = sulit[j + 1];
                    sulit[j + 1] = tempI;
                }
            }
        }
    }
}


