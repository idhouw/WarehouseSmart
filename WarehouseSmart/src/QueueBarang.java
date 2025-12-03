import java.util.LinkedList;
import java.util.Queue;

public class QueueBarang {
    Queue<NodeBarang> antrian = new LinkedList<>();

    // Tambah barang ke antrian
    public void enqueue(NodeBarang barang) {
        antrian.add(barang);
        System.out.println("Barang masuk ke antrian!");
    }

    // Mengambil barang pertama di antrian
    public NodeBarang dequeue() {
        if (antrian.isEmpty()) {
            System.out.println("Antrian barang kosong.");
            return null;
        }
        return antrian.poll();
    }

    // Melihat barang tanpa menghapus
    public NodeBarang peek() {
        if (antrian.isEmpty()) return null;
        return antrian.peek();
    }

    // Menampilkan seluruh antrian
    public void tampilAntrian() {
        if (antrian.isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("\n=== ANTRIAN BARANG MASUK ===");
        for (NodeBarang b : antrian) {
            System.out.println("- " + b.idBarang + " | " + b.namaBarang + " | " + b.Kategori);
        }
    }

    public boolean isEmpty() {
        return antrian.isEmpty();
    }

    public int size() {
        return antrian.size();
    }
}

