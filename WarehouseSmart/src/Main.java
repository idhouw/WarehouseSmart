import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedListBarang list = new LinkedListBarang();
        QueueBarang queue = new QueueBarang();
        TreeKategori tree = new TreeKategori();
        StackBarang stack = new StackBarang();

        int pilih;

        do {
            System.out.println("\n===============================");
            System.out.println("      SISTEM PENITIPAN BARANG");
            System.out.println("===============================");
            System.out.println("1. Input Barang");
            System.out.println("2. Lihat Daftar Barang");
            System.out.println("3. Lihat Antrian Barang");
            System.out.println("4. Tampilkan Tree Kategori");
            System.out.println("5. Lihat Isi Rak");
            System.out.println("0. Keluar");
            System.out.println("===============================");
            System.out.print("Pilih menu : ");
            pilih = sc.nextInt();
            sc.nextLine(); // buffer

            switch (pilih) {

                case 1:
                    System.out.println("\n=== INPUT BARANG ===");

                    System.out.print("ID Barang      : ");
                    String id = sc.nextLine();
                    System.out.print("Nama Barang    : ");
                    String nama = sc.nextLine();
                    System.out.print("Kategori       : ");
                    String kategori = sc.nextLine();
                    System.out.print("Nama Penitip   : ");
                    String penitip = sc.nextLine();
                    System.out.print("Tanggal Titip  : ");
                    String tgl = sc.nextLine();
                    System.out.print("Berat Barang   : ");
                    int berat = sc.nextInt(); 
                    sc.nextLine();
                    

                    // Membuat node baru
                    NodeBarang barang = new NodeBarang(id, nama, kategori, penitip, tgl, berat);

                    // Tambahkan ke LinkedList
                    list.tambahBarang(id, nama, kategori, penitip, tgl, berat);

                    // Tambahkan ke Queue
                    queue.enqueue(barang);

                    // Tambahkan ke Tree BST
                    tree.tambahKategori(barang);

                    stack.push(barang);

                    System.out.println("✔ Barang berhasil diinput!");
                    break;

                case 2:
                    System.out.println("\n=== DAFTAR BARANG ===");
                    list.tampilBarang();
                    break;

                case 3:
                    queue.tampilAntrian();
                    break;

                case 4:
                    System.out.println("\n=== TREE KATEGORI (INORDER) ===");
                    tree.inorder(tree.root);
                    break;

                case 5:
                    System.out.println("\n=== ISI RAK (STACK) ===");
                    stack.tampilStack();
                    break;


                case 0:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi!");
            }

        } while (pilih != 0);

    }
}
